package pl.elter.mvp.Main;

import android.content.Context;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Rodzice on 01.02.2017.
 */

public interface MainView extends MvpView {


    void loadActivityButton(String text);

    Context getContext();
    void sendAllert(String message);

}
