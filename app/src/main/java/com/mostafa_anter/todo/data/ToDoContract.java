package com.mostafa_anter.todo.data;

import android.provider.BaseColumns;

/**
 * Created by mostafa_anter on 12/14/16.
 */

public class ToDoContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private ToDoContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
    }
}
