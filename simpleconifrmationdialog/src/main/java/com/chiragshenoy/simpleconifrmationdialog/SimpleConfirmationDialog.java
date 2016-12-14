package com.chiragshenoy.simpleconifrmationdialog;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by chiragshenoy on 14/12/16.
 */

public class SimpleConfirmationDialog {

    private String title;
    private String description;
    private Context context;
    private boolean cancellable = true;

    private CustomDialog dialog;
    private Button leftButton, rightButton;
    private TextView titleTextView;
    private TextView descriptionTextView;
    private ImageView imageView;

    private int imageResource;
    private int titleColor;
    private int descriptionColor;

    private boolean showLeftButton = false;
    private boolean showRightButton = false;

    public interface OnButtonClickListener {
        void onClick(View v, CustomDialog dialog);
    }

    public SimpleConfirmationDialog(SimpleConfirmationDialogBuilder builder) {
        this.context = builder.context;
        this.title = builder.title;
        this.titleColor = builder.titleColor;
        this.description = builder.description;
        this.descriptionColor = builder.descriptionColor;
        this.imageResource = builder.imageResource;
        this.showLeftButton = builder.showLeftButton;
        this.showRightButton = builder.showRightButton;
        this.cancellable = builder.cancellable;
        this.leftButton = builder.leftButton;
        this.titleTextView = builder.titleTextView;
        this.rightButton = builder.rightButton;
        this.descriptionTextView = builder.descriptionTextView;
        this.imageView = builder.imageView;
        this.dialog = builder.dialog;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public int getDescriptionColor() {
        return descriptionColor;
    }

    public void show() {

        if (title != null && !title.isEmpty() && titleTextView != null) {
            titleTextView.setVisibility(View.VISIBLE);

            if (titleColor != 0) {
                titleTextView.setTextColor(ContextCompat.getColor(context, titleColor));
            }

            titleTextView.setText(title);
        }


        if (description != null && !description.isEmpty() && descriptionTextView != null) {
            descriptionTextView.setVisibility(View.VISIBLE);

            if (descriptionColor != 0) {
                descriptionTextView.setTextColor(ContextCompat.getColor(context, descriptionColor));
            }

            descriptionTextView.setText(description);
        }

        if (leftButton != null && showLeftButton) {
            leftButton.setVisibility(View.VISIBLE);
        }

        if (rightButton != null && showRightButton) {
            rightButton.setVisibility(View.VISIBLE);
        }

        if (imageResource != 0 && imageView != null) {
            imageView.setImageResource(imageResource);
            imageView.setVisibility(View.VISIBLE);
        }

        dialog.setCancelable(cancellable);
        dialog.show();

    }

    public static class SimpleConfirmationDialogBuilder {
        private String title;
        private String description;
        private Context context;
        private boolean cancellable = true;

        private View dialogViewLayout;
        private Button leftButton, rightButton;
        private TextView titleTextView;
        private TextView descriptionTextView;
        private ImageView imageView;

        private int imageResource;
        private int titleColor;
        private int descriptionColor;

        private boolean showLeftButton = false;
        private boolean showRightButton = false;

        private CustomDialog dialog;

        public SimpleConfirmationDialog build() {
            dialog = new CustomDialog(context, dialogViewLayout);
            return new SimpleConfirmationDialog(this);
        }

        public SimpleConfirmationDialogBuilder(Context context) {
            this.context = context;
            dialogViewLayout = LayoutInflater.from(context).inflate(R.layout.dialog_viewer_layout, null, false);
            leftButton = (Button) dialogViewLayout.findViewById(R.id.leftButton);
            rightButton = (Button) dialogViewLayout.findViewById(R.id.rightButton);
            titleTextView = (TextView) dialogViewLayout.findViewById(R.id.dialog_title);
            descriptionTextView = (TextView) dialogViewLayout.findViewById(R.id.dialog_description);
            imageView = (ImageView) dialogViewLayout.findViewById(R.id.dialog_image);
        }

        public SimpleConfirmationDialogBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public SimpleConfirmationDialogBuilder withTitleColor(int color) {
            this.titleColor = color;
            return this;
        }

        public SimpleConfirmationDialogBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public SimpleConfirmationDialogBuilder withDescriptionColor(int color) {
            this.descriptionColor = color;
            return this;
        }

        public SimpleConfirmationDialogBuilder withImage(int imageResource) {
            this.imageResource = imageResource;
            return this;
        }

        public SimpleConfirmationDialogBuilder withLeftButton(String text, final OnButtonClickListener onButtonClickListener) {
            showLeftButton = true;
            setUpClickListenerAndText(leftButton, text, onButtonClickListener);
            return this;
        }

        public SimpleConfirmationDialogBuilder withRightButton(String text, final OnButtonClickListener onButtonClickListener) {
            showRightButton = true;
            setUpClickListenerAndText(rightButton, text, onButtonClickListener);
            return this;
        }

        public SimpleConfirmationDialogBuilder isCancellable(boolean cancellable) {
            this.cancellable = cancellable;
            return this;
        }

        private void setUpClickListenerAndText(Button Button, String text, final OnButtonClickListener onButtonClickListener) {
            Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onButtonClickListener.onClick(v, dialog);
                }
            });
            Button.setText(text);
        }
    }

}
