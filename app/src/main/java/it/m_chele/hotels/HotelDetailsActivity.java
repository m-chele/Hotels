package it.m_chele.hotels;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.afollestad.viewpagerdots.DotsIndicator;

import it.m_chele.hotels.model.HotelsItem;

public class HotelDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        HotelsItem hotel = getIntent()
                .getParcelableExtra(HotelConstants.KEY_HOTEL);

        ViewPager hotelImagesViewPager = findViewById(R.id.images_view_pager);
        hotelImagesViewPager.setAdapter(new ImagesAdapter(this, hotel.getImages()));
        DotsIndicator dotsIndicator = findViewById(R.id.dots);
        dotsIndicator.attachViewPager(hotelImagesViewPager);

        TextView name = findViewById(R.id.hotel_name);
        TextView stars = findViewById(R.id.hotel_stars);
        TextView address = findViewById(R.id.hotel_address);
        TextView rating = findViewById(R.id.hotel_rating);
        TextView phone = findViewById(R.id.hotel_phone);
        TextView email = findViewById(R.id.hotel_email);
        TextView checkin = findViewById(R.id.hotel_checkin);
        TextView checkout = findViewById(R.id.hotel_checkout);

        // TODO: formatting responsibility should be isolated
        name.setText(
                String.format("%s",
                        hotel.getName()));
        stars.setText(
                String.format("%s stelle",
                        hotel.getStars()));
        address.setText(
                String.format("Valutazione %s",
                        hotel.getUserRating()));
        rating.setText(
                String.format("%s, %s",
                        hotel.getLocation().getAddress(), hotel.getLocation().getCity()));
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
