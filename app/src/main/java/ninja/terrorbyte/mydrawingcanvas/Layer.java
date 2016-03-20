package ninja.terrorbyte.mydrawingcanvas;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Vector;


public class Layer implements Drawable {

    Vector<Drawable> drawables;
    Drawable current = null;
    Paint p;

    public Layer() {
        drawables = new Vector<>();
    }

    public void add(Drawable drawable) {
        drawables.add(drawable);
    }

    private void addCurrentToDrawables() {
        add(current);
        current = null;
    }

    @Override
    public void setPaint(Paint p) {
        this.p = p;
    }

    @Override
    public void draw(Canvas canvas) {
        for (int i = 0; i < drawables.size(); i++) {
            drawables.get(i).draw(canvas);
        }
        if (current != null) {
            current.draw(canvas);
        }
    }

    @Override
    public void start(float x, float y, int type) {
        current = DrawableFactory.createDrawable(type);
        current.setPaint(p);
        current.start(x, y, type);
    }


    @Override
    public void update(float x, float y) {
        current.update(x, y);

    }

    @Override
    public void end(float x, float y) {
        current.end(x, y);
        addCurrentToDrawables();
    }
}
