package it.m_chele.hotels;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class HotelsListActivity extends AppCompatActivity implements HotelsView {

    private HotelsPresenter hotelsPresenter;
    private RecyclerView hotelsListView;
    private SwipeRefreshLayout refreshLayout;
    private FloatingActionButton fab;
    private HotelsAdapter hotelsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: inject as dependency
        hotelsPresenter = new HotelsPresenterImpl(this, new HotelsModelImpl());
        hotelsAdapter = new HotelsAdapter(hotelsPresenter);

        configureUI();

        hotelsPresenter.loadData();
    }

    private void configureUI() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        refreshLayout = findViewById(R.id.refresh_layout);
        refreshLayout.setOnRefreshListener(() -> hotelsPresenter.loadData());

        hotelsListView = findViewById(R.id.hotels_list);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        hotelsListView.setLayoutManager(layoutManager);
        hotelsListView.setHasFixedSize(true);
        hotelsListView.setAdapter(hotelsAdapter);


        fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> hotelsPresenter.onClickOnToggleStarsSorting());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hotelsPresenter.onDestroy();
    }

    @Override
    public void starsSortingCompleted(boolean ascending) {
        fab.setImageResource(ascending ? R.drawable.ic_menu_sort_by_stars_desc : R.drawable.ic_menu_sort_by_stars_asc);
    }

    @Override
    public void showLoading() {
        // TODO : UI/UX e.g progressbar
        refreshLayout.setRefreshing(true);
        showSnackbarWithMessage("Caricamento in corso...");
    }

    @Override
    public void showError() {
        refreshLayout.setRefreshing(false);
        showSnackbarWithMessage("Errore di caricamento, riprova tra poco!");
    }

    @Override
    public void refreshData() {
        refreshLayout.setRefreshing(false);
        showSnackbarWithMessage("Caricamento completo!");

        hotelsAdapter.notifyDataSetChanged();
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
        detailIntent.putExtra(HotelConstants.KEY_HOTEL, hotelsPresenter.hotelAt(position));
        startActivity(detailIntent);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.NONE)
    public void setPresenter(HotelsPresenter hotelsPresenter) {
        this.hotelsPresenter = hotelsPresenter;
    }
}
