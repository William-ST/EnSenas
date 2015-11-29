package me.doapps.essenas.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by William_ST on 29/11/15.
 */
@DatabaseTable(tableName = "RecordDetail")
public class RecordDetail {

    @DatabaseField(generatedId = true)
    private int idRecordDetail;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, maxForeignAutoRefreshLevel = 3)
    private Record record;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, maxForeignAutoRefreshLevel = 3)
    private Alphabet alphabet;

    @DatabaseField(canBeNull = false)
    private boolean state;

    public RecordDetail() {
    }

    public RecordDetail(Record record, Alphabet alphabet, boolean state) {
        this.record = record;
        this.alphabet = alphabet;
        this.state = state;
    }

    public int getIdRecordDetail() {
        return idRecordDetail;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public Alphabet getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
