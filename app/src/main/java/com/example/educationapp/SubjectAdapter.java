package com.example.educationapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SubjectAdapter extends BaseAdapter {
    String[] subjects;
    String[] mathTopics;
    String[] physicsTopics;
    String[] chemistryTopics;
    Integer[] img;
    Context context;

    public SubjectAdapter(Context context, String[] subjects, String[] mathTopics, String[] physicsTopics, String[] chemistryTopics, Integer[] img) {
        this.context = context;
        this.subjects = subjects;
        this.mathTopics = mathTopics;
        this.physicsTopics = physicsTopics;
        this.chemistryTopics = chemistryTopics;
        this.img = img;
    }

    @Override
    public int getCount() {
        return subjects.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_subject, parent, false);
        }

        // Get the views from the layout
        TextView title = convertView.findViewById(R.id.title);
        TextView subtitle1 = convertView.findViewById(R.id.subtitle1);
        TextView subtitle2 = convertView.findViewById(R.id.subtitle2);
        TextView subtitle3 = convertView.findViewById(R.id.subtitle3);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        // Set subject title
        title.setText(subjects[position]);

        // Set topics based on the subject
        switch (subjects[position]) {
            case "Mathematics":
                subtitle1.setText(mathTopics[0]);
                subtitle2.setText(mathTopics[1]);
                subtitle3.setText(mathTopics[2]);
                break;
            case "Physics":
                subtitle1.setText(physicsTopics[0]);
                subtitle2.setText(physicsTopics[1]);
                subtitle3.setText(physicsTopics[2]);
                break;
            case "Chemistry":
                subtitle1.setText(chemistryTopics[0]);
                subtitle2.setText(chemistryTopics[1]);
                subtitle3.setText(chemistryTopics[2]);
                break;
        }

        // Set image resource for the list item
        imageView.setImageResource(img[position]);

        return convertView;
    }
}
