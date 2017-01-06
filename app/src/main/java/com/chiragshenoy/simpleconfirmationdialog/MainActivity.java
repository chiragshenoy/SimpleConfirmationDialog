package com.chiragshenoy.simpleconfirmationdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chiragshenoy.simpleconifrmationdialog.CustomDialog;
import com.chiragshenoy.simpleconifrmationdialog.SimpleConfirmationDialog;

public class MainActivity extends AppCompatActivity {
    SimpleConfirmationDialog dialog;
    SimpleConfirmationDialog.SimpleConfirmationDialogBuilder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SimpleConfirmationDialog.OnButtonClickListener listener = new SimpleConfirmationDialog.OnButtonClickListener() {
            @Override
            public void onClick(View v, CustomDialog dialog) {
                Toast.makeText(MainActivity.this, "ButtonClick", Toast.LENGTH_SHORT).show();
            }
        };
        builder = new SimpleConfirmationDialog.SimpleConfirmationDialogBuilder(this);
        builder.withTitle("Title");
        builder.withDescription("Description");
        builder.withLeftButton("left",listener);
        builder.withRightButton("right",listener);
        builder.build();
        dialog = new SimpleConfirmationDialog(builder);
        dialog.show();
    }
}
