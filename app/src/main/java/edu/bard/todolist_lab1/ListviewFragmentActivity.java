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


 CMSC 374
 HW #2 Fragments: Feedback

 Names: Ben Sernau and ??

 Rubric
 ----------------------------------------------------------
 40	1. App functions correctly from end user perspective.
 20	2. Fragments are correctly created.
 10	3. Fragments share information on the adapter arraylist.
 5	4. Code is clearly commented.
 20	5. Code is readable and well constructed.

 Score: 95


 ----------------

 Comments

 My comments in your code are marked with XX in a comment.


 1. App functions correctly from end user perspective. YES, resources used, too.

 2. Fragments are correctly created. YES and managed

 3. Fragments share information on the adapter arraylist.

 You allow the activity to call the list's update, which is fine for
 this exercise.

 4. Code is clearly commented.
 You ignore commenting important methods.

 5. Code is readable and well constructed.
 Yes...good throughout.



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
    // XX Document the purpose of this method.
    public void itemToSend(String s) {
        ToDoListviewFragment listFrag = (ToDoListviewFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container_list);
        listFrag.putInList(s);
    }
}
