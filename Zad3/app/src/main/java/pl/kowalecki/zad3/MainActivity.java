package pl.kowalecki.zad3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hopToConstraintLayout(View view){
        Intent intent = new Intent(this, ConstraintLayoutActivity.class);
        startActivity(intent);
    }
    public void hopToFrameLayout(View view){
        Intent intent = new Intent(this, FrameLayoutActivity.class);
        startActivity(intent);
    }
}
