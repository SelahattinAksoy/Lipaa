package com.example.lipa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Money_Transfer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money__transfer);
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
            Intent x=new Intent(Money_Transfer.this,MainActivity.class);
            startActivity(x);
        }
        if(item.getItemId()==R.id.past_item){
            Intent y=new Intent(Money_Transfer.this,History.class);
            startActivity(y);
        }
        if(item.getItemId()==R.id.anasayfa_item){
            Intent y=new Intent(Money_Transfer.this,Anasayfa.class);
            startActivity(y);
        }
        if(item.getItemId()==R.id.hesap_bilgi){
            Intent y=new Intent(Money_Transfer.this,Hesap.class);
            startActivity(y);
        }



        return super.onOptionsItemSelected(item);
    }
}
