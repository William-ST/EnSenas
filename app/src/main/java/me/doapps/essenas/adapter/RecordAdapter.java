package me.doapps.essenas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import me.doapps.essenas.R;
import me.doapps.essenas.model.Record;

/**
 * Created by William_ST on 29/11/15.
 */
public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.CardsViewHolder> {

    private final String TAG = RecordAdapter.class.getSimpleName();
    private Context context;

    private List<Record> recordList;

    public RecordAdapter(List<Record> recordList, Context context) {
        this.recordList = recordList;
        this.context = context;
    }

    @Override
    public RecordAdapter.CardsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_record, parent, false);
        return new CardsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CardsViewHolder holder, final int position) {
        try {
            holder.textViewDate.setText(recordList.get(position).getDate());
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }

    public static class CardsViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewDate;

        public CardsViewHolder(View v) {
            super(v);
            textViewDate = (TextView) itemView.findViewById(R.id.text_view_date);
        }

    }

}