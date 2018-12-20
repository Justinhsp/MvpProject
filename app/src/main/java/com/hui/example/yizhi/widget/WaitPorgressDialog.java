package com.hui.example.yizhi.widget;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * 等待提示Dialog
 */
public class WaitPorgressDialog extends ProgressDialog {

    public WaitPorgressDialog(Context context) {
        this(context,0);
    }

    public WaitPorgressDialog(Context context, int theme) {
        super(context, theme);
        setCanceledOnTouchOutside(false);
    }
}
