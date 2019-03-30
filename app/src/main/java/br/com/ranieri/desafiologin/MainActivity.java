package br.com.ranieri.desafiologin;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import br.com.ranieri.desafiologin.request.AppSession;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text)
    TextView txEmail;

    @BindView(R.id.button)
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String text = String.format("logado : %1$s", AppSession.user.getEmail());
        txEmail.setText(text);
    }

    @OnClick(R.id.button)
    public void logout() {
        AppSession.session = null;
        AppSession.user = null;
        finish();
    }
}
