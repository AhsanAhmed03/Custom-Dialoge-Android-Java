package com.example.customdialoge;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt;
    Button dialoge_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.custom_text);
        dialoge_btn = findViewById(R.id.show_dialoge_button);

        dialoge_btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if (txt.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Please Enter Custom Text", Toast.LENGTH_SHORT).show();
                }else{
                    showDialoge(txt.getText().toString());
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void showDialoge(String custmText){
        Dialog dialog = new Dialog(MainActivity.this);

        View dialoge_view = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialoge_layout,null);
        dialog.setContentView(dialoge_view);

        TextView tv = dialoge_view.findViewById(R.id.dialoge_txt);

        Button b1 = dialoge_view.findViewById(R.id.btn1);
        Button b2 = dialoge_view.findViewById(R.id.btn2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "This is button 1 of dialoge box", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Use to dismiss the dialoge
                dialog.dismiss();
            }
        });

        tv.setText(custmText);

        dialog.setCancelable(true);
        dialog.create();
        dialog.show();
    }
    // You can set dialoge layout according to your need
}