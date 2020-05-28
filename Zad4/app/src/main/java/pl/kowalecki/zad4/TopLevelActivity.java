package pl.kowalecki.zad4;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.sql.SQLIntegrityConstraintViolationException;

public class TopLevelActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor favoritesCursor;
    private ShareActionProvider shareActionProvider;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Toolbar myToolBar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(myToolBar);

            AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0){
                        Intent foodCategory = new Intent(TopLevelActivity.this, FoodCategoryActivity.class);
                        startActivity(foodCategory);
                    }
                    if(position == 1){
                        Intent info = new Intent(TopLevelActivity.this, InfoActivity.class);
                        startActivity(info);
                    }

                }
            };
            ListView listView = (ListView) findViewById(R.id.list_food);
            listView.setOnItemClickListener(itemClickListener);
            ListView listFavorites = (ListView) findViewById(R.id.list_favorites);
            try{
                SQLiteOpenHelper foodDatabaseHelper = new FoodDatabaseHelper(this);
                db = foodDatabaseHelper.getReadableDatabase();
                favoritesCursor = db.query("FOOD", new String[] {"_id", "NAME"}, "FAVORITE = 1", null, null,null,null);
                CursorAdapter favoriteAdapter = new SimpleCursorAdapter(TopLevelActivity.this, android.R.layout.simple_list_item_1, favoritesCursor,
                        new String[] {"NAME"}, new int[]{android.R.id.text1}, 0);
                listFavorites.setAdapter(favoriteAdapter);
            } catch (SQLiteException e){
                Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
                toast.show();
            }
            listFavorites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> listView, View v, int position, long id) {
                    Intent intent = new Intent(TopLevelActivity.this, FoodActivity.class);
                    intent.putExtra(FoodActivity.EXTRA_FOODNO, (int) id);
                    startActivity(intent);

                }
            });
        }

        @Override
        public void onDestroy(){
            super.onDestroy();
            favoritesCursor.close();
            db.close();

        }

        @Override
        public void onRestart(){
            super.onRestart();
            try{
                FoodDatabaseHelper foodDatabaseHelper = new FoodDatabaseHelper(this);
                db = foodDatabaseHelper.getReadableDatabase();
                Cursor newCursor = db.query("FOOD", new String[]{"_id", "NAME"}, "FAVORITE = 1", null, null, null, null);
                ListView listFavorites= (ListView) findViewById(R.id.list_favorites);
                CursorAdapter adapter = (CursorAdapter) listFavorites.getAdapter();
                adapter.changeCursor(newCursor);
                favoritesCursor = newCursor;
            } catch (SQLiteException e){
                Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
                toast.show();;
            }
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider =
                (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("Wyskoczymy coś zjeść?");
        return super.onCreateOptionsMenu(menu);
    }

    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_order:
                Intent intent = new Intent(this, OrderFood.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    }

