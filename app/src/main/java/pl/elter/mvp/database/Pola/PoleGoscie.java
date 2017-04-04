package pl.elter.mvp.database.Pola;

import android.text.Editable;

/**
 * Created by elter on 06.02.17.
 */

public class PoleGoscie extends Pole {

    private int iloscGosci;

    public PoleGoscie(Editable iloscGosci) {
        super(iloscGosci);

        if (isCorect())
            this.iloscGosci = Integer.parseInt(editable.toString());
        else
            this.iloscGosci = -1;

        //this.iloscGosci = iloscGosci;
    }

    @Override
    public boolean isCorect() {


        if (editable.length() <= 0) {
            ErrorMessege = "Prosze wypełnić wszyskie pola oprucz \"Uwagi\"";
            return false;
        } else {
            if (Integer.parseInt(editable.toString()) > checkedConf.getMaxCompanyToTable()) {
                ErrorMessege = "Przekroczono maksymaną ilość gości (max. 50)";
                return false;
            }
            if (Integer.parseInt(editable.toString()) < checkedConf.getMinCompanyToTable()) {
                ErrorMessege = "Za mała ilość gości (min. 1)";
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer getContent() {
        return iloscGosci;
    }


}
