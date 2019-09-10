package it.m_chele.hotels;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HotelDetailsActivity extends AppCompatActivity {

    private Hotel hotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        hotel = intent.getParcelableExtra(HotelConstants.KEY_HOTEL);

        TextView phone = findViewById(R.id.hotel_phone);
        TextView email = findViewById(R.id.hotel_email);
        TextView checkin = findViewById(R.id.hotel_checkin);
        TextView checkout = findViewById(R.id.hotel_checkout);

        phone.setText(String.format("Tel: %s", hotel.phone));
        email.setText(String.format("Email: %s", hotel.email));
        checkin.setText(String.format("Check-in: %s", hotel.checkin));
        checkout.setText(String.format("Check-in: %s", hotel.checkout));
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
