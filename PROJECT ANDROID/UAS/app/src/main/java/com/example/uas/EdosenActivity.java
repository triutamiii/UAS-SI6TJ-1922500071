package com.example.uas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EdosenActivity extends AppCompatActivity {
    //public static final String URLINSERT = "http://10.117.39.244/UAS/insert.php";

    private EditText nidnt, nama_dosent, jabatant, gol_pangt, keahliant, program_studit;
    String nidn, nama_dosen, jabatan, gol_pang, keahlian, program_studi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edosen);

        nidnt = findViewById(R.id.editNidn);
        nama_dosent = findViewById(R.id.editNama);
        jabatant = findViewById(R.id.editJabatan);
        gol_pangt = findViewById(R.id.editGolongan);
        keahliant = findViewById(R.id.editKeahlian);
        program_studit = findViewById(R.id.editProdi);

        Button buttonSimpan = (Button) findViewById(R.id.buttonSimpan);
        Button buttonDashboard = (Button) findViewById(R.id.buttonDashboard);

        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nidn = nidnt.getText().toString();
                nama_dosen = nama_dosent.getText().toString();
                jabatan = jabatant.getText().toString();
                gol_pang = gol_pangt.getText().toString();
                keahlian = keahliant.getText().toString();
                program_studi = program_studit.getText().toString();

                if (TextUtils.isEmpty(nidn)) {
                    nidnt.setError("Masukkan NIDN");
                } else if (TextUtils.isEmpty(nama_dosen)) {
                    nama_dosent.setError("Masukkan Nama Dosen");
                } else if (TextUtils.isEmpty(jabatan)) {
                    jabatant.setError("Masukkan Jabatan");
                } else if (TextUtils.isEmpty(gol_pang)) {
                    gol_pangt.setError("Masukkan Golongan");
                } else if (TextUtils.isEmpty(keahlian)) {
                    keahliant.setError("Masukkan Keahlian");
                } else if (TextUtils.isEmpty(program_studi)) {
                    program_studit.setError("Masukkan Program Studi");
                } else {
                    addDataToDatabase(nidn, nama_dosen, jabatan, gol_pang, keahlian, program_studi);
                }

            }

        });

        buttonDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);}
        });

    }

    private void addDataToDatabase(String nidn, String nama_dosen, String jabatan, String gol_pang, String keahlian, String program_studi) {
        String url = "http://10.117.39.244/UAS/insert.php";

        RequestQueue queue = Volley.newRequestQueue(EdosenActivity.this);

        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    // on below line we are displaying a success toast message.
                    Toast.makeText(EdosenActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // and setting data to edit text as empty
                nidnt.setText("");
                nama_dosent.setText("");
                jabatant.setText("");
                gol_pangt.setText("");
                keahliant.setText("");
                program_studit.setText("");
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(EdosenActivity.this, "Koneksi Gagal " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<String, String>();

                params.put("NIDN", nidn);
                params.put("Nama Dosen", nama_dosen);
                params.put("Golongan", gol_pang);
                params.put("Jabatan", jabatan);
                params.put("Keahlian", keahlian);
                params.put("Program Studi", program_studi);

                return params;
            }
        };

        queue.add(request);
    }
}
