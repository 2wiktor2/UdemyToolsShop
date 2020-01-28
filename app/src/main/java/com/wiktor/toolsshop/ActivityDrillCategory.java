package com.wiktor.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityDrillCategory extends AppCompatActivity {

    private ListView listViewDrills;

    private ArrayList<Drill> drills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_category);

        listViewDrills = findViewById(R.id.listViewDrills);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        drills = new ArrayList<>();
        drills.add(new Drill(getString(R.string.drill_bosh_title), getString(R.string.drill_bosh_info), R.drawable.imagedrill_1));
        drills.add(new Drill(getString(R.string.drill_deWalt_title), getString(R.string.drill_deWalt_info), R.drawable.imagedrill_2));
        drills.add(new Drill(getString(R.string.drill_festool_title), getString(R.string.drill_festool_info), R.drawable.imagedrill_3));
        drills.add(new Drill(getString(R.string.drill_makita_title), getString(R.string.drill_makita_info), R.drawable.imagedrill_4));
        drills.add(new Drill(getString(R.string.drill_blackAndDecker_title), getString(R.string.drill_blackAndDecker_info), R.drawable.imagedrill_5));
        drills.add(new Drill(getString(R.string.drill_miwaukee_title), getString(R.string.drill_miwaukee_info), R.drawable.imagedrill_6));

        // Создаем адаптер. Для того, что бы наполнить ListView listViewDrills Дрелями(Drill)
        // В качестве параметров нужно передать контекст, шаблон для отображения элементов ListView (собственный или шаблон из андроида()), массив объектов
        ArrayAdapter<Drill> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, drills);
        // Устанавливаем адаптер для ListView
        listViewDrills.setAdapter(adapter);
        // Установка слушателя
        listViewDrills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Drill drill = drills.get(i);
                Intent intent = new Intent(getApplicationContext(), ActivityDrillDetails.class);
                intent.putExtra("title", drill.getTitle());
                intent.putExtra("info", drill.getInfo());
                intent.putExtra("resId", drill.getImageResourceId());
                startActivity(intent);
            }
        });


    }
}
