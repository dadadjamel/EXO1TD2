package com.example.dectionnaire;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListViewAdapter.OnWordListener {
    RecyclerView lv;
    private boolean isChackBookmarks = false;
    ArrayList<Word> wordList=new ArrayList<Word>();;
    ListViewAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (RecyclerView) findViewById(R.id.dictionaryList);
        initilizeList();
        setAdapter();

    }





    private void setAdapter(){

        lv.setLayoutManager(new LinearLayoutManager(this));
        listAdapter=new ListViewAdapter(this, wordList ,this);
        System.out.println(wordList.size());

        lv.setAdapter(listAdapter);
    }

    private void initilizeList(){

        wordList.add( new Word("Homee","Nom masculin","Lieu de vie d'une famille (anglicisme).",R.raw.mahsun, R.raw.mahsun));
        wordList.add( new Word("Slepp","Verbe","a condition of body and mind which typically recurs for several hours every night, in which the nervous system is inactive, the eyes closed, the postural muscles relaxed, and consciousness practically suspended."
                ,2 , R.raw.mahsun));

        wordList.add( new Word("Car","nom masculin","véhicule de transport en commun.",3 , R.raw.mahsun));

        wordList.add( new Word("Computer","nom masculin","Estimer une durée, une quantité, une somme.",4 , R.raw.mahsun));

        wordList.add( new Word("Lamp","Noun","a device for giving light, either one consisting of an electric bulb together with its holder and shade or cover, or one burning gas or oil and consisting of a wick or mantle and a glass shade.",5 , R.raw.mahsun));

        wordList.add( new Word("Math","Noun","mathematics",6 , R.raw.mahsun));

        wordList.add( new Word("Respect","Nom masculin","Sentiment qui porte à accorder à qqn de la considération en raison de la valeur qu'on lui reconnaît.",7 , R.raw.mahsun));
    }



   /* public void openAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Add Bookmarks");
        builder.setMessage("do you add bookmarks...");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                isChackBookmarks = true;

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                isChackBookmarks = false;
            }
        });

        AlertDialog alertDialog = builder.create();

        alertDialog.show();
    }*/


    @Override
    public void onClickListener(int position) {
        Intent intent = new Intent(getApplicationContext(),TextSpeelingActivity.class);
        intent.putExtra("wordDef", wordList.get(position).getDef());
        intent.putExtra("viedo" , wordList.get(position).video);
        intent.putExtra("thumbnil" , wordList.get(position).getImage());
        startActivity(intent);

    }
}
