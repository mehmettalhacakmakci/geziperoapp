package com.example.gezipero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class TurDetayActivity extends AppCompatActivity {
    private ImageView btnBack;
    private TextView textViewImgilizceDetay,textViewTurkceDetay,textViewTurAdi;
    private Turlar tur;

    SliderView sliderView;
    int[] images = {R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tur_detay);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        textViewImgilizceDetay = findViewById(R.id.textViewTurAd);
        textViewTurAdi = findViewById(R.id.turName);
        textViewTurkceDetay = findViewById(R.id.textViewTurFiyat);

        tur = (Turlar) getIntent().getSerializableExtra("nesne");

        textViewTurAdi.setText(tur.getIngilizce());
        textViewTurkceDetay.setText(tur.getTurkce());

        sliderView = findViewById(R.id.image_slider);

        SliderAdapter sliderAdapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();



    }
}