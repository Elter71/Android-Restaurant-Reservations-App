package pl.elter.mvp.database.Pola;


import android.text.Editable;

import pl.elter.mvp.configuration.CheckedConf;

/**
 * Created by elter on 06.02.17.
 */

public abstract class Pole {

    public Pole(Editable editable){
        this.editable = editable;
        checkedConf = CheckedConf.initConfiguration();
    }

    protected Editable editable;
    protected CheckedConf checkedConf;
    protected String ErrorMessege;

    abstract public boolean isCorect();
    abstract public Object getContent();
    public String getErrorMessege() {
        return ErrorMessege;
    }

}
