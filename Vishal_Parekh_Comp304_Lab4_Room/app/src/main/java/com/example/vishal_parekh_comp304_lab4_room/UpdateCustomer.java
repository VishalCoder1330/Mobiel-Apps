package com.example.vishal_parekh_comp304_lab4_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class UpdateCustomer extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    private CustomerViewModel customerViewModel;
    String city;
    String postalCode;
    String email;
    String password;
    EditText edtTxt;
    int custId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_customer);
        sharedpreferences = getSharedPreferences("mypref",
                0);
        customerViewModel = ViewModelProviders.of(this).get(CustomerViewModel.class);
        String cId = sharedpreferences.getString("mailId","");

        //custId = Integer.parseInt(cId);
        //LiveData<List<Customer>> cus=customerViewModel.findCusById(cId);
        customerViewModel.cusById(cId).observe(UpdateCustomer.this, new Observer<List<Customer>>() {
            @Override
            public void onChanged(List<Customer> customers) {
                for(Customer c:customers){
                    city = c.getCity();
                    System.out.println("inc"+city);
                    postalCode = c.getPostalCode();
                    email = c.getEmail();
                    password = c.getPassword();
                    edtTxt = (EditText) findViewById(R.id.editTextTextPersonName11);
                    edtTxt.setText(city);

                    edtTxt = (EditText) findViewById(R.id.editTextTextPersonName12);
                    edtTxt.setText(postalCode);

                    edtTxt = (EditText) findViewById(R.id.editTextTextEmailAddress2);
                    edtTxt.setText(email);

                    edtTxt = (EditText) findViewById(R.id.editTextTextPassword2);
                    edtTxt.setText(password);
                }
            }
        });

            Button btn = (Button) findViewById(R.id.button7);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(UpdateCustomer.this,TicketActivity.class);
                    edtTxt = (EditText) findViewById(R.id.editTextTextPersonName11);
                    city = edtTxt.getText().toString();
                    edtTxt = (EditText) findViewById(R.id.editTextTextPersonName12);
                    postalCode = edtTxt.getText().toString();
                    edtTxt = (EditText) findViewById(R.id.editTextTextEmailAddress2);
                    email = edtTxt.getText().toString();
                    edtTxt = (EditText) findViewById(R.id.editTextTextPassword2);
                    password = edtTxt.getText().toString();
                    customerViewModel.updateInfo(custId,city,postalCode,email,password);
                    Toast.makeText(UpdateCustomer.this,"Info Updated",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            });
    }
}