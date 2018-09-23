package com.tech.sim;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    LinearLayout survey,observation;
    private int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id=extras.getInt("PROJECT_ID");
            // and get whatever type user account id is
        }
        survey = (LinearLayout)findViewById(R.id.survey);
        observation = (LinearLayout)findViewById(R.id.observation);


        survey.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MenuActivity.this, "Get ID "+id, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MenuActivity.this, CategoryActivity.class);
                intent.putExtra("PROJECT_ID", id);
                intent.putExtra("category_parent_id", 0);
                intent.putExtra("category_type", 1);
                startActivity(intent);
            }
        });
        observation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MenuActivity.this, "Get ID "+id, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MenuActivity.this, CategoryActivity.class);
                intent.putExtra("PROJECT_ID", id);
                intent.putExtra("category_parent_id", 0);
                intent.putExtra("category_type", 2);

                startActivity(intent);
            }
        });
    }
}
