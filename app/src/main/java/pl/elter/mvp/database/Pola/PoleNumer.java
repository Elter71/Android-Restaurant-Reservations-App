package pl.elter.mvp.database.Pola;

import android.text.Editable;

/**
 * Created by elter on 06.02.17.
 */

public class PoleNumer extends Pole {

    private int numer;

    public PoleNumer(Editable editable) {
        super(editable);

        if(isCorect())
            numer = Integer.parseInt(editable.toString());

    }

    @Override
    public Integer getContent() {
        return numer;
    }

    @Override
    public boolean isCorect() {
        if (editable.length() <= 0) {
            ErrorMessege = "Prosze wypełnić wszyskie pola oprucz \"Uwagi\"";
            return false;
        }
        if (editable.length() != checkedConf.getMaxNumOnPhoneNumber()) {
            ErrorMessege = "Proszę podać poprawny numer. Numer składa się z 9 liczb";
            return false;
        }
        return true;
    }

    @Override
    public String getErrorMessege() {
        return super.getErrorMessege();
    }
}
