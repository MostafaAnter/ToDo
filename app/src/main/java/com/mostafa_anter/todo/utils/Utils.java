package com.mostafa_anter.todo.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mostafa_anter.todo.data.ToDoContract.FeedEntry;
import com.mostafa_anter.todo.data.ToDoDbHelper;
import com.mostafa_anter.todo.models.RowItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mostafa_anter on 12/14/16.
 */

public class Utils {

    public static void putRowItemInsideDb(RowItem rowItem, Context mContext) {

        ToDoDbHelper mDbHelper = new ToDoDbHelper(mContext);

        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE, rowItem.getTitle());
        values.put(FeedEntry.COLUMN_NAME_DESCRIPTION, rowItem.getDescription());

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(FeedEntry.TABLE_NAME, null, values);
    }

    public static Cursor getData(Context mContext){
        ToDoDbHelper mDbHelper = new ToDoDbHelper(mContext);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                FeedEntry._ID,
                FeedEntry.COLUMN_NAME_TITLE,
                FeedEntry.COLUMN_NAME_DESCRIPTION
        };


        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                FeedEntry.COLUMN_NAME_DESCRIPTION + " DESC";

        Cursor c = db.query(
                FeedEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return c;
    }

    public static List<RowItem> returnListFromCursor(Cursor cursor){
        List<RowItem> rowItemList = new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                String title = cursor.getString(cursor.getColumnIndex(FeedEntry.COLUMN_NAME_TITLE));
                String description = cursor.getString(cursor.getColumnIndex(FeedEntry.COLUMN_NAME_DESCRIPTION));
                rowItemList.add(new RowItem(title, description));
                // do what ever you want here
            }while(cursor.moveToNext());
        }
        cursor.close();

        return rowItemList;
    }

    public static void deleteItemFromDb(String title, Context mContext){
        ToDoDbHelper mDbHelper = new ToDoDbHelper(mContext);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        // Define 'where' part of query.
        String selection = FeedEntry.COLUMN_NAME_TITLE + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { title };
        // Issue SQL statement.
        db.delete(FeedEntry.TABLE_NAME, selection, selectionArgs);

    }
}
