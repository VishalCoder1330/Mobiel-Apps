package com.example.vishal_parekh_comp304_assign5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnclickLoc1(View view){
        Intent intent = new Intent(this, MapTypes.class);
        Cities city = new Cities("Scarborough",  43.777702, -79.233238, getScarboroughTheater());
        intent.putExtra("City",city);
        startActivity(intent);
    }
    public void OnclickLoc2(View view){
        Intent intent = new Intent(this, MapTypes.class);
        Cities city = new Cities("Oakville", 43.45011, -79.68292, getOakvilleTheater());
        intent.putExtra("City",city);
        startActivity(intent);
    }
    public void OnclickLoc3(View view){
        Intent intent = new Intent(this, MapTypes.class);
        Cities city = new Cities("Hamilton", 43.2604668, -80.2140351, getHamiltonTheater());
        intent.putExtra("City",city);
        startActivity(intent);
    }
    public void OnclickLoc4(View view){
        Intent intent = new Intent(this, MapTypes.class);
        Cities city = new Cities("Brampton",  43.7245901, -80.0404295, getBramptonTheater());

        intent.putExtra("City",city);
        startActivity(intent);
    }
    private List<Theaters> getScarboroughTheater() {
        List<Theaters> theaters = new ArrayList<>();
        theaters.add(new Theaters("Cineplex Cinemas Scarborough", "Scarborough Town Centre, 300 Borough Dr, Scarborough, ON M1P 4P5", "(416) 290-5217", "https://www.cineplex.com",43.775509, -79.255699));
        theaters.add(new Theaters("Woodside Square Cinemas", "1571 Sandhurst Cir, Scarborough, ON M1V 1V2", "(416) 299-1045", "https://www.newwoodsidecinemas.com/", 43.809490, -79.269402));
        theaters.add(new Theaters("Cineplex Cinemas Scarborough", "785 Milner Ave, Scarborough, ON M1B 3C3", " (416) 281-1444","https://www.cineplex.com", 43.797859, -79.204163));
        return theaters;
    }
    private List<Theaters> getOakvilleTheater() {
        List<Theaters> theaters = new ArrayList<>();
        theaters.add(new Theaters("Cineplex Cinemas Oakville and VIP", " 3531 Wyecroft Rd, Oakville, ON L6L 0B7", "(905) 827-7173", "https://www.cineplex.com/theatre/cineplex-cinemas-oakville-and-vip",43.393681, -79.751442));
        theaters.add(new Theaters("Film.Ca Cinemas", "171 Speers Rd Unit 25, Oakville, ON L6K 3W8", " (905) 338-6397", "https://film.ca/", 43.445399, -79.688613));
        theaters.add(new Theaters("5 Drive-In", "2332 Ninth Line, Oakville, ON L6H 7G9", "  (905) 257-8272","https://premiertheatres.ca/5drivein", 43.50469, -79.692807));
        return theaters;
    }
    private List<Theaters> getBramptonTheater() {
        List<Theaters> theaters = new ArrayList<>();
        theaters.add(new Theaters("SilverCity Brampton Cinemas", "50 Great Lakes Dr, Brampton, ON L6R 2K7", " (905) 789-6797", "https://www.cineplex.com/theatre/silvercity-brampton-cinemas",43.730624, -79.764909));
        theaters.add(new Theaters("The Rose Brampton", "1 Theatre Ln, Brampton, ON L6V 0A3, Canada", "(905) 874-2800", "http://www.therosebrampton.ca/",43.6871489, -79.7601189));
        return theaters;
    }
    private List<Theaters> getHamiltonTheater() {
        List<Theaters> theaters = new ArrayList<>();
        theaters.add(new Theaters("The Westdale", "1014 King St W, Hamilton, ON L8S 1L4", "(905) 577-0074", "https://www.thewestdale.ca/",43.2621327, -79.9056304));
        theaters.add(new Theaters("Playhouse Cinema", "177 Sherman Ave N, Hamilton, ON L8L 6M8", " (905) 545-8888", "https://playhousecinema.ca/", 43.25775, -79.836008));
        theaters.add(new Theaters("Cineplex Cinemas Hamilton Mountain", " 795 Paramount Dr, Stoney Creek, ON L8J 0B4", "(905) 560-0239","https://www.cineplex.com", 43.19303, -79.81067));
        return theaters;
    }
}
