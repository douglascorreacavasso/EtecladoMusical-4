package com.example.etecladomusical.telas;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.etecladomusical.R;
import com.example.etecladomusical.configuração.Conexao;
import com.example.etecladomusical.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Cadastro extends AppCompatActivity {

    private EditText nome;
    private EditText email;
    private EditText senha;
    private Button botaoCadastrar;
    private Usuario usuario;

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        FirebaseApp.initializeApp(this);
    //chama a class para iniciar os componentes
        iniciarComponentes();

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = new Usuario();
                usuario.setNome( nome.getText().toString() );
                usuario.setEmail(email.getText().toString());
                usuario.setSenha(senha.getText().toString());
                cadastrarUsuario();
            }
        });

    }

    private void cadastrarUsuario(){
        autenticacao = Conexao.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(Cadastro.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if( task.isSuccessful() ){
                    Toast.makeText(Cadastro.this, "Sucesso ao cadastrar usuário", Toast.LENGTH_LONG ).show();
                }else {
                    Toast.makeText(Cadastro.this, "Erro ao cadastrar usuário: ", Toast.LENGTH_LONG ).show();
                }
            }
        });
    }



    //Inicia os componentes da tela
    private void iniciarComponentes() {
        nome = (EditText) findViewById(R.id.edit_cadastro_nome);
        email = (EditText) findViewById(R.id.edit_cadastro_email);
        senha = (EditText) findViewById(R.id.edit_cadastro_senha);
        botaoCadastrar = (Button) findViewById(R.id.bt_cadastrar); }

    // class geradora de mensagem na tela do usuario
    protected void alerta(String msg) {
        Toast.makeText(Cadastro.this, msg, Toast.LENGTH_SHORT).show();
    }

    // class protegida para iniciar
    protected void onStart() {
        super.onStart();
      //  mAuth = Conexao.getFirebaseAuth();
    }

}
