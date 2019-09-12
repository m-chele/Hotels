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

public class HotelsListActivity extends AppCompatActivity implements HotelsView {

    private HotelsPresenter hotelPresenter;
    private RecyclerView hotelsListView;
    private HotelsAdapter hotelsAdapter;
    private SwipeRefreshLayout refreshLayout;
    private FloatingActionButton fab;

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

        hotelPresenter = new HotelsPresenterImpl(this, new HotelsModelImpl());
        hotelPresenter.loadData();

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> hotelPresenter.onClickOnToggleStarsSorting());
    }

    @Override
    public void starsSortingCompleted(boolean ascending) {
        fab.setImageResource(ascending ? R.drawable.ic_menu_sort_by_stars_desc : R.drawable.ic_menu_sort_by_stars_asc);
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
    public void refreshData() {

        hotelsAdapter = new HotelsAdapter(hotelPresenter);
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
        detailIntent.putExtra(HotelConstants.KEY_HOTEL, hotelPresenter.hotelAt(position));
        startActivity(detailIntent);
    }
}
