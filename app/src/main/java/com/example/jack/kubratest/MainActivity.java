package com.example.jack.kubratest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvList;
    RecyclerAdapter recyclerAdapter;

    String dummyNames[] = {"Blorut", "Hank", "Marly"};
    String dummyAddresses[] = {"123 Cool St.", "Nowhere Lane", "723 Lolongo Road"};

    private static String URL = "https://jsonplaceholder.typicode.com/users";

    List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvList = findViewById(R.id.rvList);
        personList = new ArrayList<>();

        extractUsers();
    }

    private void extractUsers() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject personObject = response.getJSONObject(i);
                        Person person = new Person();
                        Address address = new Address();
                        person.setName(personObject.getString("name").toString());
                        //person.getAddress().setStreet(personObject.getJSONObject("address").getString("street").toString());
                        //person.getAddress().setSuite(personObject.getJSONObject("address").getString("suite").toString());
                        //person.getAddress().setCity(personObject.getJSONObject("address").getString("city").toString());
                        address.setStreet(personObject.getJSONObject("address").getString("street").toString());
                        address.setSuite(personObject.getJSONObject("address").getString("suite").toString());
                        address.setCity(personObject.getJSONObject("address").getString("city").toString());
                        person.setAddress(address);
                        personList.add(person);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                rvList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerAdapter = new RecyclerAdapter(getApplicationContext(),personList);
                rvList.setAdapter(recyclerAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(jsonArrayRequest);
    }


}