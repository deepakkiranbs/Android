package com.mycompany.beards;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.mycompany.beards.MESSAGE";

    private List<HomeScreenIcon> myicons=new ArrayList<HomeScreenIcon>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateiconsList();
        pupulatelistview();
        registerClickCallBack();
    }


    private void populateiconsList() {

    myicons.add(new HomeScreenIcon("package1","Few Details",R.drawable.icon));
    myicons.add(new HomeScreenIcon("package2","Few Details",R.drawable.icon));
    myicons.add(new HomeScreenIcon("package3","Few Details",R.drawable.icon));
    myicons.add(new HomeScreenIcon("package4","Few Details",R.drawable.icon));

    }

    private void pupulatelistview() {

        ArrayAdapter<HomeScreenIcon> adapter=new MyListAdapter();
        ListView list= (ListView)findViewById(R.id.package_list_View);
        if (list != null) {
            list.setAdapter(adapter);
        }

    }

    private class MyListAdapter extends ArrayAdapter<HomeScreenIcon>
    {

      public MyListAdapter()
      {
      super(MainActivity.this,R.layout.item_view,myicons);
      }

@Override
         public View getView(int position, View convertView, ViewGroup parent)
{

    View itemView=convertView;

    if(itemView==null)//make sure we have a view to work with
    {
        itemView=getLayoutInflater().inflate(R.layout.item_view,parent,false);

    }
    //find the icon to work with
HomeScreenIcon current_icon=myicons.get(position);


    //fill the view
    ImageView imageview=(ImageView)itemView.findViewById(R.id.item_icon);
imageview.setImageResource(current_icon.getIconID());

    //package Name
    TextView packageName=(TextView)itemView.findViewById(R.id.item_packageName);
    packageName.setText(current_icon.getPackageName());

    //Few Details
    TextView details=(TextView)itemView.findViewById(R.id.item_details);
    details.setText(current_icon.getDetails());

    return itemView;
}
    }

    private void registerClickCallBack() {

        ListView list=(ListView) findViewById(R.id.package_list_View);
        if (list != null)
        {
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                    HomeScreenIcon clickedIcon = myicons.get(position);
                    String message = ""+position;
                    //Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(),DisplayPackageDetails.class);
                    intent.putExtra(EXTRA_MESSAGE, message);
                    startActivity(intent);



                }
            });

        }
    }


}
