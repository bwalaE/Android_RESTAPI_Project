package com.example.jack.kubratest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

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

public class PostsActivity extends AppCompatActivity {

    RecyclerView rvPostsList;
    PostsRecyclerAdapter postsRecyclerAdapter;
    TextView tvHeader;
    int userid;
    String nameOfPerson;

    List<Post> postList;

    private StringBuilder URL = new StringBuilder("https://jsonplaceholder.typicode.com/posts?userId=");
    // I wonder if there could be an error somehow when resuming the activity where the url isn't set back to the default above,
    // so onCreate runs again and a second number is appended to the url. hasn't happened though and might not ever, so whatever

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        Bundle b = getIntent().getExtras();
        nameOfPerson = "name";
        if (b != null) {
            userid = b.getInt("id");
            nameOfPerson = b.getString("name");
            URL.append(userid); // this works, the line below proves it
            //nameOfPerson = String.valueOf(userid);
        }

        tvHeader = findViewById(R.id.tvPostsHeader);
        tvHeader.setText("Posts by " + nameOfPerson);

        rvPostsList = findViewById(R.id.rvPostList);
        postList = new ArrayList<>();

        extractPosts();
    }

    private void extractPosts() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL.toString(), null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject postObject = response.getJSONObject(i);
                        Post post = new Post();
                        post.setUserID(userid);
                        post.setPostID(i);
                        post.setTitle(postObject.getString("title"));
                        post.setBody(postObject.getString("body"));
                        postList.add(post);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                rvPostsList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                postsRecyclerAdapter = new PostsRecyclerAdapter(getApplicationContext(),postList);
                rvPostsList.setAdapter(postsRecyclerAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(jsonArrayRequest);
    }
}