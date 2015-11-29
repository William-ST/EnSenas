package me.doapps.essenas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MenuActivity extends AppCompatActivity {

    LinearLayout linearLayoutOption01, linearLayoutOption02, linearLayoutOption03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        linearLayoutOption01 = (LinearLayout) findViewById(R.id.linear_layout_option01);
        linearLayoutOption02 = (LinearLayout) findViewById(R.id.linear_layout_option02);
        linearLayoutOption03 = (LinearLayout) findViewById(R.id.linear_layout_option03);

        linearLayoutOption01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, TraslateActivity.class));
                finish();
            }
        });


    }
}
