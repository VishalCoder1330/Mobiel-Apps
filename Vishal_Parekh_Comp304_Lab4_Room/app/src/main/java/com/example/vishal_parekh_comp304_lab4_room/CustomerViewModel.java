package com.example.vishal_parekh_comp304_lab4_room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CustomerViewModel extends AndroidViewModel{
    private CustomerRepository customerRepo;
    private androidx.lifecycle.LiveData<Integer> insertResult;
    private androidx.lifecycle.LiveData<List<Customer>> allCustomer;

    public CustomerViewModel(@NonNull Application application) {
        super(application);
        customerRepo = new CustomerRepository(application);
        insertResult = customerRepo.getInsertResult();
        allCustomer = customerRepo.getAllCustomer();
    }

    public void insert(Customer customer) {customerRepo.insert(customer);}

    public void updateInfo(int custId,String city,String postalCode, String email, String password){
        customerRepo.updateInfo(custId,city,postalCode,email,password);
    }

    LiveData<List<Customer>> cusById(String email){
        allCustomer = customerRepo.cusById(email);
        return allCustomer;
    }

    public LiveData<Integer> getInsertResult(){ return insertResult; }

    LiveData<List<Customer>> logIn(String email, String password){
        allCustomer = customerRepo.logIn(email,password);
        return allCustomer;
    }

    LiveData<List<Customer>> getAllCustomer() {return allCustomer; }
}
