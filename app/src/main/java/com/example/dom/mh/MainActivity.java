package com.example.dom.mh;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity{

    private Toolbar toolbar;
    ListView list;
    ListView list1;

    String[] web = {
            "Bumrungrap Internation Hopsital",
            "Center Hosaital",
            "Royal Rathanak Hospital"
    };

    Integer[] imageId = {
            R.drawable.ic_bum,
            R.drawable.ic_sun,
            R.drawable.ic_cen
    };

    String[] web1 = {
            "Dentist",
            "Emergency",
            "Stomach",

            "Contact us"
    };

    Integer[] imageId1 = {
            R.drawable.ic_dentist,
            R.drawable.ic_emergency,
            R.drawable.ic_stomach,

            R.drawable.ic_about
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //list
        CustomList adapter = new CustomList(MainActivity.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, SubActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, web[+position], Toast.LENGTH_SHORT).show();
                }
            }
        });

        //list in fragment
        CustomList1 adapter1 = new CustomList1(MainActivity.this, web1, imageId1);
        list1=(ListView)findViewById(R.id.list1);
        list1.setAdapter(adapter1);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                } else {
                    Toast.makeText(MainActivity.this, web1[+position], Toast.LENGTH_SHORT).show();
                }
            }
        });

        toolbar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Fragment Navigation Drawer
        NavigationDrawerFragment drawerFragment=(NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setup(R.id.fragment_navigation_drawer,(DrawerLayout) findViewById(R.id.drawer_layout),toolbar);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this,"Hello " + item.getTitle(),Toast.LENGTH_SHORT).show();
            return true;
        }
//
//        if(id==R.id.navigate){
//            startActivity(new Intent(this,SubActivity.class));
//        }
        //back button
        if (id==R.id.home){
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
