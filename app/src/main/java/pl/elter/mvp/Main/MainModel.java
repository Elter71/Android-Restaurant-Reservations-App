package pl.elter.mvp.Main;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;

import com.hannesdorfmann.mosby.mvp.MvpActivity;

import java.security.cert.Extension;
import java.util.ArrayList;
import java.util.List;

import pl.elter.mvp.R;
import pl.elter.mvp.configuration.CheckedConf;
import pl.elter.mvp.database.Pola.Pole;
import pl.elter.mvp.database.ReservationDataBase;

/**
 * Created by Rodzice on 02.02.2017.
 */

public class MainModel {

    private ReservationDataBase dataBase;

    private List<Boolean> tableReserved;

    private CheckedConf checkedConf;

    public MainModel(Context context) {
        dataBase = new ReservationDataBase(context);
        tableReserved = new ArrayList<Boolean>();
        checkedConf = CheckedConf.initConfiguration();
        for (int i =0; i<checkedConf.getMaxTable();i++){
            tableReserved.add(i,false);
        }
    }

    private void queryTableReserved() {
        String[] colums = {"id"};
        Cursor cursor = dataBase.getReadableDatabase().query("Reservation", colums, null, null, null, null, null);

        while (cursor.moveToNext()) {
            for (int i = 0; i<checkedConf.getMaxTable(); i++){
                if(cursor.getInt(0) == i+1)
                    tableReserved.set(i,true);
            }
        }

    }

    public List<Boolean> getTableReserved() {
        queryTableReserved();
        return tableReserved;
    }

    public ReservationDataBase getDataBase(){
        return dataBase;
    }



}
