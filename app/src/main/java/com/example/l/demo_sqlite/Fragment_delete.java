package com.example.l.demo_sqlite;


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
public class Fragment_delete extends Fragment {
SQLiteDatabase db;

    public Fragment_delete() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LayoutInflater lf=getActivity().getLayoutInflater();
        View v=lf.inflate(R.layout.fragment_blank,container,false);
        final View rootview=inflater.inflate(R.layout.fragment_blank,container,false);
        final EditText e1= (EditText) rootview.findViewById(R.id.delete_id);
        Button deletedata=(Button) rootview.findViewById(R.id.delete_button);
        deletedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u_id_d=e1.getText().toString();
                String sql_delete_data="DELETE FROM PERSONS WHERE id='"+u_id_d+"'";
               db.execSQL(sql_delete_data);
                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
                }
        });
        return rootview;
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_fragment_delete, container, false);
    }

}
