package com.hui.example.yizhi.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hui.example.yizhi.R;
import com.hui.example.yizhi.bean.ZhihuDailyItemBean;

import java.util.List;

/**
 * 知乎 Adapter
 */
public class ZhuHuAdapter extends BaseCompatAdapter<ZhihuDailyItemBean,BaseViewHolder> {

    public ZhuHuAdapter(int layoutResId) {
        super(layoutResId);
    }

    public ZhuHuAdapter(int layoutResId, @Nullable List<ZhihuDailyItemBean> data) {
        super(layoutResId, data);
    }

    public ZhuHuAdapter(@Nullable List<ZhihuDailyItemBean> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZhihuDailyItemBean item) {
        helper.setText(R.id.tv_item_title, item.getTitle());

        RequestOptions requestOptions=new RequestOptions()
                .centerCrop();

        Glide.with(mContext)
                .load(item.getImages()[0])
                .apply(requestOptions)
                .into((ImageView) helper.getView(R.id.iv_item_image));
    }
}
