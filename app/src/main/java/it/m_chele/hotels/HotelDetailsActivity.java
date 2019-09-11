package it.m_chele.hotels;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.afollestad.viewpagerdots.DotsIndicator;

import it.m_chele.hotels.model.HotelsItem;

public class HotelDetailsActivity extends AppCompatActivity {

    private HotelsItem hotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        hotel = intent.getParcelableExtra(HotelConstants.KEY_HOTEL);

        ViewPager hotelImagesViewPager = findViewById(R.id.images_view_pager);
        hotelImagesViewPager.setAdapter(new ImagesAdapter(this, hotel.getImages()));
        DotsIndicator dotsIndicator = findViewById(R.id.dots);
        dotsIndicator.attachViewPager(hotelImagesViewPager);

        TextView address = findViewById(R.id.hotel_address);
        TextView phone = findViewById(R.id.hotel_phone);
        TextView email = findViewById(R.id.hotel_email);
        TextView checkin = findViewById(R.id.hotel_checkin);
        TextView checkout = findViewById(R.id.hotel_checkout);

        address.setText(
                String.format("%s",
                        hotel.getLocation().getAddress()));
        phone.setText(
                String.format("Tel: %s",
                        hotel.getContact().getPhoneNumber()));
        email.setText(
                String.format("Email: %s",
                        hotel.getContact().getEmail()));
        checkin.setText(
                String.format("Check-in: %s to %s",
                        hotel.getCheckIn().getFrom()
                        , hotel.getCheckIn().getTo()));
        checkout.setText(
                String.format("Check-in: %s to %s",
                        hotel.getCheckOut().getFrom(),
                        hotel.getCheckOut().getTo()));
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
