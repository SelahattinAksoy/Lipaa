package com.example.lipa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Hesap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesap);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.drwa_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.kur_item){
            Intent x=new Intent(Hesap.this,MainActivity.class);
            startActivity(x);
        }
        if(item.getItemId()==R.id.past_item){
            Intent y=new Intent(Hesap.this,History.class);
            startActivity(y);
        }
        if(item.getItemId()==R.id.anasayfa_item){
            Intent y=new Intent(Hesap.this,Anasayfa.class);
            startActivity(y);
        }
        if(item.getItemId()==R.id.money_transfer){
            Intent y=new Intent(Hesap.this,Money_Transfer.class);
            startActivity(y);
        }
        if(item.getItemId()==R.id.logout){
            Intent y=new Intent(Hesap.this,Login.class);
            startActivity(y);
        }



        return super.onOptionsItemSelected(item);
    }
}
