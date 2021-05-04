package com.example.ourfood;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Registrar extends AppCompatActivity {

    TextInputEditText edt_nomeCompleto, edt_usuario, edt_senha, edt_email;
    Button btn_registrar;
    TextView txtentreaqui;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        edt_nomeCompleto = (TextInputEditText)findViewById(R.id.edt_NomeCompleto);
        edt_usuario = (TextInputEditText)findViewById(R.id.edt_Usuario);
        edt_senha = (TextInputEditText)findViewById(R.id.edt_Senha);
        edt_email = (TextInputEditText)findViewById(R.id.edt_email);
        btn_registrar = (Button)findViewById(R.id.btn_Registrar);
        txtentreaqui = (TextView)findViewById(R.id.txtEntreaqui);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);

        txtentreaqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Registrar.this, Login.class);
                startActivity(it);
                finish();
            }
        });

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Iniciando a progressbar (Colocando a visibilidade VISIBLE)
                progressBar.setVisibility(View.VISIBLE);

                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        String nomecompleto, usuario, senha, email;

                        nomecompleto = String.valueOf(edt_nomeCompleto.getText());
                        usuario = String.valueOf(edt_usuario.getText());
                        senha = String.valueOf(edt_senha.getText());
                        email = String.valueOf(edt_email.getText());

                        if (!nomecompleto.equals("") && !usuario.equals("") && !senha.equals("") && !email.equals("")) {

                            //Começando a fazer o get e set com put e data

                            String[] field = new String[4];
                            field[0] = "nomecompleto";
                            field[1] = "usuario";
                            field[2] = "senha";
                            field[3] = "email";
                            String[] data = new String[4];
                            data[0] = nomecompleto;
                            data[1] = usuario;
                            data[2] = senha;
                            data[3] = email;
                            PutData putData = new PutData("https://teste002api.000webhostapp.com/registrar.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    //Fim da ProgressBar (Colocando a visibilidade GONE)

                                    progressBar.setVisibility(View.GONE);

                                    String result = putData.getResult();
                                    if (result.equals("Registro feito com sucesso!")){
                                        Toast toast2 = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT);
                                        toast2.show();
                                        Intent it = new Intent(Registrar.this, Login.class);
                                        startActivity(it);
                                        finish();
                                    }
                                    else {
                                        Toast toast = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT);
                                        toast.show();
                                    }
                                }
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Todos os campos são necessários", Toast.LENGTH_SHORT);
                        }
                    }
                });

            }

        });

    }
}