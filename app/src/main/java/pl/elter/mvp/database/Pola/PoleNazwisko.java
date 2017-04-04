package pl.elter.mvp.database.Pola;

import android.text.Editable;

/**
 * Created by elter on 06.02.17.
 */

public class PoleNazwisko extends Pole {

    private String nazwisko;

    public PoleNazwisko(Editable editable) {
        super(editable);

        if (isCorect())
            nazwisko = editable.toString();
    }

    @Override
    public boolean isCorect() {
        if (editable.length() <= 0) {
            ErrorMessege = "Prosze wypełnić wszyskie pola oprucz \"Uwagi\"";
            return false;
        }
        return true;
    }

    @Override
    public String getContent() {
        return nazwisko;
    }

    @Override
    public String getErrorMessege() {
        return super.getErrorMessege();
    }
}
