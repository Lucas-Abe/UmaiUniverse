    package com.example.umaiuniverse;

    import android.content.Intent;
    import android.os.Bundle;

    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;
    import java.text.ParseException;

    import android.view.View;
    import android.widget.EditText;
    import java.text.SimpleDateFormat;
    import java.util.Date;

    public class Cadastro extends AppCompatActivity {

        private EditText editTextNome;
        private EditText editTextEmail;
        private EditText editTextDataNasc;
        private EditText editTextSenha;

        public void abrirPrincipal() {
            Intent intent = new Intent(this, Pagina_Principal.class);
            startActivity(intent);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastro);
            editTextNome = findViewById(R.id.editTextNome);
            editTextEmail = findViewById(R.id.editTextEmail);
            editTextDataNasc = findViewById(R.id.editTextDataNasc);
            editTextSenha = findViewById(R.id.editTextSenha);

        }

        public void cadastrar(View view) {
            AppDatabase db = AppDatabase.getInstance(this);
            ContaDao dao = db.contaDao();

            String nome = editTextNome.getText().toString();
            String email = editTextEmail.getText().toString();
            String senha = editTextSenha.getText().toString();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNasc;
            try {
                dataNasc = dateFormat.parse(editTextDataNasc.getText().toString());
            } catch (ParseException e) {
                dataNasc = new Date();
            }
            Conta c = new Conta(nome, dataNasc, email, senha);
            dao.insert(c);
            abrirPrincipal();
        }


    }