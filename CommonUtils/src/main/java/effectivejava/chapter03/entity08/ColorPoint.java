package effectivejava.chapter03.entity08;

import java.awt.*;

/**
 * Created by liguodong on 2016/12/7.
 */
public class ColorPoint extends  Point{

    private Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }
    //Remainder omitted
}
