package ninja.terrorbyte.mydrawingcanvas;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.Log;

public class Line implements Drawable {


    Paint p;

    public Line() {

        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setStrokeWidth(10);
        p.setStyle(Paint.Style.STROKE);
        p.setColor(0xFF000000);

    }

    @Override
    public void setPaint(Paint p) {
        this.p = p;
    }

    PointF startPoint = null;
    PointF endPoint = null;

    @Override
    public void draw(Canvas canvas) {
        if (endPoint == null) return;

        Log.i("Line", this.toString());

        canvas.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y, p);
        //Do nothing for now
    }


    @Override
    public void start(float x, float y, int type) {
        startPoint = new PointF(x, y);
    }


    @Override
    public void update(float x, float y) {
        endPoint = new PointF(x, y);
    }

    @Override
    public void end(float x, float y) {
        endPoint = new PointF(x, y);
    }


    @Override
    public String toString() {
        return "Line{" +
                "startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                '}';
    }
}
