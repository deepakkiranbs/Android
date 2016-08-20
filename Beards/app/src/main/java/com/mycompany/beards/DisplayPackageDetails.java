package com.mycompany.beards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayPackageDetails extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.beards.MESSAGE";
    String packageName="",details="",price="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_package_details);


        Intent intent = getIntent();
        String message =intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int a=Integer.parseInt(message);
        String packageName="s",details="ds",price="ds";
        switch(a)
        {
            case 0:packageName="Package 1"; details="Details Go here";price="INR 200"; break;
            case 1:packageName="Package 2"; details="Details Go here";price="INR 300"; break;
            case 2:packageName="Package 3"; details="Details Go here";price="INR 400"; break;
            case 3:packageName="Package 4"; details="Details Go here";price="INR 500"; break;


        }

       TextView package_name =(TextView)findViewById(R.id.package_name);
        TextView package_details =(TextView)findViewById(R.id.details);
        TextView package_price =(TextView)findViewById(R.id.price);


        package_name.setText(packageName);
        package_details.setText(details);
        package_price.setText(price);
    }


    public void takeOrder(View view)
    {
        Intent intent = new Intent(this,TakeOrder.class);
        //intent.putExtra(EXTRA_MESSAGE, packageName);
        startActivity(intent);



    }

}
