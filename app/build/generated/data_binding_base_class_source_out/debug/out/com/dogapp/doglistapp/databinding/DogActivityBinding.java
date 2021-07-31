// Generated by view binder compiler. Do not edit!
package com.dogapp.doglistapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.dogapp.doglistapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DogActivityBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RelativeLayout rlNav;

  @NonNull
  public final RecyclerView rvDogs;

  private DogActivityBinding(@NonNull ConstraintLayout rootView, @NonNull RelativeLayout rlNav,
      @NonNull RecyclerView rvDogs) {
    this.rootView = rootView;
    this.rlNav = rlNav;
    this.rvDogs = rvDogs;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DogActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DogActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dog_activity, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DogActivityBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.rlNav;
      RelativeLayout rlNav = rootView.findViewById(id);
      if (rlNav == null) {
        break missingId;
      }

      id = R.id.rvDogs;
      RecyclerView rvDogs = rootView.findViewById(id);
      if (rvDogs == null) {
        break missingId;
      }

      return new DogActivityBinding((ConstraintLayout) rootView, rlNav, rvDogs);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}