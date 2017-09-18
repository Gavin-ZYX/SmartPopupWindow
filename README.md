# SmartPopupWindow
用法：
```java
 SmartPopupWindow popupWindow= SmartPopupWindow.Builder
     .build(Activity.this, view)
     .setAlpha(0.4f)                   //背景灰度     默认全透明
     .setOutsideTouchDismiss(false)    //点击外部消失  默认true（消失）
     .createPopupWindow();
 popupWindow.showAtAnchorView(view, VerticalPosition.ABOVE, HorizontalPosition.CENTER);
```
水平方向参数HorizontalPosition：LEFT 、 RIGHT 、 ALIGN_LEFT 、 ALIGN_RIGHT、 CENTER
竖直方向参数VerticalPosition ：ABOVE 、 BELOW、 ALIGN_TOP 、 ALIGN_BOTTOM、 CENTER
