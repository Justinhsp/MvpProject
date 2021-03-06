package com.hui.example.yizhi.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hui.example.yizhi.R;
import com.hui.example.yizhi.bean.GankDayItemBean;

import java.util.List;

public class GankDayAdapter extends BaseMultiItemQuickAdapter<GankDayItemBean,BaseViewHolder> {

    private List<GankDayItemBean> mlist;
    private int mAndroidIndex = 0;
    private int mIOSIndex = 0;


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public GankDayAdapter(List<GankDayItemBean> data) {
        super(data);
        mlist=data;
        addItemType(GankDayItemBean.GANK_IO_DAY_ITEM_DAY_NORMAL,R.layout.item_gank_day_normal);
        addItemType(GankDayItemBean.GANK_IO_DAY_ITEM_DAY_REFESH,R.layout.item_gank_day_refesh);
    }

    @Override
    protected void convert(BaseViewHolder helper, GankDayItemBean item) {
        helper.setText(R.id.tv_type_item_title, item.getType());
        helper.setText(R.id.tv_item_title, item.getDesc());

        switch (item.getType()) {
            case "福利":
                helper.setImageResource(R.id.iv_type_item_title, R.drawable.ic_vector_title_welfare);
                Glide.with(mContext).load(item.getUrl()).into((ImageView) helper
                        .getView(R.id.iv_item_title));
                break;
            case "Android":
                helper.setImageResource(R.id.iv_type_item_title, R.drawable
                        .ic_vector_title_android);
                helper.setImageResource(R.id.iv_item_title, mResAndroid[mAndroidIndex % 6]);
                break;
            case "iOS":
                helper.setImageResource(R.id.iv_type_item_title, R.drawable.ic_vector_title_ios);
                helper.setImageResource(R.id.iv_item_title, mResIOS[mIOSIndex % 3]);
                break;
            case "前端":
                helper.setImageResource(R.id.iv_type_item_title, R.drawable.ic_vector_title_front);
                helper.setImageResource(R.id.iv_item_title, R.mipmap.gank_io_day_item_web);
                break;
            case "休息视频":
                helper.setImageResource(R.id.iv_type_item_title, R.drawable.ic_vector_title_video);
                helper.setImageResource(R.id.iv_item_title, R.mipmap.gank_io_day_item_video);
                break;
            case "瞎推荐":
                helper.setImageResource(R.id.iv_type_item_title, R.drawable.ic_vector_item_tuijian);
                break;
            case "拓展资源":
                helper.setImageResource(R.id.iv_type_item_title, R.drawable.ic_vector_item_tuozhan);
                break;
            case "App":
                helper.setImageResource(R.id.iv_type_item_title, R.drawable.ic_vector_item_app);
                break;
        }

        switch (helper.getItemViewType()) {
            case GankDayItemBean.GANK_IO_DAY_ITEM_DAY_NORMAL:
                helper.addOnClickListener(R.id.ll_more);
                break;
            case GankDayItemBean.GANK_IO_DAY_ITEM_DAY_REFESH:
                helper.addOnClickListener(R.id.ll_more).addOnClickListener(R.id.ll_refesh);
                break;
            default:
                break;
        }

    }


    /**
     * 由于bean中没有图片，这里更新固定图片数组index，模拟刷新图片
     *
     * @param position position
     * @param bean     bean
     */
    public void refeshItem(int position, GankDayItemBean bean) {
        if (bean.getType().equals("Android")) {
            mAndroidIndex++;
        } else {
            mIOSIndex++;
        }
        setData(position, bean);
    }

    //GankIo没有返回ImageList，这里使用固定的图片资源模拟刷新item效果
    private int[] mResAndroid = {
            R.mipmap.gank_io_day_item_android1,
            R.mipmap.gank_io_day_item_android2,
            R.mipmap.gank_io_day_item_android3,
            R.mipmap.gank_io_day_item_android4,
            R.mipmap.gank_io_day_item_android5,
            R.mipmap.gank_io_day_item_android6};

    private int[] mResIOS = {
            R.mipmap.gank_io_day_item_ios1,
            R.mipmap.gank_io_day_item_ios2,
            R.mipmap.gank_io_day_item_ios3};
}
