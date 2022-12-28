package com.example.vishal_parekh_comp304_lab4_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class Registration extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    private CustomerViewModel customerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        sharedpreferences = getSharedPreferences("mypref",
                0);
        customerViewModel = ViewModelProviders.of(this).get(CustomerViewModel.class);
        final int[] id = new int[1];
        LiveData<List<Customer>> cust = customerViewModel.getAllCustomer();
        if(cust == null){
            id[0] = 0;
        }
        else{
            cust.observe(this,cus->{
                for(Customer c:cus){
                    id[0] = c.getCustId();
                }
            });
        }
        /*
        customerViewModel.getAllCustomer().observe(this, customers -> {
            if(customers==null){
                id[0] = 0;
            }
            else{
                for(Customer cus: customers){
                    id[0] = cus.getCustId();
                }
            }
        });*/
        Button btn = (Button) findViewById(R.id.button2);
        Intent intent = new Intent(this, MainActivity.class);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                Customer customer = new Customer();
                int cusId = id[0]+1;
                EditText editTxt;
                editTxt = (EditText) findViewById(R.id.editTextTextPersonName3);
                String firstName = editTxt.getText().toString();
                editor.putString("firstName",firstName);
                editTxt = (EditText) findViewById(R.id.editTextTextPersonName4);
                String lastName = editTxt.getText().toString();
                editor.putString("lastName",lastName);
                editTxt = (EditText) findViewById(R.id.editTextTextPersonName5);
                String address = editTxt.getText().toString();
                editor.putString("address",address);
                editTxt = (EditText) findViewById(R.id.editTextTextPersonName6);
                String city = editTxt.getText().toString();
                editor.putString("city",city);
                editTxt = (EditText) findViewById(R.id.editTextTextPersonName7);
                String postalCode = editTxt.getText().toString();
                editor.putString("postalCode",postalCode);
                editTxt = (EditText) findViewById(R.id.editTextTextEmailAddress);
                String email = editTxt.getText().toString();
                editor.putString("email",email);
                editTxt = (EditText) findViewById(R.id.editTextTextPassword);
                String password = editTxt.getText().toString();
                editor.putString("password",password);
                editor.commit();
                customer.setFirstname(firstName);
                customer.setLastname(lastName);
                customer.setCustId(cusId);
                customer.setAddress(address);
                customer.setCity(city);
                customer.setPostalCode(postalCode);
                customer.setEmail(email);
                customer.setPassword(password);
                customerViewModel.insert(customer);
                startActivity(intent);
            }
        });
    }
}