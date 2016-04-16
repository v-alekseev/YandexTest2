package com.valekseev.yandextest2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // получаем экземпляр элемента ListView
        ListView listView = (ListView)findViewById(R.id.listView);

// определяем массив типа String
        final String[] catnames = new String[] {
                "Рыжик", "Барсик", "Мурзик", "Мурка", "Васька",
                "Томасина", "Кристина", "Пушок", "Дымка", "Кузя",
                "Китти", "Масяня", "Симба"
        };

// используем адаптер данных
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item, catnames);

        listView.setAdapter(adapter);

// ListView Onclick event
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {


                // show detailed Activity
                Intent intent = new Intent(MainActivity.this, ArtistInfoActivity.class);
                intent.putExtra("PersonID", 123);
                startActivity(intent);


                // show message
                Toast.makeText(getApplicationContext(), ((TextView) itemClicked).getText(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}
