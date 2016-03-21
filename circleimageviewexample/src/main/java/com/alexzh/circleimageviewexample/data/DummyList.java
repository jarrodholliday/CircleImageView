package com.alexzh.circleimageviewexample.data;

import com.alexzh.circleimageviewexample.AndroidVersion;

import java.util.ArrayList;
import java.util.List;

public class DummyList {

    public static final List<AndroidVersion> getAndroidVersionList() {
        List<AndroidVersion> list = new ArrayList<>();
        list.add(new AndroidVersion("Ice Cream Sandwich", "http://theinspirationroom.com/daily/design/2013/9/android-icecream-sandwich-logo.jpg"));
        list.add(new AndroidVersion("Jelly Bean", "http://theinspirationroom.com/daily/design/2013/9/android-jellybean-logo.jpg"));
        list.add(new AndroidVersion("KitKat", "http://theinspirationroom.com/daily/design/2013/9/android-kitkat-logo.jpg"));
        list.add(new AndroidVersion("Lollipop", "http://cdn2.knowyourmobile.com/sites/knowyourmobilecom/files/styles/gallery_wide/public/8/77/android_5_lollipop.png?itok=CVS1_DCp"));
        list.add(new AndroidVersion("Marshmallow", "https://lh3.googleusercontent.com/oZK2sRk95CaKTqkyrIOODEdM73JWHzWIbn1FsMHxOENqJeMffuaCwQQFThkdXil3g5Q=w300"));
        list.add(new AndroidVersion("N", null));
        return list;
    }
}
