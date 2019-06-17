package com.marvel.superheroes;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.marvel.superheroes.Constans.Constantes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {
    private ProgressDialog progressDialog;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        RestSuperHeroes();
    }
    public void RestSuperHeroes() {

        JSONObject js = new JSONObject();
        try {
            js.put("nameSuperheroe","");
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, Constantes.URL_HEROES, js,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("RESPONSE","RESPONSE: "+ response.toString());

                        try{
                                JSONArray superheroes = response.getJSONArray("superheroes");
                                for (int i = 0; i < superheroes.length(); i++) {
                                    JSONObject object = superheroes.getJSONObject(i);
                                    String sname =object.getString("name");
                                    String sphoto =object.getString("photo");
                                    String srealName =object.getString("realName");
                                    String sheight =object.getString("height");
                                    String spower =object.getString("power");
                                    String sabilities =object.getString("abilities");
                                    String sgroups =object.getString("groups");

                                    Constantes.name.add(sname);
                                    Constantes.photo.add(sphoto);
                                    Constantes.realName.add(srealName);
                                    Constantes.heigth.add(sheight);
                                    Constantes.power.add(spower);
                                    Constantes.abilities.add(sabilities);
                                    Constantes.groups.add(sgroups);
                                }
                                if(progressDialog.isShowing())
                                {
                                    progressDialog.dismiss();
                                    Intent intent = new Intent(MainActivity.this, Activity_Heroes.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                            catch (JSONException e1) {
                            e1.printStackTrace();
                            Log.e("error ", "error: " + e1);
                            if(progressDialog.isShowing())
                            {
                                progressDialog.dismiss();
                            }
                        }


                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", "Error" + error);
          /*      if(progressDialog.isShowing()) {
                    progressDialog.dismiss();
                    AlertDialog_ErrorServer();
                }*/
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        requestQueue.add(jsonObjReq);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Cargando Super Heroes");
        progressDialog.setMessage("Espera un Momento...");
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
