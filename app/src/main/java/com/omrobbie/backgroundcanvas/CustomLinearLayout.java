package com.omrobbie.backgroundcanvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.io.LineNumberReader;

/**
 * Created by omrobbie on 26/03/18.
 */

public class CustomLinearLayout extends LinearLayout {
    private Paint paint;
    private Bitmap bitmap;

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tile);
        bitmap = Bitmap.createScaledBitmap(bitmap, 200, 200, true);

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPaint(paint);
    }
}
