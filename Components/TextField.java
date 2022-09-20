package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class TextField extends JTextField {
  private Shape shape;
  private int size;

  public TextField(int size) {
    super(size);
    this.size = size;
    setOpaque(false); // As suggested by @AVD in comment.
    setCaretColor(new Color(255,255,255));
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
        0, 0, getWidth()-1, getHeight()-1, size, size 
      );
    }

    return shape.contains(x, y);
  }
}