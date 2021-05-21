package com.example.ourfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Login extends AppCompatActivity {

    EditText edt_usuario, edt_senha;
    Button btn_logar;
    TextView txtentreaqui2;
    ProgressBar progressBar;
    String nome_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        edt_usuario = (EditText) findViewById(R.id.edt_Usuario);
        edt_senha = (EditText) findViewById(R.id.edt_Senha);
        txtentreaqui2 = (TextView)findViewById(R.id.loginText);
        btn_logar = (Button)findViewById(R.id.btn_Login);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);



        txtentreaqui2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Login.this, Registrar.class);
                startActivity(it);
                finish();
            }
        });

        btn_logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Iniciando a progressbar (Colocando a visibilidade VISIBLE)
                progressBar.setVisibility(View.VISIBLE);

                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {


                        String usuario, senha;

                        usuario = String.valueOf(edt_usuario.getText());
                        senha = String.valueOf(edt_senha.getText());
                        nome_user = String.valueOf(edt_usuario.getText());

                        if (!usuario.equals("") && !senha.equals("")) {

                            //Começando a fazer o get e set com put e data

                            String[] field = new String[2];
                            field[0] = "usuario";
                            field[1] = "senha";
                            String[] data = new String[2];
                            data[0] = usuario;
                            data[1] = senha;
                            PutData putData = new PutData("http://localhost:8080/android/api/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    //Fim da ProgressBar (Colocando a visibilidade GONE)

                                    progressBar.setVisibility(View.GONE);

                                    String result = putData.getResult();
                                    if (result.equals("Login efetuado")){
                                        Toast toast2 =Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT);
                                        toast2.show();
                                        Intent manda = new Intent(Login.this, SplashScreen.class);

                                        manda.putExtra("nome", nome_user);

                                        startActivity(manda);
                                        finish();


                                    }
                                    else {
                                        Toast toast2 = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT);
                                        toast2.show();
                                    }
                                }
                            }
                        }
                        else{
                            Toast toast = Toast.makeText(getApplicationContext(), "Todos os campos são necessários", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                });

            }

        });
    }
}
