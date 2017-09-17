# SmartPopupWindow
用法：
```java
 SmartPopupWindow.Builder
    .build(Activity.this, view)
    .setBackgroundAlpha(0.4f)                   //背景灰度     默认全透明
    .setOutsideTouchDismiss(false)    //点击外部消失  默认true（消失）
    .showAtAnchorView(view, VerticalPosition.ABOVE, HorizontalPosition.LEFT, 0, 0);
```
