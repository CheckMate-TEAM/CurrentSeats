package com.example.currentseats;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    static GridLayout.Spec spec(int start[, int size, GridLayout.Alignment ali]) {
//        return null;
//    }

    ViewGroup layout;


    // 좌석 배치
    String seats =   "NNNN__NNN__/"+
                     "NNNN__NNN__/"+
                     "NNNN__NNN__/"+
                     "NNNN__NNN__/"+
                     "NNNN__NNN__/"+
                     "NNNN__NNN__/"+
                     "NNNN__NNNN_/";


    List<TextView> seatView = new ArrayList<>();
    int seatWidth = 130;
    int seatHeight = 150;
    int seatGaping = 10;
    int cnt = 0;
    int i;
    TextView tv1, tv2;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        layout = findViewById(R.id.layoutSeats);

        seats= "/" + seats;

        LinearLayout layoutSeat = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                                        ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutSeat.setOrientation(LinearLayout.VERTICAL);
        layoutSeat.setLayoutParams(params);
        layoutSeat.setPadding(8 * seatGaping, 30 * seatGaping, 8 * seatGaping, 8 * seatGaping);
        layout.addView(layoutSeat);

        LinearLayout layout = null;
//        //dialog
//        OptionCodeTypeDialog customDialog = new OptionCodeTypeDialog(this, close);


        // 시트 구성
        for(i = 0; i < seats.length(); i++) {
            if (seats.charAt(i) == '/') {
                layout = new LinearLayout(this);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                layoutSeat.addView(layout);


            } else if (seats.charAt(i) == 'N') { // 좌석 부분
                tv1 = new TextView(this);
                cnt++;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatWidth, seatHeight);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                tv1.setLayoutParams(layoutParams);
                tv1.setPadding(0, 0, 0, 0);
                tv1.setId(cnt);
                tv1.setGravity(Gravity.CENTER);
                tv1.setText(cnt + "");
                tv1.getAutoSizeMaxTextSize();
                tv1.setTextColor(Color.BLACK);
                layout.addView(tv1);
                seatView.add(tv1);
                tv1.setBackgroundResource(R.drawable.seats);
                tv1.setOnClickListener(this); // 팝업창


            } else if (seats.charAt(i) == '_') { // 공백부분
                tv2 = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatWidth, seatHeight);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                tv2.setLayoutParams(layoutParams);
                tv2.setBackgroundColor(Color.TRANSPARENT);
                tv2.setText("");
                layout.addView(tv2);
            }
        }
    }

    @Override
    public void onClick(View v) {
        CustomDialog dialog = new CustomDialog(this);
        dialog.callDialog();
    }


}