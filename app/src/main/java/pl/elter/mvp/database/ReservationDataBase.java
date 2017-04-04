package pl.elter.mvp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by elter on 09.02.2017.
 */

public class ReservationDataBase extends SQLiteOpenHelper
{

    public ReservationDataBase(Context context) {
        super(context, "DBreservation.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE Reservation(" +
                "id integer primary key," +
                "volumeOfCompany integer," +
                "timeOfReservation text," +
                "surname text," +
                "phoneNumber integer," +
                "additionalInformation text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void saveRecort(Recort recort) {
        ContentValues values = new ContentValues();
        values.put("id",recort.getId());
        values.put("volumeOfCompany",recort.getCompanyAtTable());
        values.put("timeOfReservation",recort.getTimeOfReservation());
        values.put("surname",recort.getSurname());
        values.put("phoneNumber",recort.getPhoneNumber());
        values.put("additionalInformation",recort.getAdditionalInformation());

        getWritableDatabase().insertOrThrow("Reservation",null,values);
    }
    public void resetDataBase(){
        getReadableDatabase().delete("Reservation",null,null);
    }
//    public Cursor getAllRecort(){
//        String[] colums = {"id","volumeOfCompany","timeOfReservation","surname","phoneNumber","additionalInformation"};
//        Cursor cursor = getReadableDatabase().query("Reservation",colums,null,null,null,null,null);
//        return cursor;
//    }
}
