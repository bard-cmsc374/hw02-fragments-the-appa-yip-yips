package edu.bard.todolist_lab1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by bsern on 9/20/2016.
 */
public class ListviewFragmentActivity extends FragmentActivity implements ItemViewFragment.theListener {

    @Override
    public void onCreate(Bundle stuff) {
        super.onCreate(stuff);
        setContentView(R.layout.main);
        FragmentManager fm = getSupportFragmentManager();
        ItemViewFragment itemFrag = (ItemViewFragment) fm.findFragmentById(R.id.fragment_container_item);
        ToDoListviewFragment listFrag = (ToDoListviewFragment) fm.findFragmentById(R.id.fragment_container_list);
        if (itemFrag == null) {
            itemFrag = new ItemViewFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container_item, itemFrag)
                    .commit();
        }
        if (listFrag == null) {
            listFrag = new ToDoListviewFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container_list, listFrag)
                    .commit();
        }
    }

    public void itemToSend(String s) {
        ToDoListviewFragment listFrag = (ToDoListviewFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container_list);
        listFrag.putInList(s);
    }
}
