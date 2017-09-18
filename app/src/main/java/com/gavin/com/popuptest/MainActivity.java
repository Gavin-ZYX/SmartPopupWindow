package com.gavin.com.popuptest;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.gavin.com.smartpopupwindow.HorizontalPosition;
import com.gavin.com.smartpopupwindow.SmartPopupWindow;
import com.gavin.com.smartpopupwindow.VerticalPosition;

public class MainActivity extends AppCompatActivity {

    private TestPopupWindow mWindow;

    private View mButton;
    private View mPopupContentView;

    private int mGravity = Gravity.START;
    private int mOffsetX = 0;
    private int mOffsetY = 0;

    private boolean useSmartPopup = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWindow = new TestPopupWindow(this);
        mButton = findViewById(R.id.btn);
        mPopupContentView = getLayoutInflater().inflate(R.layout.popup_test, null);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg);


        mWindow = new TestPopupWindow(this);
        View contentView = mWindow.getContentView();
        //需要先测量，PopupWindow还未弹出时，宽高为0
        contentView.measure(makeDropDownMeasureSpec(mWindow.getWidth()), makeDropDownMeasureSpec(mWindow.getHeight()));
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.below_left:
                        mGravity = Gravity.START;
                        mOffsetX = -mWindow.getContentView().getMeasuredWidth();
                        mOffsetY = 0;
                        //使用SmartPopup
                        if (useSmartPopup)
                            SmartPopupWindow.Builder
                                    .build(MainActivity.this, mPopupContentView)
                                    .createPopupWindow()
                                    .showAtAnchorView(mButton, VerticalPosition.BELOW, HorizontalPosition.LEFT);
                        break;
                    case R.id.below_align_left:
                        mGravity = Gravity.START;
                        mOffsetX = 0;
                        mOffsetY = 0;
                        //使用SmartPopup
                        if (useSmartPopup)
                            SmartPopupWindow.Builder
                                    .build(MainActivity.this, mPopupContentView)
                                    .createPopupWindow()
                                    .showAtAnchorView(mButton, VerticalPosition.BELOW, HorizontalPosition.ALIGN_LEFT);

                        break;
                    case R.id.below_right:
                        mGravity = Gravity.END;
                        mOffsetX = 0;
                        mOffsetY = 0;
                        //使用SmartPopup
                        if (useSmartPopup)
                            SmartPopupWindow.Builder
                                    .build(MainActivity.this, mPopupContentView)
                                    .createPopupWindow()
                                    .showAtAnchorView(mButton, VerticalPosition.BELOW, HorizontalPosition.RIGHT);

                        break;
                    case R.id.below_align_right:
                        mGravity = Gravity.START;
                        mOffsetX = mButton.getWidth() - mWindow.getContentView().getMeasuredWidth();
                        mOffsetY = 0;
                        //使用SmartPopup
                        if (useSmartPopup)
                            SmartPopupWindow.Builder
                                    .build(MainActivity.this, mPopupContentView)
                                    .createPopupWindow()
                                    .showAtAnchorView(mButton, VerticalPosition.BELOW, HorizontalPosition.ALIGN_RIGHT);

                        break;
                    case R.id.below_center:
                        mGravity = Gravity.START;
                        mOffsetX = Math.abs(mWindow.getContentView().getMeasuredWidth() - mButton.getWidth()) / 2;
                        mOffsetY = 0;
                        //使用SmartPopup
                        if (useSmartPopup)
                            SmartPopupWindow.Builder
                                    .build(MainActivity.this, mPopupContentView)
                                    .createPopupWindow()
                                    .showAtAnchorView(mButton, VerticalPosition.BELOW, HorizontalPosition.CENTER);

                        break;
                    case R.id.above_center:
                        mGravity = Gravity.START;
                        mOffsetX = Math.abs(mWindow.getContentView().getMeasuredWidth() - mButton.getWidth()) / 2;
                        mOffsetY = -(mWindow.getContentView().getMeasuredHeight() + mButton.getHeight());
                        //使用SmartPopup
                        if (useSmartPopup)
                            SmartPopupWindow.Builder
                                    .build(MainActivity.this, mPopupContentView)
                                    .createPopupWindow()
                                    .showAtAnchorView(mButton, VerticalPosition.ABOVE, HorizontalPosition.CENTER);

                        break;
                    case R.id.left_center:
                        mGravity = Gravity.START;
                        mOffsetX = -mWindow.getContentView().getMeasuredWidth();
                        mOffsetY = -(mWindow.getContentView().getMeasuredHeight() + mButton.getHeight()) / 2;
                        //使用SmartPopup
                        if (useSmartPopup)
                            SmartPopupWindow.Builder
                                    .build(MainActivity.this, mPopupContentView)
                                    .createPopupWindow()
                                    .showAtAnchorView(mButton, VerticalPosition.CENTER, HorizontalPosition.LEFT);

                        break;
                    case R.id.right_center:
                        mGravity = Gravity.END;
                        mOffsetX = 0;
                        mOffsetY = -(mWindow.getContentView().getMeasuredHeight() + mButton.getHeight()) / 2;
                        //使用SmartPopup
                        if (useSmartPopup)
                            SmartPopupWindow.Builder
                                    .build(MainActivity.this, mPopupContentView)
                                    .createPopupWindow()
                                    .showAtAnchorView(mButton, VerticalPosition.CENTER, HorizontalPosition.RIGHT);

                        break;
                }
            }
        });
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });
    }

    @SuppressWarnings("ResourceType")
    private static int makeDropDownMeasureSpec(int measureSpec) {
        int mode;
        if (measureSpec == ViewGroup.LayoutParams.WRAP_CONTENT) {
            mode = View.MeasureSpec.UNSPECIFIED;
        } else {
            mode = View.MeasureSpec.EXACTLY;
        }
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(measureSpec), mode);
    }

    private void showPopup() {
        PopupWindowCompat.showAsDropDown(mWindow, mButton, mOffsetX, mOffsetY, mGravity);
    }

}
