package it.m_chele.hotels;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import it.m_chele.hotels.model.Hotels;
import it.m_chele.hotels.model.HotelsItem;

public class MainActivity extends AppCompatActivity implements HotelsView, HotelListItemClickListener {

    private HotelsPresenter hotelPresenter;
    private RecyclerView hotelsListView;
    private List<HotelsItem> hotelsList;
    private HotelsAdapter hotelsAdapter;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        refreshLayout = findViewById(R.id.refresh_layout);
        refreshLayout.setOnRefreshListener(() -> hotelPresenter.loadData());

        hotelsListView = findViewById(R.id.hotels_list);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        hotelsListView.setLayoutManager(layoutManager);
        hotelsListView.setHasFixedSize(true);

        hotelPresenter = new HotelsPresenter(this);
        hotelPresenter.loadData();

        // TODO: pensare a UI/UX: usare per filtro e aggiungere pull to refresh
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> hotelPresenter.loadData());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hotelPresenter.onDestroy();
    }

    @Override
    public void showLoading() {
        // TODO : UI/UX e.g progressbar
        refreshLayout.setRefreshing(true);
        showSnackbarWithMessage("Caricamento in corso...");
    }

    @Override
    public void showError(String message) {
        refreshLayout.setRefreshing(false);
        showSnackbarWithMessage("Errore di caricamento, riprova tra poco!");
    }

    @Override
    public void updateWith(final Hotels hotels) {

        this.hotelsList = hotels.getHotels();
        hotelsAdapter = new HotelsAdapter(hotels, this);
        hotelsListView.setAdapter(hotelsAdapter);

        hotelsAdapter.notifyDataSetChanged();

        refreshLayout.setRefreshing(false);
        showSnackbarWithMessage("Caricamento completo!");
    }

    private void showSnackbarWithMessage(String message) {
        Snackbar.make(findViewById(R.id.fab), message, Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public void onHotelItemClick(int position) {

        if (position == -1) {
            return;
        }
        Intent detailIntent = new Intent(this, HotelDetailsActivity.class);
        detailIntent.putExtra(HotelConstants.KEY_HOTEL, hotelsList.get(position));
        startActivity(detailIntent);
    }
}
