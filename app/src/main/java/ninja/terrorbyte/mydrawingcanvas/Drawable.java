package ninja.terrorbyte.mydrawingcanvas;

import android.graphics.Canvas;
import android.graphics.Paint;

public interface Drawable {

    void setPaint(Paint p);

    void draw(Canvas canvas);

    void start(float x, float y, int type);

    void update(float x, float y);

    void end(float x, float y);

}
