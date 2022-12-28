package com.example.vishal_parekh_comp304_lab4_room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface CustomerDao {

    @Insert
    void insert(Customer customer);

    @Query("select * from Customer")
    LiveData<List<Customer>> getAllCustomer();

    @Query("select * from Customer where email = :email and password = :password")
    LiveData<List<Customer>> logIn(String email,String password);

    @Query("select * from Customer where email = :email ")
    LiveData<List<Customer>> cusById(String email);

    @Query("update Customer set city = :city, postalCode = :postalCode, email = :email, password = :password where custId = :custId")
    void updateInfo(int custId,String city,String postalCode, String email, String password);
}
