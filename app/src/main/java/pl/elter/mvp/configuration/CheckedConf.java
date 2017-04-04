package pl.elter.mvp.configuration;


import java.util.Date;

/**
 * Created by elter on 06.02.17.
 */

public class CheckedConf {

    private static CheckedConf me;

    private int maxCompanyToTable;
    private int minCompanyToTable;
    private Date maxTime;
    private Date minTime;
    private int maxNumOnPhoneNumber;

    private int maxHours;
    private int minHours;

    private int maxMinutes;
    private int minMinutes;

    private int maxTable;

    private int maxLenghtAdditionalInformation;

    private CheckedConf(){
        maxCompanyToTable = 50;
        minCompanyToTable = 1;
        minTime = new Date(2017,1,1,9,0);
        maxTime = new Date(2017,1,1,20,0);
        maxNumOnPhoneNumber = 9;
        maxLenghtAdditionalInformation = 300;

        maxHours = 23;
        minHours = 0;

        maxMinutes = 59;
        minMinutes = 0;

        maxTable = 11;

    }

    public static CheckedConf initConfiguration(){
        if(me == null)
            me = new CheckedConf();
        return me;
    }

    public int getMaxCompanyToTable() {
        return maxCompanyToTable;
    }

    public int getMinCompanyToTable() {
        return minCompanyToTable;
    }

    public Date getMaxTime() {
        return maxTime;
    }

    public Date getMinTime() {
        return minTime;
    }

    public int getMaxNumOnPhoneNumber() {
        return maxNumOnPhoneNumber;
    }

    public int getMaxLenghtAdditionalInformation() {
        return maxLenghtAdditionalInformation;
    }

    public int getMaxHours() {
        return maxHours;
    }

    public int getMinHours() {
        return minHours;
    }

    public int getMaxMinutes() {
        return maxMinutes;
    }

    public int getMinMinutes() {
        return minMinutes;
    }

    public int getMaxTable() {
        return maxTable;
    }
}
