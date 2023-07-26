package com.example.vottingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class result extends AppCompatActivity {
    Button blog;
    EditText editid,epass;
    TextView tv_res1,tv_res2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        blog=findViewById(R.id.login);
        editid=findViewById(R.id.etID);
        epass=findViewById(R.id.etpass);
        tv_res1=findViewById(R.id.ers1);
        tv_res2=findViewById(R.id.ers2);






        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent=getIntent();
                int res1= getIntent().getIntExtra("score1",0);
                int res2= getIntent().getIntExtra("score2",0);
                if (editid.getText().toString().equals("cdit") && epass.getText().toString().equals("android")){



                    Toast.makeText(result.this, "Logged in", Toast.LENGTH_SHORT).show();


                }else {
                    Toast.makeText(result.this, "Invalid ID OR Password", Toast.LENGTH_SHORT).show();
                }
                tv_res1.setText("  "+String.valueOf(res1));
                tv_res2.setText("  "+String.valueOf(res2));
            }
        });


    }
}