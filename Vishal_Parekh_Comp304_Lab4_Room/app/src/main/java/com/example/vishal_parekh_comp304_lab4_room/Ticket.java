package com.example.vishal_parekh_comp304_lab4_room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Ticket {
    @PrimaryKey(autoGenerate = true)
    private int ticketId;
    private int custId;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public int getNumerOfTickets() {
        return numerOfTickets;
    }

    public void setNumerOfTickets(int numerOfTickets) {
        this.numerOfTickets = numerOfTickets;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private int movieId;
    private String showDate;
    private String showTime;
    private int numerOfTickets;
    private float price;
}
