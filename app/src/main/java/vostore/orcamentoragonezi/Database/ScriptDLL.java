package vostore.orcamentoragonezi.Database;

public class ScriptDLL {

    public static String getCreateTableProdutos(){

        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE IF NOT EXISTS SERVICOS ( ");
        sql.append("    CODIGO   INTEGER      PRIMARY KEY AUTOINCREMENT NOT NULL, ");
        sql.append("    NOME     VARCHAR(250) NOT NULL DEFAULT(''), ");
        sql.append("    PRECO DOUBLE NOT NULL DEFAULT(0) ) ");




        return sql.toString();
    }
}
