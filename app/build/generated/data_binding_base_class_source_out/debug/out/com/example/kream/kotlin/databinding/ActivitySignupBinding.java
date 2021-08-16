// Generated by view binder compiler. Do not edit!
package com.example.kream.kotlin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.kream.kotlin.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySignupBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView agreement1;

  @NonNull
  public final TextView agreement2;

  @NonNull
  public final ImageButton backBtn;

  @NonNull
  public final AppCompatCheckBox checkBox1;

  @NonNull
  public final AppCompatCheckBox checkBox2;

  @NonNull
  public final TextView email;

  @NonNull
  public final AppCompatToggleButton loginPasswordToggle;

  @NonNull
  public final TextView password;

  @NonNull
  public final FrameLayout passwordLayout;

  @NonNull
  public final EditText signUpEtEmail;

  @NonNull
  public final EditText signUpEtPassword;

  @NonNull
  public final FrameLayout signUpSneakersSize;

  @NonNull
  public final Button signupButton;

  @NonNull
  public final TextView sneakersSize;

  @NonNull
  public final TextView wrongEmail;

  @NonNull
  public final TextView wrongPassword;

  private ActivitySignupBinding(@NonNull ConstraintLayout rootView, @NonNull TextView agreement1,
      @NonNull TextView agreement2, @NonNull ImageButton backBtn,
      @NonNull AppCompatCheckBox checkBox1, @NonNull AppCompatCheckBox checkBox2,
      @NonNull TextView email, @NonNull AppCompatToggleButton loginPasswordToggle,
      @NonNull TextView password, @NonNull FrameLayout passwordLayout,
      @NonNull EditText signUpEtEmail, @NonNull EditText signUpEtPassword,
      @NonNull FrameLayout signUpSneakersSize, @NonNull Button signupButton,
      @NonNull TextView sneakersSize, @NonNull TextView wrongEmail,
      @NonNull TextView wrongPassword) {
    this.rootView = rootView;
    this.agreement1 = agreement1;
    this.agreement2 = agreement2;
    this.backBtn = backBtn;
    this.checkBox1 = checkBox1;
    this.checkBox2 = checkBox2;
    this.email = email;
    this.loginPasswordToggle = loginPasswordToggle;
    this.password = password;
    this.passwordLayout = passwordLayout;
    this.signUpEtEmail = signUpEtEmail;
    this.signUpEtPassword = signUpEtPassword;
    this.signUpSneakersSize = signUpSneakersSize;
    this.signupButton = signupButton;
    this.sneakersSize = sneakersSize;
    this.wrongEmail = wrongEmail;
    this.wrongPassword = wrongPassword;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_signup, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySignupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.agreement1;
      TextView agreement1 = rootView.findViewById(id);
      if (agreement1 == null) {
        break missingId;
      }

      id = R.id.agreement2;
      TextView agreement2 = rootView.findViewById(id);
      if (agreement2 == null) {
        break missingId;
      }

      id = R.id.back_btn;
      ImageButton backBtn = rootView.findViewById(id);
      if (backBtn == null) {
        break missingId;
      }

      id = R.id.checkBox1;
      AppCompatCheckBox checkBox1 = rootView.findViewById(id);
      if (checkBox1 == null) {
        break missingId;
      }

      id = R.id.checkBox2;
      AppCompatCheckBox checkBox2 = rootView.findViewById(id);
      if (checkBox2 == null) {
        break missingId;
      }

      id = R.id.email;
      TextView email = rootView.findViewById(id);
      if (email == null) {
        break missingId;
      }

      id = R.id.login_password_toggle;
      AppCompatToggleButton loginPasswordToggle = rootView.findViewById(id);
      if (loginPasswordToggle == null) {
        break missingId;
      }

      id = R.id.password;
      TextView password = rootView.findViewById(id);
      if (password == null) {
        break missingId;
      }

      id = R.id.password_layout;
      FrameLayout passwordLayout = rootView.findViewById(id);
      if (passwordLayout == null) {
        break missingId;
      }

      id = R.id.sign_up_et_email;
      EditText signUpEtEmail = rootView.findViewById(id);
      if (signUpEtEmail == null) {
        break missingId;
      }

      id = R.id.sign_up_et_password;
      EditText signUpEtPassword = rootView.findViewById(id);
      if (signUpEtPassword == null) {
        break missingId;
      }

      id = R.id.sign_up_sneakers_size;
      FrameLayout signUpSneakersSize = rootView.findViewById(id);
      if (signUpSneakersSize == null) {
        break missingId;
      }

      id = R.id.signup_button;
      Button signupButton = rootView.findViewById(id);
      if (signupButton == null) {
        break missingId;
      }

      id = R.id.sneakers_size;
      TextView sneakersSize = rootView.findViewById(id);
      if (sneakersSize == null) {
        break missingId;
      }

      id = R.id.wrong_email;
      TextView wrongEmail = rootView.findViewById(id);
      if (wrongEmail == null) {
        break missingId;
      }

      id = R.id.wrong_password;
      TextView wrongPassword = rootView.findViewById(id);
      if (wrongPassword == null) {
        break missingId;
      }

      return new ActivitySignupBinding((ConstraintLayout) rootView, agreement1, agreement2, backBtn,
          checkBox1, checkBox2, email, loginPasswordToggle, password, passwordLayout, signUpEtEmail,
          signUpEtPassword, signUpSneakersSize, signupButton, sneakersSize, wrongEmail,
          wrongPassword);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}