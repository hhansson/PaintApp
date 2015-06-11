package io.intrepid.hhansson.paintapp;

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
public class PaintingView extends Fragment {

    private Paint paint;
    private Path path;
    private int paintColor = 0xFF660000;
    private Paint canvasPaint;
    private DisplayMetrics display = new DisplayMetrics();
    private Bitmap bitmap = null;
    //private Button undoButton, colorButton, sizeButton;
    //private Button redButton, yellowButton, blueButton;
    private Canvas canvas;

   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        undoButton = (Button) getView().findViewById(R.id.undo_button);
        colorButton = (Button) getView().findViewById(R.id.color_selection_button);
        sizeButton = (Button) getView().findViewById(R.id.size_selection_button);
        redButton = (Button) getView().findViewById(R.id.red_button);
        yellowButton = (Button) getView().findViewById(R.id.yellow_button);
        blueButton = (Button) getView().findViewById(R.id.blue_button);
        //Set onClick for all buttons
        undoButton.setOnClickListener(this);
        colorButton.setOnClickListener(this);
        sizeButton.setOnClickListener(this);
        redButton.setOnClickListener(this);
        yellowButton.setOnClickListener(this);
        blueButton.setOnClickListener(this);

        Log.v ("Custom Log: ", "onCreateView in Fragment accessed");
        return inflater.inflate(R.layout.fragment_main, container, false);
    }*/

    public void setupDrawing () {
        path = new Path();
        paint = new Paint();
        paint.setColor(paintColor);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);

        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    /*public void onClick(View view){
        switch (view.getId()){
            case (R.id.undo_button):
                break;
            case (R.id.color_selection_button): redButton.setVisibility(View.VISIBLE);
                yellowButton.setVisibility(View.VISIBLE);
                blueButton.setVisibility(View.VISIBLE);
                break;
            case (R.id.size_selection_button):
                break;
            case (R.id.red_button):
                Log.w("Log: ", "Red button click");
                //Disappear color choices
                redButton.setVisibility(View.GONE);
                yellowButton.setVisibility(View.GONE);
                blueButton.setVisibility(View.GONE);
                //CHANGE COLOR TO RED
                break;
            case (R.id.yellow_button):
                //Disappear color choices
                redButton.setVisibility(View.GONE);
                yellowButton.setVisibility(View.GONE);
                blueButton.setVisibility(View.GONE);
                //CHANGE COLOR TO YELLOW
                break;
            case (R.id.blue_button):
                //Disappear color choices
                redButton.setVisibility(View.GONE);
                yellowButton.setVisibility(View.GONE);
                blueButton.setVisibility(View.GONE);
                //CHANGE COLOR TO BLUE
                break;
        }
    }*/

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
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.drawPath(path, paint);
    }

}
