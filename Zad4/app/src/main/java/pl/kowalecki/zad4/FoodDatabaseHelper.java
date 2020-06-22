package pl.kowalecki.zad4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FoodDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "zad4";
    private static final int DB_VERSION = 2;

    FoodDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){
        if(oldVersion < 1){
            db.execSQL("CREATE TABLE FOOD (_id INTEGER PRIMARY KEY AUTOINCREMENT, "+ "NAME TEXT,"+ "DESCRIPTION TEXT," + "IMAGE_RESOURCE_ID INTEGER);");
            insertFood(db,"Scrambled eggs", "Jajecznica na maśle", R.drawable.scrambled_eggs);
            insertFood(db,"Chicken butter", "Kawałki kurczaka w sosie masala", R.drawable.chicken_butter);

        }
        insertFood(db,"Mushroom  soup", "Zupa z pieczarek", R.drawable.mushroom_soup);
        if (oldVersion < 2){
            db.execSQL("ALTER TABLE FOOD ADD COLUMN FAVORITE NUMERIC;");
        }
        }




    private static void insertFood(SQLiteDatabase db, String name, String description, int resourceId){
        ContentValues foodValues = new ContentValues();
        foodValues.put("NAME", name);
        foodValues.put("DESCRIPTION", description);
        foodValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("FOOD", null, foodValues);
    }
}
