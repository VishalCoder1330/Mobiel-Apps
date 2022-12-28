package com.example.vishal_parekh_comp304_lab4_room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TicketViewModel extends AndroidViewModel {
    private TicketRepository ticketRepo;
    private androidx.lifecycle.LiveData<Integer> insertResult;
    private androidx.lifecycle.LiveData<List<Ticket>> allTicket;
    public TicketViewModel(@NonNull Application application) {
        super(application);
        ticketRepo = new TicketRepository(application);
        insertResult = ticketRepo.getInsertResult();
        allTicket = ticketRepo.getAllTickets();
    }

    public void insert(Ticket ticket) {ticketRepo.insert(ticket);}

    LiveData<List<Ticket>> getAllTickets() {return allTicket; }

    public void deleteTicket(int ticketId){
        ticketRepo.deleteTicket(ticketId);
        return;
    }
}
