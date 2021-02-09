package com.example.gehu.progressbar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {
ProgressBar p;
int counter=0;
TextView t;
Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p=(ProgressBar)findViewById(R.id.progressBar2);
        t=findViewById(R.id.textView);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(counter<100) {
                    counter += 1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            p.setProgress(counter);
                            t.setText(counter + "/" + p.getMax());
                        }
                    });
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

    }

}
