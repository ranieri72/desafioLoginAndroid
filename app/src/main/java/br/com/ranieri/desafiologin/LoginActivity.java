package br.com.ranieri.desafiologin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.koushikdutta.async.future.FutureCallback;

import br.com.ranieri.desafiologin.entity.RequestLogin;
import br.com.ranieri.desafiologin.entity.User;
import br.com.ranieri.desafiologin.request.AppSession;
import br.com.ranieri.desafiologin.request.Requester;
import br.com.ranieri.desafiologin.request.WSmethods;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    private static final String USER_DATA = "user_data";

    @BindView(R.id.edtEmail)
    EditText edtEmail;

    @BindView(R.id.edtPassword)
    EditText edtPassword;

    @BindView(R.id.btnLogin)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        SharedPreferences prefs = getSharedPreferences(USER_DATA, MODE_PRIVATE);
        if (prefs != null) {
            String email = prefs.getString("email", "");
            edtEmail.setText(email);
        }
    }

    @OnClick(R.id.btnLogin)
    public void login() {
        RequestLogin login = new RequestLogin();
        User user = new User();

        user.setEmail(edtEmail.getText().toString());
        user.setPassword(edtPassword.getText().toString());
        login.setUser(user);

        FutureCallback<String> callback = (e, result) -> {

            if (e == null) {
                RequestLogin loginCallback = new Gson().fromJson(result, RequestLogin.class);
                if (loginCallback != null) {
                    AppSession.user = loginCallback.getUser();
                    AppSession.session = loginCallback.getSession();

                    SharedPreferences.Editor editor = getSharedPreferences(USER_DATA, MODE_PRIVATE).edit();
                    editor.putString("email", loginCallback.getUser().getEmail());
                    editor.putString("token", loginCallback.getSession().getToken());
                    editor.apply();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    LoginActivity.this.startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, getString(R.string.login_error), Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(LoginActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        };
        new Requester(this.getApplicationContext()).start(login, WSmethods.login, callback);
    }
}
