package pl.kowalecki.zad5;

import android.app.Activity;
import android.os.Bundle;

public class DetailActivity extends Activity {

    public static final String EXTRA_TASK_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TaskDetailFragment taskDetailFragment = (TaskDetailFragment)
                getFragmentManager().findFragmentById(R.id.detail_frag);
        int taskId = (int) getIntent().getExtras().get(EXTRA_TASK_ID);
        taskDetailFragment.setTask(taskId);
    }
}

