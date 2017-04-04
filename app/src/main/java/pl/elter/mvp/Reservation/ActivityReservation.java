package pl.elter.mvp.Reservation;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpActivity;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.elter.mvp.R;

public class ActivityReservation extends MvpActivity<ReservationView, ReservationPresenter> implements ReservationView {

    @BindView(R.id.Text_NR)
    TextView NoTextView;
    @BindView(R.id.Text_goscie) EditText EditCompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getPresenter().loadValueFromIntent();
        getPresenter().initializationDataBase();

    }

    @NonNull
    @Override
    public ReservationPresenter createPresenter() {
        return new ReservationPresenter();
    }

    @Override
    public String loadPutInterntValue(String name) {
        String geterString = this.getIntent().getStringExtra(name);
        if (geterString != null) {
            return geterString;
        }
        return "null";

    }

    @Override
    public void addTextToTextView(String text) {
        this.NoTextView.setText(this.NoTextView.getText().toString() + " " + text);
    }

    @OnClick(R.id.Rezerwuj_Button)
    public void onPressReservationButton() {
        getPresenter().sendRezerwacje();
    }

    @Override
    public View getViewByID(int id) {
        return findViewById(id);
    }

    @Override
    public Editable getTextByIDView(int id) {
        EditText text = (EditText)findViewById(id);
        return text.getText();
    }

    @Override
    public Context getContext() {
        return this.getApplicationContext();
    }

    @Override
    public void sendAllert(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.activity_main), message,Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}