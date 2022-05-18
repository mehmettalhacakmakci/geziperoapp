package com.example.gezipero;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class ThirdFragment extends Fragment {
    private ConstraintLayout searchTurName;
    private TextView searchWordTur;
    private Button buttonTurAra;
    private RecyclerView rvTurAna;
    private ArrayList<Turlar> turlarListe;
    private TurlarAdapter adapter;
    private RecyclerView rvTurAnaG;
    private ArrayList<Turlar> turlarListeG;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        searchWordTur = view.findViewById(R.id.searchWordTur);
        String search = (String) searchWordTur.getText();

        searchTurName = view.findViewById(R.id.searchTurName);
        searchTurName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        getContext(),R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getContext())
                        .inflate(
                                R.layout.layout_bottom_sheet,
                                (LinearLayout)view.findViewById(R.id.bottomSheetContainer)
                        );
                bottomSheetView.findViewById(R.id.searchTurName).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(),"share...",Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();

            }
        });

        buttonTurAra = view.findViewById(R.id.buttonTurAra);
        buttonTurAra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),TurlarPageActivity.class);
                intent.putExtra("arama",search);
                startActivity(intent);
            }
        });

        //tur arama sayfasında kültür turlarını listelenen yer
        rvTurAna = view.findViewById(R.id.rvTurAna);

        rvTurAna.setHasFixedSize(true);
        rvTurAna.setLayoutManager(new LinearLayoutManager(getContext()));
        turlarListe = new ArrayList<>();

        Turlar k1 = new Turlar(1,"Kapadokya Turu","400 TL");
        Turlar k2 = new Turlar(2,"Gap Turu","1750 TL");
        Turlar k3 = new Turlar(3,"Adalar Turu","1250 TL");

        turlarListe.add(k1);
        turlarListe.add(k2);
        turlarListe.add(k3);

        adapter = new TurlarAdapter(getContext(),turlarListe);

        rvTurAna.setAdapter(adapter);

        //tur arama sayfasında günibirlik turlarını listelenen yer
        rvTurAnaG = view.findViewById(R.id.rvTurAnaG);

        rvTurAnaG.setHasFixedSize(true);
        rvTurAnaG.setLayoutManager(new LinearLayoutManager(getContext()));
        turlarListeG = new ArrayList<>();

        Turlar t1 = new Turlar(1,"Kapadokyaaa Turu","400 TL");
        Turlar t2 = new Turlar(2,"Gap Turasu","1750 TL");
        Turlar t3 = new Turlar(3,"Adalaaar Turu","1050 TL");

        turlarListeG.add(k1);
        turlarListeG.add(k2);
        turlarListeG.add(k3);

        adapter = new TurlarAdapter(getContext(),turlarListeG);

        rvTurAnaG.setAdapter(adapter);

        return view;
    }



}