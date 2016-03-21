package com.alexzh.circleimageviewexample;

public class AndroidVersion {

    private String mName;
    private String mLogoPath;

    public AndroidVersion(String mName, String mLogoPath) {
        this.mName = mName;
        this.mLogoPath = mLogoPath;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getLogoPath() {
        return mLogoPath;
    }

    public void setLogoPath(String logoPath) {
        this.mLogoPath = logoPath;
    }
}
