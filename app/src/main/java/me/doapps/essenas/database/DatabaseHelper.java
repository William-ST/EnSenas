package me.doapps.essenas.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import me.doapps.essenas.R;
import me.doapps.essenas.model.Alphabet;
import me.doapps.essenas.model.Record;
import me.doapps.essenas.model.RecordDetail;

/**
 * Created by William_ST on 29/11/15.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    Context context;
    private static final String DATABASE_NAME = "EnSenas.db";
    private static final int DATABASE_VERSION = 1;
    private final String TAG = DatabaseHelper.class.getSimpleName();

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    private Dao<Alphabet, Integer> alphabetDao = null;
    private Dao<Record, Integer> recordDao = null;
    private Dao<RecordDetail, Integer> recordDetailDao = null;

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource source) {
        try {
            TableUtils.createTable(source, Alphabet.class);
            TableUtils.createTable(source, Record.class);
            TableUtils.createTable(source, RecordDetail.class);

            getRecordDao().create(new Record("10/10 10:10", "10:10", true));

            getAlphabetDao().create(new Alphabet("a", R.mipmap.a, true));
            getAlphabetDao().create(new Alphabet("b", R.mipmap.b, true));
            getAlphabetDao().create(new Alphabet("c", R.mipmap.c, true));
            getAlphabetDao().create(new Alphabet("d", R.mipmap.d, true));
            getAlphabetDao().create(new Alphabet("e", R.mipmap.e, true));
            getAlphabetDao().create(new Alphabet("f", R.mipmap.f, true));
            getAlphabetDao().create(new Alphabet("g", R.mipmap.g, true));
            getAlphabetDao().create(new Alphabet("h", R.mipmap.h, true));
            getAlphabetDao().create(new Alphabet("i", R.mipmap.i, true));
            getAlphabetDao().create(new Alphabet("j", R.mipmap.j, true));
            getAlphabetDao().create(new Alphabet("k", R.mipmap.k, true));
            getAlphabetDao().create(new Alphabet("l", R.mipmap.l, true));
            getAlphabetDao().create(new Alphabet("m", R.mipmap.m, true));
            getAlphabetDao().create(new Alphabet("n", R.mipmap.n, true));
            getAlphabetDao().create(new Alphabet("ñ", R.mipmap.enie, true));
            getAlphabetDao().create(new Alphabet("o", R.mipmap.o, true));
            getAlphabetDao().create(new Alphabet("p", R.mipmap.p, true));
            getAlphabetDao().create(new Alphabet("q", R.mipmap.q, true));
            getAlphabetDao().create(new Alphabet("r", R.mipmap.r, true));
            getAlphabetDao().create(new Alphabet("s", R.mipmap.s, true));
            getAlphabetDao().create(new Alphabet("t", R.mipmap.t, true));
            getAlphabetDao().create(new Alphabet("u", R.mipmap.u, true));
            getAlphabetDao().create(new Alphabet("v", R.mipmap.v, true));
            getAlphabetDao().create(new Alphabet("x", R.mipmap.x, true));
            getAlphabetDao().create(new Alphabet("y", R.mipmap.y, true));
            getAlphabetDao().create(new Alphabet("z", R.mipmap.z, true));
        } catch(SQLException e){
            Log.e(TAG, "onCreate "+e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource source, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(source, Alphabet.class, true);
            TableUtils.dropTable(source, Record.class, true);
            TableUtils.dropTable(source, RecordDetail.class, true);
            onCreate(db, source);
        } catch(SQLException e){
            Log.e(TAG, "onUpgrade "+e.toString());
        }
    }

    public Dao<Alphabet, Integer> getAlphabetDao() throws SQLException{
        if(alphabetDao == null) alphabetDao = getDao(Alphabet.class);
        return alphabetDao;
    }

    public Dao<Record, Integer> getRecordDao() throws SQLException{
        if(recordDao == null) recordDao = getDao(Record.class);
        return recordDao;
    }

    public Dao<RecordDetail, Integer> getRecordDetailDao() throws SQLException{
        if(recordDetailDao == null) recordDetailDao = getDao(RecordDetail.class);
        return recordDetailDao;
    }

}
