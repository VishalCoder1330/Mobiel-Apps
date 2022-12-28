package com.example.vishalparekh_comp304_assign2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmTicket extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_ticket);
        sharedpreferences = getSharedPreferences("mypref",
                0);
        String firstName = sharedpreferences.getString("firstName","");
        String lastName = sharedpreferences.getString("lastName","");
        String address = sharedpreferences.getString("address","");
        String phone = sharedpreferences.getString("phoneNO","");
        String mail = sharedpreferences.getString("mail","");
        String movie = sharedpreferences.getString("Movie Key","");
        String time = sharedpreferences.getString("timeKey","");
        String aCat = sharedpreferences.getString("adultKey","");
        String cCat = sharedpreferences.getString("childKey","");
        String aNo = sharedpreferences.getString("noOfAdultTicket","");
        String cNo = sharedpreferences.getString("noOfChildTicket","");
        String name  = firstName + " " + lastName;
        String noOfTic = "Adult - " + aNo + " " + cCat+" - " + cNo;
        System.out.println("name"+name);
        System.out.println("no1"+aCat);
        TextView textView;
        textView = findViewById(R.id.textView21);
        textView.setText(firstName + " " + lastName);
        textView = findViewById(R.id.textView22);
        textView.setText(address);
        textView = findViewById(R.id.textView23);
        textView.setText(phone);
        textView = findViewById(R.id.textView24);
        textView.setText(mail);
        textView = findViewById(R.id.textView25);
        textView.setText(movie);
        textView = findViewById(R.id.textView30);
        textView.setText(time);
        textView = findViewById(R.id.textView31);
        textView.setText(noOfTic);
    }
}