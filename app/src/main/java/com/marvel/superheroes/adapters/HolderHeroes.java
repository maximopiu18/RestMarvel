package com.marvel.superheroes.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.marvel.superheroes.R;

public class HolderHeroes extends RecyclerView.ViewHolder
        implements View.OnClickListener {

    ImageView ivModelo;
    TextView tvDescripcion;
    OnHolderClickListener onHolderClickListener;
    public HolderHeroes(View itemView) {
        super(itemView);
        ivModelo = (ImageView) itemView.findViewById(R.id.img_heroe);
        tvDescripcion = (TextView) itemView.findViewById(R.id.tv_name);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int posicion = getAdapterPosition();
        try {
            this.onHolderClickListener.onHolderClick(posicion);

        }
        catch (Exception e)
        {
            Log.e("error","error click" +e);
        }
    }

    public void setOnHolderClickListener(OnHolderClickListener onHolderClickListener) {
        this.onHolderClickListener = onHolderClickListener;
    }


}
