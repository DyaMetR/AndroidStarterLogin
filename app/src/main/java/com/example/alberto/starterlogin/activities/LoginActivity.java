package com.example.alberto.starterlogin.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alberto.starterlogin.R;
import com.example.alberto.starterlogin.interfaces.I_User;
import com.example.alberto.starterlogin.models.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    I_User service;
    Retrofit retrofit;
    @BindView(R.id.usernameInput) EditText username;
    @BindView(R.id.passwordInput) EditText password;
    SharedPreferences sharedPreferences;
    String sharedTag = "Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initRetrofit();
        sharedPreferences = getSharedPreferences(sharedTag, MODE_PRIVATE);
    }

    @OnClick(R.id.confirm)
    public void login() {
        /*startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();*/
        if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
            Toast.makeText(LoginActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
            return;
        }

          service.login("3", username.getText().toString(), password.getText().toString()).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                switch (response.body().getR()) {
                    case "ci":
                        Toast.makeText(LoginActivity.this, getString(R.string.login_sv_password), Toast.LENGTH_SHORT).show();
                        break;
                    case "si":
                        Toast.makeText(LoginActivity.this, getString(R.string.login_sv_success), Toast.LENGTH_SHORT).show();
                        /*Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("name", response.body().getNombre());
                        startActivity(intent);*/
                        sharedPreferences.edit().putString("name", response.body().getNombre()).apply();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        break;
                    case "nr":
                        Toast.makeText(LoginActivity.this, getString(R.string.login_sv_username), Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });


    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(I_User.class);
    }
}
