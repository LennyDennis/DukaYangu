package com.lennydennis.dukayangu.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lennydennis.dukayangu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {

    @BindView(R.id.sign_in_email) EditText signInEmail;
    @BindView(R.id.sign_in_password) EditText signInPassword;
    @BindView(R.id.forgot_password) TextView forgotText;
    @BindView(R.id.sign_in_button) Button signInButton;
    @BindView(R.id.register_text) TextView registerText;

    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container,false);
        ButterKnife.bind(this,view);

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert getFragmentManager() != null;
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                SignUpFragment signUpFragment = new SignUpFragment();

                transaction.replace(R.id.fragment_container, signUpFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}
