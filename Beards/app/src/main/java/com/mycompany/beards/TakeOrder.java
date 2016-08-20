package com.mycompany.beards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TakeOrder extends AppCompatActivity {

    EditText name,address,pin,email,phone;
    String name_,address_,pin_,email_,phone_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_order);
         name=(EditText)findViewById(R.id.name);
        address=(EditText)findViewById(R.id.address);
        pin=(EditText)findViewById(R.id.Pin);
        email=(EditText)findViewById(R.id.email);
        phone=(EditText)findViewById(R.id.phone);
    }


    public void confirmOrder(View view)
    {


        name_=name.getText().toString();
        address_=address.getText().toString();
        pin_=pin.getText().toString();
        email_=email.getText().toString();
        phone_=phone.getText().toString();

        String method="register";
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(method,name_,address_,pin_,email_,phone_);
        finish();
    }


}
