package com.mostafa_anter.todo.models;

/**
 * Created by mostafa_anter on 12/13/16.
 */

public class RowItem {
    private String title;
    private String description;

    public RowItem() {
    }

    public RowItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescrption(String description) {
        this.description = description;
    }
}
