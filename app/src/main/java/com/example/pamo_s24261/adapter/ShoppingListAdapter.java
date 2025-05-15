package com.example.pamo_s24261.adapter;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pamo_s24261.R;
import com.example.pamo_s24261.model.ShoppingItem;

import java.util.List;

public class ShoppingListAdapter
        extends RecyclerView.Adapter<ShoppingListAdapter.ViewHolder> {

    private final List<ShoppingItem> items;

    public ShoppingListAdapter(List<ShoppingItem> items) {
        this.items = items;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final CheckBox cbBought;
        public final TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cbBought = itemView.findViewById(R.id.cbBought);
            tvName   = itemView.findViewById(R.id.tvItemName);
        }
    }

    @NonNull @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType
    ) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shopping, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position
    ) {
        ShoppingItem item = items.get(position);

        holder.cbBought.setOnCheckedChangeListener(null);

        holder.cbBought.setChecked(item.isBought());
        holder.tvName.setText(item.getName());

        if (item.isBought()) {
            holder.tvName.setPaintFlags(
                    holder.tvName.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG
            );
        } else {
            holder.tvName.setPaintFlags(
                    holder.tvName.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG
            );
        }

        holder.cbBought.setOnCheckedChangeListener((buttonView, isChecked) -> {
            item.setBought(isChecked);

            if (isChecked) {
                holder.tvName.setPaintFlags(
                        holder.tvName.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG
                );
            } else {
                holder.tvName.setPaintFlags(
                        holder.tvName.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG
                );
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
