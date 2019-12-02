package com.example.lipa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class History extends AppCompatActivity {

    String[] hist={" PARA"," PARA"," PARA"," PARA"," PARA"," PARA"," PARA"," PARA"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        ListView ls=findViewById(R.id.history_list);
        ArrayAdapter<String> adp=new ArrayAdapter<>(History.this,R.layout.support_simple_spinner_dropdown_item,hist);

        ls.setAdapter(adp);

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
            Intent x=new Intent(History.this,MainActivity.class);
            startActivity(x);
        }
        if(item.getItemId()==R.id.anasayfa_item){
            Intent y=new Intent(History.this,Anasayfa.class);
            startActivity(y);
        }
        if(item.getItemId()==R.id.money_transfer){
            Intent y=new Intent(History.this,Money_Transfer.class);
            startActivity(y);
        }
        if(item.getItemId()==R.id.hesap_bilgi){
            Intent y=new Intent(History.this,Hesap.class);
            startActivity(y);
        }



        return super.onOptionsItemSelected(item);
    }
}
