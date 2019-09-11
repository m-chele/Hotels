package it.m_chele.hotels;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        showSnackbarWithMessage("Iniziato caricamento");
    }

    @Override
    public void showError(String message) {
        // TODO: UI/UX
        showSnackbarWithMessage("Errore di caricamento, riprova tra poco");
    }

    @Override
    public void updateWith(final Hotels hotels) {

        this.hotelsList = hotels.getHotels();
        hotelsAdapter = new HotelsAdapter(hotels, this);
        hotelsListView.setAdapter(hotelsAdapter);

        hotelsAdapter.notifyDataSetChanged();

        showSnackbarWithMessage("Caricamento completo");
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
