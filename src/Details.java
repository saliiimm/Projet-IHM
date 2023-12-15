import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Details extends JFrame {
  
    public Details() {
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
        JComboBox<String> ComboBox1 = new JComboBox<String>(comboBoxItems) {};
        JComboBox<String> ComboBox2 = new JComboBox<String>(comboBoxItems) {};
      //style combobox
      //1
      UIManager.put("ComboBox.selectionBackground", new ColorUIResource(Color.ORANGE));
            comboBox.setEditable(true);
        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(Color.BLACK);
        comboBox.setBorder(null);
           
        comboBox.setBorder(BorderFactory.createEmptyBorder());
        comboBox.setPrototypeDisplayValue("Prototype");
       comboBox.setBackground(Color.WHITE);
       //2
         UIManager.put("ComboBox1.selectionBackground", new ColorUIResource(Color.ORANGE));
            ComboBox1.setEditable(true);
        ComboBox1.setBackground(Color.WHITE);
        ComboBox1.setForeground(Color.BLACK);
        ComboBox1.setBorder(null);
           
        ComboBox1.setBorder(BorderFactory.createEmptyBorder());
        ComboBox1.setPrototypeDisplayValue("Prototype");
       ComboBox1.setBackground(Color.WHITE);
       //3
         UIManager.put("ComboBox2.selectionBackground", new ColorUIResource(Color.ORANGE));
            ComboBox2.setEditable(true);
        ComboBox2.setBackground(Color.WHITE);
        ComboBox2.setForeground(Color.BLACK);
        ComboBox2.setBorder(null);
           
        ComboBox2.setBorder(BorderFactory.createEmptyBorder());
        ComboBox2.setPrototypeDisplayValue("Prototype");
       ComboBox2.setBackground(Color.WHITE);
       //haut conetent
       JPanel contentPane = new JPanel() ;
       contentPane.add(search);


        search.add(comboBox);
        contentPane.add(ComboBox1);
        contentPane.add(ComboBox2);

        search.add(searchField);
        JLabel img = new JLabel(resizedIcon6);
        search.add(img);
        search.setLayout(new BoxLayout(search, BoxLayout.X_AXIS));
    JPanel titles=new JPanel();
    JLabel title=new JLabel("Full Name") ;
    JLabel Category=new JLabel("Specialiter") ;
    JLabel edite=new JLabel("edite") ;
    JLabel delete=new JLabel("delete") ;
      Font font = new Font("Inter", Font.PLAIN, 16);
        title.setFont(font);
        Category.setFont(font);
        edite.setFont(font);
        delete.setFont(font);
     title.setPreferredSize(new Dimension(100, 100));
      Category.setPreferredSize(new Dimension(100, 100));
       edite.setPreferredSize(new Dimension(100, 100));
        delete.setPreferredSize(new Dimension(100, 100));
    titles.add(title);
     titles.add(Category);
     titles.add(edite);
    titles.add(delete);
      titles.setLayout(new BoxLayout(titles, BoxLayout.X_AXIS));
        JPanel main = new JPanel();
        ul.setPreferredSize(new Dimension(300, 100));

        JButton homePanel = createLabelAndIconButton("Home", resizedIcon1);
        JButton bookPanel = createLabelAndIconButton("Book", resizedIcon2);
        JButton memoirePanel = createLabelAndIconButton("Memoire", resizedIcon5);
        JButton settingPanel = createLabelAndIconButton("Setting", resizedIcon4);

        sideBar.setBackground(Color.WHITE);
        homePanel.setBackground(Color.WHITE);
        bookPanel.setBackground(Color.WHITE);
        memoirePanel.setBackground(Color.WHITE);
        settingPanel.setBackground(Color.WHITE);

        ul.add(homePanel);
        ul.add(bookPanel);
        ul.add(memoirePanel);
        ul.add(settingPanel);
        CardLayout cardLayout = new CardLayout();
          JPanel contBox=new JPanel(cardLayout);
      
       JPanel techere = new JPanel();
       JPanel memoire = new JPanel();
     
          
          JPanel home=new JPanel(); 


          //////
          ///////
          ////// DETAILS PAGE 
         JPanel details=new JPanel(); 
         //card
         JButton Ouvrir = new JButton("Ouvrir");
         Ouvrir.setBackground(Color.decode("#fa7c54"));
         Ouvrir.setForeground(Color.WHITE);
      
         JPanel BottomCard=new JPanel();
         JPanel imageD=new JPanel();
         JPanel cardMemoire2=new JPanel(){
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
         cardMemoire2.setLayout(new BoxLayout(cardMemoire2, BoxLayout.Y_AXIS));
        

         cardMemoire2.add(imageD);
         cardMemoire2.add(Box.createVerticalStrut(20));
         cardMemoire2.add(BottomCard);
         BottomCard.add(Ouvrir);
        cardMemoire2.add(Box.createVerticalStrut(5));
       
        BottomCard.setBackground(Color.WHITE);
        imageD.setPreferredSize(new Dimension(300,400));
        cardMemoire2.setBorder(new EmptyBorder(15,15,15,15)); 
        cardMemoire2.setPreferredSize(new Dimension(350, 510));
        cardMemoire2.setBackground(Color.WHITE);
        Ouvrir.setBorder(new EmptyBorder(10, 40, 10, 40));  
        
        // right 
        
        //info
        JPanel Right =new JPanel();
        Right.setBorder(new EmptyBorder(0, 20, 0, 0));  
          Right.setPreferredSize(new Dimension(600,510));
          Font font2 = new Font("Inter", Font.PLAIN, 30);
          Font font3 = new Font("Inter", Font.PLAIN, 20);
        JLabel Id=new JLabel("Id: 12 ");
        Id.setFont(font3);
        JLabel titleD=new JLabel("TITRE TU CONNAIS ");
       titleD.setFont(font2);
        JLabel AuteurD=new JLabel("Auteur: double s skara f soundous");
         AuteurD.setFont(font3);
        JLabel encardarntD=new JLabel("Encardarnt: Mr stl3");
              encardarntD.setFont(font3);   
        Id.setPreferredSize(new Dimension(570,50));
        titleD.setPreferredSize(new Dimension(570,50));
        AuteurD.setPreferredSize(new Dimension(570,50));
        encardarntD.setPreferredSize(new Dimension(570,50));
  
        //resumer
        
        JPanel resumerJPanel=new JPanel(){
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
       
             resumerJPanel.setBorder(new EmptyBorder(20, 20, 20, 20));  
             JLabel resumerTitle=new JLabel("Resumer");
             resumerTitle.setFont(font2);
             resumerTitle.setForeground(Color.decode("#fa7c54"));
        JTextArea resumerd=new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem jjsjsjsjjsjjsjsjsjjsjsjsjsjsjsjsjjssj jssjsjsj jsjsj zkoej jen jnie zeidei eidiejfi dizid ndinez nieijieddjeidn jlagetbd dkp sokjd i kdjdzo kdodked Lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem jjsjsjsjjsjjsjsjsjjsjsjsjsjsjsjsjjssj jssjsjsj jsjsj zkoej jen jnie zeidei eidiejfi dizid ndinez nieijieddjeidn jlagetbd dkp sokjd i kdjdzo kdodkedLorem ipsum dolor sit amet, consectetur adipiscing elit Lorem jjsjsjsjjsjjsjsjsjjsjsjsjsjsjsjsjjssj jssjsjsj jsjsj zkoej jen jnie zeidei eidiejfi dizid ndinez nieijieddjeidn jlagetbd dkp sokjd i kdjdzo kdodked Lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem jjsjsjsjjsjjsjsjsjjsjsjsjsjsjsjsjjssj jssjsjsj jsjsj zkoej jen jnie zeidei eidiejfi dizid ndinez nieijieddjeidn jlagetbd dkp sokjd i kdjdzo kdodked jjsjsjsjsjsjsjsjjssj jssjsjsj jsjsj zkoej jen jnie zeidei eidiejfi dizid ndinez nieijieddjeidn jlagetbd dkp sokjd i kdjdzo kdodked Lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem jjsjsjsjjsjjsjsjsjjsjsjsjsjsjsjsjjssj jssjsjsj jsjsj zkoej jen jnie zeidei eidiejfi dizid ndinez nieijieddjeidn jlagetbd dkp sokjd i kdjdzo kdodked p sokjd i kdjdzo kdodked Lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem jjsjsjsjjsjjsjsjsjjsjsjsjsjsjsjsjjssj jssjsjsj jsjsj zkoej jen jnie zeidei eidiejfi dizid ndinez nieijieddjeidn jlagetbd dkp sokjd i kdjdzo kdodkep sokjd i kdjdzo kdodked Lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem jjsjsjsjjsjjsjsjsjjsjsjsjsjsjsjsjjssj jssjsjsj jsjsj zkoej jen jnie zeidei eidiejfi dizid ndinez nieijieddjeidn jlagetbd dkp sokjd i kdjdzo kdodke jjsjsjsjjsjsjsjsjsjsjsjjssj jssjsjsj jsjsj zkoej jen jnie zeidei eidiejfi dizid ndinez nieijieddjeidn jlagetbd dkp sokjd i k jjsjsjsjjsjsjsjsjsjsjsjjssj jssjsjsj jsjsj zkoej jen jnie zeidei eidiejfi dizid ndinez nieijieddjeidn jlagetbd dkp sokjd i k jjsjsjsjjsjsjsjsjsjsjsjjssj jssjsjsj jsjsj zkoej jen jnie zeidei eidiejfi dizid ndinez nieijieddjeidn jlagetbd dkp sokjd i k");
         JScrollPane scrollPane=new JScrollPane(resumerd);
        resumerd.setLineWrap(true);
        resumerd.setEditable(false);
       
        
        scrollPane.setPreferredSize(new Dimension(550,200));
        scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
        scrollPane.getHorizontalScrollBar().setBackground(Color.WHITE);
        javax.swing.UIManager.put("ScrollBar.thumb", new javax.swing.plaf.ColorUIResource(250,124,84));
javax.swing.UIManager.put("Button.foreground", new javax.swing.plaf.ColorUIResource(250,124,84));
          scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
    @Override
    protected void configureScrollBarColors() {
        this.thumbColor = Color.decode("#fa7c54");
    }
});
        resumerJPanel.setPreferredSize(new Dimension(570,280));
     
        resumerJPanel.setBackground(Color.WHITE);;
        
      //add 
    resumerJPanel.add(resumerTitle); 
    
    resumerJPanel.add(scrollPane); 
   
     
      Right.add(titleD); 
       Right.add(Id); 
      Right.add(AuteurD); 
      Right.add(encardarntD); 
      Right.add(resumerJPanel); 
       details.add(cardMemoire2);
      
       details.add(Right);


         
         ///////// FIN DETAILS
               titles.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 30));
            contBox.add(details,"details");
            contBox.add(home,"Card1");
            contBox.add(techere,"Card2");
            contBox.add(memoire,"Card3");
        //switch card
        homePanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contBox, "Card1");
            }
        });
        bookPanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contBox, "Card2");
            }
        });
        memoirePanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contBox, "Card3");
            }
        });
        //techere
         techere.add(titles);
          for(int i=0;i<16;i++){
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
             JLabel titleBox=new JLabel("gaceb kda mna");
       JLabel auteurJLabel=new JLabel("IA");
      
            elmntBox.add(titleBox);
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
       JButton btnEdite=new JButton(){
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
        ImageIcon iconEdit = new ImageIcon("src\\assets\\edit.png");
         
        Image originalImageE = iconEdit.getImage();
        Image resizedImageE = originalImageE.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedIconE = new ImageIcon(resizedImageE);
       JLabel image=new JLabel(resizedIconD);
       JLabel image3=new JLabel(resizedIconE);
       btndeleButton.add(image);
       btnEdite.add(image3);
        titleBox.setPreferredSize(new Dimension(100, 50));
     auteurJLabel.setPreferredSize(new Dimension(100, 50));

       elmntBox.add(auteurJLabel);
    
       elmntBox.add(btnEdite);
       elmntBox.add(btndeleButton);
       
          elmntBox.setPreferredSize(new Dimension(1050, 100));
 techere.add(elmntBox);}

         //memoire page 
        memoire.setLayout(new GridLayout(0, 6, 20, 40));
         memoire.setBorder(new EmptyBorder(50,70,5,70));
         
        for(int j=0;j<16;j++){
        
             JLabel memoireTitle = new JLabel("Comment avoir 0 en ps");
         JLabel memoireAuteur=new JLabel("salim ghalem");
         JPanel image2=new JPanel();
         JPanel cardMemoire=new JPanel(){
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
         cardMemoire.setLayout(new BoxLayout(cardMemoire, BoxLayout.Y_AXIS));
        

         cardMemoire.add(image2);
         cardMemoire.add(Box.createVerticalStrut(20));
         cardMemoire.add(memoireTitle);
            cardMemoire.add(Box.createVerticalStrut(5));
         cardMemoire.add(memoireAuteur);
         cardMemoire.add(Box.createVerticalStrut(5));
         memoire.add(cardMemoire);
         image2.setPreferredSize(new Dimension(80, 200));
        
       
      
        
                
                     cardMemoire.setBorder(new EmptyBorder(5,5,5,5));
       
     cardMemoire.setPreferredSize(new Dimension(90, 210));
         cardMemoire.setBackground(Color.WHITE);
        }
     
        
      
      
    
     
      
        this.add(sideBar, BorderLayout.WEST);
        this.add(main, BorderLayout.CENTER);
        main.add(contentPane, BorderLayout.NORTH);
       
        main.add(contBox, BorderLayout.CENTER);
    
      
        search.setBorder(new EmptyBorder(padding, padding, padding, padding));
        
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
             
                titles.setPreferredSize(new Dimension(childWidth, 100));
                contBox.setPreferredSize(new Dimension(parentWidth, parentHeight));
                searchField.setBackground(Color.WHITE);
                contentPane.setPreferredSize(new Dimension(childWidth, 100));
                search.setPreferredSize(new Dimension((childWidth*2)/3, 50));
                search.revalidate();
            }
        });

        setVisible(true);
    }

  private JButton createLabelAndIconButton(String labelText, ImageIcon icon) {
    JButton button = new JButton(labelText, icon);
    Font font = new Font("Inter", Font.PLAIN, 20);
    button.setForeground(Color.decode("#C"));
    button.setFont(font);
    button.setBorderPainted(false);
    button.setContentAreaFilled(false);
    
    

    return button;
}

    public static void main(String[] args) {
        new Details();
    }
}
