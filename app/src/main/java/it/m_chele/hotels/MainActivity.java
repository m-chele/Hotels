package it.m_chele.hotels;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity implements HotelsView, HotelListItemClickListener {

    private HotelsPresenter hotelPresenter;
    private RecyclerView hotelsListView;
    private List<Hotel> hotels;
    private HotelsAdapter hotelsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        hotelsListView = findViewById(R.id.hotels_list);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        hotelsListView.setLayoutManager(layoutManager);
        hotelsListView.setHasFixedSize(true);

        hotelPresenter = new HotelsPresenter(this);
        hotelPresenter.loadData();


        // TODO: pensare a UI/UX: rimuovere o usare per filtro
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hotelPresenter.loadData();  // FOR DEBUG ONLY
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hotelPresenter.onDestroy();
    }

    @Override
    public void showLoading() {
        // TODO : UI/UX
        Snackbar.make(findViewById(R.id.fab), "Iniziato caricamento", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void showError(String message) {
        // TODO: UI/UX
        Snackbar.make(findViewById(R.id.fab), message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void updateWith(final List<Hotel> hotelsList) {

        hotels = hotelsList;
        hotelsAdapter = new HotelsAdapter(this, hotels);
        hotelsListView.setAdapter(hotelsAdapter);

        hotelsAdapter.notifyDataSetChanged();

        // TODO: rimuovere
        Snackbar.make(findViewById(R.id.fab), "Cricamento completo", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onHotelItemClick(int position) {
        Log.d("!!!", "onHotelItemClick: HO CLICKATO " + position);
    }
}
