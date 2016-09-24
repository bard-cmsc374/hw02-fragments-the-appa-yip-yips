package edu.bard.todolist_lab1;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by cs374 on 9/24/16.
 */
public class ItemViewFragment extends Fragment {

    private LinearLayout ll; //Layout
    private EditText mEditText; // enter todo item
    private Button mItemButton; // add the item to the list
    private ArrayList<String> mToDoItems; // list of items
    private ArrayAdapter<String> aa; // adapter from list to viewlist

    @Override
    public void onCreate(Bundle stuff) {

        super.onCreate(stuff);

        // Add key listener to add the new todo item
        // when the middle D-pad button is pressed.
        mItemButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mToDoItems.add(0, mEditText.getText().toString());
                aa.notifyDataSetChanged();
                mEditText.setText("");
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle stuff) {
        View v = inflater.inflate(R.layout.main, container, false);
        // Get references to UI widgets
        mEditText = (EditText)v.findViewById(R.id.myEditText);
        mItemButton = (Button)v.findViewById(R.id.addButton);
        return v;

    }
}

