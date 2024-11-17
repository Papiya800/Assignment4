package com.example.educationapp;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.listView);

        // Subject names
        String[] subjects = getResources().getStringArray(R.array.subject_array);

        // Arrays for topics under each subject
        String[] mathTopics = getResources().getStringArray(R.array.math_topics);
        String[] physicsTopics = getResources().getStringArray(R.array.physics_topics);
        String[] chemistryTopics = getResources().getStringArray(R.array.chemistry_topics);

        // Image resources for each subject (placeholder images)
        Integer[] imgId = {
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground
        };

        // Set the adapter for the list view
        SubjectAdapter adapter = new SubjectAdapter(this, subjects, mathTopics, physicsTopics, chemistryTopics, imgId);
        listView.setAdapter(adapter);
    }
}
