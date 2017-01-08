package com.proledesign.secretsantaquiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class SecondQuestion extends AppCompatActivity {

    private Button mButton;

    private EditText mEditText;

    private TextView mTextView;


    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

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
               query2();

            }
        });


    }


    private void query2 () {

        String textEntered = mEditText.getText().toString();


        if ("1873".equals(textEntered)) {
            Toast.makeText(SecondQuestion.this, "Bravo Siniša! Drug prešjednik ti želi sve najbolje u novoj godini!", Toast.LENGTH_LONG).show();


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.klubljubiteljazeleznice-beograd.com/about.php"));
                    startActivity(intent);
                }
            }, 3000);


        } else {
            Toast.makeText(SecondQuestion.this, "Ooops nije tačno!", Toast.LENGTH_SHORT).show();
            mEditText.setText("");
        }

    }

}
