package com.example.aldiros.myassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class customProfile extends AppCompatActivity implements View.OnClickListener{

    private DatabaseReference databaseReference;

    private EditText editTextName;
    private EditText editTextAddress;
    private EditText editTextPhone;
    private EditText editTextPekerjaan;

    private Button buttonUpdate;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null){
            finish();
        }

        databaseReference = FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = firebaseAuth.getCurrentUser();


        editTextName = (EditText) findViewById(R.id.name);
        editTextAddress = (EditText) findViewById(R.id.address);
        editTextPhone = (EditText) findViewById(R.id.phone);
        editTextPekerjaan = (EditText) findViewById(R.id.pekerjaan);
        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);

        buttonUpdate.setOnClickListener(this);
    }

    private void saveUserInformation(){
        String name = editTextName.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String pekerjaan = editTextPekerjaan.getText().toString().trim();


        UserInformation userInformation = new UserInformation(name, address, phone, pekerjaan);

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference User = rootRef.child("User").push();


        String key = User.getKey();
        Map<String,UserInformation > map = new HashMap<>();
        map.put(key, userInformation);
        User.updateChildren(new HashMap<String, Object>(map));

        Toast.makeText(this, "Information Updated..", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, home.class));
    }

    @Override
    public void onClick(View view) {
        if(view==buttonUpdate){
            saveUserInformation();
        }
    }
}
