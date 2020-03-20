package com.lennydennis.dukayangu.ui;

import android.os.Bundle;
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

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lennydennis.dukayangu.R;
import com.lennydennis.dukayangu.User;

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
    @BindView(R.id.gender_radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.sign_up_button) Button signUpButton;
    @BindView(R.id.already_registered_text) TextView signInText;
    @BindView(R.id.sign_up_phone)
    EditText signUpPhone;

    RadioButton genderButton;

    private FirebaseAuth mAuth;
    String userId;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth.AuthStateListener authStateListener;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, view);
        int selectedGenderId = radioGroup.getCheckedRadioButtonId();
        genderButton = view.findViewById(selectedGenderId);

        mAuth = FirebaseAuth.getInstance();


        signInText.setOnClickListener(this);
        signUpButton.setOnClickListener(this);

        if(mAuth.getCurrentUser() != null){
            goToHomeFragment();
        }
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
        final String userName = signUpName.getText().toString().trim();
        final String userEmail = signUpEmail.getText().toString().trim();
        String password = signUpPassword.getText().toString().trim();
        String cPassword  = confirmPassword.getText().toString().trim();
        String gender = genderButton.getText().toString().trim();
        final String phoneNumber = signUpPhone.getText().toString().trim();


        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(getContext(),"Enter your name",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(userEmail)) {
            Toast.makeText(getContext(),"Email field is empty",Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(userEmail, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getContext(),"Registration successful",Toast.LENGTH_SHORT).show();
                            firebaseDatabase = FirebaseDatabase.getInstance();
                            databaseReference = firebaseDatabase.getReference();
                            FirebaseUser firebaseUser = mAuth.getCurrentUser();
                            userId = firebaseUser.getUid();
                            User user = new User(userName, userEmail, phoneNumber);
                            databaseReference.child("Users").child(userId).setValue(user);
                            goToLoginFragment();
                        }else{
                            Toast.makeText(getContext(),"Registration unsuccessful",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void goToLoginFragment(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        SignInFragment signInFragment = new SignInFragment();

        transaction.replace(R.id.fragment_container, signInFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void goToHomeFragment(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        HomeFragment homeFragment = new HomeFragment();

        transaction.replace(R.id.fragment_container, homeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
