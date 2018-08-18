package com.example.ndambuki.testingexcels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ItemArrayAdapter extends ArrayAdapter<String[]> {
    private List<String[]> scoreList = new ArrayList<String[]>();

    static class ItemViewHolder {
        TextView item_id;
        TextView item_name;
        TextView item_quantity;
        TextView item_price;

    }

    public ItemArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(String[] object) {
        scoreList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.scoreList.size();
    }

    @Override
    public String[] getItem(int index) {
        return this.scoreList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ItemViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.item_layout, parent, false);
            viewHolder = new ItemViewHolder();
            viewHolder.item_id = (TextView) row.findViewById(R.id.id);
            viewHolder.item_name = (TextView) row.findViewById(R.id.name);
            viewHolder.item_quantity = (TextView) row.findViewById(R.id.quantity);
            viewHolder.item_price = (TextView) row.findViewById(R.id.price);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ItemViewHolder)row.getTag();
        }
        String[] stat = getItem(position);
        viewHolder.item_id.setText(stat[0]);
        viewHolder.item_name.setText(stat[1]);
        viewHolder.item_quantity.setText(stat[2]);
        viewHolder.item_price.setText(stat[3]);

        return row;
    }
}
