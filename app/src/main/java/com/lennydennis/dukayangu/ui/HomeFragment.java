package com.lennydennis.dukayangu.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.lennydennis.dukayangu.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.NoActionBarTheme);

        LayoutInflater layoutInflater = inflater.cloneInContext(contextThemeWrapper);
        // Inflate the layout for this fragment
        return layoutInflater.inflate(R.layout.fragment_home, container, false);
    }
}
