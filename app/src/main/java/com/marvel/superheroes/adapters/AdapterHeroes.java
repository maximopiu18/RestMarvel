package com.marvel.superheroes.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marvel.superheroes.Activity_Description;
import com.marvel.superheroes.Constans.Constantes;
import com.marvel.superheroes.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class AdapterHeroes extends RecyclerView.Adapter<HolderHeroes> {
    private Context context;
    private List<String> modeloList;

    public AdapterHeroes(List<String> modeloList, Context context) {

        this.context = context;
        this.modeloList = modeloList;
    }

    @Override
    public HolderHeroes onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_modelos, parent, false);

        return new HolderHeroes(view);
    }

    @Override
    public void onBindViewHolder(final HolderHeroes holder, final int position) {


        holder.tvDescripcion.setText(Constantes.name.get(position));
       // Log.e("TAG: ", "imgUrl :" + modelo.getDescripcion());
        Picasso.with(context).load(Constantes.photo.get(position))
                .resize(200,300)
                .centerInside()
                .placeholder(R.drawable.ic_marvel)
                .error(R.drawable.ic_marvel)
                .into(holder.ivModelo);



        holder.ivModelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Constantes.IDMODELO = idModelo;
                Constantes.MODELO = Modelo;
                Constantes.IMAGENURL = imagenUrl;
                BitmapDrawable drawable = (BitmapDrawable) holder.ivModelo.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                Constantes.BITMAPIMAGEN = bitmap;

                Log.e("id modelo", Constantes.IDMODELO);
                Log.e("modelo", Constantes.MODELO);
*/

                Log.e("position", "position: " + position);
                Constantes.positionSuperheroe = position;
                Intent intent = new Intent(context, Activity_Description.class);
                context.startActivity(intent);
                //((Activity) context).setResult(RESULT_OK);
                //((Activity) context).finish();
              //  ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }
    @Override
    public int getItemCount() {
        return modeloList.size(); }


}

