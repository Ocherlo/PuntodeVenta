package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite_OpenHelper extends SQLiteOpenHelper {
    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table usuarios(_ID integer primary key autoincrement,Nombre text,Correo text,Password text);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //ABRIR BASE DE DATOS
    public void abrir(){this.getWritableDatabase();}
    //CERRAR BASE DE DATOS
    public void cerrar(){this.close();}

    //INSERTAR REGISTRO
    public void insertar(String nom,String cor,String pas){
        ContentValues valores=new ContentValues();
        valores.put("Nombre",nom);
        valores.put("Correo",cor);
        valores.put("Password",pas);
        this.getWritableDatabase().insert("usuarios",null,valores);
    }

    //VALIDAR USUARIO
    public Cursor consultar(String usu,String pas)throws SQLException{
        Cursor mcursor= null;
        mcursor=this.getReadableDatabase().query("usuarios",new String[]{"_ID","Nombre","Correo","Password"},"Nombre like '"+usu+"'and Password like '"+pas+"'",null,null,null,null);

        return mcursor;
    }
    //VALIDAR USUARIO CORREO Y CONTRASEÑA
    public Cursor consultar1(String usu,String cor)throws SQLException{
        Cursor mcursor1= null;
        mcursor1=this.getReadableDatabase().query("usuarios",new String[]{"_ID","Nombre","Correo","Password"},"Nombre like '"+usu+"'and Correo like '"+cor+"'",null,null,null,null);

        return mcursor1;
    }
}
