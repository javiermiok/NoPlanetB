package com.muruzabal.javier.noplanetb.noplanetb;

import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BMain extends AppCompatActivity {

    private SwipeRefreshLayout swipeLayout;
    private LinearLayout llMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llMain = findViewById(R.id.layoutMain);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Snackbar snackbar = Snackbar.make(llMain, "Intentando actualizar datos", Snackbar.LENGTH_LONG);
                snackbar.setAction("Deshacer", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar snackbar1 = Snackbar.make(llMain, "Se han repuesto los datos antiguos!", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });
                snackbar.show();
                swipeLayout.setRefreshing(false);


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itmFavoritoMenu:
                mostrarMensaje(R.string.toast_favorito);
                break;

            case R.id.itmSettingsMenu:
                mostrarMensaje(R.string.toast_settings);
                break;

            case R.id.itmExitMenu:
                System.exit(0);
                break;

            default:

        }

        return true;
    }

    private void mostrarMensaje(int id) {
        Toast t = Toast.makeText(BMain.this, id, Toast.LENGTH_SHORT);
        t.setGravity(Gravity.TOP, 0, 300);
        t.show();
    }
}
