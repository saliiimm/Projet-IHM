import java.awt.*;
import javax.swing.*;


public class App {

    //LogIn page:
 class ImagePanel extends JPanel {

  private Image img;

  public ImagePanel(String img) {
    this(new ImageIcon(img).getImage());
  }

  public ImagePanel(Image image) {
    this.img = image;
    Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }

  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
  }



}

}