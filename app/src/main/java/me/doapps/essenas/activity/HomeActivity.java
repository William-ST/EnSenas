package me.doapps.essenas.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.j256.ormlite.stmt.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import me.doapps.essenas.R;
import me.doapps.essenas.adapter.RecordAdapter;
import me.doapps.essenas.database.DatabaseHelper;
import me.doapps.essenas.model.Record;

public class HomeActivity extends AppCompatActivity {

    final String TAG = HomeActivity.class.getSimpleName();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layout_manager;
    RecordAdapter adapter;
    List<Record> recordList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = (RecyclerView) findViewById(R.id.recordList);
        layout_manager = new LinearLayoutManager(HomeActivity.this);

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
        recyclerView.setLayoutManager(layout_manager);
    }
}
