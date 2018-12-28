package com.hui.example.yizhi.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hui.example.yizhi.R;
import com.hui.example.yizhi.bean.GankWelFareItemBean;

import java.util.List;

/**
 * 福利 Adapter
 */
public class GankWelFareAdapter extends BaseCompatAdapter<GankWelFareItemBean,BaseViewHolder> {

    public GankWelFareAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    public GankWelFareAdapter(@LayoutRes int layoutResId, @Nullable List<GankWelFareItemBean>
            data) {
        super(layoutResId, data);
    }

    public GankWelFareAdapter(@Nullable List<GankWelFareItemBean> data) {
        super(data);
    }



    @Override
    protected void convert(BaseViewHolder helper, GankWelFareItemBean item) {

        RequestOptions requestOptions=new RequestOptions()
                .placeholder(R.mipmap.img_default_meizi)
                .centerCrop();

        Glide.with(mContext)
                .load(item.getUrl())
                .apply(requestOptions)
                .into((ImageView) helper.getView(R.id.iv_item_image));
    }
}
