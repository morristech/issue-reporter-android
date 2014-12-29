package com.cookpad.android.issuereporter.sample.adapters;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cookpad.android.issuereporter.sample.R;
import com.cookpad.android.issuereporter.sample.activities.DetailActivity;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public ListAdapter(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return ItemViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ((ItemViewHolder) viewHolder).bind(position);
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private View itemView;

        public static ItemViewHolder create(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new ItemViewHolder(view);
        }

        public ItemViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public void bind(final int position) {
            TextView titleTextView = (TextView) itemView.findViewById(R.id.title_text);
            titleTextView.setText("list item " + position);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DetailActivity.launch(itemView.getContext(), position);
                }
            });
        }
    }
}
