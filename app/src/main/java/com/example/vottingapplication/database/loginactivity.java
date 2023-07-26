package com.example.vottingapplication.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vottingapplication.DBHelper;
import com.example.vottingapplication.MainActivity;
import com.example.vottingapplication.R;

public class loginactivity extends AppCompatActivity {

    EditText userlogin,passlogin;
    Button btnlogin;

    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        userlogin=findViewById(R.id.usernamelogin);
        passlogin=findViewById(R.id.passwordlogin);
        btnlogin=findViewById(R.id.btnlogin);

        myDB=new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=userlogin.getText().toString().trim();
                String pass=passlogin.getText().toString().trim();

                if(user.equals("") || pass.equals(""))
                {
                    Toast.makeText(loginactivity.this, "Please enter credentials", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean result= myDB.checkusernamepassword(user,pass);

                    if(result==true)
                    {
                        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else
                    {
                        Toast.makeText(loginactivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}