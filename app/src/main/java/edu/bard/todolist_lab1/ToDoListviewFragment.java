package edu.bard.todolist_lab1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by bsern on 9/20/2016.




 *
 */
public class ToDoListviewFragment extends Fragment{

    private ArrayList<String> mToDoItems; // list of items
    private ArrayAdapter<String> aa; // adapter from list to viewlist
    private ListView mListView;

    @Override
    public void onCreate(Bundle stuff){
        super.onCreate(stuff);
        mToDoItems = new ArrayList<String>();
        aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mToDoItems);
    }

    public void putInList(String newLine) {
        mToDoItems.add(0, newLine.toString());
        aa.notifyDataSetChanged();
        mListView.setAdapter(aa);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle stuff) {
        View v = inflater.inflate(R.layout.listfrag, container, false);
        mListView = (ListView) v.findViewById(R.id.myListView);
        return v;
    }
}
