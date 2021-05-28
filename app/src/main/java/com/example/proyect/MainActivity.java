package com.example.proyect;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void getCV(View view){

        Button b = (Button)view;
        String buttonText = b.getText().toString();
        Intent intent = new Intent(MainActivity.this, ShowVC.class);
        Bundle bd = new Bundle();
        Integer matricula;
        switch (buttonText){
            case "Ruben":
                matricula = 329806;
                break;
            case "Juan":
                matricula = 329688;
                break;
            case "Luis":
                matricula = 329865;
                break;
            default:
                matricula = 0;
        }
        bd.putInt("matricula", matricula);
        intent.putExtras(bd);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), buttonText, Toast.LENGTH_SHORT).show();
    }


}
