package com.alexzh.circleimageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Custom ImageView for circular images in Android.
 */
public class CircleImageView extends ImageView {
    private final static String TAG = "CIRCLE_IMAGE_VIEW";

    private boolean hasBorder;
    private float borderWidth;
    private int borderColor;
    private int selectedColor;
    private boolean isSelected;

    private Paint paint;
    private Paint borderPaint;
    private Paint backgroundPaint;
    private Bitmap image;
    private int minCanvasSide;
    private BitmapShader shader;

    private ItemSelectedListener listener;

    public CircleImageView(Context context) {
        this(context, null, R.styleable.CircleImageViewStyle_circleImageViewDefault);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, R.styleable.CircleImageViewStyle_circleImageViewDefault);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        paint = new Paint();
        borderPaint = new Paint();
        backgroundPaint = new Paint();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
            setLayerType(LAYER_TYPE_SOFTWARE, null);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView, defStyle, 0);
        int backgroundColor = attributes.getColor(R.styleable.CircleImageView_view_backgroundColor,
                android.R.color.transparent);
        hasBorder = attributes.getBoolean(R.styleable.CircleImageView_view_border, false);
        borderColor = attributes.getColor(R.styleable.CircleImageView_view_borderColor,
                android.R.color.white);
        borderWidth = attributes.getDimension(R.styleable.CircleImageView_view_borderWidth, 2.0f);
        selectedColor = attributes.getColor(R.styleable.CircleImageView_view_selectedColor,
                android.R.color.white);

        setBackgroundColor(backgroundColor);

        if (hasBorder) {
            setBorderWidth(borderWidth);
            setBorderColor(borderColor);
        }

        paint.setAntiAlias(true);
        borderPaint.setAntiAlias(true);
        borderPaint.setStyle(Paint.Style.STROKE);
        backgroundPaint.setAntiAlias(true);
        backgroundPaint.setStyle(Paint.Style.FILL);

        attributes.recycle();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        RectF rect;

        int oldCanvasSize = minCanvasSide;
        minCanvasSide = getMeasuredWidth() < getMeasuredHeight() ? getMeasuredWidth() : getMeasuredHeight();

        if(oldCanvasSize != minCanvasSide)
            updateBitmapShader();

        paint.setShader(shader);

        int centerX = this.getMeasuredWidth() / 2;
        int centerY = this.getMeasuredHeight() / 2;
        float radius;

        if (hasBorder && !isSelected) {
            setBorderColor(borderColor);
            radius = (minCanvasSide - borderWidth) / 2;
            rect = new RectF(0 + borderWidth / 2, 0 + borderWidth / 2, minCanvasSide - borderWidth / 2, minCanvasSide - borderWidth / 2);
            canvas.drawArc(rect, 360, 360, false, borderPaint);
        } else if (hasBorder) {
            setBorderColor(selectedColor);
            radius = (minCanvasSide - borderWidth) / 2;
            rect = new RectF(0 + borderWidth / 2, 0 + borderWidth / 2, minCanvasSide - borderWidth / 2, minCanvasSide - borderWidth / 2);
            canvas.drawArc(rect, 360, 360, false, borderPaint);
        } else {
            radius = minCanvasSide / 2;
        }
        canvas.drawCircle(centerX, centerY, radius, backgroundPaint);
        canvas.drawCircle(centerX, centerY, radius, paint);
    }

    @Override
    public boolean dispatchTouchEvent(@NonNull MotionEvent event) {
        if (!isClickable()) {
            isSelected = false;
            return super.onTouchEvent(event);
        }
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.isSelected = !isSelected;
                if (isSelected && listener != null) {
                    listener.onSelected(this);
                } else if (!isSelected && listener != null) {
                    listener.onUnselected(this);
                }
                break;
        }
        // Redraw image and return super type
        this.invalidate();
        return super.dispatchTouchEvent(event);
    }


    /**
     * Sets the CircleImageView's selected listener.
     * @param listener The new listener to set for image.
     */
    public void setOnItemSelectedClickListener(ItemSelectedListener listener) {
        this.listener = listener;
    }

    /**
     * Sets the CircleImageView's background color.
     * @param backgroundColor The new color to set the background.
     */
    public void setBackgroundColor(int backgroundColor) {
        if (backgroundPaint != null)
            backgroundPaint.setColor(backgroundColor);
        this.invalidate();
    }

    /**
     * Sets the CircleImageView's basic border color.
     * @param borderColor The new color to set the border.
     */
    public void setBorderColor(int borderColor) {
        if (borderPaint != null)
            borderPaint.setColor(borderColor);
        this.invalidate();
    }

    /**
     * Sets the CircleImageView's border width in pixels.
     * @param borderWidth Width in pixels for the border.
     */
    public void setBorderWidth(float borderWidth) {
        this.borderWidth = borderWidth;
        if(borderPaint != null)
            borderPaint.setStrokeWidth(borderWidth);
        requestLayout();
        invalidate();
    }

    public Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null)
            return null;
        else if (drawable instanceof BitmapDrawable) {
            Log.i(TAG, "Bitmap drawable!");
            return ((BitmapDrawable) drawable).getBitmap();
        }

        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();

        if (!(intrinsicWidth > 0 && intrinsicHeight > 0))
            return null;

        try {
            Bitmap bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (OutOfMemoryError e) {
            Log.e(TAG, "Encountered OutOfMemoryError while generating bitmap!");
            return null;
        }
    }

    @Override
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);

        // Extract a Bitmap out of the drawable & set it as the main shader
        image = drawableToBitmap(getDrawable());
        if(minCanvasSide > 0)
            updateBitmapShader();
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);

        // Extract a Bitmap out of the drawable & set it as the main shader
        image = drawableToBitmap(getDrawable());
        if(minCanvasSide > 0)
            updateBitmapShader();
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);

        // Extract a Bitmap out of the drawable & set it as the main shader
        image = drawableToBitmap(getDrawable());
        if(minCanvasSide > 0)
            updateBitmapShader();
    }

    @Override
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);

        image = bm;
        if(minCanvasSide > 0)
            updateBitmapShader();
    }

    /**
     * Re-initializes the shader texture used to fill in
     * the Circle upon drawing.
     */
    public void updateBitmapShader() {
        if (image == null)
            return;

        shader = new BitmapShader(image, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        if(minCanvasSide != image.getWidth() || minCanvasSide != image.getHeight()) {
            Matrix matrix = new Matrix();
            float scale = (float) minCanvasSide / (float) image.getWidth();
            matrix.setScale(scale, scale);
            shader.setLocalMatrix(matrix);
        }
    }
}
