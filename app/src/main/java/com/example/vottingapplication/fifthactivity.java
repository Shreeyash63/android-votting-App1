package com.example.vottingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.vottingapplication.database.mydatabase;

public class fifthactivity extends AppCompatActivity {
    Button b1;
    EditText ename,ephn;

    ListView lv1;
    mydatabase mdb= new mydatabase();
    Cursor cursor;
    SimpleCursorAdapter sca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifthactivity);

        lv1 = findViewById(R.id.listv);
        b1 = findViewById(R.id.insert);
        ename = findViewById(R.id.editname);
       // ephn = findViewById(R.id.editTextText2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sname = ename.getText().toString().trim();

                EditText intphn =(EditText)findViewById(R.id.editTextText2);


                if (sname.isEmpty()) {
                    ename.setError("Adress connot be empty");


                } else if (intphn == null || intphn.equals("")) {
                    ephn.setError("salary cannot be empty");

                } else {
                    ContentValues cv = new ContentValues();
                    cv.put("name", sname);
                    cv.put("phone", String.valueOf(intphn));

                   mdb.insertvoter(cv);
                    Toast.makeText(fifthactivity.this, "Data inserted succesfully", Toast.LENGTH_SHORT).show();

                    ename.setText(null);
                    ephn.setText(null);

                    cursor.requery();





                }
                Intent intent=new Intent(fifthactivity.this,MainActivity.class);
                startActivity(intent);
            }

        });


    }
    public  void showdata(){
        cursor= mdb.getData();
        String[] fromdb={"name","phone no."};
        int[]toTextView={R.id.editname,R.id.editTextText2};
        sca=new SimpleCursorAdapter(this,R.layout.row,cursor,fromdb,toTextView,0);
        lv1.setAdapter(sca);
        cursor.requery();

    }
}