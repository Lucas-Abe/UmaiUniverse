package com.example.umaiuniverse;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.SharedPreferences;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;


public class Login extends AppCompatActivity {

    private EditText editTextEmailLogin;
    private EditText editTextSenhaLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            editTextEmailLogin = findViewById(R.id.editTextEmailLogin);
            editTextSenhaLogin = findViewById(R.id.editTextSenhaLogin);


            return insets;
        });
    }

    public void fazerLogin(View view) {

        String email = editTextEmailLogin.getText().toString();
        String senha = editTextSenhaLogin.getText().toString();

        AppDatabase db = AppDatabase.getInstance(this);
        ContaDao dao = db.contaDao();

        Conta conta = dao.buscarEmail(email);

        if (conta != null && conta.getSenha().equals(senha)) {

            SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("user_email", email);
            editor.apply();

            Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Pagina_Principal.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Email ou senha incorretos!", Toast.LENGTH_SHORT).show();
        }
    }

}