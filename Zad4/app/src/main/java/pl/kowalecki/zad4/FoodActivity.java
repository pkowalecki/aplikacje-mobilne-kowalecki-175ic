package pl.kowalecki.zad4;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FoodActivity extends AppCompatActivity {

    public static final String EXTRA_FOODNO = "foodNo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        Toolbar myToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolBar);


        int foodNo = (Integer) getIntent().getExtras().get(EXTRA_FOODNO);
        try{
            SQLiteOpenHelper foodDatabaseHelper = new FoodDatabaseHelper(this);
            SQLiteDatabase db = foodDatabaseHelper.getWritableDatabase();
            Cursor cursor = db.query("FOOD", new String[] {"NAME", "DESCRIPTION","IMAGE_RESOURCE_ID", "FAVORITE"},
                    "_id = ?", new String[] {Integer.toString(foodNo)}, null, null, null);
            if(cursor.moveToFirst()){
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);
                boolean isFavorite = (cursor.getInt(3) == 1);

                TextView name = (TextView) findViewById(R.id.name);
                name.setText(nameText);

                TextView description = (TextView) findViewById(R.id.description);
                description.setText(descriptionText);

                ImageView photo = (ImageView) findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);

                CheckBox favorite = (CheckBox) findViewById(R.id.favorite);
                favorite.setChecked(isFavorite);
            };
            cursor.close();
            db.close();
        } catch(SQLiteException e){
            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
            toast.show();
        }
        //Food food = Food.foodArray[foodNo];
    }

    public void onFavoriteClicked(View view){
        int foodNo = (Integer) getIntent().getExtras().get(EXTRA_FOODNO);
        CheckBox favorite = (CheckBox)findViewById(R.id.favorite);

        ContentValues foodValues = new ContentValues();

        foodValues.put("FAVORITE", favorite.isChecked());

        SQLiteOpenHelper foodDatabaseHelper = new FoodDatabaseHelper(FoodActivity.this);
        try{
            SQLiteDatabase db = foodDatabaseHelper.getWritableDatabase();
            db.update("FOOD", foodValues, "_id = ?", new String[] {Integer.toString(foodNo)});
            db.close();
        }catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "Baza danych jest niedostepna", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
