package com.example.vishal_parekh_comp304_lab4_room;

import androidx.appcompat.app.AppCompatActivity;
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

public class Login extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    private CustomerViewModel customerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedpreferences = getSharedPreferences("mypref",
                0);
        customerViewModel = ViewModelProviders.of(this).get(CustomerViewModel.class);
        Button btn = (Button) findViewById(R.id.button);
        Intent intent = new Intent(this, TicketActivity.class);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                EditText edtTxt;
                edtTxt = (EditText) findViewById(R.id.editTextTextPersonName);
                String email = edtTxt.getText().toString();
                edtTxt = (EditText) findViewById(R.id.editTextTextPersonName2);
                String password = edtTxt.getText().toString();
                //LiveData<List<Customer>> cut = customerViewModel.logIn(email,password);
                customerViewModel.logIn(email,password).observe(Login.this, new Observer<List<Customer>>() {
                    @Override
                    public void onChanged(List<Customer> customers) {
                        System.out.println("cus"+customers);
                        if(customers.isEmpty()){
                            Toast.makeText(getApplicationContext(), "Invalid Login Credentials", Toast.LENGTH_SHORT).show();
                        }
                        for(Customer cus:customers){
                            System.out.println("mail"+cus.getEmail());
                            if(cus.getEmail().equals(email) && cus.getPassword().equals(password)){
                                editor.putString("mailId",email);
                                editor.putString("pass",password);
                                String name = cus.getFirstname() + " " + cus.getLastname();
                                editor.putString("name",name);
                                String id = Integer.toString(cus.getCustId());
                                editor.putString("custId",id);
                                editor.commit();
                                startActivity(intent);
                            }
                        }
                    }
                });

            }
        });
    }
    public void rdrReg(View v){
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }
}