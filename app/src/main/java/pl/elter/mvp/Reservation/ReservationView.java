package pl.elter.mvp.Reservation;

import android.content.Context;
import android.text.Editable;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpView;



/**
 * Created by elter on 03.02.17.
 */

public interface ReservationView extends MvpView {

    String loadPutInterntValue(String name);
    void addTextToTextView(String text);

    View getViewByID(int id);
    Editable getTextByIDView(int id);

    Context getContext();

    void sendAllert(String message);
}
