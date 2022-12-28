package com.example.vishal_parekh_comp304_lab4_room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Customer.class,Movie.class,Ticket.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    //
    private static volatile AppDatabase INSTANCE;
    private static final String DATABASE_NAME = "MovieData";
    public abstract CustomerDao custDao();
    public abstract MovieDao movieDao();
    public abstract TicketDao ticketDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            //Create database object
            INSTANCE = Room.databaseBuilder(context,
                    AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}