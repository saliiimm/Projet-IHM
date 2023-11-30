import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;


import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

public class MainPage extends JFrame {
  
    public MainPage() {
        this.setTitle("My Book Shelf");
        setSize(1500, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel sideBar = new JPanel();
        sideBar.setBackground(Color.WHITE);

        sideBar.setPreferredSize(new Dimension(300, getHeight()));

        int padding = 10;
        sideBar.setBorder(new EmptyBorder(padding, padding, padding, padding));

        ImageIcon imageIcon = new ImageIcon("src/assets/logo.png");
        Image originalImage = imageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(150, 80, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        ImageIcon imageIcon4 = new ImageIcon("src/assets/gear-solid.png");
        Image originalImage4 = imageIcon4.getImage();
        Image resizedImage4 = originalImage4.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon4 = new ImageIcon(resizedImage4);

        ImageIcon imageIcon5 = new ImageIcon("src/assets/folder-solid.png");
        Image originalImage5 = imageIcon5.getImage();
        Image resizedImage5 = originalImage5.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon5 = new ImageIcon(resizedImage5);

        ImageIcon imageIcon6 = new ImageIcon("src/assets/search.png");
        Image originalImage6 = imageIcon6.getImage();
        Image resizedImage6 = originalImage6.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon6 = new ImageIcon(resizedImage6);

        ImageIcon imageIcon1 = new ImageIcon("src/assets/house-solid.png");
        Image originalImage1 = imageIcon1.getImage();
        Image resizedImage1 = originalImage1.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon1 = new ImageIcon(resizedImage1);

        ImageIcon imageIcon2 = new ImageIcon("src/assets/book-solid.png");
        Image originalImage2 = imageIcon2.getImage();
        Image resizedImage2 = originalImage2.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon2 = new ImageIcon(resizedImage2);

        JLabel label = new JLabel(resizedIcon);
        JPanel logo = new JPanel();
        logo.add(label);
        logo.setBackground(Color.WHITE);
        logo.setBorder(new EmptyBorder(0, 0, 50, 0));

        JPanel ul = new JPanel();
        ul.setLayout(new BoxLayout(ul, BoxLayout.Y_AXIS));
        ul.setBackground(Color.WHITE);
        JPanel search = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int width = getWidth();
                int height = getHeight();

                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width, height, 40, 40);
                g2d.setColor(Color.WHITE);
                g2d.fill(roundedRectangle);

                g2d.setColor(Color.WHITE);
                g2d.draw(roundedRectangle);

                g2d.dispose();
            }
        };

        JTextField searchField = new JTextField();
        searchField.setBorder(null);
        search.setBackground(Color.WHITE);

        String[] comboBoxItems = {"Item 1", "Item 2", "Item 3", "Item 4"};
        JComboBox<String> comboBox = new JComboBox<String>(comboBoxItems) {};
      UIManager.put("ComboBox.selectionBackground", new ColorUIResource(Color.ORANGE));
            comboBox.setEditable(true);
        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(Color.BLACK);
        comboBox.setBorder(null);
           
        comboBox.setBorder(BorderFactory.createEmptyBorder());
        comboBox.setPrototypeDisplayValue("Prototype");
       comboBox.setBackground(Color.WHITE);
       
       
        search.add(comboBox);

        search.add(searchField);
        JLabel img = new JLabel(resizedIcon6);
        search.add(img);
        search.setLayout(new BoxLayout(search, BoxLayout.X_AXIS));

        JPanel main = new JPanel();
        ul.setPreferredSize(new Dimension(300, 100));

        JPanel homePanel = createLabelAndIconPanel("Home", resizedIcon1);
        JPanel bookPanel = createLabelAndIconPanel("Book", resizedIcon2);
        JPanel memoirePanel = createLabelAndIconPanel("Memoire", resizedIcon5);
        JPanel settingPanel = createLabelAndIconPanel("Setting", resizedIcon4);

        sideBar.setBackground(Color.WHITE);
        homePanel.setBackground(Color.WHITE);
        bookPanel.setBackground(Color.WHITE);
        memoirePanel.setBackground(Color.WHITE);
        settingPanel.setBackground(Color.WHITE);

        ul.add(homePanel);
        ul.add(bookPanel);
        ul.add(memoirePanel);
        ul.add(settingPanel);
          JPanel contBox=new JPanel();
       JPanel elmntBox=new JPanel(){
          @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int width = getWidth();
                int height = getHeight();

                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width, height, 20, 20);
                g2d.setColor(Color.WHITE);
                g2d.fill(roundedRectangle);

                g2d.setColor(Color.WHITE);
                g2d.draw(roundedRectangle);

                g2d.dispose();
            }
       };
       elmntBox.setBackground(Color.WHITE);
           elmntBox.setLayout(new BoxLayout(elmntBox, BoxLayout.X_AXIS));
           elmntBox.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 30));
            contBox.add(elmntBox);
        
         
       JLabel titleBox=new JLabel("harry poter");
       JLabel auteurJLabel=new JLabel("auteur");
       ImageIcon icondeletIcon = new ImageIcon("src\\assets\\trash-solid.png");
         
        Image originalImageD = icondeletIcon.getImage();
        Image resizedImageD = originalImageD.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedIconD = new ImageIcon(resizedImageD);
       JButton btndeleButton=new JButton(){
          @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                int width = getWidth();
                int height = getHeight();

                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width, height, 20, 20);
                g2d.setColor(new Color(0xf2, 0x78, 0x51));
                g2d.fill(roundedRectangle);

                g2d.setColor(Color.WHITE);
                g2d.draw(roundedRectangle);

                g2d.dispose();
            }
            @Override
    public boolean isFocusPainted() {
        return false; // Remove focus indication
    }

    @Override
    public boolean isBorderPainted() {
        return false; // Remove default border
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Do not paint the default border
    }

 
    @Override
    public void setContentAreaFilled(boolean b) {
        // Avoid painting the background when the button is pressed
        super.setContentAreaFilled(false);
    }

    @Override
    public void setBorderPainted(boolean b) {
        // Remove the default border
        super.setBorderPainted(false);
    }
    @Override
    public ButtonModel getModel() {
        return new DefaultButtonModel() {
            @Override
            public boolean isRollover() {
                return false; // Remove the default rollover effect
            }
        };
    }

       };
       JLabel image=new JLabel(resizedIconD);
       btndeleButton.add(image);
       
      
     
       elmntBox.add(titleBox);
       elmntBox.add(auteurJLabel);
       elmntBox.add(btndeleButton);
        this.add(sideBar, BorderLayout.WEST);
        this.add(main, BorderLayout.CENTER);
        main.add(search, BorderLayout.NORTH);
        main.add(contBox, BorderLayout.CENTER);
    
        int parentWidth = main.getWidth();
        int childWidth = (int) (parentWidth * 0.8);
        search.setBorder(new EmptyBorder(padding, padding, padding, padding));
        search.setPreferredSize(new Dimension(childWidth, 50));
        sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));
        sideBar.add(logo);
        sideBar.add(Box.createVerticalStrut(5));
        sideBar.add(ul);

        for (int i = 1; i <= 15; i++) {
            JPanel emptyJPanel = new JPanel();
            emptyJPanel.setBackground(Color.WHITE);
            sideBar.add(emptyJPanel);
        }

        main.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int parentWidth = main.getWidth();
                int parentHeight = main.getHeight();
                int childWidth = (int) (parentWidth * 0.9);
                int childWidth2 = (int) (parentWidth * 0.8);
                searchField.setPreferredSize(new Dimension(childWidth2, 30));
                elmntBox.setPreferredSize(new Dimension(childWidth, 100));
                contBox.setPreferredSize(new Dimension(parentWidth, parentHeight));
                searchField.setBackground(Color.WHITE);
                search.setPreferredSize(new Dimension(childWidth, 50));
                search.revalidate();
            }
        });

        setVisible(true);
    }

    private JPanel createLabelAndIconPanel(String labelText, ImageIcon icon) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel label = new JLabel(labelText);
        Font font = new Font("Inter", Font.PLAIN, 20);
        label.setForeground(Color.decode("#C"));
        label.setFont(font);
        if (icon != null) {
            JLabel iconLabel = new JLabel(icon);
            panel.add(iconLabel);
            panel.add(Box.createRigidArea(new Dimension(5, 0)));
        }
        panel.setBorder(new EmptyBorder(0, 60, 0, 80));
        panel.add(label);
        return panel;
    }

    public static void main(String[] args) {
        new MainPage();
    }
}
