// Generated code from Butter Knife. Do not modify!
package com.lennydennis.dukayangu.ui;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lennydennis.dukayangu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AccountFragment_ViewBinding implements Unbinder {
  private AccountFragment target;

  @UiThread
  public AccountFragment_ViewBinding(AccountFragment target, View source) {
    this.target = target;

    target.userName = Utils.findRequiredViewAsType(source, R.id.userName, "field 'userName'", TextView.class);
    target.userEmail = Utils.findRequiredViewAsType(source, R.id.userEmail, "field 'userEmail'", TextView.class);
    target.userPhone = Utils.findRequiredViewAsType(source, R.id.userPhone, "field 'userPhone'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AccountFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.userName = null;
    target.userEmail = null;
    target.userPhone = null;
  }
}
