package com.example.android.inventoryapp1.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.inventoryapp1.data.BooksContract.BooksEntry;

/**
 * Database helper for Inventory app. Manages database creation and version management.
 */
public class BooksDbHelper extends SQLiteOpenHelper {

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "books.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link BooksDbHelper}.
     *
     * @param context of the app
     */
    public BooksDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // Create a String that contains the SQL statement to create the books table
        String SQL_CREATE_BOOKS_TABLE = "CREATE TABLE " + BooksEntry.TABLE_NAME + " (" +
                BooksEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                BooksEntry.COLUMN_BOOKS_NAME + " TEXT NOT NULL ," +
                BooksEntry.COLUMN_BOOKS_AUTHOR + " TEXT NOT NULL ," +
                BooksEntry.COLUMN_BOOKS_PRICE + " INTEGER NOT NULL," +
                BooksEntry.COLUMN_BOOKS_QUANTITY + " INTEGER NOT NULL DEFAULT 0," +
                BooksEntry.COLUMN_BOOKS_SUPPLIER_NAME + " TEXT NOT NULL ," +
                BooksEntry.COLUMN_BOOKS_SUPPLIER_PHONE + " TEXT NOT NULL );";

        // Execute the SQL statement
        sqLiteDatabase.execSQL(SQL_CREATE_BOOKS_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //do nothing for now
    }
}