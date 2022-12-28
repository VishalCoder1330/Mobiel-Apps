package com.example.vishalparekh_comp304_assign2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CheckOut extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        sharedpreferences = getSharedPreferences("mypref",
                0);
    }
    public void paymentInfo(View view){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        Intent intent = new Intent(this, Payment.class);
        EditText firstName = (EditText) findViewById(R.id.editTextTextPersonName7);
        String firstNameVal =firstName.getText().toString();
        editor.putString("firstName",firstNameVal);
        EditText lastName = (EditText) findViewById(R.id.editTextTextPersonName8);
        String lastNameVal =lastName.getText().toString();
        editor.putString("lastName",lastNameVal);
        EditText phone = (EditText) findViewById(R.id.editTextPhone2);
        String phoneVal =phone.getText().toString();
        editor.putString("phoneNO",phoneVal);
        EditText mail = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        String mailVal =mail.getText().toString();
        editor.putString("mail",mailVal);
        EditText add = (EditText) findViewById(R.id.editTextTextPersonName9);
        String addVal =add.getText().toString();
        editor.putString("address",addVal);
        editor.commit();
        startActivity(intent);
    }
}