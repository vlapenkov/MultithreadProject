package com.yst.sms.multithreadproject;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;
import java.util.concurrent.TimeUnit;

//
// основная активность - в ней запускаем
//
public class MainActivity extends AppCompatActivity {

    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;
    TextView text1;

    private static final Object lock= new Object();

    Handler handler = new Handler(    ) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            final  TextView text1 =(TextView) findViewById(R.id.Text1);
      //      text1.setText("Job done!");

            text1.setText(Integer.toString(msg.arg1));
        }
    };

    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button but1 =(Button) findViewById(R.id.Button1);
    /*  final  TextView */ text1 =(TextView) findViewById(R.id.Text1);

      final  Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
               //     Thread.sleep(10000);
                //    synchronized (lock)
                    {
                        TimeUnit.SECONDS.sleep(5);
                   // wait(5000);
                    //    Thread.sleep(5000);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

               Message msg =   handler.obtainMessage(1,++counter,0);
                handler.sendMessage( msg);
                // this code throws exception
                //   text1.setText(Integer.toString(++counter));
            }
        };
//  кнопка 1 - запуск асинхронного потока вне птока данной активности
        but1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new Thread(r).start();
            }
        });
    }

    //  кнопка 2 - запуск второй активности
    public void Button2Click(View v){
        Intent intent = new Intent(this, ActivitySecond.class);

  //      intent.putExtra(PRODUCT_ID_MESSAGE, Long.toString(id));

        startActivity(intent);
    }


    //  кнопка 3 - запуск сервиса который через минуту отправит уведомление, даже если это приложение не работает
    public void Button3Click(View v){


        Log.d("ALARM SET BEGIN", "onReceive");
        alarmMgr = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent  intentToCall = new Intent(this, AlarmReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(this, 0, intentToCall, 0);

        alarmMgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() +
                        60 * 1000, alarmIntent);
        Log.d("ALARM SET END", "onReceive");

    }


/*
    public class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String result = intent
                    .getStringExtra(MyIntentService.EXTRA_KEY_OUT);
            text1.setText(result);
//        mInfoTextView.setText(result);
        }
    }
    */
}
