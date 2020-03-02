package com.lennydennis.dukayangu;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.username)
    EditText userName;
    @BindView(R.id.loginButton)
    Button loginButton;

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yourUserName = userName.getText().toString();

                Toast.makeText(getActivity(), "Welcome "+yourUserName, Toast.LENGTH_LONG).show();

                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                AccountFragment accountFragment = new AccountFragment();

                Bundle bundle= new Bundle();
                bundle.putString("username",yourUserName);
                accountFragment.setArguments(bundle);

                transaction.replace(R.id.homeFragment, accountFragment);
                transaction.commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}
