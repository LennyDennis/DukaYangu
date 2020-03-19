// Generated code from Butter Knife. Do not modify!
package com.lennydennis.dukayangu.ui;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lennydennis.dukayangu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SignInFragment_ViewBinding implements Unbinder {
  private SignInFragment target;

  @UiThread
  public SignInFragment_ViewBinding(SignInFragment target, View source) {
    this.target = target;

    target.signInEmail = Utils.findRequiredViewAsType(source, R.id.sign_in_email, "field 'signInEmail'", EditText.class);
    target.signInPassword = Utils.findRequiredViewAsType(source, R.id.sign_in_password, "field 'signInPassword'", EditText.class);
    target.forgotText = Utils.findRequiredViewAsType(source, R.id.forgot_password, "field 'forgotText'", TextView.class);
    target.signInButton = Utils.findRequiredViewAsType(source, R.id.sign_in_button, "field 'signInButton'", Button.class);
    target.registerText = Utils.findRequiredViewAsType(source, R.id.register_text, "field 'registerText'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SignInFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.signInEmail = null;
    target.signInPassword = null;
    target.forgotText = null;
    target.signInButton = null;
    target.registerText = null;
  }
}
