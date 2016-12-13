package com.mostafa_anter.todo.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mostafa_anter.todo.R;
import com.mostafa_anter.todo.R2;
import com.mostafa_anter.todo.activities.MainActivity;
import com.mostafa_anter.todo.models.RowItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mostafa_anter on 12/13/16.
 */

public class AddRowItemDialog extends DialogFragment {
    @BindView(R2.id.titleEditText)EditText title;
    @BindView(R2.id.descriptionEditText)EditText description;

    public AddRowItemDialog(){

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_for_add_new_item, null);
        ButterKnife.bind(this, view);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                        addNewItem();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AddRowItemDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    private void addNewItem() {
        Activity parent = getActivity();
        if (parent instanceof MainActivity) {
            ((MainActivity) parent).addNewItem(new RowItem(title.getText().toString(),
                    description.getText().toString()));
        }
        dismissAllowingStateLoss();
    }


}
