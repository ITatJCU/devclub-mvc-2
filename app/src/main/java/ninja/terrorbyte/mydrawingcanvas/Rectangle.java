package ninja.terrorbyte.mydrawingcanvas;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by xander on 20/03/2016.
 */
public class Rectangle implements Drawable {
    Paint p;

    RectF bounds = null;

    public Rectangle() {
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setStrokeWidth(10);
        p.setStyle(Paint.Style.STROKE);
        p.setColor(0xFF000000);
    }

    @Override
    public void setPaint(Paint p) {
        this.p = p;
    }


    @Override
    public void draw(Canvas canvas) {
        if (bounds == null) return;

        canvas.drawRect(bounds, p);
    }

    @Override
    public void start(float x, float y, int type) {
        bounds = new RectF();
        bounds.left = x;
        bounds.top = y;
        bounds.right = x;
        bounds.bottom = y;
    }

    @Override
    public void update(float x, float y) {
        bounds.right = x;
        bounds.bottom = y;
    }

    @Override
    public void end(float x, float y) {
        bounds.right = x;
        bounds.bottom = y;
    }
}
