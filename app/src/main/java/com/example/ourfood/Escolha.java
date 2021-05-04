package com.example.ourfood;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;



public class Escolha extends AppCompatActivity {

Button button;


    private void abrirMapsNagao(){
        Intent maps = new Intent(this, Mapa.class);
        maps.putExtra("l1", -23.4072);
        maps.putExtra("l2",-46.8586);
        maps.putExtra("nome", "Nagao Sushi");
        maps.putExtra("image", R.drawable.japa);
        startActivity(maps);
    }
    private void abrirMapsGrandcru(){
        Intent maps = new Intent(this, Mapa.class);
        maps.putExtra("l1", -23.49813491893413);
        maps.putExtra("l2",-46.847469661506615);
        maps.putExtra("nome", "Grand Cru");
        maps.putExtra("image", R.drawable.lasanha);
        startActivity(maps);
    }
    private void abrirMapsDominos(){
        Intent maps = new Intent(this, Mapa.class);
        maps.putExtra("l1", -23.4989);
        maps.putExtra("l2",-46.8536);
        maps.putExtra("nome", "Domino's Pizza");
        maps.putExtra("image", R.drawable.pizzaria);
        startActivity(maps);
    }
    private void abrirMapsExBurguer(){
        Intent maps = new Intent(this, Mapa.class);
        maps.putExtra("l1", -23.4093);
        maps.putExtra("l2",-46.8871);
        maps.putExtra("nome", "Ex - Burguer");
        maps.putExtra("image", R.drawable.hamburgueria);
        startActivity(maps);
    }
    private void abrirMapsTiãoespetinhos(){
        Intent maps = new Intent(this, Mapa.class);
        maps.putExtra("l1", -23.557170325484766);
        maps.putExtra("l2",-46.75549541185888);
        maps.putExtra("nome", "Tião espetinhos");
        maps.putExtra("image", R.drawable.buteco);
        startActivity(maps);
    }
    private void abrirMapsSodie(){
        Intent maps = new Intent(this, Mapa.class);
        maps.putExtra("l1", -23.44620612463328);
        maps.putExtra("l2",-46.914373138267806);
        maps.putExtra("nome", "Sodiê");
        maps.putExtra("image", R.drawable.bolos);
        startActivity(maps);
    }
    private void abrirMapshabbibs(){
        Intent maps = new Intent(this, Mapa.class);
        maps.putExtra("l1", -23.5025 );
        maps.putExtra("l2",-46.8311);
        maps.putExtra("nome", "habbibs");
        maps.putExtra("image", R.drawable.hab);
        startActivity(maps);
    }
    private void abrirMapsSoniaPasteis(){
        Intent maps = new Intent(this, Mapa.class);
        maps.putExtra("l1", -23.4096);
        maps.putExtra("l2",-46.8894);
        maps.putExtra("nome", "Sonia Pasteis");
        maps.putExtra("image", R.drawable.pastelaria);
        startActivity(maps);
    }

    public void notifyThis(String title, String message) {
        NotificationCompat.Builder b = new NotificationCompat.Builder(Escolha.this);
        b.setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_baseline_food_bank_24)
                .setTicker("{your tiny message}")
                .setContentTitle(title)
                .setContentText(message)
                .setContentInfo("INFO");

        NotificationManager nm = (NotificationManager) Escolha.this.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1, b.build());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha);

        Login login = new Login();


        final CardView cardone = (CardView) findViewById(R.id.CardViewOne);
        cardone.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMapsNagao();
            }
        });
        final CardView cardtwo = (CardView)findViewById(R.id.CardViewTwo);
        cardtwo.setOnClickListener(new CardView.OnClickListener(){
            @Override
            public void onClick(View v) {
                abrirMapsGrandcru();
            }
        });
        final CardView cardthree = (CardView)findViewById(R.id.CardViewThree);
        cardthree.setOnClickListener(new CardView.OnClickListener(){
            @Override
            public void onClick(View v) {
                abrirMapsDominos();
            }
        });
        final CardView cardfour = (CardView)findViewById(R.id.CardViewFour);
        cardfour.setOnClickListener(new CardView.OnClickListener(){
            @Override
            public void onClick(View v) {
                abrirMapsExBurguer();
            }
        });
        final CardView cardfive = (CardView)findViewById(R.id.CardViewFive);
        cardfive.setOnClickListener(new CardView.OnClickListener(){
            @Override
            public void onClick(View v) {
                abrirMapsSoniaPasteis();
            }
        });
        final CardView cardsix = (CardView)findViewById(R.id.CardViewSix);
        cardsix.setOnClickListener(new CardView.OnClickListener(){
            @Override
            public void onClick(View v) {
                abrirMapshabbibs();
            }
        });
        final CardView cardseven = (CardView)findViewById(R.id.CardViewSeven);
        cardseven.setOnClickListener(new CardView.OnClickListener(){
            @Override
            public void onClick(View v) {
                abrirMapsTiãoespetinhos();
            }
        });
        final CardView cardeight = (CardView)findViewById(R.id.CardViewEight);
        cardeight.setOnClickListener(new CardView.OnClickListener(){
            @Override
            public void onClick(View v) {
                abrirMapsSodie();
            }
        });

        final TextView texto = (TextView)findViewById(R.id.textview);
        Calendar c1 = Calendar.getInstance();
        int hora = c1.get(Calendar.HOUR_OF_DAY);

        String mensagem;

        Intent it = getIntent();
        String nome = it.getStringExtra("nome2");

        if (hora > 6 && hora < 12){
            mensagem = "Bom dia " + nome + "! O que você ira comer agora?";
        }
        else if (hora > 12 && hora < 18)
        {
            mensagem = "Boa tarde "+ nome + "! O que você ira comer agora?";
        }
        else if (hora > 0 && hora < 6)
        {
            mensagem = "Boa Madrugada "+ nome + "! O que você ira comer agora?";
        }
        else
        {
            mensagem = "Boa noite "+ nome + "! O que você ira comer agora?";
        }

        texto.setText(mensagem);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finishAffinity();
               notifyThis("OurFood","O app fechou");
            }
        });

    }


}