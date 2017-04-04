package pl.elter.mvp.Main;

import android.content.SharedPreferences;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.List;

import pl.elter.mvp.database.DataBaseModel;

/**
 * Created by Rodzice on 01.02.2017.
 */

public class MainPresenter extends MvpBasePresenter<MainView> {

    private MainModel model;

    public MainPresenter() {
        super();
    }

    public void initializationDataBase() {

        model = new MainModel(getView().getContext());
    }

    public void startActivity(int number){
        if(!tableIsReserved(number))
            getView().loadActivityButton(""+number);

        //getView().sendAllert("iD: "+model.tableId);

    }

    private boolean tableIsReserved(int number){

        if(model.getTableReserved().get(number-1)){
            getView().sendAllert("Stolik zarezerwoany proszę wybrać inny");
            return true;
        }

        return false;
    }


    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }


    public void resetDataBase() {
        model.getDataBase().resetDataBase();
    }
}
