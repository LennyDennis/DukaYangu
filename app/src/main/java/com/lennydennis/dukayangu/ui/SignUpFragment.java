package com.lennydennis.dukayangu.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.lennydennis.dukayangu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.sign_up_name) EditText signUpName;
    @BindView(R.id.sign_up_email) EditText signUpEmail;
    @BindView(R.id.sign_up_password) EditText signUpPassword;
    @BindView(R.id.sign_up_cPassword) EditText confirmPassword;
    @BindView(R.id.sign_up_gender) RadioGroup signUpGender;
    @BindView(R.id.sign_up_button) Button signUpButton;
    @BindView(R.id.already_registered_text) TextView signInText;

    private FirebaseAuth mAuth;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, view);

        mAuth = FirebaseAuth.getInstance();

        signInText.setOnClickListener(this);
        signUpButton.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.already_registered_text:
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                SignInFragment signInFragment = new SignInFragment();

                transaction.replace(R.id.fragment_container, signInFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case R.id.sign_up_button:
                createNewUser();
        }
    }

    public void createNewUser(){
        String name = signUpName.getText().toString().trim();
        String email = signUpEmail.getText().toString().trim();
        String password = signUpPassword.getText().toString().trim();
        String cPassword  = confirmPassword.getText().toString().trim();
        String gender = signUpGender.toString().trim();

        if(TextUtils.isEmpty(name)){
            Toast.makeText(getContext(),"Enter your name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(email)){
            Toast.makeText(getContext(),"Email field is empty",Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getContext(),"Registration successful",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getContext(),"Registration unsuccessful",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
