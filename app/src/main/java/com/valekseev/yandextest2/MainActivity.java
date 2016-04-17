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
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ArrayList<HashMap<String, Object>> mCatList;
    private static final String TITLE = "catname"; // Верхний текст
    private static final String DESCRIPTION = "description"; // ниже главного
    private static final String ICON = "icon";  // будущая картинка

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
      //  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item, catnames);

        // создаем массив списков
        mCatList = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> hm;

        hm = new HashMap<>();
        hm.put(TITLE, "Рыжик"); // Название
        hm.put(DESCRIPTION, "Рыжий и хитрый"); // Описание
        hm.put(ICON, R.drawable.common_google_signin_btn_icon_light); // Картинка
        mCatList.add(hm);

        hm = new HashMap<>();
        hm.put(TITLE, "Васька");
        hm.put(DESCRIPTION, "Слушает да ест");
        hm.put(ICON, R.drawable.common_plus_signin_btn_icon_light_pressed);
        mCatList.add(hm);

        hm = new HashMap<>();
        hm.put(TITLE, "Мурзик");
        hm.put(DESCRIPTION, "Спит и мурлыкает");
        hm.put(ICON, R.drawable.ic_cast_on_1_light);
        mCatList.add(hm);

        hm = new HashMap<>();
        hm.put(TITLE, "Барсик");
        hm.put(DESCRIPTION, "Болеет за Барселону");
        hm.put(ICON, R.drawable.common_plus_signin_btn_icon_light_focused);
        mCatList.add(hm);

        SimpleAdapter adapter = new SimpleAdapter(this, mCatList,
                R.layout.list_item, new String[]{TITLE, DESCRIPTION, ICON},
                new int[]{R.id.text1, R.id.text2, R.id.img});


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
