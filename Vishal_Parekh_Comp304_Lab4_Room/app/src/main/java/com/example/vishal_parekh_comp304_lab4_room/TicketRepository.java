package com.example.vishal_parekh_comp304_lab4_room;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class TicketRepository {
    private final TicketDao ticketDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private LiveData<List<Ticket>> ticketList;

    public TicketRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        ticketDao = db.ticketDao();
        ticketList = ticketDao.getAllTickets();
    }
    // returns query results as LiveData object
    LiveData<List<Ticket>> getAllTickets() {
        return ticketList;
    }
    //inserts a person asynchronously
    public void insert(Ticket ticket) {
        insertAsync(ticket);
    }

    public void deleteTicket(int ticketId){
        ticketDao.deleteTicket(ticketId);
    return;}
    // returns insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    private void insertAsync(final Ticket tick) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ticketDao.insert(tick);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }
}
