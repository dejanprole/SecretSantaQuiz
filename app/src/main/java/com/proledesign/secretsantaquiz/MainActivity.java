package com.proledesign.secretsantaquiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mButton;

    private EditText mEditText;

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/dosisRegular.ttf");
        Typeface typefaceSemiBold = Typeface.createFromAsset(getAssets(), "fonts/dosisBold.ttf");


        mButton = (Button) findViewById(R.id.gumb1);
        mButton.setTypeface(typefaceSemiBold);

        mEditText = (EditText) findViewById(R.id.field1);
        mEditText.setTypeface(typefaceSemiBold);
        mEditText.getBackground().setAlpha(80);

        mTextView = (TextView) findViewById(R.id.query1);
        mTextView.setTypeface(typeface);
        mTextView.getBackground().setAlpha(80);




        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queryTrackWidth();
            }
        });



    }

    private void queryTrackWidth () {

        String textEntered = mEditText.getText().toString();


        if ("1435".equals(textEntered)) {
            Toast.makeText(MainActivity.this, "Bravo!", Toast.LENGTH_SHORT ).show();


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    final Intent intent = new Intent(getApplicationContext(), SecondQuestion.class);
                    startActivity(intent);
                }
            }, 3000);


        } else {
            Toast.makeText(MainActivity.this, "Ooops nije tačno!", Toast.LENGTH_SHORT ).show();
            mEditText.setText("");
        }

    }







}
