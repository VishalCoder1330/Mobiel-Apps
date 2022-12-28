package com.example.vishal_parekh_comp304_lab4_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TicketView extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    TextView txtView;
    TicketViewModel ticketViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_view);
        sharedpreferences = getSharedPreferences("mypref",
                0);

        Button btn = (Button) findViewById(R.id.button5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticketViewModel = ViewModelProviders.of(TicketView.this).get(TicketViewModel.class);
                String movieName = sharedpreferences.getString("Movie Key","");
                String time = sharedpreferences.getString("time","");
                String date = sharedpreferences.getString("date","");
                String noOfTickets = sharedpreferences.getString("noOfTickets","");
                String totalPrice = sharedpreferences.getString("totalPrice","");
                txtView = (TextView) findViewById(R.id.textView17);
                txtView.setText("Movie Name: "+movieName);
                txtView = (TextView) findViewById(R.id.textView18);
                txtView.setText("Movie Time: "+time);
                txtView = (TextView) findViewById(R.id.textView19);
                txtView.setText("Movie Date: "+date);
                txtView = (TextView) findViewById(R.id.textView20);
                txtView.setText("No of Tickets: "+noOfTickets);
                txtView = (TextView) findViewById(R.id.textView21);
                txtView.setText("Total Price(in CAD): "+totalPrice);
                ticketViewModel.getAllTickets().observe(TicketView.this,tick->{
                    for(Ticket ticks: tick){
                        System.out.println("id"+ticks.getTicketId());
                    }
                });
            }
        });

        btn = (Button) findViewById(R.id.button6);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticketViewModel = ViewModelProviders.of(TicketView.this).get(TicketViewModel.class);
                String tId = sharedpreferences.getString("tId","");
                int id = Integer.parseInt(tId);
                ticketViewModel.deleteTicket(id);
                Toast.makeText(TicketView.this, "Ticket Deleted",Toast.LENGTH_SHORT).show();
            }
        });
    }
}