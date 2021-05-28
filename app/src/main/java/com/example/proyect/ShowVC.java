package com.example.proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.Queue;

public class ShowVC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_vc);

        final TextView nombre = findViewById(R.id.txtnombre);
        final TextView bio= findViewById(R.id.txtbio);
        final TextView secu = findViewById(R.id.txtsecu);
        final TextView prepa = findViewById(R.id.txtprepa);
        final TextView uni = findViewById(R.id.txtuni);
        final TextView habi1 = findViewById(R.id.txthabi1);
        final TextView habi2 = findViewById(R.id.txthabi2);
        final TextView habi3 = findViewById(R.id.txthabi3);
        final ImageView img = findViewById(R.id.imgpersona);
        Bundle b = getIntent().getExtras();
        int value = 0;
        if(b != null)
            value = b.getInt("matricula");
        switch (value){
            case 329806:
                img.setImageResource(R.drawable.ruben);
                break;
            case 329688:
                img.setImageResource(R.drawable.juan);
                break;
            default:
                value = 0;
                img.setImageResource(R.drawable.uach);
        }

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://calm-sea-64078.herokuapp.com/" + value;
        StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Info infoCV = new Gson().fromJson(response.toString(), Info.class);
                nombre.setText(infoCV.nombre);
                bio.setText(infoCV.bio);
                secu.setText(infoCV.educacion.secundaria);
                prepa.setText(infoCV.educacion.preparatoria);
                uni.setText(infoCV.educacion.universidad);
                habi1.setText(infoCV.listaHabilidades[0]);
                habi2.setText(infoCV.listaHabilidades[1]);
                habi3.setText(infoCV.listaHabilidades[2]);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("weather-request-error", error.getMessage());
            }
        });
        queue.add(sr);
    }
}