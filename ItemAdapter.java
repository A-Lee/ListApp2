package com.example.ali.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter
{
    LayoutInflater mInflater;
    String [] items;
    String[] prices;
    String[] desc;

    public ItemAdapter(Context c, String[] items, String[] prices, String[] desc)
    {
        this.items = items;
        this.prices = prices;
        this.desc = desc;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return items.length;
    }

    @Override
    public Object getItem(int position)
    {
        return items[position];
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = mInflater.inflate(R.layout.my_listview_detail, null);
        TextView itemList = (TextView) view.findViewById(R.id.nameTextView);
        TextView descList = (TextView) view.findViewById(R.id.descriptionView);
        TextView priceList = (TextView) view.findViewById(R.id.priceTextView);

        String name = items[position];
        String descs = desc[position];
        String price = prices[position];

        itemList.setText(name);
        descList.setText(descs);
        priceList.setText(price);

        return view;
    }
}
