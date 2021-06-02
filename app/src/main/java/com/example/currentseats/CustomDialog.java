package com.example.currentseats;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class CustomDialog {

    private Context context;

    public CustomDialog(Context context){
        this.context = context;
    }

    public void callDialog(){
        final Dialog dialog = new Dialog(context);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);
        dialog.show();

        final Button close = (Button) dialog.findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Close", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
//                ((MainActivity) context).finish();
            }
        });

    }
}

