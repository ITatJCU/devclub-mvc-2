package ninja.terrorbyte.mydrawingcanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class CanvasView extends View {


    Drawable layer = new Layer();
    int type = 0;

    public CanvasView(Context context) {
        super(context);
        init();
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Log.i("CanvasView", "onDraw");

        if (layer != null) {
            layer.draw(canvas);
        }
        super.onDraw(canvas);

    }


    public void setType(int i) {
        type = i;
    }

    private void init() {

        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("CanvasView", "ActionDown");
                        layer.start(motionEvent.getX(), motionEvent.getY(), type);
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i("CanvasView", "ActionUp");
                        layer.end(motionEvent.getX(), motionEvent.getY());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.i("CanvasView", "ActionMove");
                        layer.update(motionEvent.getX(), motionEvent.getY());
                        break;
                }
                invalidate();
                return true;
            }
        });
    }

}
