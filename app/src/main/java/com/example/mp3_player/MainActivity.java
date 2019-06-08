package com.example.mp3_player;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Selection;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Boolean gra = false;
    int z;


    private static final String RADIO_STATION_URL = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageButton start = (ImageButton)findViewById(R.id.startbtn);
        final TextView koniec = (TextView)findViewById(R.id.koniec);
        final ImageButton stop = (ImageButton)findViewById(R.id.stopbtn);
        ImageButton losuj = (ImageButton)findViewById(R.id.round);
        final RelativeLayout rel = (RelativeLayout)findViewById(R.id.relative);

        ImageButton go = (ImageButton)findViewById(R.id.gogo);
        final ImageButton back = (ImageButton)findViewById(R.id.back);
        final SeekBar progres = (SeekBar)findViewById(R.id.progressBar);
        final TextView tytul = (TextView)findViewById(R.id.nazwa);
        // final TextView tit =(TextView)findViewById(R.id.title);
        // tit.setText("Tytuł");
        final MediaPlayer[] mp = {MediaPlayer.create(getApplicationContext(), R.raw.bonson_jeden)};
        final ListView lista = (ListView)findViewById(R.id.lista);
        progres.setMax((int) mp[0].getDuration());
        final TextView tit =(TextView)findViewById(R.id.title);


        final ArrayList<String> liscik = new  ArrayList<String>();
        liscik.add("Bonson - Bonson musi umrzeć");
        liscik.add("Trzeci wymiar - Dla mnie masz stajla");
        liscik.add("Bisz - Zdjęcie");
        liscik.add("Deep - Cesta la vi");
        liscik.add("Mixtape 5 - Zła dziewczyna");
        liscik.add("Brudne Serca - Co bylo a nie jest");
        liscik.add("Brudne Serca - Wiesz dobra Nara");
        liscik.add("Hans Solo - 300");
        liscik.add("Paluch - Bomba piona zdrówko");
        liscik.add("Hans Solo - Wyższa kultura osobista");
        liscik.add("Kali - Azymut");
        liscik.add("Eminem - Kamikaze");
        liscik.add("Quebonafide - Rocknroller 2");
        liscik.add("Hans Solo - Dopóki jestem");
        liscik.add("Quebonafide - Avengers");
        liscik.add("Quebonafide - Hossa");


        final int [] piosenki = {R.raw.bonson_jeden,
                R.raw.trzeci_stajl,
                R.raw.bisz_zdjecie,
                R.raw.deep_cesta,
                R.raw.zla_dziewczyna,
                R.raw.brudne_serca,
                R.raw.wiesz_dobra,
                R.raw.hans_r,
                R.raw.paluch_bomba,
                R.raw.hans_wyzsza,
                R.raw.kali_azymut,
                R.raw.kamikaze,
                R.raw.rockn,
                R.raw.dopki,
                R.raw.avengers,
                R.raw.hossa
        };




        tit.setText("Bonson - Bonson musi umrzeć");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,liscik);

        lista.setAdapter(adapter);



        losuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rand = new Random();

                int random = rand.nextInt(piosenki.length);
                mp[0].pause();
                mp[0]= MediaPlayer.create(getApplicationContext(),piosenki[random]);
                switch (piosenki[random])
                {
                    case R.raw.bonson_jeden:
                        tit.setText("Bonson - Bonson musi umrzeć");

                        break;
                    case R.raw.trzeci_stajl:
                        tit.setText("Trzeci wymiar - Dla mnie masz stajla");
                        break;
                    case R.raw.bisz_zdjecie:
                        tit.setText("Bisz - Zdjęcie");
                        break;
                    case R.raw.deep_cesta:
                        tit.setText("Deep - Cesta la vi");
                        break;
                    case R.raw.zla_dziewczyna:
                        tit.setText("Mixtape 5 - Zła dziewczyna");

                        break;
                    case R.raw.brudne_serca:
                        tit.setText("Brudne Serca - Co bylo a nie jest");
                        break;
                    case R.raw.wiesz_dobra:
                        tit.setText("Brudne Serca - Wiesz dobra Nara");
                        break;
                    case R.raw.hans_r:
                        tit.setText("Hans Solo - 300");
                        break;
                    case R.raw.paluch_bomba:
                        tit.setText("Paluch - Bomba piona zdrówko");
                        break;
                    case R.raw.hans_wyzsza:
                        tit.setText("Hans Solo - Wyższa kultura osobista");
                        break;
                    case R.raw.kali_azymut:
                        tit.setText("Kali - Azymut");
                        break;
                    case R.raw.kamikaze:
                        tit.setText("Eminem - Kamikaze");
                        break;
                    case R.raw.rockn:
                        tit.setText("Quebonafide - Rocknroller 2");
                        break;
                    case R.raw.dopki:
                        tit.setText("Hans Solo - Dopóki jestem");
                        break;
                    case R.raw.avengers:
                        tit.setText("Quebonafide - Avengers");

                        break;
                    case R.raw.hossa:
                        tit.setText("Quebonafide - Hossa");

                }

            }
        });



        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                mp[0].pause();
                mp[0].reset();
                z=i;
                mp[0] = MediaPlayer.create(getApplicationContext(),piosenki[z]);
                tit.setText(lista.getItemAtPosition(i).toString());

                lista.setSelector(R.color.colorAccent);

            }
        });





        go.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if(mp[0].getDuration()+5000>mp[0].getCurrentPosition()) {
                    mp[0].seekTo(mp[0].getCurrentPosition() + 5000, MediaPlayer.SEEK_NEXT_SYNC);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if(mp[0].getDuration()-5000>mp[0].getCurrentPosition()) {
                    mp[0].seekTo(mp[0].getCurrentPosition() - 5000, MediaPlayer.SEEK_NEXT_SYNC);
                }
            }
        });




        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mp[0].isPlaying()){
                    mp[0].start();
                    gra=true;
                    
                }


            }
        });

        //  progres.setProgress();


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp[0].isPlaying())
                {
                    mp[0].pause();
                    gra = false;


                }

            }
        });


        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                if(gra)
                {

                    int sec = (int)(mp[0].getCurrentPosition()%(1000*60*60)%(1000*60)/1000);
                    int min = (int)mp[0].getCurrentPosition()%(1000*60*60)/(1000*60);

                    tytul.setText(String.format("%02d:%02d",min,sec));
                    int sec2 = (int)(mp[0].getDuration()%(1000*60*60)%(1000*60)/1000);
                    int min2 = (int)mp[0].getDuration()%(1000*60*60)/(1000*60);
                    koniec.setText(String.format("%02d:%02d",min2,sec2));



                    progres.setMax((int) mp[0].getDuration());
                    progres.setProgress((int) mp[0].getCurrentPosition());
                }
                handler.postDelayed(this,1000);
            }
        });

    }


}
