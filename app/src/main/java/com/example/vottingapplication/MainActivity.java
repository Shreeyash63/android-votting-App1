package com.example.vottingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vottingapplication.R;

public class MainActivity extends AppCompatActivity {
    Button bt1,bt2,bt3;
    TextView tv1,tv2;

    int score1=0;
    int score2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent myintent=getIntent();
         intilizer();
        eventhandler();

    }
    public void intilizer()
    {
        bt1=findViewById(R.id.btnFirst);
        bt2=findViewById(R.id.btnSecond);
        tv1=findViewById(R.id.txtFirst);
        tv2=findViewById(R.id.txtSecond);
        bt3=findViewById(R.id.bresult);


        tv1.setText(String.valueOf(score1));
        tv2.setText(String.valueOf(score2));

    }

    public void eventhandler()
    {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1++;
                Toast.makeText(MainActivity.this, "You voted for Java", Toast.LENGTH_SHORT).show();

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score2++;
                Toast.makeText(MainActivity.this, "You voted for python", Toast.LENGTH_SHORT).show();
            }

        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,result.class);
                intent.putExtra("score1",score1);
                intent.putExtra("score2",score2);
                startActivity(intent);




            }
        });

    }
}