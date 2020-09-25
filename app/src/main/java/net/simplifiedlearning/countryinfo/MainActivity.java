package net.simplifiedlearning.countryinfo;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

   TextView name,capital,region,subregion,population,borders,flag,languages;
   Button btn_save;
    public static MyDatabase myDatabase;



    final String URL_GET_DATA = "https://restcountries.eu/rest/v2/all";
    RecyclerView recyclerView;
    HeroAdapter adapter;
    List<Hero> heroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabase= Room.databaseBuilder(getApplicationContext(),MyDatabase.class,"infodb").allowMainThreadQueries().build();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        heroList = new ArrayList<>();

        name=(TextView)findViewById(R.id.textViewName);
        capital=(TextView)findViewById(R.id.textViewRealName);
        region=(TextView)findViewById(R.id.textViewTeam);
        subregion=(TextView)findViewById(R.id.textViewFirstAppearance);
        population=(TextView)findViewById(R.id.textViewCreatedBy);
        borders=(TextView)findViewById(R.id.textViewPublisher);
        languages=(TextView)findViewById(R.id.textViewBio);





        loadHeroes();
    }

    private void loadHeroes() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_GET_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject obj = jsonArray.getJSONObject(i);

                                Hero hero = new Hero(
                                        obj.getString("name"),
                                        obj.getString("capital"),
                                        obj.getString("region"),
                                        obj.getString("subregion"),
                                        obj.getString("population"),
                                        obj.getString("borders"),
                                        obj.getString("flag"),
                                        obj.getString("languages")
                                );

                                heroList.add(hero);
                            }

                            adapter = new HeroAdapter(heroList, getApplicationContext());
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}