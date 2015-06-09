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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by hayleyhansson on 6/9/15.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    private Paint paint = new Paint();
    private Path path = new Path();
    private Color color = new Color();
    private DisplayMetrics display = new DisplayMetrics();
    private Bitmap bitmap = Bitmap.createBitmap(display, R.dimen.activity_horizontal_margin, R.dimen.activity_vertical_margin, Bitmap.Config.ARGB_8888);
    private Button undoButton, colorButton, sizeButton;
    private Button redButton, yellowButton, blueButton;
    private Canvas canvas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        undoButton = (Button) getView().findViewById(R.id.undo_button);
        colorButton = (Button) getView().findViewById(R.id.color_selection_button);
        sizeButton = (Button) getView().findViewById(R.id.size_selection_button);
        redButton = (Button) getView().findViewById(R.id.red_button);
        yellowButton = (Button) getView().findViewById(R.id.yellow_button);
        blueButton = (Button) getView().findViewById(R.id.blue_button);
        undoButton.setOnClickListener(this);
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    public void onClick(View view){
        switch (view.getId()){
            case (R.id.undo_button):
                break;
            case (R.id.color_selection_button): redButton.setVisibility(View.VISIBLE);
                yellowButton.setVisibility(View.VISIBLE);
                blueButton.setVisibility(View.VISIBLE);
                break;
            case (R.id.size_selection_button): sizeSelector();
                break;
            case (R.id.red_button):
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
    }

    private void sizeSelector() {

    }

}
