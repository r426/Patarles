package lt.kaunascoding.posakiai.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import lt.kaunascoding.posakiai.R;

public class ItemArrayAdapter extends ArrayAdapter<String> {
    public ItemArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final View view;
        final TextView text;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.activity_listview, parent, false);
        } else {
            view = convertView;
        }
        text = view.findViewById(R.id.label);
        text.setText(this.getItem(position));
        return view;

    }
}
