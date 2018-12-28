package com.hui.example.yizhi.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hui.example.yizhi.R;
import com.hui.example.yizhi.bean.WeixinChoiceItemBean;

import java.util.List;

public class WeiXinAdapter extends BaseCompatAdapter<WeixinChoiceItemBean,BaseViewHolder> {

    public WeiXinAdapter(@Nullable List<WeixinChoiceItemBean> data) {
        super(data);
    }

    public WeiXinAdapter(int layoutResId) {
        super(layoutResId);
    }

    public WeiXinAdapter(int layoutResId, @Nullable List<WeixinChoiceItemBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WeixinChoiceItemBean item) {
        helper.setText(R.id.tv_item_title, item.getTitle());
        helper.setText(R.id.tv_item_who, item.getSource());
        Glide.with(mContext).load(item.getFirstImg()).into((ImageView) helper.getView(R
                .id.iv_item_image));
    }
}
