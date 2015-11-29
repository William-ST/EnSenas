package me.doapps.essenas.database;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import me.doapps.essenas.model.Alphabet;
import me.doapps.essenas.model.Record;
import me.doapps.essenas.model.RecordDetail;

/**
 * Created by William_ST on 29/11/15.
 */
public class DatabaseConfig extends OrmLiteConfigUtil {

    private static final Class<?>[] classes = new Class[]{
            Alphabet.class,
            Record.class,
            RecordDetail.class
    };

    public static void main(String[] args) throws Exception {
        writeConfigFile("ormlite_config.txt", classes);
    }

}
