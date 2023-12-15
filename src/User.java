import javax.swing.*;
import javax.swing.border.Border;

import java.awt.geom.RoundRectangle2D;
import java.awt.*;
public class User extends JFrame  {
    public  User() {
        //init
        setTitle("User");
        setSize(1500, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //import images
     //1
     ImageIcon user = new ImageIcon("src/assets/id-card.png");
     Image userOriginalImage = user.getImage();
     Image userResizedImage = userOriginalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
     ImageIcon userResizedIcon = new ImageIcon(userResizedImage);
     //2
     ImageIcon admin = new ImageIcon("src/assets/admin-panel.png");
     Image adminOriginalImage = admin.getImage();
     Image adminResizedImage = adminOriginalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
     ImageIcon adminResizedIcon = new ImageIcon(adminResizedImage);
     //3
     ImageIcon logo = new ImageIcon("src/assets/logo.png");
     Image logoOriginalImage = logo.getImage();
     Image logoResizedImage = logoOriginalImage.getScaledInstance(200, 120, Image.SCALE_SMOOTH);
     ImageIcon logoResizedIcon = new ImageIcon(logoResizedImage);

        //creation
      JButton User_Etudiant=new JButton();
      JButton User_Admin=new JButton();
      JPanel UserChoix=new JPanel(){
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width = getWidth();
            int height = getHeight();

            RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width, height, 30, 30);
            g2d.setColor(Color.WHITE);
            g2d.fill(roundedRectangle);

            g2d.setColor(Color.WHITE);
            g2d.draw(roundedRectangle);

            g2d.dispose();
        }
      };
      Box MainUserChoix = new Box(BoxLayout.Y_AXIS);
      JLabel userIcon=new JLabel(userResizedIcon);
      JLabel adminIcon=new JLabel(adminResizedIcon);
      JLabel logolJLabel=new JLabel(logoResizedIcon);
      JLabel message_choix=new JLabel(" se connecter en tant que ");
      JLabel message_user=new JLabel(" Visiteur");
      JLabel message_admin=new JLabel(" Admin");
    
       //add
       
         User_Admin.add(adminIcon);
      User_Etudiant.add(userIcon);
       User_Etudiant.add(message_user);
       User_Admin.add(message_admin);
        UserChoix.add(logolJLabel);
       
        UserChoix.add(message_choix);
      
       UserChoix.add(User_Etudiant);
       UserChoix.add(User_Admin);
      getContentPane().add(MainUserChoix);
    
      //style
   UserChoix.setBackground(Color.WHITE);
      //aligner text
      //1
      message_admin.setHorizontalAlignment(JLabel.CENTER);
      message_admin.setVerticalAlignment(JLabel.CENTER);
      //2
      message_user.setHorizontalAlignment(JLabel.CENTER);
      message_user.setVerticalAlignment(JLabel.CENTER);
      //taille
      message_admin.setPreferredSize(new Dimension(320,200));
      message_user.setPreferredSize(new Dimension(320,200));
      logolJLabel.setPreferredSize(new Dimension(1000,200));
    
      //font
      Font font = new Font("Inter", Font.PLAIN, 40);
      Font font2 = new Font("Inter", Font.PLAIN, 65);
      //1
      message_user.setForeground(Color.decode("#4D4D4D"));
      message_user.setFont(font);
      //2
      message_admin.setForeground(Color.decode("#4D4D4D"));
      message_admin.setFont(font);
      //
      message_choix.setForeground(Color.decode("#4D4D4D"));
      message_choix.setFont(font2);
      //aligner box
      MainUserChoix.setAlignmentX(JComponent.CENTER_ALIGNMENT);
      MainUserChoix.add(Box.createVerticalGlue());
      UserChoix.setAlignmentX(0.5f);
      UserChoix.setAlignmentY(0.5f);
      MainUserChoix.add(UserChoix);
      MainUserChoix.add(Box.createVerticalGlue());
      //taille box
      UserChoix.setMaximumSize(new Dimension(1200,600));
      UserChoix.setMinimumSize(new Dimension(1200,600));
      UserChoix.setPreferredSize(new Dimension(1200, 600));
      //style button
      User_Etudiant.setPreferredSize(new Dimension(500,200));
      User_Admin.setPreferredSize(new Dimension(500,200));
      User_Admin.setLayout(new GridLayout());
      User_Etudiant.setLayout(new GridLayout());
    

      Border roundedBorder = BorderFactory.createLineBorder(Color.decode("#fa7c54"), 2, true);
      User_Admin.setBorder(BorderFactory.createCompoundBorder(
              BorderFactory.createEmptyBorder(10, 20, 10, 20), // Ajoute des marges pour l'apparence
              new RoundBorder(15, roundedBorder)
      ));
      User_Etudiant.setBorder(BorderFactory.createCompoundBorder(
              BorderFactory.createEmptyBorder(10, 20, 10, 20), // Ajoute des marges pour l'apparence
              new RoundBorder(15, roundedBorder)
      ));

      //
      User_Etudiant.setContentAreaFilled(false);

      //2
      User_Admin.setContentAreaFilled(false);
  
    
     
      


        setVisible(true);
    } 
      static class RoundBorder implements Border {
        private int arcSize;
        private Border innerBorder;

        public RoundBorder(int arcSize, Border innerBorder) {
            this.arcSize = arcSize;
            this.innerBorder = innerBorder;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(0, 0, 0, 0);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Shape borderShape = new RoundRectangle2D.Double(x, y, width - 1, height - 1, arcSize, arcSize);

            if (innerBorder != null) {
                innerBorder.paintBorder(c, g, x, y, width, height);
            }
            g2d.setColor(Color.decode("#fa7c54"));
            g2d.draw(borderShape);
            g2d.dispose();
        }
    }
    public static void main(String[] args) {
        new User();
    }
}
