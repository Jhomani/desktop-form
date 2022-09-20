import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import Components.Button;
import Components.TextField;

public class CreateDessert extends JFrame implements ActionListener {

  private JTextField nameField, detailField, priceField;
  private JButton sendBtn;
  public static String texto = "";  

  private void config() {
    UIManager.put("Button.focus", new Color(0,0,0,0));
    UIManager.put("Button.select", new Color(0,0,0,0));
    UIManager.put("OptionPane.background", new Color(0,0,0));

    JPanel panel = new JPanel() {
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
    setTitle("Postre Form");
    setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
  }

  public CreateDessert(){
    int cursor = 35;
    config();

    ImageIcon imagen = new ImageIcon("images/logo2.png");
    JLabel logo = new JLabel(imagen);
    logo.setBounds(Constants.middle(300), cursor, 300,150);
    add(logo);

    cursor += 200;

    JLabel name = new JLabel("Enter the name");
    name.setBounds(110,cursor,200,30);
    name.setFont(new Font("Andale Mono", 1, 12));
    name.setForeground(new Color(255,255,255));
    add(name);
    cursor += 35;
    nameField = new TextField(25);
    nameField.setBounds(Constants.middle(350), cursor, 350, 35);
    nameField.setBackground(new Color(255,255,255, 30));
    nameField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    nameField.setFont(new Font("Andale Mono", 1, 14));
    nameField.setForeground(new Color(255, 255,255));
    add(nameField);

    cursor += 60;

    JLabel description = new JLabel("Description (optional)");
    description.setBounds(110,cursor,200,30);
    description.setFont(new Font("Andale Mono", 1, 12));
    description.setForeground(new Color(255,255,255));
    add(description);
    cursor += 35;
    detailField = new TextField(25);
    detailField.setBounds(Constants.middle(350), cursor, 350, 35);
    detailField.setBackground(new Color(255,255,255, 30));
    detailField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    detailField.setFont(new Font("Andale Mono", 1, 14));
    detailField.setForeground(new Color(255, 255,255));
    add(detailField);

    cursor += 60;

    JLabel price = new JLabel("Enter the price");
    price.setBounds(110,cursor,200,30);
    price.setFont(new Font("Andale Mono", 1, 12));
    price.setForeground(new Color(255,255,255));
    add(price);
    cursor += 35;
    priceField = new TextField(25);
    priceField.setBounds(Constants.middle(350), cursor, 350, 35);
    priceField.setBackground(new Color(255,255,255, 30));
    priceField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    priceField.setFont(new Font("Andale Mono", 1, 14));
    priceField.setForeground(new Color(255, 255,255));
    add(priceField);

    cursor += 90;

    sendBtn = new Button("Add Product", 25);
    sendBtn.setBounds(Constants.middle(150), cursor, 150, 35);
    sendBtn.setBackground(new Color(14, 136, 249));
    sendBtn.setFont(new Font("Andale Mono", 1, 14));
    sendBtn.setForeground(new Color(255,255,255));
    sendBtn.addActionListener(this);
    add(sendBtn);
  }

   public void actionPerformed(ActionEvent e){
     if(e.getSource() == sendBtn){

      float price = Float.parseFloat(priceField.getText());

      MySQL.create(
        new Dessert(
          nameField.getText(),
          detailField.getText(),
          price
        )
      );
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
