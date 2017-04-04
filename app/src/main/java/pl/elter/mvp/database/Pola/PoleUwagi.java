package pl.elter.mvp.database.Pola;

import android.text.Editable;

/**
 * Created by elter on 06.02.17.
 */

public class PoleUwagi extends Pole {
    private String Uwagi;
    public PoleUwagi(Editable editable) {
        super(editable);

        if(isCorect())
            Uwagi = editable.toString();
    }

    @Override
    public String getContent() {
        return Uwagi;
    }

    @Override
    public boolean isCorect() {
        if (editable.length() > checkedConf.getMaxLenghtAdditionalInformation()) {
            ErrorMessege = "Maksymana długość \"Uwagi\" to 300 znaków. Proszę zmieścić się w tej liczbie";
            return false;
        }

        return true;
    }

    @Override
    public String getErrorMessege() {
        return super.getErrorMessege();
    }
}
