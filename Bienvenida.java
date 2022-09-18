import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.border.Border;

import Components.Button;

class RoundJTextField extends JTextField {
  private Shape shape;
  private int size;

    public RoundJTextField(int size) {
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


public class Bienvenida extends JFrame implements ActionListener {

  private JTextField field;
  private JLabel label1, label2, label3, label4;
  private JButton boton1;
  public static String texto = "";  

  public Bienvenida(){
    JPanel panel = new javax.swing.JPanel() {
      protected void paintComponent(Graphics g) {
          Paint p = new GradientPaint(0.0f, 0.0f, new Color(0,0, 0),
          getWidth(), getHeight(), new Color(3, 41, 77), true);
          Graphics2D g2d = (Graphics2D)g;
          g2d.setPaint(p);
          g2d.fillRect(0, 0, getWidth(), getHeight());
      }
    };


    setContentPane(panel);
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Bienvenido");
    // getContentPane().setBackground(new Color(0,0,0, 0));
    setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
    UIManager.put("Button.focus", new Color(0,0,0,0));
    UIManager.put("Button.select", new Color(0,0,0,0));
    UIManager.put("OptionPane.background", new Color(0,0,0));


    ImageIcon imagen = new ImageIcon("images/logo-coca.png");
    label1 = new JLabel(imagen);
    label1.setBounds(25,15,300,150);
    add(label1);

    label2 = new JLabel("Sistema de Control Vacacional");
    label2.setBounds(35,135,300,30);
    label2.setFont(new Font("Andale Mono", 3, 18));
    label2.setForeground(new Color(255,255,255));
    add(label2);

    label4 = new JLabel("�2017 The Coca-Cola Company");
    label4.setBounds(85,375,300,30);
    label4.setFont(new Font("Andale Mono", 1, 12));
    label4.setForeground(new Color(255,255,255));
    add(label4);

    label3 = new JLabel("Ingrese su nombre");
    label3.setBounds(50,212,200,30);
    label3.setFont(new Font("Andale Mono", 1, 12));
    label3.setForeground(new Color(255,255,255));
    add(label3);

    field = new RoundJTextField(25);
    field.setBounds(45,245,350,35);
    field.setBackground(new Color(255,255,255, 30));
    field.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    field.setFont(new Font("Andale Mono", 1, 14));
    field.setForeground(new Color(255, 255,255));
    add(field);


    boton1 = new Button("Ingresar", 25);
    boton1.setBounds(135,280,100,35);
    boton1.setBackground(new Color(14, 136, 249));
    boton1.setFont(new Font("Andale Mono", 1, 14));
    boton1.setForeground(new Color(255,255,255));
    boton1.addActionListener(this);
    add(boton1);
  }

   public void actionPerformed(ActionEvent e){
     if(e.getSource() == boton1){
       texto = field.getText().trim();
       if(texto.equals("")){
        //  JOptionPane.showMessageDialog(null, "Debes ingresar tu nombre.");
        label2.setVisible(false);
       } else {
        //  Licencia ventanalicencia = new Licencia();
        //  ventanalicencia.setBounds(0,0,600,360);
        //  ventanalicencia.setVisible(true);
        //  ventanalicencia.setResizable(false);
        //  ventanalicencia.setLocationRelativeTo(null);
        //  this.setVisible(false);
       }
     }
   }


   public static void main(String args[]){
     Bienvenida ventanabienvenida = new Bienvenida();

     ventanabienvenida.setBounds(0,0,550,750);
     ventanabienvenida.setVisible(true);
     ventanabienvenida.setResizable(false);
     ventanabienvenida.setLocationRelativeTo(null);
   }
}
