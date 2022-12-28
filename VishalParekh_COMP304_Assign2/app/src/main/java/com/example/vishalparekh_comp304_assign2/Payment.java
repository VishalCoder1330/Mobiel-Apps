package com.example.vishalparekh_comp304_assign2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Payment extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        sharedpreferences = getSharedPreferences("mypref",
                0);
    }

    public void bookTicket(View view){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        Intent intent = new Intent(this, ConfirmTicket.class);
        EditText cardNo = (EditText) findViewById(R.id.editTextTextPersonName);
        String cardNoVal =cardNo.getText().toString();
        editor.putString("cardNo",cardNoVal);
        EditText exp = (EditText) findViewById(R.id.editTextTextPersonName2);
        String expVal =exp.getText().toString();
        editor.putString("expVal",expVal);
        EditText cvc = (EditText) findViewById(R.id.editTextTextPersonName3);
        String cvcVal =cvc.getText().toString();
        editor.putString("cvcVal",cvcVal);
        editor.commit();
        startActivity(intent);
    }
}