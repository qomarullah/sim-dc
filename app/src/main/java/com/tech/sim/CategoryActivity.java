package com.tech.sim;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.tech.sim.adapter.CategoryAdapter;
import com.tech.sim.adapter.ProjectAdapter;
import com.tech.sim.model.Category;
import com.tech.sim.model.CategoryItem;
import com.tech.sim.model.Project;
import com.tech.sim.model.ProjectItem;
import com.tech.sim.network.GetDataService;
import com.tech.sim.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {
    private CategoryAdapter adapter;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeContainer;
    private int id=0;
    private int category_parent_id=0;
    private int category_type=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            id=extras.getInt("PROJECT_ID");
            category_parent_id=extras.getInt("category_parent_id");
            category_type=extras.getInt("category_type");

            // and get whatever type user account id is
        }
        loadData();

        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);

        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();

            }

        });

        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(
                android.R.color.holo_green_light,
                android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

    }
    private void loadData(){
        //progressDoalog = new ProgressDialog(MainActivity.this);
        //progressDoalog.setMessage("Loading....");
        //progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<Category> call = service.getCategory(category_parent_id,category_type);
        call.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                //progressDoalog.dismiss();
                Category jsonResponse = response.body();
                //Log.d("TEST", jsonResponse.getStatus());
                if(jsonResponse.getApi_status().equals(1)) {

                    List<CategoryItem> data = jsonResponse.getData();
                    /*if(BuildConfig.VERSION_CODE < jsonResponse.getVersion()){
                        showDialogUpdate();
                    }else {
                        generateDataList(data);
                    }*/
                    //adapter.clear();
                    swipeContainer.setRefreshing(false);
                    generateDataList(data);

                }else{
                    Toast.makeText(CategoryActivity.this, "Koneksi gangguan...Silakan coba kembali!", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                //progressDoalog.dismiss();
                Toast.makeText(CategoryActivity.this, "Koneksi gangguan...Silakan coba kembali!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<CategoryItem> dataList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CategoryAdapter(this,dataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CategoryActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void showDialogUpdate(){
        // Use the Builder class for convenient dialog construction
        final AlertDialog.Builder builder = new AlertDialog.Builder(CategoryActivity.this);
        builder.setMessage("Ada versi aplikasi yang lebih baru, silakan melanjutkan update di google play store.. ")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                        } catch (android.content.ActivityNotFoundException anfe) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
        // Create the AlertDialog object and return it
        builder.create();
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            //Toast.makeText(MainActivity.this, "Refresh..", Toast.LENGTH_LONG).show();
            loadData();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}