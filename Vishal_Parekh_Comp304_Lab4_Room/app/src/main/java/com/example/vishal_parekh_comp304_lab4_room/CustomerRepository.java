package com.example.vishal_parekh_comp304_lab4_room;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class CustomerRepository {
    private final CustomerDao custDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private LiveData<List<Customer>> customerList;

    public CustomerRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        custDao = db.custDao();
        customerList = custDao.getAllCustomer();
    }
    // returns query results as LiveData object
    LiveData<List<Customer>> getAllCustomer() {
        return customerList;
    }

    LiveData<List<Customer>> logIn(String email, String password){
        customerList = custDao.logIn(email,password);
        return customerList;}

    LiveData<List<Customer>> cusById(String email){
        customerList = custDao.cusById(email);
        return customerList;
    }

    public void updateInfo(int custId,String city,String postalCode, String email, String password){
        custDao.updateInfo(custId,city,postalCode,email,password);
    }
    //inserts a person asynchronously
    public void insert(Customer cust) {
        insertAsync(cust);
    }
    // returns insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    private void insertAsync(final Customer customer) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    custDao.insert(customer);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }
}
