# CircleImageView
CircleImageView is a component which display circle image with customization options

<img src="https://github.com/AlexZhukovich/CircleImageView/blob/master/screenshots/circle_image_view_example.png" width="300px" height="500px" />
<img src="https://github.com/AlexZhukovich/CircleImageView/blob/master/screenshots/circle_image_view_example_selected.png" width="300px" height="500px" />

Usage
--------
To make a circular ImageView, add this CircleImageView library to your project and add CircleImageView in your layout XML. 
You can also grab it via Gradle:

```groovy
      compile 'com.alexzh:circleimageview:1.0.0@aar'
```

or Maven:

```xml
<dependency>
      <groupId>com.alexzh</groupId>
      <artifactId>circleimageview</artifactId>
      <version>1.0.0</version>
      <type>aar</type>
</dependency>
```

###XML
```xml
    <com.alexzh.circleimageview.CircleImageView
        android:id="@+id/imageView"
        android:layout_width="256dp"
        android:layout_height="256dp"
        android:clickable="true"
        android:src="@drawable/android_logo"
        app:view_border="true"
        app:view_borderWidth="8dp"
        app:view_borderColor="@color/blue"
        app:view_selectedColor="@android:color/white"
        app:view_backgroundColor="@color/colorPrimary"
```

You may use the following properties in your XML to customize your CircularImageView.

#####Properties:

* `app:view_backgroundColor`    (color)             
* `app:view_border`             (boolean)
* `app:view_borderColor`        (color)
* `app:view_borderWidth`        (dimension)  
* `app:view_selectedColor`      (color)    

###JAVA

* `setOnItemSelectedClickListener(ItemSelectedListener listener)` - let's handle onSelected(View view) and onUnselected(View view)

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
