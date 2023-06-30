package com.busanit.ex09_delay;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request();
            }
        });
    }

    private void request() {
        AlertDialog.Builder requestDialog = new AlertDialog.Builder(this);
        requestDialog.setTitle("원격 요청");
        requestDialog.setMessage("데이터를 요청하시겠습니까?");
        requestDialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText("5초 후에 결과 표시됨");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("요청 완료됨.");
                    }
                },5000);
            }
        });
        requestDialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        requestDialog.show();
        textView.setText("대화상자 표시 중...");

//        String title = "원격 요청";
//        String message = "데이터를 요청하시겠습니까?";
//        String titleButtonYes = "예";
//        String titleButtonNo = "아니오";
//        AlertDialog dialog = makeRequestDialog(title,message,titleButtonYes,titleButtonNo);
//        dialog.show();
    }

//    private AlertDialog makeRequestDialog(String title, String message, String titleButtonYes, String titleButtonNo) {
//        AlertDialog.Builder requestDialog = new AlertDialog.Builder(this);
//        requestDialog.setTitle(title);
//        requestDialog.setMessage(message);
//        requestDialog.setPositiveButton(titleButtonYes, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                textView.setText("5초 후에 결과 표시됨.");
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText("요청 완료됨");
//                    }
//                }, 5000);
//            }
//        });
//        requestDialog.setNegativeButton(titleButtonNo, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//
//        return requestDialog.create();
    }
