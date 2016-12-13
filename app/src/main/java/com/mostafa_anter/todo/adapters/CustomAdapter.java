package com.mostafa_anter.todo.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mostafa_anter.todo.R;
import com.mostafa_anter.todo.R2;
import com.mostafa_anter.todo.models.RowItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mostafa_anter on 12/13/16.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private List<RowItem> mDataSet;

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R2.id.title) TextView title;
        @BindView(R2.id.description)TextView description;

        public TextView getTitle() {
            return title;
        }

        public TextView getDescription() {
            return description;
        }

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public CustomAdapter(List<RowItem> dataSet) {
        mDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.to_do_row_item, viewGroup, false);

        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getTitle().setText(mDataSet.get(position).getTitle());
        viewHolder.getDescription().setText(mDataSet.get(position).getDescription());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}

