# CircleImageView
CircleImageView is a component which display circle image with customization options

<img src="https://github.com/AlexZhukovich/CircleImageView/blob/master/screenshots/circle_image_view_example.png" width="300px" height="500px" />
<img src="https://github.com/AlexZhukovich/CircleImageView/blob/master/screenshots/circle_image_view_example_selected.png" width="300px" height="500px" />

Release notes
--------
#####1.1.2
* Support padding parameters (paddingLeft, paddingTop, paddingRight, paddingBottom).

#####1.1.1
* Fix bug (issue #1 on github).

#####1.1.0
* shows shadow for image;
* shows shadow for border.

#####1.0.0
* change background for *.png images;
* shows images;
* realize click listener for this component;
* shows border (component is selected or component is unselected).

Usage
--------
To make a circular ImageView, add this CircleImageView library to your project and add CircleImageView in your layout XML. 
You can also grab it via Gradle:

```groovy
      compile 'com.alexzh:circleimageview:1.1.2@aar'
```

or Maven:

```xml
<dependency>
      <groupId>com.alexzh</groupId>
      <artifactId>circleimageview</artifactId>
      <version>1.1.2</version>
      <type>aar</type>
</dependency>
```

###XML
```xml
    <com.alexzh.circleimageview.CircleImageView
        android:id="@+id/imageView"
        android:layout_width="192dp"
        android:layout_height="192dp"
        android:clickable="true"
        android:src="@drawable/android_logo"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="10dp"
        app:view_backgroundColor="@color/colorPrimary"
        app:view_shadowRadius="4dp"
        app:view_shadowDx="2dp"
        app:view_shadowDy="0dp"
        app:view_shadowColor="@color/grey"
        app:view_borderWidth="4dp"
        app:view_selectedColor="@color/blue"
        app:view_borderColor="@android:color/darker_gray"/>
```

You may use the following properties in your XML to customize your CircularImageView.

#####Properties:

* `app:view_backgroundColor`    (color)       
* `app:view_borderColor`        (color)
* `app:view_borderWidth`        (dimension)  
* `app:view_selectedColor`      (color)    
* `app:view_shadowRadius`       (dimension)
* `app:view_shadowDx`           (dimension)
* `app:view_shadowDy`           (dimension)
* `app:view_shadowColor`        (color)

###JAVA

* `setOnItemSelectedClickListener(ItemSelectedListener listener)` - let's handle onSelected(View view) and onUnselected(View view)

* `onSelected(View view)` - view is selected
* `onUnselected(View view)` - view is unselected


Developed By
--------

Aliaksandr Zhukovich - http://alexzh.com

License
--------

    The MIT License (MIT)
    
    Copyright (c) 2015 Aliaksandr Zhukovich
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.
