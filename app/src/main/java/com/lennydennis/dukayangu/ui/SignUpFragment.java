package com.lennydennis.dukayangu.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lennydennis.dukayangu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    @BindView(R.id.sign_up_name) EditText signUpName;
    @BindView(R.id.sign_up_email) EditText signUpEmail;
    @BindView(R.id.sign_up_password) EditText signUpPassword;
    @BindView(R.id.sign_up_cPassword) EditText confirmPassword;
    @BindView(R.id.sign_up_gender) RadioGroup signUpGender;
    @BindView(R.id.sign_up_button) Button signUpButton;
    @BindView(R.id.already_registered_text) TextView signInText;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, view);

        signInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                SignInFragment signInFragment = new SignInFragment();

                transaction.replace(R.id.fragment_container, signInFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}
