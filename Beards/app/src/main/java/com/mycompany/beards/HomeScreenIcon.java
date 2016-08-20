package com.mycompany.beards;

/**
 * Created by losta_000 on 7/30/2016.
 */
public class HomeScreenIcon {

    private String packageName;
    private String details;
    private int iconID;

    public HomeScreenIcon(String packageName,String details, int iconID) {

        this.packageName=packageName;
        this.details=details;

        this.iconID=iconID;

    }

    public String getPackageName() {
        return packageName;
    }



    public int getIconID() {
        return iconID;
    }

    public String getDetails() {
        return details;
    }
}
