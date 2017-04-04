package pl.elter.mvp.database;

import java.util.ArrayList;
import java.util.List;

import pl.elter.mvp.database.Box.*;

/**
 * Created by elter on 06.02.17.
 */

public class Recort {

    private int id;
    private int CompanyAtTable;
    private String timeOfReservation;
    private String surname;
    private int phoneNumber;
    private String additionalInformation;



    public Recort(int id, BoxCompany CompanyAtTable, BoxTime timeOfReservation, BoxSurname surname, BoxPhoneNumber phoneNumber, BoxAdditionalInformation additionalInformation) {
        this.id = id;
        this.CompanyAtTable = CompanyAtTable.getContent();
        this.timeOfReservation = timeOfReservation.getContent().getHours()+":"+ timeOfReservation.getContent().getMinutes();
        this.surname = surname.getContent();
        this.phoneNumber = phoneNumber.getContent();
        this.additionalInformation = additionalInformation.getContent();
    }


    public int getId() {
        return id;
    }

    public int getCompanyAtTable() {
        return CompanyAtTable;
    }

    public String getTimeOfReservation() {
        return timeOfReservation;
    }

    public String getSurname() {
        return surname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }
    public List<Object> getRekordList(){
        List<Object> listaRekordu = new ArrayList<Object>();
        listaRekordu.add(0,id);
        listaRekordu.add(1, CompanyAtTable);
        listaRekordu.add(2, timeOfReservation);
        listaRekordu.add(3, surname);
        listaRekordu.add(4, phoneNumber);
        listaRekordu.add(5, additionalInformation);

        return listaRekordu;
    }
}
