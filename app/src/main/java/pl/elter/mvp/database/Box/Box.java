package pl.elter.mvp.database.Box;


import android.text.Editable;

import pl.elter.mvp.configuration.CheckedConf;

/**
 * Created by elter on 06.02.17.
 */

public abstract class Box {

    public Box(Editable editable){
        this.editable = editable;
        checkedConf = CheckedConf.initConfiguration();
    }

    protected Editable editable;
    protected CheckedConf checkedConf;
    protected String ErrorMessage;

    abstract public boolean isCorect();
    abstract public Object getContent();
    public String getErrorMessage() {
        return ErrorMessage;
    }

}
