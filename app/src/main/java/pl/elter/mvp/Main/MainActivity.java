package pl.elter.mvp.Main;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.elter.mvp.R;
import pl.elter.mvp.Reservation.ActivityReservation;

public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        getPresenter().initializationDataBase();
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));

    }

    @OnClick(R.id.button)
    public void onPressButton1() {
        getPresenter().startActivity(1);
    }

    @OnClick(R.id.button2)
    public void onPressButton2() {
        getPresenter().startActivity(2);
    }

    @OnClick(R.id.button3)
    public void onPressButton3() {
        getPresenter().startActivity(3);
    }

    @OnClick(R.id.button4)
    public void onPressButton4() {
        getPresenter().startActivity(4);
    }

    @OnClick(R.id.button5)
    public void onPressButton5() {
        getPresenter().startActivity(5);
    }

    @OnClick(R.id.button6)
    public void onPressButton6() {
        getPresenter().startActivity(6);
    }

    @OnClick(R.id.button7)
    public void onPressButton7() {
        getPresenter().startActivity(7);
    }

    @OnClick(R.id.button8)
    public void onPressButton8() {
        getPresenter().startActivity(8);
    }

    @OnClick(R.id.button9)
    public void onPressButton9() {
        getPresenter().startActivity(9);
    }

    @OnClick(R.id.button10)
    public void onPressButton10() {
        getPresenter().startActivity(10);
    }

    @OnClick(R.id.button11)
    public void onPressButton11() {
        getPresenter().startActivity(11);
    }


    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void loadActivityButton(String text) {

        Intent intent = new Intent(this, ActivityReservation.class);
        intent.putExtra("No. Of Table", text);
        startActivity(intent);

    }

    @Override
    public void sendAllert(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.activity_main2), message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }


    @Override
    public Context getContext() {
        return this.getApplicationContext();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.resetDatabase:
                getPresenter().resetDataBase();
            break;
        }
        return super.onOptionsItemSelected(item);
    }

}
