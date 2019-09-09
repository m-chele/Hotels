package it.m_chele.hotels;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class HotelsAdapter extends RecyclerView.Adapter<HotelsAdapter.HotelViewHolder> {
    private List<Hotel> hotels;

    public HotelsAdapter(List<Hotel> hotels) {

        this.hotels = hotels;
    }

    @NonNull
    @Override
    public HotelsAdapter.HotelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hotel_list_item, viewGroup, false);
        return new HotelViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelsAdapter.HotelViewHolder hotelViewHolder, int i) {
        Hotel hotel = hotels.get(i);
        hotelViewHolder.name.setText(hotel.name);
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public class HotelViewHolder extends RecyclerView.ViewHolder {

        public TextView name;

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.hotel_name);
        }
    }
}
