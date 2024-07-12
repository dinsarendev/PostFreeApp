package com.dinsarenkh.postfreeapp.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dinsarenkh.postfreeapp.R;
import com.dinsarenkh.postfreeapp.app.BaseActivity;
import com.dinsarenkh.postfreeapp.models.request.RegiserRequest;
import com.dinsarenkh.postfreeapp.presenters.RegisterPresenter;
import com.dinsarenkh.postfreeapp.views.RegisterView;

public class RegisterActivity extends BaseActivity implements RegisterView {
    private EditText firstName, lastName, username, email, phone, password, confirmPassword;
    private Button btnRegister;
    private ProgressBar progressBar;
    private RegisterPresenter registerPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        registerPresenter = new RegisterPresenter(this);
        initView();
    }

    private void initView(){
        progressBar =findViewById(R.id.progressBar);
        firstName = findViewById(R.id.etFirstName);
        lastName = findViewById(R.id.etLastName);
        username = findViewById(R.id.etUername);
        phone = findViewById(R.id.etPhone);
        email = findViewById(R.id.etEmail);
        confirmPassword = findViewById(R.id.etConfirmPassword);
        password = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegiserRequest req = new RegiserRequest();
                req.setFirstName(firstName.getText().toString().trim());
                req.setLastName(lastName.getText().toString().trim());
                req.setUsername(username.getText().toString().trim());
                req.setPhoneNumber(phone.getText().toString().trim());
                req.setEmail(email.getText().toString().trim());
                req.setPassword(password.getText().toString().trim());
                req.setConfirmPassword(confirmPassword.getText().toString().trim());
                req.setRole("USER");
                req.setProfile("NON");
                registerPresenter.register(req);
            }
        });
    }

    @Override
    public void onLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHidingLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(String message) {
        showMessage(message);
    }

    @Override
    public void onSuccess(Object message) {
        showMessage("Register Success");
    }
}