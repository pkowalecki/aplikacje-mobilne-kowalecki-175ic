package pl.kowalecki.zad4;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<Food> listAdapter = new ArrayAdapter<Food>(this,
                android.R.layout.simple_list_item_1,
                Food.foodArray);
        ListView listFood = (ListView) findViewById(R.id.list_food);
        listFood.setAdapter(listAdapter);
    }

}
