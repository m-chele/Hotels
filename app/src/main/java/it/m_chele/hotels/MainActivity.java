package it.m_chele.hotels;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity implements HotelsView {

    private HotelsPresenter hotelPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        hotelPresenter = new HotelsPresenter(this);
        hotelPresenter.loadData();


        // TODO: pensare a UI/UX
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
        // TODO : implementare
        Snackbar.make(findViewById(R.id.fab), "Iniziato caricamento", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void showError() {
        // TODO : implementare
        Snackbar.make(findViewById(R.id.fab), "Errore bla bla", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }

    @Override
    public void updateWith(List<Hotel> hotelsList) {
        // TODO : implementare
        Snackbar.make(findViewById(R.id.fab), "Aggiornato bla bla", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }
}
