package com.example.appshoppingwithselfrefernce;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    TextView tvprice,tvprod;
    Button btbuy;
    Spinner spinProd;

    String product[]={"PANIPURI","SAMOSA","VADAPAV","PIZZA","BURGER","MOMOS","AATREY"};
    String price[]={"40","40","50","120","60","130","1200"};
    int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvprod = findViewById(R.id.tvProd);
        tvprice = findViewById(R.id.tvPrice);

        btbuy = findViewById(R.id.btBuy);
        spinProd = findViewById(R.id.spinProd);

        ArrayAdapter<String> ad = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,product);
        spinProd.setAdapter(ad);

        SharedPreferences shad = getSharedPreferences("mydata", Context.MODE_PRIVATE);

        String lastprod = shad.getString("myproduct","nothing");
        String lastprice = shad.getString("myprice","0");

        if(lastprod.equals("nothing"))
        {
            tvprod.setText("BHAI KAI TO LE");
        }
        else
        {
            tvprod.setText("YOUR LAST PURCHASE : "+lastprod+"AT Rs."+lastprice);
        }


        spinProd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(getApplicationContext(),"SELECTOR :"+product[i],Toast.LENGTH_LONG).show();
                tvprice.setText("PRICE : "+price[i]);
                index = i;

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

        btbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String prod = product[index];
                String pri = price[index];

                SharedPreferences shad = getSharedPreferences("mydata", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = shad.edit();

                edit.putString("myproduct",prod);
                edit.putString("myprice",pri);
                edit.commit();

                Toast.makeText(getApplicationContext(),"YOUR ORDER HAS BEEN PLACED",Toast.LENGTH_LONG).show();

            }
        });

    }
}





//
//public class MainActivity extends Activity {
//    TextView tvProd,tvPrice;
//    Button btBuy;
//    Spinner spinProd;
//    String product[] = {"PANIPURI","VADAPAW","SAMOSA","MOMOS","DHOSA","BURGER","FAFDA"};
//    String price[] = {"40","25","20","80","150","50","30"};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        tvProd = findViewById(R.id.tvProd);
//        tvPrice = findViewById(R.id.tvPrice);
//
//        btBuy = findViewById(R.id.btBuy);
//        spinProd = findViewById(R.id.spinProd);
//
//                    // arrayadapter (applicationcontext,view,array(je display karavo hoy a))
//        ArrayAdapter<String> ad = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,product);
//        spinProd.setAdapter(ad);//list show karva mate
//
//        //spiner mate on item selected listner use karay
//        spinProd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),"Selection : "+product[i],Toast.LENGTH_LONG).show();
//                tvPrice.setText("Price : "+price[i]);
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });



//
//    }
//}