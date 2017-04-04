package pl.elter.mvp.database.Box;

import android.text.Editable;

/**
 * Created by elter on 06.02.17.
 */

public class BoxPhoneNumber extends Box {

    private int phoneNumber;

    public BoxPhoneNumber(Editable editable) {
        super(editable);

        if(isCorect())
            phoneNumber = Integer.parseInt(editable.toString());

    }

    @Override
    public Integer getContent() {
        return phoneNumber;
    }

    @Override
    public boolean isCorect() {
        if (editable.length() <= 0) {
            ErrorMessage = "Prosze wypełnić wszyskie pola oprucz \"Uwagi\"";
            return false;
        }
        if (editable.length() != checkedConf.getMaxNumOnPhoneNumber()) {
            ErrorMessage = "Proszę podać poprawny phoneNumber. Numer składa się z 9 liczb";
            return false;
        }
        return true;
    }

    @Override
    public String getErrorMessage() {
        return super.getErrorMessage();
    }
}
