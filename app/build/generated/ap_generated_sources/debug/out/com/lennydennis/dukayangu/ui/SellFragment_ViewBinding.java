// Generated code from Butter Knife. Do not modify!
package com.lennydennis.dukayangu.ui;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lennydennis.dukayangu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SellFragment_ViewBinding implements Unbinder {
  private SellFragment target;

  @UiThread
  public SellFragment_ViewBinding(SellFragment target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
    target.mErrorTextView = Utils.findRequiredViewAsType(source, R.id.errorTextView, "field 'mErrorTextView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SellFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
    target.mErrorTextView = null;
  }
}
