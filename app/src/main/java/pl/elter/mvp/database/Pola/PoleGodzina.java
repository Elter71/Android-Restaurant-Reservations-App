package pl.elter.mvp.database.Pola;

import android.text.Editable;

import java.util.Date;

import pl.elter.mvp.configuration.CheckedConf;

/**
 * Created by elter on 06.02.17.
 */

public class PoleGodzina extends Pole {

    private Date time;

    private int Hours = -1;
    private int Minutes;

    public PoleGodzina(Editable EditGodzina) {
        super(EditGodzina);

        if (isCorectFormat())
            time = new Date(2017, 1, 1, Hours, Minutes);
        else
            time = null;
    }

    @Override
    public boolean isCorect() {
        if (!isCorectFormat()) {
            return false;
        }

        if (time.before(checkedConf.getMinTime()) || time.after(checkedConf.getMaxTime())) {
            ErrorMessege = "Restaracja jest otwarta od 9:00 do 20:00";
            return false;
        }


        return true;
    }

    public boolean isCorectFormat() {

        if (editable.length() <= 0) {
            ErrorMessege = "Prosze wypełnić wszyskie pola oprucz \"Uwagi\"";
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
                        this.Hours = Integer.parseInt(active);
                    } catch (Exception e) {
                        this.Hours = -2;
                    }
                    active = "";
                    if (Hours > 23 && Hours < 0) {
                        ErrorMessege = "Proszę podać poprawny czas";
                        return false;
                    }

                }
            }
            try {
                this.Minutes = Integer.parseInt(active);
            }catch (Exception e){
                this.Minutes = 0;
            }

            if(Hours == -1){ // piedy nie dalismy ':' podczas wpisywania godziny
                Minutes = 0;
                Hours = Integer.parseInt(active);
            }

            if (Minutes > 59) {
                ErrorMessege = "Proszę podać poprawny czas";
                return false;
            }

        }

        return true;
    }

    @Override
    public Date getContent() {
        return time;
    }
}
