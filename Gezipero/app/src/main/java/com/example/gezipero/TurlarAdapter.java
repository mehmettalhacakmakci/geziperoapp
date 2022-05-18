package com.example.gezipero;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TurlarAdapter extends RecyclerView.Adapter<TurlarAdapter.CardTasarimTutucu> {

    private Context mContext;
    private List<Turlar> kelimelersListe;

    public TurlarAdapter(Context mContext, List<Turlar> kelimelersListe) {
        this.mContext = mContext;
        this.kelimelersListe = kelimelersListe;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim,parent,false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Turlar kelime = kelimelersListe.get(position);
        holder.textViewIngilizce.setText(kelime.getIngilizce());
        holder.textViewTurkce.setText(kelime.getTurkce());

        holder.kelimeKard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext,TurDetayActivity.class);
                intent.putExtra("nesne",kelime);
                mContext.startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return kelimelersListe.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private TextView textViewIngilizce;
        private TextView textViewTurkce;
        private CardView kelimeKard;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            textViewIngilizce = itemView.findViewById(R.id.textViewTurAdi);
            textViewTurkce = itemView.findViewById(R.id.textViewTurFiyat);
            kelimeKard = itemView.findViewById(R.id.turKard);
        }
    }

}
