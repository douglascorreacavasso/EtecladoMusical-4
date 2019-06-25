package com.example.etecladomusical.telas;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.etecladomusical.R;
import com.example.etecladomusical.help.Permissao;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

    private EditText nomeUsuario, senhaUsuario;
    private Button btnEntrar;
    private Button botaoCad ;
    //LISTA DE PERMISSÕES QUE ACREDITO SEREM NECESSARIAS PARA O APP
    private String[] permissoesNecessarias = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.INTERNET,
            Manifest.permission.CAPTURE_SECURE_VIDEO_OUTPUT,
            Manifest.permission.CAPTURE_VIDEO_OUTPUT};

    private DatabaseReference referenciaFirebase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //faz com que não exiba o titulo do app
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        iniciarComponentes();
        FirebaseApp.initializeApp(this);
    //PASSA A LISTA DE PERMISSÕES NECESSARIAS PARA A CLASS QUE VERIFICA E SE NÃO AS TEM JÁ AS SOLICITA
        Permissao.validaPermissoes(1, this, permissoesNecessarias);

        //referenciaFirebase = Conexao.getFirebase();

        botaoCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Cadastro.class));
            }
        });

        btnEntrar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView nomeUsuario = (TextView) findViewById(R.id.nomeUsuario);
                TextView senhaUsuario = (TextView) findViewById(R.id.senhaUsuario);
                String nome = nomeUsuario.getText().toString();
                String senha = senhaUsuario.getText().toString();

                // Initialize verifica usuario se está logado
                //verificaUsuarioLogado();
                // Inicia componentes da tela




                if (nome.equals("douglas")&&senha.equals("123")){
                    alert("Login realizado com sucesso!!");

                    //EXIBIR O NOME E A SENHA DIGITADO COM "TOAST"
                    Toast.makeText(getApplicationContext(), "Olá " + nome +
                            "Seja bem vindo(a)", Toast.LENGTH_SHORT).show();
                    abrirAreaPrincipal ();
                }else{
                    alert("Login ou senha incorretos");
                }
            }
        }));

        }





    //class inicia componentes da tela
    private void iniciarComponentes(){
        nomeUsuario= findViewById(R.id.nomeUsuario);
        senhaUsuario = findViewById(R.id.senhaUsuario);
        btnEntrar = findViewById(R.id.btnEntrar);
        botaoCad = findViewById(R.id.botaoCad);
    }


    public void abrirCadastroUsuario(View view){
        Intent intent = new Intent(MainActivity.this, Cadastro.class);
        startActivity(intent);
}


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseAuth mAuth;
      //  FirebaseUser currentUser = mAuth.getCurrentUser();
       // updateUI(currentUser);
    }
    private void  verificaUsuarioLogado(){
       //if (ParseUser.getCurrectUser() != null){
       // abrirAreaPrincipal();
       //  }
    }
    private void abrirAreaPrincipal (){
        Intent intent = new Intent(MainActivity.this, ListaMusicas.class);
        startActivity(intent);
        finish();
    }

    //exibe um a mesagem avisando o usuario se foi logado com sucesso ou não
    private void alert (String s ){
        Toast.makeText(this, s,Toast.LENGTH_LONG).show();
    }

}
