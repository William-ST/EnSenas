package me.doapps.essenas.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by William_ST on 29/11/15.
 */
@DatabaseTable(tableName = "Record")
public class Record {

    @DatabaseField(generatedId = true)
    private int idRecord;

    @DatabaseField(canBeNull = false)
    private String date;

    @DatabaseField(canBeNull = false)
    private String time;

    @DatabaseField(canBeNull = false)
    private boolean state;

    public Record() {
    }

    public Record(String date, String time, boolean state) {
        this.date = date;
        this.time = time;
        this.state = state;
    }

    public int getIdRecord() {
        return idRecord;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
