package com.nkhatho.leole.doggyparlour;


import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DogListFragment extends ListFragment {

    private onDogClickedListener dogListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public DogListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dogListener.onDogSelected(0);
    }

    public interface onDogClickedListener
    {
        void onDogSelected(int index);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DogListAdapter dogAdapter = new DogListAdapter(this.getContext(), DogApplicationClass.list);
        setListAdapter(dogAdapter);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{

            dogListener = (onDogClickedListener) context;

        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "Must implement onDogClickedListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        dogListener.onDogSelected(position);
    }
}
