package com.joe.indoorlocalization.Calibration;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.joe.indoorlocalization.CustomImageView;
import com.joe.indoorlocalization.R;

/**
 * Created by joe on 22/11/15.
 */
public class CustomImageViewCalibrate extends CustomImageView {

    static String TAG = CustomImageViewCalibrate.class.getSimpleName();


    public CustomImageViewCalibrate(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setX(float x) {
        TextView test = (TextView) ((Activity) getContext()).findViewById(R.id.positionX);
        test.setText("x: " + x);
    }

    @Override
    public void setY(float y) {
        TextView test = (TextView) ((Activity) getContext()).findViewById(R.id.positionY);
        test.setText("y: " + y);
    }

    @Override
    public void setText() {
    }

}