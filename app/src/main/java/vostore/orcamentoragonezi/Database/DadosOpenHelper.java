package vostore.orcamentoragonezi.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DadosOpenHelper extends SQLiteOpenHelper {
    public DadosOpenHelper(Context context) {
        super(context,"DADOS", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

            db.execSQL(ScriptDLL.getCreateTableProdutos());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
