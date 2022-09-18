package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Button extends JButton {
  private Shape shape;
  private int size;

  public Button(String label, int size) {
    super(label);
    this.size = size;
    setOpaque(false); // As suggested by @AVD in comment.

    // this.addMouseListener(new MouseAdapter() {
    //   public void mouseEntered(MouseEvent evt) {
    //     setBackground(Color.GREEN);
    //   }

    //   public void mouseExited(MouseEvent evt) {
    //     setBackground(UIManager.getColor("control"));
    //   }
    // });
  }

  protected void paintComponent(Graphics g) {
    g.setColor(getBackground());
    g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, size, size);
    super.paintComponent(g);
  }

  protected void paintBorder(Graphics g) {
        g.setColor(getBackground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, size, size);
  }

  public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(
              0,
              0,
            getWidth()-1,
            getHeight()-1,
            size,
            size 
          );
        }

        return shape.contains(x, y);
  }

}

