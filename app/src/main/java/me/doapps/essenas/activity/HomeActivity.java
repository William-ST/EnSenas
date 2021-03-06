package me.doapps.essenas.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.j256.ormlite.stmt.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import me.doapps.essenas.R;
import me.doapps.essenas.adapter.RecordAdapter;
import me.doapps.essenas.database.DatabaseHelper;
import me.doapps.essenas.model.Record;
import me.doapps.essenas.utils.FontUtils;
import me.doapps.essenas.utils.PreferencesUtil;

public class HomeActivity extends AppCompatActivity {

    final String TAG = HomeActivity.class.getSimpleName();
    RecyclerView recyclerView;
    RecordAdapter adapter;
    List<Record> recordList = new ArrayList<>();
    PreferencesUtil preferencesUtil;
    private SeekBar seekBarSpeed;
    private TextView textViewIndex, textViewSpeed, textViewRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = (RecyclerView) findViewById(R.id.recordList);
        seekBarSpeed = (SeekBar) findViewById(R.id.seek_bar_speed);
        textViewIndex = (TextView) findViewById(R.id.text_view_index);
        textViewSpeed = (TextView) findViewById(R.id.text_view_speed);
        textViewRecord = (TextView) findViewById(R.id.text_view_record);

        textViewIndex.setTypeface(FontUtils.getFiraSansMedium(HomeActivity.this));
        textViewSpeed.setTypeface(FontUtils.getFiraSansMedium(HomeActivity.this));
        textViewRecord.setTypeface(FontUtils.getFiraSansMedium(HomeActivity.this));

        preferencesUtil = new PreferencesUtil(HomeActivity.this);

        ((ImageView)findViewById(R.id.imgBack)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        try {
            QueryBuilder<Record, Integer> recordQb = new DatabaseHelper(HomeActivity.this).getRecordDao().queryBuilder();
            recordQb.where().eq("state", true);
            for(Record record : recordQb.query()){
                recordList.add(record);
            }
        } catch(Exception e){
            Log.e(TAG, e.toString());
        }

        adapter = new RecordAdapter(recordList, HomeActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this));

        seekBarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewIndex.setText("("+(progress+1)+")");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarSpeed.setProgress(preferencesUtil.getSpeedConfig());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.e(TAG, "save "+seekBarSpeed.getProgress());
        int tempSpeed = 3000;
        switch (seekBarSpeed.getProgress()){
            case 0:
                tempSpeed = 5000;
                break;
            case 1:
                tempSpeed = 4000;
                break;
            case 2:
                tempSpeed = 3000;
                break;
            case 3:
                tempSpeed = 2000;
                break;
            case 4:
                tempSpeed = 1000;
                break;
        }
        preferencesUtil.setSpeedConfig(tempSpeed);
    }
}
