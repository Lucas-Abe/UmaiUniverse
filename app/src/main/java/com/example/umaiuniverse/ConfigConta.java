package com.example.umaiuniverse;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.SharedPreferences;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfigConta extends AppCompatActivity {

    private EditText editTextNomeConfig;
    private EditText editTextEmailConfig;
    private EditText editTextDataNascConfig;
    private EditText editTextSenhaConfig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_config_conta);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
            String email = sharedPreferences.getString("user_email", "");

            editTextNomeConfig = findViewById(R.id.editTextNomeConfig);
            editTextEmailConfig = findViewById(R.id.editTextEmailConfig);
            editTextDataNascConfig = findViewById(R.id.editTextDataNascConfig);
            editTextSenhaConfig = findViewById(R.id.editTextSenhaConfig);

            buscar(email);

            return insets;
        });

    }

    public void buscar(String email) {
        AppDatabase db = AppDatabase.getInstance(this);
        ContaDao dao = db.contaDao();
        Conta c = dao.buscarEmail(email);
        editTextNomeConfig.setText(c.getNome());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        editTextDataNascConfig.setText(dateFormat.format(c.getDataNascimento()));
        editTextEmailConfig.setText(c.getEmail());
        editTextSenhaConfig.setText(c.getSenha());
    }

    public void atualizar(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        String email = sharedPreferences.getString("user_email", "");

        AppDatabase db = AppDatabase.getInstance(this);
        ContaDao dao = db.contaDao();

        String nome = editTextNomeConfig.getText().toString();
        String senha = editTextSenhaConfig.getText().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNasc;
        try {
            dataNasc = dateFormat.parse(editTextDataNascConfig.getText().toString());
        } catch (ParseException e) {
            dataNasc = new Date();
        }

        Conta c = new Conta(nome, dataNasc, email, senha);
        dao.update(c);

        Toast.makeText(this, "Dados atualizados!", Toast.LENGTH_SHORT).show();
        finish();

        /*
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

         */

    }

    public void excluir(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        String email = sharedPreferences.getString("user_email", "");

        AppDatabase db = AppDatabase.getInstance(this);
        ContaDao dao = db.contaDao();

        String nome = editTextNomeConfig.getText().toString();
        String senha = editTextSenhaConfig.getText().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNasc;
        try {
            dataNasc = dateFormat.parse(editTextDataNascConfig.getText().toString());
        } catch (ParseException e) {
            dataNasc = new Date();
        }
        Conta c = new Conta(nome, dataNasc, email, senha);
        dao.delete(c);

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }


}