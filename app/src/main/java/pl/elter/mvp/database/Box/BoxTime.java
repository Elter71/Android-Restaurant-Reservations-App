package pl.elter.mvp.database.Box;

import android.text.Editable;

import java.util.Date;

/**
 * Created by elter on 06.02.17.
 */

public class BoxTime extends Box {

    private Date timeOfReservation;

    private int hoursOfReservation = -1;
    private int hinutesOfReservation;

    public BoxTime(Editable EditGodzina) {
        super(EditGodzina);

        if (isCorectFormat())
            timeOfReservation = new Date(2017, 1, 1, hoursOfReservation, hinutesOfReservation);
        else
            timeOfReservation = null;
    }

    @Override
    public boolean isCorect() {
        if (!isCorectFormat()) {
            return false;
        }

        if (timeOfReservation.before(checkedConf.getMinTime()) || timeOfReservation.after(checkedConf.getMaxTime())) {
            ErrorMessage = "Restaracja jest otwarta od 9:00 do 20:00";
            return false;
        }


        return true;
    }

    public boolean isCorectFormat() {

        if (editable.length() <= 0) {
            ErrorMessage = "Prosze wypełnić wszyskie pola oprucz \"Uwagi\"";
            return false;
        } else {
            //sprawdzamy poprawny fomrat podanego czasu
            String active = "";
            String czas = editable.toString();

            for (int i = 0; i < czas.length(); i++) {
                if (czas.charAt(i) != ':')
                    active += czas.charAt(i);
                else {
                    try {
                        this.hoursOfReservation = Integer.parseInt(active);
                    } catch (Exception e) {
                        this.hoursOfReservation = -2;
                    }
                    active = "";
                    if (hoursOfReservation > 23 && hoursOfReservation < 0) {
                        ErrorMessage = "Proszę podać poprawny czas";
                        return false;
                    }

                }
            }
            try {
                this.hinutesOfReservation = Integer.parseInt(active);
            }catch (Exception e){
                this.hinutesOfReservation = 0;
            }

            if(hoursOfReservation == -1){ // kiedy nie dalismy ':' podczas wpisywania godziny
                hinutesOfReservation = 0;
                hoursOfReservation = Integer.parseInt(active);
            }

            if (hinutesOfReservation > 59) {
                ErrorMessage = "Proszę podać poprawny czas";
                return false;
            }

        }

        return true;
    }

    @Override
    public Date getContent() {
        return timeOfReservation;
    }
}
