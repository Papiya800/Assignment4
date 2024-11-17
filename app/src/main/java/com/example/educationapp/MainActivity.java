package com.example.educationapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> groupData;
    HashMap<String, List<String>> childData;
    int lastExpandedGroup = -1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.sub);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
            startActivity(intent);
        });

        expandableListView = findViewById(R.id.expandableListView);
        prepareData();

        SubAdapter adapter = new SubAdapter(this, groupData, childData);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnGroupExpandListener(groupPosition -> {
            if (lastExpandedGroup != -1 && lastExpandedGroup != groupPosition) {
                expandableListView.collapseGroup(lastExpandedGroup);
            }
            lastExpandedGroup = groupPosition;
        });

        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            String childText = childData.get(groupData.get(groupPosition)).get(childPosition);
            Toast.makeText(getApplicationContext(), "Selected: " + childText, Toast.LENGTH_SHORT).show();
            return false;
        });
    }

    private void prepareData() {
        groupData = new ArrayList<>();
        childData = new HashMap<>();

        groupData.add("Science");
        groupData.add("Arts");
        groupData.add("Commerce");

        List<String> scienceSubjects = new ArrayList<>();
        scienceSubjects.add("Physics");
        scienceSubjects.add("Chemistry");
        scienceSubjects.add("Biology");

        List<String> artsSubjects = new ArrayList<>();
        artsSubjects.add("History");
        artsSubjects.add("Literature");
        artsSubjects.add("Philosophy");

        List<String> commerceSubjects = new ArrayList<>();
        commerceSubjects.add("Accounting");
        commerceSubjects.add("Business Studies");
        commerceSubjects.add("Economics");

        childData.put(groupData.get(0), scienceSubjects);
        childData.put(groupData.get(1), artsSubjects);
        childData.put(groupData.get(2), commerceSubjects);
    }
}
