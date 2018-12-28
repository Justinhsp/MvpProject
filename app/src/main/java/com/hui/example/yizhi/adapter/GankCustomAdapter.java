package com.hui.example.yizhi.adapter;

import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hui.example.yizhi.R;
import com.hui.example.yizhi.bean.GankCustomItemBean;
import com.hui.example.yizhi.utils.StringUtils;
import com.hui.example.yizhi.widget.RvLoadMoreView;

import java.util.List;

public class GankCustomAdapter extends BaseMultiItemQuickAdapter<GankCustomItemBean,BaseViewHolder> {

    private String mImageSize = "?imageView2/0/w/200";

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public GankCustomAdapter(List<GankCustomItemBean> data) {
        super(data);
        setLoadMoreView(new RvLoadMoreView());
        setEnableLoadMore(true);
        openLoadAnimation();

        addItemType(GankCustomItemBean.GANK_IO_DAY_ITEM_CUSTOM_NORMAL, R.layout.item_gank_io_custom_normal);
        addItemType(GankCustomItemBean.GANK_IO_DAY_ITEM_CUSTOM_IMAGE, R.layout.item_gank_io_custom_image);
        addItemType(GankCustomItemBean.GANK_IO_DAY_ITEM_CUSTOM_NO_IMAGE, R.layout.item_gank_io_custom_no_image);
    }

    @Override
    protected void convert(BaseViewHolder helper, GankCustomItemBean item) {
        initTypeImage(helper, item);

        helper.setText(R.id.tv_item_who, StringUtils.isEmpty(item.getWho()) ? "佚名" : item
                .getWho());
        helper.setText(R.id.tv_item_type, item.getType());
        helper.setText(R.id.tv_item_time, item.getCreatedAt().substring(0, 10));


        switch (helper.getItemViewType()) {
            case GankCustomItemBean.GANK_IO_DAY_ITEM_CUSTOM_NORMAL:
                helper.setText(R.id.tv_item_title, item.getDesc());
                //initTitleColor(helper, item);
                if (item.getImages() != null) {
                    if (item.getImages().size() > 0 && !TextUtils.isEmpty(item.getImages().get(0)))
                        Glide.with(mContext)
                                .load(item.getImages().get(0) + mImageSize)
                                .into((ImageView) helper.getView(R.id.iv_item_image));
                }
                break;
            case GankCustomItemBean.GANK_IO_DAY_ITEM_CUSTOM_IMAGE:
                RequestOptions requestOptions=new RequestOptions()
                        .centerCrop()
                        .placeholder(R.mipmap.img_default_meizi);

                Glide.with(mContext)
                        .load(item.getUrl())
                        .apply(requestOptions)
                        .into((ImageView) helper.getView(R.id.iv_item_image));
                break;
            case GankCustomItemBean.GANK_IO_DAY_ITEM_CUSTOM_NO_IMAGE:
                helper.setText(R.id.tv_item_title, item.getDesc());
                //initTitleColor(helper, item);
                break;
            default:
                break;
        }
    }


    private void initTypeImage(BaseViewHolder helper, GankCustomItemBean item) {
        switch (item.getType()) {
            case "福利":
                helper.setImageResource(R.id.iv_type_item_title, R.drawable
                        .ic_vector_title_welfare);
                break;
            case "Android":
                helper.setImageResource(R.id.iv_type_item_title, R.drawable
                        .ic_vector_title_android);
                break;
            case "iOS":
                helper.setImageResource(R.id.iv_type_item_title, R.drawable.ic_vector_title_ios);
                break;
            case "前端":
                helper.setImageResource(R.id.iv_type_item_title, R.drawable.ic_vector_title_front);
                break;
            case "休息视频":
                helper.setImageResource(R.id.iv_type_item_title, R.drawable.ic_vector_title_video);
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
    }
}
