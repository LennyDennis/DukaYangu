// Generated code from Butter Knife. Do not modify!
package com.lennydennis.dukayangu.ui;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lennydennis.dukayangu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FavoritesFragment_ViewBinding implements Unbinder {
  private FavoritesFragment target;

  @UiThread
  public FavoritesFragment_ViewBinding(FavoritesFragment target, View source) {
    this.target = target;

    target.favoritesRecyclerView = Utils.findRequiredViewAsType(source, R.id.favoritesRecyclerView, "field 'favoritesRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FavoritesFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.favoritesRecyclerView = null;
  }
}
