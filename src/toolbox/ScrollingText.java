package toolbox;
import java.awt.*;

/**
 * Created by Daniel on 20.03.15.
 */
public class scrollingText {
    double speed;
    double position;
    int fontSize;
    String fontName;
    String text;
    double direction;
    Graphics2D g2d;

    public scrollingText(double speed, int position, String fontName, String text, int direction, Graphics2D g2d, int fontSize) {
        this.speed = speed;
        this.position = position;
        this.fontName = fontName;
        this.text = text;
        this.direction = direction;
        this.g2d = g2d;
        this.fontSize = fontSize;
    }

    public void render() {
        FontMetrics FontMetrics = g2d.getFontMetrics(new Font(fontName, 0, fontSize));
        int fontWith = FontMetrics.stringWidth(text);
        //System.out.println(fontWith);

        g2d.setColor(new Color(0, 0, 0));

        g2d.fillRect(0, 0, 18, 10);
        g2d.setColor(new Color(0, 0, 255));
        g2d.setFont(new Font(fontName, 0, fontSize));
        g2d.drawString(text, (int) position, 8);
        position += direction * speed;
        if (position > 0) direction = -1;
        if (position < (-(fontWith-17))) direction = +1;
    }


    public void setText(String text, Boolean resetPosition) {
        this.text = text;
        if(resetPosition) position = 0;
    }
}

