// Generated code from Butter Knife. Do not modify!
package com.lennydennis.dukayangu.ui;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lennydennis.dukayangu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SignUpFragment_ViewBinding implements Unbinder {
  private SignUpFragment target;

  @UiThread
  public SignUpFragment_ViewBinding(SignUpFragment target, View source) {
    this.target = target;

    target.signUpName = Utils.findRequiredViewAsType(source, R.id.sign_up_name, "field 'signUpName'", EditText.class);
    target.signUpEmail = Utils.findRequiredViewAsType(source, R.id.sign_up_email, "field 'signUpEmail'", EditText.class);
    target.signUpPassword = Utils.findRequiredViewAsType(source, R.id.sign_up_password, "field 'signUpPassword'", EditText.class);
    target.confirmPassword = Utils.findRequiredViewAsType(source, R.id.sign_up_cPassword, "field 'confirmPassword'", EditText.class);
    target.signUpGender = Utils.findRequiredViewAsType(source, R.id.sign_up_gender, "field 'signUpGender'", RadioGroup.class);
    target.signUpButton = Utils.findRequiredViewAsType(source, R.id.sign_up_button, "field 'signUpButton'", Button.class);
    target.signInText = Utils.findRequiredViewAsType(source, R.id.already_registered_text, "field 'signInText'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SignUpFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.signUpName = null;
    target.signUpEmail = null;
    target.signUpPassword = null;
    target.confirmPassword = null;
    target.signUpGender = null;
    target.signUpButton = null;
    target.signInText = null;
  }
}
