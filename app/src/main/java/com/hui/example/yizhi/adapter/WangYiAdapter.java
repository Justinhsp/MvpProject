package com.hui.example.yizhi.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hui.example.yizhi.R;
import com.hui.example.yizhi.bean.WangyiNewsItemBean;

import java.util.List;

public class WangYiAdapter extends BaseCompatAdapter<WangyiNewsItemBean,BaseViewHolder> {

    public WangYiAdapter(int layoutResId) {
        super(layoutResId);
    }

    public WangYiAdapter(int layoutResId, @Nullable List<WangyiNewsItemBean> data) {
        super(layoutResId, data);
    }

    public WangYiAdapter(@Nullable List<WangyiNewsItemBean> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WangyiNewsItemBean item) {
        helper.setText(R.id.tv_item_title, item.getTitle());
        helper.setText(R.id.tv_item_who, item.getSource());
        helper.setText(R.id.tv_item_time, item.getPtime());
        Glide.with(mContext)
                .load(item.getImgsrc())
                .into((ImageView) helper.getView(R
                .id.iv_item_image));
    }
}
