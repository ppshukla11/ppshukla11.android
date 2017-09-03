package com.example.l.demo_sqlite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    SQLiteDatabase db;


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        db=SQLiteDatabase.openOrCreateDatabase("Persontable", Context.MODE_PRIVATE,null);

        // Inflate the layout for this fragment
        LayoutInflater lf=getActivity().getLayoutInflater();
        View v=lf.inflate(R.layout.fragment_blank,container,false);
        final View rootview=inflater.inflate(R.layout.fragment_blank,container,false);
        final EditText e1= (EditText) rootview.findViewById(R.id.u_id);
        final EditText e2= (EditText) rootview.findViewById(R.id.name);
        final EditText e3= (EditText) rootview.findViewById(R.id.number);
        Button savedata=(Button) rootview.findViewById(R.id.save);
        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String userid1=e1.getText().toString();
                String username1=e2.getText().toString();
                String usernum1=e3.getText().toString();
                Toast.makeText(getActivity(), username1, Toast.LENGTH_SHORT).show();
                String sqlsave="INSERT INTO PERSONS (name,number) VALUES('"+username1+"','"+usernum1+"');";
                db.execSQL(sqlsave);
                Toast.makeText(getActivity(), "data saved successfully", Toast.LENGTH_SHORT).show();
            }
        });
        return rootview;
//        return inflater.inflate(R.layout.fragment_blank, container, false);

    }

}
