package com.example.calculator.my_control;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/*
 *带有边框的标签
 */
public class MyTextView extends androidx.appcompat.widget.AppCompatTextView {
    Paint paint = new Paint();

    public MyTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        //绘制边框
        canvas.drawLine(0,1,this.getWidth(),1,paint);//上
        canvas.drawLine(0,this.getHeight()-1,this.getWidth(),this.getHeight()-1,paint);//下
        canvas.drawLine(0,0,0,this.getHeight(),paint);//左
        canvas.drawLine(this.getWidth()-1,0,this.getWidth()-1,this.getHeight(),paint);//右
    }
}
