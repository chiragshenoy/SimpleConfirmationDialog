package com.chiragshenoy.simpleconifrmationdialog;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.view.Window;

/**
 * Created by chiragshenoy on 14/12/16.
 */

public class CustomDialog extends AppCompatDialog {

    private View view;

    CustomDialog(Context context, View layout) {
        super(context);
        view = layout;
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(view);
        super.onCreate(savedInstanceState);
    }

}
