package com.example.ourfood;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;



public class Escolha extends AppCompatActivity {

    Button button;


    private void abrirMapsMexicanissimo(){
        Intent maps = new Intent(this, Mapa.class);
        maps.putExtra("l1", -23.55545134398203);
        maps.putExtra("l2",-46.688916172169236);
        maps.putExtra("nome", "Mexicaníssimo");
        maps.putExtra("image", R.drawable.frango);
        startActivity(maps);
    }
    private void abrirMapsTaqueria(){
        Intent maps = new Intent(this, Mapa.class);
        maps.putExtra("l1", -23.545761007078266);
        maps.putExtra("l2",-46.66140907647792);
        maps.putExtra("nome", "Taqueria");
        maps.putExtra("image", R.drawable.taco);
        startActivity(maps);
    }
    private void abrirMapsOak(){
        Intent maps = new Intent(this, Mapa.class);
        maps.putExtra("l1", -23.548948450140863);
        maps.putExtra("l2",-46.58016630417413);
        maps.putExtra("nome", "Oak's burritos");
        maps.putExtra("image", R.drawable.burru_frito);
        startActivity(maps);
    }
    private void abrirMapsDonPancho(){
        Intent maps = new Intent(this, Mapa.class);
        maps.putExtra("l1", -23.577697736695253);
        maps.putExtra("l2",-46.64599644330109);
        maps.putExtra("nome", "Don Pancho");
        maps.putExtra("image", R.drawable.sla);
        startActivity(maps);
    }
    private void abrirMapsHechoenMex(){
        Intent maps = new Intent(this, Mapa.class);
        maps.putExtra("l1", -23.577734573865413);
        maps.putExtra("l2",-46.67757386013628);
        maps.putExtra("nome", "Hecho en Mexico");
        maps.putExtra("image", R.drawable.pozzole);
        startActivity(maps);
    }
    private void abrirMapsGuadalaraja(){
        Intent maps = new Intent(this, Mapa.class);
        maps.putExtra("l1", -23.541091070815547);
        maps.putExtra("l2",-46.58987450527248);
        maps.putExtra("nome", "Guadalajara");
        maps.putExtra("image", R.drawable.nacho);
        startActivity(maps);
    }
    private void abrirMapsLosBigotes(){
        Intent maps = new Intent(this, Mapa.class);
        maps.putExtra("l1", -23.590619091513883);
        maps.putExtra("l2",-46.654159997785165);
        maps.putExtra("nome", "Los Bigotes");
        maps.putExtra("image", R.drawable.parece_pastel);
        startActivity(maps);
    }
    private void abrirMapsSiSenor(){
        Intent maps = new Intent(this, Mapa.class);
        maps.putExtra("l1", -23.490891307184995);
        maps.putExtra("l2",-46.634997059005926);
        maps.putExtra("nome", "Sí Señor!");
        maps.putExtra("image", R.drawable.pamonha_mexicana);
        startActivity(maps);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void show_Notification(){
        Intent intent=new Intent(getApplicationContext(),Escolha.class);
        String CHANNEL_ID="MYCHANNEL";
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,"name",NotificationManager.IMPORTANCE_HIGH);
        PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),1,intent,0);
        Notification notification=new Notification.Builder(getApplicationContext(),CHANNEL_ID)
                .setContentText("")
                .setContentTitle("O APP fechou")
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_baseline_food_bank_24,"OurFood",pendingIntent)
                .setChannelId(CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_food_bank_24)
                .build();
        NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(notificationChannel);
        notificationManager.notify(1,notification);

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
                abrirMapsMexicanissimo();
            }
        });
        final CardView cardtwo = (CardView)findViewById(R.id.CardViewTwo);
        cardtwo.setOnClickListener(new CardView.OnClickListener(){
            @Override
            public void onClick(View v) {
                abrirMapsTaqueria();
            }
        });
        final CardView cardthree = (CardView)findViewById(R.id.CardViewThree);
        cardthree.setOnClickListener(new CardView.OnClickListener(){
            @Override
            public void onClick(View v) {
                abrirMapsOak();
            }
        });
        final CardView cardfour = (CardView)findViewById(R.id.CardViewFour);
        cardfour.setOnClickListener(new CardView.OnClickListener(){
            @Override
            public void onClick(View v) {
                abrirMapsDonPancho();
            }
        });
        final CardView cardfive = (CardView)findViewById(R.id.CardViewFive);
        cardfive.setOnClickListener(new CardView.OnClickListener(){
            @Override
            public void onClick(View v) {
                abrirMapsHechoenMex();
            }
        });
        final CardView cardsix = (CardView)findViewById(R.id.CardViewSix);
        cardsix.setOnClickListener(new CardView.OnClickListener(){
            @Override
            public void onClick(View v) {
                abrirMapsGuadalaraja();
            }
        });
        final CardView cardseven = (CardView)findViewById(R.id.CardViewSeven);
        cardseven.setOnClickListener(new CardView.OnClickListener(){
            @Override
            public void onClick(View v) {
                abrirMapsLosBigotes();
            }
        });
        final CardView cardeight = (CardView)findViewById(R.id.CardViewEight);
        cardeight.setOnClickListener(new CardView.OnClickListener(){
            @Override
            public void onClick(View v) { abrirMapsSiSenor(); }
        });

        final TextView texto = (TextView)findViewById(R.id.textview);
        Calendar c1 = Calendar.getInstance();
        int hora = c1.get(Calendar.HOUR_OF_DAY);

        String mensagem;

        Intent it = getIntent();
        String nome = it.getStringExtra("nome2");

        if (hora > 6 && hora < 12){
            mensagem = "Bom Dia " + nome + getString(R.string.final_frase);
        }
        else if (hora > 12 && hora < 18)
        {
            mensagem = "Boa Tarde "+ nome + getString(R.string.final_frase);
        }
        else if (hora > 0 && hora < 6)
        {
            mensagem = "Boa Madrugada "+ nome + getString(R.string.final_frase);
        }
        else
        {
            mensagem = "Boa Noite "+ nome + getString(R.string.final_frase);
        }

        texto.setText(mensagem);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                finishAffinity();
                show_Notification();
            }
        });

    }


}