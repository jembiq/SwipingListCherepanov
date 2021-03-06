package com.example.swipelistcherepanov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private static final String HEADER = "header";
    private static final String TEXT = "text";
    private static List<Map<String, String>> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        listView = findViewById(R.id.list_view);
        prepareContent();
        listView.setAdapter(createAdapter(list));
    }

    private void prepareContent() {
        Map<String,String> map = new HashMap<>();
        map.put(HEADER, getString(R.string.text).length()+"");
        map.put(TEXT, getString(R.string.text));
        list.add(map);

        Map<String, String> map1 = new HashMap<>();
        map1.put(HEADER, getString(R.string.text1).length()+"");
        map1.put(TEXT, getString(R.string.text1));
        list.add(map1);

        Map<String, String> map2 = new HashMap<>();
        map2.put(HEADER, getString(R.string.text2).length()+"");
        map2.put(TEXT, getString(R.string.text2));
        list.add(map2);
    }

    private SimpleAdapter createAdapter (List<Map<String, String>> list) {
        return new SimpleAdapter(this
                , list
                , R.layout.views
                , new String[] {HEADER, TEXT}
                , new int[] {R.id.header, R.id.text});
    }
}
