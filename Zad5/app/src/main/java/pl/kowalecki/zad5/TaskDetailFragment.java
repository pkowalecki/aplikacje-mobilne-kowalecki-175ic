package pl.kowalecki.zad5;

import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.sql.Time;


public class TaskDetailFragment extends Fragment {

    private long taskId;


    public TaskDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(savedInstanceState != null){
            taskId = savedInstanceState.getLong("taskId");
        }else {
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            TimeFragment timeFragment = new TimeFragment();
            ft.replace(R.id.time_container, timeFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();}
            return inflater.inflate(R.layout.fragment_task_detail, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null){
            TextView title = (TextView) view.findViewById(R.id.textTittle);
            Task task = Task.tasks [(int) taskId];
            title.setText(task.getSubjectName());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(task.getSubjectToDo());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
       savedInstanceState.putLong("taskId", taskId);
    }

    public void setTask(long taskId) {
        this.taskId = taskId;
    }

}
