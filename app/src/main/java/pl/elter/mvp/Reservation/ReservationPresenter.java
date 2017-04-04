package pl.elter.mvp.Reservation;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;


import java.util.ArrayList;
import java.util.List;

import pl.elter.mvp.R;
import pl.elter.mvp.database.Box.Box;
import pl.elter.mvp.database.Box.BoxTime;
import pl.elter.mvp.database.Box.BoxCompany;
import pl.elter.mvp.database.Box.BoxSurname;
import pl.elter.mvp.database.Box.BoxPhoneNumber;
import pl.elter.mvp.database.Box.BoxAdditionalInformation;
import pl.elter.mvp.database.DataBaseModel;
import pl.elter.mvp.database.Recort;


/**
 * Created by elter on 03.02.17.
 */

public class ReservationPresenter extends MvpBasePresenter<ReservationView> {


    private String ErrorInputMessage;

    private Recort recort;

    static private DataBaseModel ModelDataBase;

    private int numberOfTable;

    private List<Box> boxList;

    boolean isReserved;

    public void initializationDataBase() {

        ModelDataBase = new DataBaseModel(getView().getContext());
        isReserved = false;
    }

    public void loadValueFromIntent() {
        String loadText = getView().loadPutInterntValue("No. Of Table");
        numberOfTable = Integer.parseInt(loadText);
        getView().addTextToTextView(loadText);
    }

    public void sendRezerwacje() {
        if (!isReserved) {
            if (checkEditText()) {
                recort = new Recort(numberOfTable, (BoxCompany) boxList.get(0), (BoxTime) boxList.get(1), (BoxSurname) boxList.get(2), (BoxPhoneNumber) boxList.get(3), (BoxAdditionalInformation) boxList.get(4));
                ModelDataBase.setRecort(recort);
                ModelDataBase.sendRecortToDataBase();
                getView().sendAllert("Zarezerwowano stolik pomyślnie");
                isReserved = true;

            } else
                getView().sendAllert(ErrorInputMessage);
        } else
            getView().sendAllert("Zarezerwowaleś już stolik.");
    }

    private boolean checkEditText() {
        boxList = createListOfBox();

        if (!boxList.get(0).isCorect()) {

            ErrorInputMessage = boxList.get(0).getErrorMessage();
            return false;
        }
        if (!boxList.get(1).isCorect()) {

            ErrorInputMessage = boxList.get(1).getErrorMessage();
            return false;
        }

        if (!boxList.get(2).isCorect()) {

            ErrorInputMessage = boxList.get(2).getErrorMessage();
            return false;
        }

        if (!boxList.get(3).isCorect()) {

            ErrorInputMessage = boxList.get(3).getErrorMessage();
            return false;
        }

        if (!boxList.get(4).isCorect()) {

            ErrorInputMessage = boxList.get(4).getErrorMessage();
            return false;
        }
        return true;
    }

    private List<Box> createListOfBox() {
        List<Box> boxList = new ArrayList<Box>();

        boxList.add(new BoxCompany(getView().getTextByIDView(R.id.Text_goscie)));
        boxList.add(new BoxTime(getView().getTextByIDView(R.id.Text_Data)));
        boxList.add(new BoxSurname(getView().getTextByIDView(R.id.Text_Nazwisko)));
        boxList.add(new BoxPhoneNumber(getView().getTextByIDView(R.id.Text_Numer)));
        boxList.add(new BoxAdditionalInformation(getView().getTextByIDView(R.id.Text_Uwagi)));


        return boxList;
    }
//    private List<Editable> getListOfPole(){
////        List<Editable> listaEditable = new ArrayList<Editable>();
////
////        listaEditable.add(0,getView().getTextByIDView(R.id.Text_goscie));
////        listaEditable.add(1,getView().getTextByIDView(R.id.Text_Data));
////        listaEditable.add(2,getView().getTextByIDView(R.id.Text_Numer));
////        listaEditable.add(3,getView().getTextByIDView(R.id.Text_Nazwisko));
////        listaEditable.add(4,getView().getTextByIDView(R.id.Text_Uwagi));
//
////        return listaEditable;
//    }

}
