package vostore.orcamentoragonezi.ActivitysNavigation;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.List;

import vostore.orcamentoragonezi.Database.DadosOpenHelper;
import vostore.orcamentoragonezi.Main2Activity;
import vostore.orcamentoragonezi.R;
import vostore.orcamentoragonezi.ServicosAdapter;
import vostore.orcamentoragonezi.dominio.entidade.Servicos;
import vostore.orcamentoragonezi.dominio.repositorio.ServicosRepositorio;

public class Produtos extends AppCompatActivity {
    private RecyclerView listDados;
    private SQLiteDatabase conexao;
    private ConstraintLayout layoutProduto;
    private DadosOpenHelper dadosOpenHelper;
    private Servicos servicos;
    private ServicosAdapter servicosAdapter;
    private ServicosRepositorio servicosRepositorio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);



        //Cast

        listDados = findViewById(R.id.listaDados);
        layoutProduto = findViewById(R.id.layoutProdutos);

        criarConexao();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        listDados.setLayoutManager(linearLayoutManager);

        servicosRepositorio = new ServicosRepositorio(conexao);
        List<Servicos> dados = servicosRepositorio.buscarTodos();
        servicosAdapter = new ServicosAdapter(dados);
        listDados.setAdapter(servicosAdapter);
    }

  private void criarConexao(){

        try {
            dadosOpenHelper = new DadosOpenHelper(this);
            conexao = dadosOpenHelper.getWritableDatabase();

            Snackbar.make(layoutProduto, R.string.mensagemSnack ,Snackbar.LENGTH_SHORT).setAction("Ok",null).show();


            servicosRepositorio = new ServicosRepositorio(conexao);

        }
        catch (SQLException ex){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.tituloDialog);
            dlg.setMessage(R.string.falha);
            dlg.setNeutralButton("Ok",null);
            dlg.show();

        }
    }

    private void confirmar(){

        String nome = "Lucas Reinaldo";
        Double preco = 0.0;
        int codigo = 0;


        servicos.nome = nome;
        servicos.preco = preco;
        servicos.codigo = codigo;

        servicosRepositorio.inserir(servicos);

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        finish();
    }
}
