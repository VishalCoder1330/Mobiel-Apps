package com.example.vishal_parekh_comp304_lab4_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

public class TicketActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    private String date;
    RadioButton rgb;
    EditText txt;
    private int tickets;
    private String movieId;
    private String customerId;
    private TicketViewModel ticketViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        sharedpreferences = getSharedPreferences("mypref",
                0);
        String name =sharedpreferences.getString("name","");
        Intent intent = new Intent(this,TicketView.class);
        TextView txtView = (TextView) findViewById(R.id.textView12);
        String value = txtView.getText().toString() + " "+ name;
        txtView.setText(value);

        txtView = (TextView) findViewById(R.id.textView13);
        String movieName = txtView.getText().toString() + " "+sharedpreferences.getString("Movie Key","");
        System.out.println("name"+movieName);
        txtView.setText(movieName);

        Button pickDate = (Button) findViewById(R.id.button3);
        TextView textView =  (TextView) findViewById(R.id.textView14);
        String selectedDate = textView.getText().toString();

        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        TicketActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                date = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                                editor.putString("date",date);
                                editor.commit();
                                textView.setText(selectedDate+" "+dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                datePickerDialog.show();
            }
        });
        RadioGroup rdg = (RadioGroup) findViewById(R.id.radioGroup);

        Button btn = (Button) findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticketViewModel = ViewModelProviders.of(TicketActivity.this).get(TicketViewModel.class);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                Ticket ticketsObj = new Ticket();
                int selectedId = rdg.getCheckedRadioButtonId();
                rgb = (RadioButton) findViewById(selectedId);
                String time = rgb.getText().toString();
                editor.putString("time",time);
                txt = (EditText) findViewById(R.id.editTextTextPersonName8);
                String noOfTicket = txt.getText().toString();
                tickets = Integer.parseInt(noOfTicket);
                editor.putString("noOfTickets",noOfTicket);
                int totalPrice = tickets*10;
                String price  = Integer.toString(totalPrice);
                editor.putString("totalPrice",price);
                movieId = sharedpreferences.getString("movieId","");
                customerId = sharedpreferences.getString("custId","");
                int mId = Integer.parseInt(movieId);
                int cId = Integer.parseInt(customerId);
                LiveData<List<Ticket>> tick = ticketViewModel.getAllTickets();
                int[] id = new int[1];
                if(tick == null){
                    id[0] = 0;
                }
                else{
                    tick.observe(TicketActivity.this,tic->{
                        for(Ticket t:tic){
                            id[0] = t.getTicketId();
                        }
                    });
                }
                String tId = Integer.toString(id[0]);
                editor.putString("tId",tId);
                editor.commit();
                ticketsObj.setTicketId(id[0]);
                ticketsObj.setCustId(cId);
                ticketsObj.setMovieId(mId);
                ticketsObj.setNumerOfTickets(tickets);
                ticketsObj.setPrice(totalPrice);
                ticketsObj.setShowDate(date);
                ticketsObj.setShowTime(time);
                ticketViewModel.insert(ticketsObj);
                startActivity(intent);
            }
        });

        Button btnInfo = (Button) findViewById(R.id.button10);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicketActivity.this,UpdateCustomer.class);
                startActivity(intent);
            }
        });
    }


}