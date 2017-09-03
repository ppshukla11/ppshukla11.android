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
public class Fragment_update extends Fragment {

    SQLiteDatabase db;
    public Fragment_update() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LayoutInflater lf=getActivity().getLayoutInflater();
        final View v=lf.inflate(R.layout.fragment_fragment_update,container,false);
        final View rootview=inflater.inflate(R.layout.fragment_fragment_update,container,false);
        final EditText e1= (EditText) rootview.findViewById(R.id.update_id);
        final EditText e2= (EditText) rootview.findViewById(R.id.update_name);
        final EditText e3= (EditText) rootview.findViewById(R.id.update_num);
        Button updatedata=(Button) rootview.findViewById(R.id.update_data);
        updatedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String update_uid=e1.getText().toString();
                String update_uname=e2.getText().toString();
                String update_unum=e3.getText().toString();
                Toast.makeText(getActivity(),update_uname, Toast.LENGTH_SHORT).show();
                String sql_update_data="UPDATE PERSONS SET name='"+update_uname+"',number='"+update_unum+"' WHERE id='"+update_uid+"';";
                db.execSQL(sql_update_data);
                Toast.makeText(getActivity(), "data updated successfully", Toast.LENGTH_SHORT).show();
            }
        });
        return rootview;
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_fragment_update, container, false);
    }

}
