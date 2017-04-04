package pl.elter.mvp.database.Box;

import android.text.Editable;

/**
 * Created by elter on 06.02.17.
 */

public class BoxAdditionalInformation extends Box {
    private String additionalInformation;
    public BoxAdditionalInformation(Editable editable) {
        super(editable);

        if(isCorect())
            additionalInformation = editable.toString();
    }

    @Override
    public String getContent() {
        return additionalInformation;
    }

    @Override
    public boolean isCorect() {
        if (editable.length() > checkedConf.getMaxLenghtAdditionalInformation()) {
            ErrorMessage = "Maksymana długość \"additionalInformation\" to 300 znaków. Proszę zmieścić się w tej liczbie";
            return false;
        }

        return true;
    }

    @Override
    public String getErrorMessage() {
        return super.getErrorMessage();
    }
}
