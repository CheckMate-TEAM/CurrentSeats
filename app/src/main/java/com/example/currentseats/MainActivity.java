package com.example.currentseats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
//    static GridLayout.Spec spec(int start[, int size, GridLayout.Alignment ali]) {
//        return null;
//    }

    ViewGroup layout;

    String seats = "_NNNN___NNN__/"+
                     "_NNNN___NNN__/"+
                     "_NNNN___NNN__/"+
                     "_NNNN___NNN__/"+
                     "_NNNN___NNN__/"+
                     "_NNNN___NNN__/"+
                     "_NNNN___NNNN_/";

    List<TextView> seatView = new ArrayList<>();
    int seatSize = 65;
    int seatGaping = 10;
    int STATUS_NORMAL = 1;
    int STATUS_EMPTY = 2;
    int cnt = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.popup_activity);

        layout = findViewById(R.id.layoutSeats);

        seats= "/" + seats;

        LinearLayout layoutSeat = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                                        ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutSeat.setOrientation(LinearLayout.VERTICAL);
        layoutSeat.setLayoutParams(params);
        layoutSeat.setPadding(8 * seatGaping, 8 * seatGaping, 8 * seatGaping, 8 * seatGaping);
        layout.addView(layoutSeat);

        LinearLayout layout = null;


        for(int i = 0; i < seats.length(); i++){
            if(seats.charAt(i) == '/'){
                layout = new LinearLayout(this);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                layoutSeat.addView(layout);
            }else if(seats.charAt(i) == 'N'){
                cnt++;
                TextView tv = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                tv.setLayoutParams(layoutParams);
                tv.setPadding(0, 0, 0, 2 * seatGaping);
                tv.setId(cnt);
//                tv.setGravity(Gravity.CENTER);
//                tv.setBackgroundResource(TypedValue.COMPLEX_UNIT_DIP, 9);
                tv.setText(cnt + "");
                tv.setTextColor(Color.BLACK);
                tv.setTextSize(15);
                layout.addView(tv);
                seatView.add(tv);
                tv.setTag("STATUS_NORMAL");
                tv.setOnClickListener(this);
            }else if(seats.charAt(i) == '_'){
                TextView tv = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                tv.setLayoutParams(layoutParams);
                tv.setBackgroundColor(Color.TRANSPARENT);
                tv.setText("");
                layout.addView(tv);
            }
        }


    }
    @Override
    public void onClick(View view){
        if((int) tv.getTag() == STATUS_NORMAL){
            Intent intent = new Intent();
            intent.putExtra("data", "test Popup");
            startActivityForResult(intent, cnt);

            finish();
//            view.popup();
        }

    }
}