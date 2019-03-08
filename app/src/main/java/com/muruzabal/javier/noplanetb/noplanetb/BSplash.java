package com.muruzabal.javier.noplanetb.noplanetb;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class BSplash extends AppCompatActivity {

    private ImageView ivFondo;
    private ImageView ivLogo;
    private TextView tvNombre;
    private TextView tvLema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bsplash);

        /* 1º Búsqueda de elementos del XML*/
        ivFondo = findViewById(R.id.ivFondoSplash);
        ivLogo = findViewById(R.id.ivLogoSpalsh);
        tvNombre = findViewById(R.id.tvNombreSplash);
        tvLema = findViewById(R.id.tvLemaSplash);

        /* 2º Cargar con glide el fondo del activity*/
        Glide.with(this)
                .load(R.drawable.planetearth)
                .apply(new RequestOptions()
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(ivFondo);

        /* 3º Poner a pantalla completa y quitar el ActionBar*/
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            /*Esconder la AppBar*/
            getSupportActionBar().hide();

        } else {
            View decorView = getWindow().getDecorView();
            // Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            // Remember that you should never show the action bar if the
            // status bar is hidden, so hide that too if necessary.
            /*Esconder la AppBar*/
            getSupportActionBar().hide();
        }



        /*Cargar animaciones*/
        Animation animLogo = AnimationUtils.loadAnimation(this, R.anim.rotat_grow);
        Animation animTexto = AnimationUtils.loadAnimation(this, R.anim.fadein_down);
        ivLogo.startAnimation(animLogo);
        tvNombre.startAnimation(animTexto);
        tvLema.startAnimation(animTexto);

        /*Cambiar de ventana al pasar 3 segundos*/
        openApp(true);
    }

    /**
     * Handler que espera 3 segundos hasta cambiar de activity(a BLogin.class)
     * @param locationPermission
     */
    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(BSplash.this, BLogin.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
