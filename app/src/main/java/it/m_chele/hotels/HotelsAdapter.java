package it.m_chele.hotels;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.Locale;

import it.m_chele.hotels.model.HotelsItem;

public class HotelsAdapter extends RecyclerView.Adapter<HotelsAdapter.HotelViewHolder> {
    private HotelsPresenter hotelsPresenter;

    public HotelsAdapter(HotelsPresenter hotelsPresenter) {
        this.hotelsPresenter = hotelsPresenter;
    }

    @NonNull
    @Override
    public HotelsAdapter.HotelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hotel_list_item, viewGroup, false);
        return new HotelViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelsAdapter.HotelViewHolder hotelViewHolder, final int position) {
        HotelsItem hotel = hotelsPresenter.hotelAt(position);
        Picasso.get()
                .load(hotel.getImages().get(0))
                .error(R.drawable.image_problem)
                .into(hotelViewHolder.images);
        hotelViewHolder.name.setText(hotel.getName());
        hotelViewHolder.stars.setText(String.format("%d stelle", hotel.getStars()));
        hotelViewHolder.address.setText(String.format("%s, %s", hotel.getLocation().getAddress(), hotel.getLocation().getCity()));
        hotelViewHolder.rating.setText(String.format(Locale.ITALY, "Valutazione %.1f", hotel.getUserRating()));

        hotelViewHolder.itemView.setOnClickListener(view -> hotelsPresenter.onClickOnHotelAt(position));
    }

    @Override
    public int getItemCount() {
        return hotelsPresenter.hotelsCount();
    }

    public class HotelViewHolder extends RecyclerView.ViewHolder {

        public ImageView images;
        public TextView name;
        public TextView stars;
        public TextView address;
        public TextView rating;

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);

            images = itemView.findViewById(R.id.hotel_images);
            name = itemView.findViewById(R.id.hotel_name);
            stars = itemView.findViewById(R.id.hotel_stars);
            address = itemView.findViewById(R.id.hotel_address);
            rating = itemView.findViewById(R.id.hotel_rating);
        }
    }
}
