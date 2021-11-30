package com.example.lesson2_7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button bSave,bRead;
    TextView textView;

     private String simpleFileName = "note.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        bSave = findViewById(R.id.button1);
        bRead = findViewById(R.id.button2);


      bSave.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              saveData();
          }
      });
      bRead.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              readData();
          }
      });

    }


    private void saveData() {
        String data = this.editText.getText().toString();
        try {

            FileOutputStream out = this.openFileOutput(simpleFileName, MODE_PRIVATE);

            out.write(data.getBytes());
            out.close();
            Toast.makeText(this,"File saved!",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this,"Error:"+ e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    private void readData() {
        try {

            FileInputStream in = this.openFileInput(simpleFileName);

            BufferedReader br= new BufferedReader(new InputStreamReader(in));

            StringBuilder sb= new StringBuilder();
            String s= null;
            while((s= br.readLine())!= null)  {
                sb.append(s).append("\n");
            }
            this.textView.setText(sb.toString());

        } catch (Exception e) {
            Toast.makeText(this,"Error:"+ e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

}




