package me.doapps.essenas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import me.doapps.essenas.R;

public class MenuActivity extends AppCompatActivity {
    LinearLayout linearLayoutOption01, linearLayoutOption02, linearLayoutOption03;
    public static String TYPE = "type";
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        intent = new Intent(MenuActivity.this, TraslateActivity.class);

        linearLayoutOption01 = (LinearLayout) findViewById(R.id.linear_layout_option01);
        linearLayoutOption02 = (LinearLayout) findViewById(R.id.linear_layout_option02);
        linearLayoutOption03 = (LinearLayout) findViewById(R.id.linear_layout_option03);

        linearLayoutOption01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(TYPE, 1);
                startActivity(intent);
            }
        });
        linearLayoutOption02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra(TYPE, 2);
                startActivity(intent);
            }
        });


    }
}
