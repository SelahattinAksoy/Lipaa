package com.example.lipa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Currency;

public class MainActivity extends AppCompatActivity {




    ListView lv;
    String[] urlList={"http://www.floatrates.com/daily/usd.json",
            "http://www.floatrates.com/daily/eur.json",
            "http://www.floatrates.com/daily/jpy.json",
            "http://www.floatrates.com/daily/azn.json"};

    public static String usd="A";
    public static String euro="L";
    public static String yen="A";
    public static String manat=":)";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=findViewById(R.id.list_id);


        String a[]={usd,euro,yen,manat};
        String[] name={"USD","EUR","YEN","MNT"};


        SatınAl selo=new SatınAl(this,R.layout.row,a,name);
        lv.setAdapter(selo);
        int x =1;
        for(String i:urlList){
            fetchData f=new fetchData(i,x);
            f.execute();
            x++;
        }


    }

    class  SatınAl extends ArrayAdapter<String >{

        Context context;
        String[] a;
        int resource;
        String[] name;
        public SatınAl(@NonNull Context context, int resource,String [] a, String[] name) {
            super(context, resource,a);
            this.a= a;
            this.context=context;
            this.resource=resource;
            this.name=name;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater=LayoutInflater.from(context);
            View v=layoutInflater.inflate(resource,null);

            final TextView money=v.findViewById(R.id.currency_id);
            final Button bt_buy=v.findViewById(R.id.buy_button_id);
            final Button bt_convert=v.findViewById(R.id.conver_button_id);
            final TextView amount=v.findViewById(R.id.currency_amaout_id);
            final TextView price=v.findViewById(R.id.currency_price_id);
            final Switch sw=v.findViewById(R.id.switch1);


            sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                    if(b){
                        a= new String[]{MainActivity.usd, MainActivity.euro,MainActivity.yen,MainActivity.manat};
                        money.setText(a[position]);
                    }



                }
            });



            bt_buy.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {




                    AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                    alert.setMessage(price.getText().toString()+" ye "+amount.getText().toString()+" "+sw.getText().toString()+" alındı. ").setCancelable(false).setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog al=alert.create();
                    al.setTitle("----------BAŞARIYLA---------");
                    al.show();

                }
            });
            bt_convert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String deger=money.getText().toString();
                    String mik=amount.getText().toString();

                    Double sex=Double.parseDouble(deger)*Integer.parseInt(mik);

                    price.setText(Double.toString(sex)+" TL");

                }
            });
            money.setText(a[position]);
            sw.setText(name[position]);
            return v;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.drwa_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.anasayfa_item){
            Intent i=new Intent(MainActivity.this,Anasayfa.class);
            startActivity(i);
        }
        if(item.getItemId()==R.id.past_item){
            Intent y=new Intent(MainActivity.this,History.class);
            startActivity(y);
        }
        if(item.getItemId()==R.id.money_transfer){
            Intent y=new Intent(MainActivity.this,Money_Transfer.class);
            startActivity(y);
        }
        if(item.getItemId()==R.id.hesap_bilgi){
            Intent y=new Intent(MainActivity.this,Hesap.class);
            startActivity(y);
        }



        return super.onOptionsItemSelected(item);
    }
}
