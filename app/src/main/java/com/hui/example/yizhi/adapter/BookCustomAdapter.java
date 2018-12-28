package com.hui.example.yizhi.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hui.example.yizhi.R;
import com.hui.example.yizhi.bean.BookItemBean;

import java.util.List;

public class BookCustomAdapter extends BaseCompatAdapter<BookItemBean,BaseViewHolder> {

    public BookCustomAdapter(@Nullable List<BookItemBean> data) {
        super(data);
    }

    public BookCustomAdapter(int layoutResId) {
        super(layoutResId);
    }

    public BookCustomAdapter(int layoutResId, @Nullable List<BookItemBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BookItemBean item) {
        helper.setText(R.id.tv_item_title, "《" + item.getTitle() + "》");
        helper.setText(R.id.tv_item_author, "作者：" + item.getAuthorsString());
        helper.setText(R.id.tv_item_publisher, "出版社：" + item.getPublisher());
        helper.setText(R.id.tv_item_pubdate, "出版日期：" + item.getPubdate());
        helper.setText(R.id.tv_item_rate, "评分：" + item.getRating().getAverage());
        Glide.with(mContext).load(item.getImage()).into((ImageView) helper.getView
                (R.id.iv_item_image));
    }
}
