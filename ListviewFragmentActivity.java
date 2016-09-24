package edu.bard.todolist_lab1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by bsern on 9/20/2016.
 */
public class ListviewFragmentActivity extends FragmentActivity{

    @Override
    public void onCreate(Bundle stuff) {
        super.onCreate(stuff);
        setContentView(R.layout.main);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.myListView);
        Fragment fragmentOther = fm.findFragmentById(R.id.textView);
        if (fragment == null) {
            fragment = new ToDoListviewFragment();
            fm.beginTransaction()
                    .add(R.id.myListView, fragment)
                    .commit();
        }
        if (fragmentOther == null) {
            fragmentOther == new ItemView();
            fm.beginTransaction();
                .add(R.id.textView, fragmentOther);
                .commit;
        }

    }
}
