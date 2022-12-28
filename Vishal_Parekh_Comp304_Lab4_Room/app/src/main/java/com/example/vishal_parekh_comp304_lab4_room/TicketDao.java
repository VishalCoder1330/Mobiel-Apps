package com.example.vishal_parekh_comp304_lab4_room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TicketDao {
    @Insert
    void insert(Ticket ticket);

    @Query("select * from Ticket order by ticketId")
    LiveData<List<Ticket>> getAllTickets();

    @Query("delete from Ticket where ticketId = :ticketId")
    void deleteTicket(int ticketId);
}
