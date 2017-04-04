package pl.elter.mvp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import pl.elter.mvp.R;
import pl.elter.mvp.Reservation.ReservationPresenter;

/**
 * Created by elter on 07.02.17.
 */

public class DataBaseModel {

    private Recort recort;
    private ReservationDataBase dataBase;

    public DataBaseModel(Context context) {

        dataBase = new ReservationDataBase(context);
    }

    public void setRecort(Recort recort) {
        this.recort = recort;
    }

    public void sendRecortToDataBase() {
        if (recort != null) {
                dataBase.saveRecort(recort);
        }
    }

//    public String getAll() {
//        String ret = "";
//        Cursor c = dataBase.getAllRecort();
//        while (c.moveToNext()) {
//            ret += c.getInt(0) + "|" + c.getInt(1) + "|" + c.getString(2) + "|" + c.getString(3);
//        }
//        return ret;
//    }
//    public boolean isIdIstnieje(int id){
//        String[] colums = {"id"};
//
//        Cursor cursor =dataBase.getReadableDatabase().query("Reservation",colums,"id="+id,null,null,null,null);
//
//        while (cursor.moveToNext()){
//            if(cursor.getInt(0) == id)
//                return true;
//        }
//
//        return false;
//    }

}
