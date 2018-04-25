package com.example.aldiros.myassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class babysitter extends AppCompatActivity {

    private EditText mSearchField;
    private ImageButton mSearchButton;

    RecyclerView mResultBabysitter;
    babysitterAdapter adapter;
    List<babysitterUser> babysitterList;

    private DatabaseReference mUserDatabase;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_babysitter);

        mSearchField = (EditText) findViewById(R.id.searchBabysitter);
        mSearchButton = (ImageButton) findViewById(R.id.searchImg);
        mResultBabysitter = (RecyclerView) findViewById(R.id.result_babysitter);

        mResultBabysitter.setHasFixedSize(true);
        mResultBabysitter.setLayoutManager(new LinearLayoutManager(this));

        //        child pada firebase
        mUserDatabase = FirebaseDatabase.getInstance().getReference("Babysitter");

        mUserDatabase.addValueEventListener(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    babysitterUser bs = postSnapshot.getValue(babysitterUser.class);
//                   Toast.makeText(babysitter.this, bs.getNama(), Toast.LENGTH_LONG).show();
                    babysitterList.add(bs);
                }
                adapter = new babysitterAdapter(babysitter.this, babysitterList);
                mResultBabysitter.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mAuth.getCurrentUser();
    }
}
