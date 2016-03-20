package ninja.terrorbyte.mydrawingcanvas;


public class DrawableFactory {

    static Drawable createDrawable() {
        return new Line();
    }

    static Drawable createDrawable(int type) {

        switch (type) {
            case 1:
                return new Line();
            case 2:
                return new Rectangle();
            default:
                return new Line();
        }
    }
}
