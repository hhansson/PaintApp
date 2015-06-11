package io.intrepid.hhansson.paintapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.zip.Inflater;


public class MainActivity extends Activity implements View.OnClickListener{
    private PaintingView paintingView;
    private Button undoButton;
    private Button colorButton;
    private Button sizeButton;
    private Button redButton;
    private Button yellowButton;
    private Button blueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.painting_view);
        paintingView = (PaintingView) findViewById(R.id.painting);
        paintingView.setupDrawing();

        undoButton = (Button) findViewById(R.id.undo_button);
        colorButton = (Button) findViewById(R.id.color_selection_button);
        sizeButton = (Button) findViewById(R.id.size_selection_button);
        redButton = (Button) findViewById(R.id.red_button);
        yellowButton = (Button) findViewById(R.id.yellow_button);
        blueButton = (Button) findViewById(R.id.blue_button);
        //Set onClick for all buttons
        undoButton.setOnClickListener(this);
        colorButton.setOnClickListener(this);
        sizeButton.setOnClickListener(this);
        redButton.setOnClickListener(this);
        yellowButton.setOnClickListener(this);
        blueButton.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.undo_button):
                break;
            case (R.id.color_selection_button):
                redButton.setVisibility(View.VISIBLE);
                yellowButton.setVisibility(View.VISIBLE);
                blueButton.setVisibility(View.VISIBLE);
                break;
            case (R.id.size_selection_button):
                break;
            case (R.id.red_button):
                redButton.setVisibility(View.GONE);
                yellowButton.setVisibility(View.GONE);
                blueButton.setVisibility(View.GONE);
                paintingView.changePaintColor(0xffff0000);
                break;
            case (R.id.yellow_button):
                //Disappear color choices
                redButton.setVisibility(View.GONE);
                yellowButton.setVisibility(View.GONE);
                blueButton.setVisibility(View.GONE);
                paintingView.changePaintColor(0xffffff00);
                break;
            case (R.id.blue_button):
                //Disappear color choices
                redButton.setVisibility(View.GONE);
                yellowButton.setVisibility(View.GONE);
                blueButton.setVisibility(View.GONE);
                paintingView.changePaintColor(0xff0000ff);
                break;
        }
    }
}
