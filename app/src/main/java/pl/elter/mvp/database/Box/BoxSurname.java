package pl.elter.mvp.database.Box;

import android.text.Editable;

/**
 * Created by elter on 06.02.17.
 */

public class BoxSurname extends Box {

    private String surname;

    public BoxSurname(Editable editable) {
        super(editable);

        if (isCorect())
            surname = editable.toString();
    }

    @Override
    public boolean isCorect() {
        if (editable.length() <= 0) {
            ErrorMessage = "Prosze wypełnić wszyskie pola oprucz \"Uwagi\"";
            return false;
        }
        return true;
    }

    @Override
    public String getContent() {
        return surname;
    }

    @Override
    public String getErrorMessage() {
        return super.getErrorMessage();
    }
}
