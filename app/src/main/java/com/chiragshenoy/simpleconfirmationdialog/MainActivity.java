package com.chiragshenoy.simpleconfirmationdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chiragshenoy.simpleconifrmationdialog.ConfirmationAction;
import com.chiragshenoy.simpleconifrmationdialog.CustomDialog;
import com.chiragshenoy.simpleconifrmationdialog.SimpleConfirmationDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    SimpleConfirmationDialog dialog;
    SimpleConfirmationDialog.SimpleConfirmationDialogBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpDialog();
    }

    private void setUpDialog() {
        SimpleConfirmationDialog.OnButtonClickListener listener = new SimpleConfirmationDialog.OnButtonClickListener() {
            @Override
            public void onClick(View v, CustomDialog dialog) {
                Toast.makeText(MainActivity.this, "ButtonClick", Toast.LENGTH_SHORT).show();
            }
        };

        builder = new SimpleConfirmationDialog.SimpleConfirmationDialogBuilder(this);
        builder.withTitle("Title")
                .withDescription("Description")
                .withLeftButton("left", listener)
                .withRightButton("right", listener)
                .withButtonSelector(R.drawable.button_selector, ConfirmationAction.POSITIVE)
                //use withButtonSelector(drawable) to add the same selector for both the buttons
                .withTypeface("CaviarDreams.ttf").build();

        dialog = new SimpleConfirmationDialog(builder);
    }

    @OnClick(R.id.show_dialog)
    public void showDialog() {
        Log.e("Dialog", "showing");
        dialog.show();
    }

}
