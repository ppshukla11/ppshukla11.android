package com.example.l.demo_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    EditText e1,e2,e3;
    Button b1,b2,b3,b4;
    SQLiteDatabase db;
    RelativeLayout r;
    Cursor c;
    String list1="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openDatabase();

        b1= (Button) findViewById(R.id.insert);
        b2= (Button) findViewById(R.id.show);
        b3= (Button) findViewById(R.id.update);
        b4= (Button) findViewById(R.id.delete);
        r= (RelativeLayout) findViewById(R.id.rl1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
////                String id1=e1.getText().toString();
//                String name1=e2.getText().toString();
//                String num1=e3.getText().toString();
////                Toast.makeText(MainActivity.this, "name"+name1, Toast.LENGTH_SHORT).show();
////                Toast.makeText(MainActivity.this, "number"+num1, Toast.LENGTH_SHORT).show();
//                String sql="INSERT INTO PERSONS (name,number) VALUES('"+name1+"','"+num1+"');";
//                db.execSQL(sql);
//                Toast.makeText(MainActivity.this, "data saved successfully", Toast.LENGTH_SHORT).show();
////                Toast.makeText(MainActivity.this, "name and number is"+name1+num1, Toast.LENGTH_SHORT).show();
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                BlankFragment frag=new BlankFragment();
                ft.add(R.id.rl1,frag);
                ft.addToBackStack(null);
                ft.commit();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ArrayList<String> list=new ArrayList<String>();
//                c=db.rawQuery("SELECT * FROM PERSONS",null);
//                if(c != null)
//                {
//                    if(c.moveToFirst()){
//                        do{
//                            String dir=c.getString(0);
//                            list.add(dir);
//                            String dir1=c.getString(1);
//                            list.add(dir1);
//                            String dir2=c.getString(2);
//                            list.add(dir2);
//                        }while (c.moveToNext());
//                    }
//                }
////                String list1 = "";
//                for (String s:list){
//                    list1+= s +"\n";
//                }
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                Fragment_show frag=new Fragment_show();
                ft.add(R.id.rl1,frag);
                ft.addToBackStack(null);
                ft.commit();
//                Toast.makeText(MainActivity.this, "list is\n"+list1, Toast.LENGTH_LONG).show();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                Fragment_update frag=new Fragment_update();
                ft.add(R.id.rl1,frag);
                ft.addToBackStack(null);
                ft.commit();
//                String id1=e1.getText().toString();
//                String name1=e2.getText().toString();
//                String num1=e3.getText().toString();
//                String sql_update="UPDATE PERSONS SET name='"+name1+"',number='"+num1+"' WHERE id='"+id1+"';";
//                db.execSQL(sql_update);
//                Toast.makeText(MainActivity.this, "updated successfully", Toast.LENGTH_SHORT).show();


            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                Fragment_delete frag=new Fragment_delete();
                ft.add(R.id.rl1,frag);
                ft.addToBackStack(null);
                ft.commit();
//                String id1=e1.getText().toString();
//                String sql_delete="DELETE FROM PERSONS WHERE id='"+id1+"'";
//                db.execSQL(sql_delete);
//                Toast.makeText(MainActivity.this, "record deleted", Toast.LENGTH_SHORT).show();
}
        });

    }

    public void openDatabase() {
        db=openOrCreateDatabase("Persontable", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS PERSONS(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,name VARCHAR,number VARCHAR);");
        Toast.makeText(this, "database created successfully", Toast.LENGTH_SHORT).show();

    }
//    public String getMyData(){
//
//        return list1;
//    }
}
