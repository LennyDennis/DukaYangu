package com.lennydennis.dukayangu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountFragment extends Fragment {

    @BindView(R.id.accountName) TextView accountName;
    @BindView(R.id.accountName1) TextView accountName1;
    @BindView(R.id.accountEmail) TextView accountEmail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        accountName.setText(String.valueOf(bundle.getString("username")));
        accountName1.setText(String.valueOf(bundle.getString("username")));
        accountEmail.setText(String.valueOf(bundle.getString("username"))+"@gmail.com");
        // Inflate the layout for this fragment
        return view;
    }
}
