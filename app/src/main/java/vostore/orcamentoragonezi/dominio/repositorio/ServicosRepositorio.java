package vostore.orcamentoragonezi.dominio.repositorio;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vostore.orcamentoragonezi.ActivitysNavigation.Produtos;
import vostore.orcamentoragonezi.dominio.entidade.Servico;
import vostore.orcamentoragonezi.dominio.entidade.Servicos;

public class ServicosRepositorio {

    private SQLiteDatabase conexao;
    public ServicosRepositorio(SQLiteDatabase conexao){
        this.conexao = conexao;
    }

    public void inserir(Servicos servicos){

        ContentValues contentValues = new ContentValues();
        contentValues.put("NOME", servicos.nome);
        contentValues.put("PRECO", servicos.preco);

        conexao.insertOrThrow("SERVICOS", null, contentValues);
    }
    public void excluir ( int codigo){


        String[] parametros = new String[1];
        parametros[0] = String.valueOf(codigo);

        conexao.delete("SERVICO","CODIGO = ?",parametros);
    }
    public void alterar (Servicos servicos){


        ContentValues contentValues = new ContentValues();
        contentValues.put("NOME", servicos.nome);
        contentValues.put("PRECO", servicos.preco);


        String[] parametros = new String[1];
        parametros[0] = String.valueOf(servicos.codigo);

        conexao.update("SERVICO",contentValues,"CODIGO = ?",parametros);
    }
    public List<Servicos> buscarTodos(){

        List<Servicos> servicos = new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT CODIGO, NOME, PRECO ");
        sql.append(" FROM SERVICOS ");
        Cursor  resultado = conexao.rawQuery(sql.toString(),null);

       if (resultado.getCount() > 0) {
           resultado.moveToFirst();

            do {
                Servicos servicos1 = new Servicos();

                servicos1.codigo = resultado.getInt( resultado.getColumnIndexOrThrow("CODIGO"));
                servicos1.nome = resultado.getString( resultado.getColumnIndexOrThrow("NOME"));
                servicos1.preco = resultado.getDouble( resultado.getColumnIndexOrThrow("PRECO"));

                servicos.add(servicos1);
            }while (resultado.moveToNext());

       }


        return servicos;
    }
    public Servicos buscarServico(int codigo){


        Servicos servicos = new Servicos();


        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT CODIGO, NOME,PRECO     ");
        sql.append("    FROM SERVICOS ");
        sql.append("  WHERE CODIGO = ? ");

        String[] parametros = new String[1];
        parametros[0] = String.valueOf(codigo);


        Cursor  resultado = conexao.rawQuery(sql.toString(),parametros);

        if (resultado.getCount() > 0) {
            resultado.moveToFirst();


                servicos.codigo = resultado.getInt( resultado.getColumnIndexOrThrow("CODIGO"));
                servicos.nome = resultado.getString( resultado.getColumnIndexOrThrow("NOME"));
                servicos.preco = resultado.getDouble( resultado.getColumnIndexOrThrow("PRECO"));



                return  servicos;

        }


        return null;
    }



}
