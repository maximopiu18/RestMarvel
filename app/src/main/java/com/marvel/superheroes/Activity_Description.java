package com.marvel.superheroes;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.marvel.superheroes.Constans.Constantes;
import com.squareup.picasso.Picasso;

public class Activity_Description extends Activity {
    ImageView img_heroe;
    TextView tv_name, tv_realName,tv_height, tv_power, tv_abilities, tv_groups;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_description);
        img_heroe = (ImageView)findViewById(R.id.img_heroe_descripcion);
        tv_name = (TextView)findViewById(R.id.tv_name);
        tv_height = (TextView)findViewById(R.id.tv_height);
        tv_realName = (TextView)findViewById(R.id.tv_real_name);
        tv_power = (TextView)findViewById(R.id.tv_power);
        tv_abilities = (TextView)findViewById(R.id.tv_abilities);
        tv_groups = (TextView)findViewById(R.id.tv_groups);

        downloadImage();
    }

    public void downloadImage(){
        Picasso.with(this).load(Constantes.photo.get(Constantes.positionSuperheroe))
                .resize(400,400)
                .centerInside()
                .placeholder(R.drawable.ic_marvel)
                .error(R.drawable.ic_marvel)
                .into(img_heroe);

        tv_name.setText(Constantes.name.get(Constantes.positionSuperheroe));
        tv_realName.setText(Constantes.realName.get(Constantes.positionSuperheroe));
        tv_power.setText(Constantes.power.get(Constantes.positionSuperheroe));
        tv_height.setText(Constantes.heigth.get(Constantes.positionSuperheroe));
        tv_abilities.setText(Constantes.abilities.get(Constantes.positionSuperheroe));
        tv_groups.setText(Constantes.groups.get(Constantes.positionSuperheroe));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
