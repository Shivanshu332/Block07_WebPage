package com.example.block07_webpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NumberPicker possibilities=(NumberPicker) findViewById(R.id.numberPage);

        String[] possibilitiesString={ "Android", "Check text-input field", "Coursera", "Instagam" };
        possibilities.setDisplayedValues(possibilitiesString);
        possibilities.setMinValue(0);
        possibilities.setMaxValue(possibilitiesString.length-1);

        final WebView webPage= findViewById(R.id.webPage);

        Button btnOk = (Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int choice= possibilities.getValue();
                if (choice==0) {
                    webPage.setWebViewClient(new WebViewClient());
                    webPage.loadUrl("file:///android_asset/android.html");
                }
                else if(choice==1)
                    webPage.loadUrl("https://www.w3schools.com");
                else if(choice==2)
                    webPage.loadUrl("https://www.coursera.org");
                else if(choice==3)
                    webPage.loadUrl("https://www.instagram.com");
            }
        });
    }
}