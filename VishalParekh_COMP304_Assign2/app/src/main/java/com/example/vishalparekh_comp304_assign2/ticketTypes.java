package com.example.vishalparekh_comp304_assign2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class ticketTypes extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_types);
        sharedpreferences = getSharedPreferences("mypref",
                0);
        CheckBox checkBox = (CheckBox) findViewById(R.id.adult);
        checkBox.setOnClickListener(new View.OnClickListener()
        {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            String checkKey = "adultKey";
            String checkVal = getString(R.string.adult);;

            public void onClick(View v) {
                if (((CheckBox)v).isChecked()){
                    editor.putString(checkKey,checkVal);
                    editor.commit();
                }
            }
        });
        CheckBox checkBoxChild = (CheckBox) findViewById(R.id.child);
        checkBox.setOnClickListener(new View.OnClickListener()
        {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            String checkChildKey = "childKey";
            String checkChildVal = getString(R.string.child);

            public void onClick(View v) {
                if (((CheckBox)v).isChecked()){
                    editor.putString(checkChildKey,checkChildVal);
                    editor.commit();
                }
            }
        });
    }

    public void checkOut(View view){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        String adultTicKey = "noOfAdultTicket";
        EditText editText = (EditText) findViewById(R.id.adultTickets);
        String noOfTicket =editText.getText().toString();
        String childTicKey = "noOfChildTicket";
        EditText editText_child = (EditText) findViewById(R.id.childTickets);
        String noOfChildTicket =editText.getText().toString();
        editor.putString(adultTicKey,noOfTicket);
        editor.putString(childTicKey,noOfChildTicket);
        editor.commit();
        Intent intent = new Intent(this, CheckOut.class);
        startActivity(intent);
    }
}