package ninja.terrorbyte.mydrawingcanvas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void updateCanvasDrawableType(int i) {
        CanvasView view = (CanvasView) findViewById(R.id.canvasView);
        view.setType(i);
    }

    public void setRectangle(View view) {
        updateCanvasDrawableType(2);
    }

    public void setLine(View view) {
        updateCanvasDrawableType(1);
    }
}
