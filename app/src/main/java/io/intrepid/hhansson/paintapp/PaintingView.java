package io.intrepid.hhansson.paintapp;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by hayleyhansson on 6/9/15.
 */
public class PaintingView extends View {

    private Paint paint;
    private Path path;
    private int paintColor;
    private int canvasPaint;
    private DisplayMetrics display = new DisplayMetrics();
    private Bitmap bitmap = null;
    private Canvas canvas;

    public PaintingView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }


    public void setupDrawing () {
        path = new Path();
        paint = new Paint();
        canvasPaint = 0xffffffff;
        //canvas.drawColor(canvasPaint);
        paintColor = 0xff000000;
        paint.setColor(paintColor);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);

        //canvasPaint = new Paint(Paint.DITHER_FLAG);
    }


    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                canvas.drawPath(path, paint);
                path.reset();
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        canvas.drawColor(canvasPaint);
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.drawPath(path, paint);
    }

    public void changePaintColor (int color){
        paintColor = color;
        paint.setColor(paintColor);
    }

    public void changeBrushSize (int size){
        paint.setStrokeWidth(size);
    }

    public void erasePaint () {
        paintColor = canvasPaint;
        paint.setColor(paintColor);
    }
}
