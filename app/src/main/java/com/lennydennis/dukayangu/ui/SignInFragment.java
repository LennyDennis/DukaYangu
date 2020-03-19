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
public class SignInFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.sign_in_email) EditText signInEmail;
    @BindView(R.id.sign_in_password) EditText signInPassword;
    @BindView(R.id.forgot_password) TextView forgotText;
    @BindView(R.id.sign_in_button) Button signInButton;
    @BindView(R.id.register_text) TextView registerText;

    private FirebaseAuth mAuth;

    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container,false);
        ButterKnife.bind(this,view);

        registerText.setOnClickListener(this);
        signInButton.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser() != null){
            goToHomeFragment();
        }

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
         if(v == signInButton){
             signInUser();
         }
         if(v == registerText){
             assert getFragmentManager() != null;
             FragmentTransaction transaction = getFragmentManager().beginTransaction();
             SignUpFragment signUpFragment = new SignUpFragment();

             transaction.replace(R.id.fragment_container, signUpFragment);
             transaction.addToBackStack(null);
             transaction.commit();
         }
    }

    public void signInUser(){
        String email = signInEmail.getText().toString().trim();
        String password = signInPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(getContext(), "Fill the email field",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(getContext(), "Fill the password field", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getActivity(),"Login successful",Toast.LENGTH_SHORT).show();
                                goToHomeFragment();
                            }else {
                                Toast.makeText(getActivity(), "Login unsuccessful", Toast.LENGTH_SHORT).show();
                            }
                        }
                });

    }

    public void goToHomeFragment(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        HomeFragment homeFragment = new HomeFragment();

        transaction.replace(R.id.fragment_container, homeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
