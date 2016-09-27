package edu.bard.todolist_lab1;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.Editable;
import android.text.TextWatcher;
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

    private EditText mEditText; // enter todo item
    private Button mItemButton; // add the item to the list
    public theListener mCallback;

    public interface theListener {
        public void itemToSend(String s);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (theListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement theListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle stuff) {
        View v = inflater.inflate(R.layout.itemfrag, container, false);
        // Get references to UI widgets
        mEditText = (EditText)v.findViewById(R.id.myEditText);
        mItemButton = (Button)v.findViewById(R.id.addButton);
        mItemButton.setEnabled(true);
        mItemButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mCallback.itemToSend(mEditText.getText().toString());
                mEditText.setText("");
            }
        });
        return v;
    }

    @Override
    public void onCreate(Bundle stuff) {

        super.onCreate(stuff);
        }
}
