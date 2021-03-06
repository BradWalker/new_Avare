package com.ds.avare.content;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by zkhan on 3/13/17.
 */

public class ObstaclesDatabaseHelper extends MainDatabaseHelper {

    private static final String DBNAME = "obs.db";

    public ObstaclesDatabaseHelper(Context context, String folder) {
        super(context, folder, DBNAME, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

}