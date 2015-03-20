package toolbox;
import java.awt.*;

/**
 * Created by Daniel on 20.03.15.
 */
public class drawText  {
    double xPosition;
    double yPosition;
    int fontSize;
    String fontName;
    String text;
    Graphics2D g2d;

    public drawText(double xPosition, double yPosition, int fontSize, String fontName, String text, Graphics2D g2d) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.fontSize = fontSize;
        this.fontName = fontName;
        this.text = text;
        this.g2d = g2d;
    }

    public void render(){
        g2d.setColor(new Color(0, 0, 0));
        g2d.fillRect(0, 0, 18, 10);
        g2d.setColor(new Color(0, 0, 255));
        g2d.setFont(new Font(fontName, 0, 14));
        g2d.drawString(text, (int) xPosition, (int) yPosition);

    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public void setText(String text) {
        this.text = text;
    }
}
