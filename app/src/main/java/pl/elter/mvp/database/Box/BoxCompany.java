package pl.elter.mvp.database.Box;

import android.text.Editable;

/**
 * Created by elter on 06.02.17.
 */

public class BoxCompany extends Box {

    private int valueCompany;

    public BoxCompany(Editable valueCompany) {
        super(valueCompany);

        if (isCorect())
            this.valueCompany = Integer.parseInt(editable.toString());
        else
            this.valueCompany = -1;
    }

    @Override
    public boolean isCorect() {


        if (editable.length() <= 0) {
            ErrorMessage = "Prosze wypełnić wszyskie pola oprucz \"Uwagi\"";
            return false;
        } else {
            if (Integer.parseInt(editable.toString()) > checkedConf.getMaxCompanyToTable()) {
                ErrorMessage = "Przekroczono maksymaną ilość gości (max. "+checkedConf.getMaxCompanyToTable()+");";
                return false;
            }
            if (Integer.parseInt(editable.toString()) < checkedConf.getMinCompanyToTable()) {
                ErrorMessage = "Za mała ilość gości (min. "+checkedConf.getMinCompanyToTable()+");";
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer getContent() {
        return valueCompany;
    }


}
