import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import CustomButton.ButtonCustom;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageClient extends JFrame {

    private JPanel titles;
    private JPanel memoiretitles;
    private Connection connection;

    public MainPageClient() {
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
     titles=new JPanel();
     memoiretitles = new JPanel();
    JLabel title=new JLabel("Full Name") ;
    JLabel Category=new JLabel("Specialité") ;
    JLabel memoirereferenceLabel=new JLabel("Enter Reference:") ;
    JTextField memoireReferenceInput=new JTextField() ;
    JLabel memoiretitleLabel=new JLabel("Enter Title:") ;
    JTextField memoiretitleInput=new JTextField() ;
    JLabel memoireprofessorLabel=new JLabel("Enter Professor:") ;
    JTextField memoireprofessorInput=new JTextField() ;
     ButtonCustom btnrecherche  = new ButtonCustom();
      btnrecherche.setText("Search");
    btnrecherche.setStyle(ButtonCustom.ButtonStyle.PRIMARY);
    btnrecherche.setPreferredSize(new Dimension(100,30));
      Font font = new Font("Inter", Font.PLAIN, 16);
        title.setFont(font);
        Category.setFont(font);
        memoirereferenceLabel.setFont(font);
        memoireReferenceInput.setFont(font);
        memoiretitleLabel.setFont(font);
        memoiretitleInput.setFont(font);
        memoireprofessorLabel.setFont(font);
        memoireReferenceInput.setFont(font);
        memoireprofessorInput.setFont(font);
        //professsor
     title.setPreferredSize(new Dimension(250, 50));
      Category.setPreferredSize(new Dimension(250, 50));

      //memoire
      memoirereferenceLabel.setPreferredSize(new Dimension(100, 20));
      memoireReferenceInput.setPreferredSize(new Dimension(100, 20));
      memoiretitleLabel.setPreferredSize(new Dimension(100, 20));
      memoiretitleInput.setPreferredSize(new Dimension(100, 20));
      memoireprofessorLabel.setPreferredSize(new Dimension(100, 20));
      memoireprofessorInput.setPreferredSize(new Dimension(100, 20));
    titles.add(title);
     titles.add(Category);
      titles.setLayout(new BoxLayout(titles, BoxLayout.X_AXIS));
     memoiretitles.add(memoirereferenceLabel);
     memoiretitles.add(memoireReferenceInput);
     memoiretitles.add(memoiretitleLabel);
     memoiretitles.add(memoiretitleInput);
     memoiretitles.add(memoireprofessorLabel);
     memoiretitles.add(memoireprofessorInput);
     memoiretitles.add(memoirereferenceLabel);
     memoiretitles.add(btnrecherche);



      memoiretitles.setLayout(new FlowLayout( FlowLayout.LEFT));
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        ul.setPreferredSize(new Dimension(300, 150));

        JButton homePanel = createLabelAndIconButton("Home", resizedIcon1);
        JButton bookPanel = createLabelAndIconButton("Book", resizedIcon2);
        JButton memoirePanel = createLabelAndIconButton("Memoire", resizedIcon5);
        JButton searchPanel = createLabelAndIconButton("Search", resizedIcon5);

        sideBar.setBackground(Color.WHITE);
        homePanel.setBackground(Color.WHITE);
        bookPanel.setBackground(Color.WHITE);
        memoirePanel.setBackground(Color.WHITE);
        searchPanel.setBackground(Color.WHITE);

        ul.add(homePanel);
        ul.add(bookPanel);
        ul.add(memoirePanel);
        CardLayout cardLayout = new CardLayout();
      JPanel contBox=new JPanel(cardLayout);
      
       JPanel techere = new JPanel();
       JPanel memoire = new JPanel();
       JPanel home=new JPanel();
       JPanel searchpanel=new JPanel();
                   
         

            titles.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 10));
            memoiretitles.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 10));
            
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
      

        //home
        home.setLayout(new BorderLayout());

        // Ajouter l'image centrée
        ImageIcon welcomeIcon = new ImageIcon("src/assets/welcomeimg.png");
        JLabel welcomeLabel = new JLabel(welcomeIcon);
        home.add(welcomeLabel, BorderLayout.CENTER);
        // Ajouter le JPanel "home" à votre conteneur principal
        contBox.add(home, "Card1");

        //techere
        techere.setLayout(new BoxLayout(techere, BoxLayout.Y_AXIS));
         techere.add(titles);
         JScrollPane techereScrollPane = new JScrollPane(techere,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
         
       try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/porjet_ihm", "ihm", "ihm");

        // Récupération de la liste des professeurs depuis la base de données
        List<String> professeurs = getAllProfesseurs(connection);
         techere.add(Box.createVerticalStrut(15));
        // Ajout des professeurs à la liste
        for (String professeur : professeurs) {
            JPanel elmntBox = createListElement(professeur, techere, techereScrollPane);
            techere.add(elmntBox);
            techere.add(Box.createVerticalStrut(15));
        }
    } catch (ClassNotFoundException | SQLException ex) {
        ex.printStackTrace(); 
    }



        
        contBox.add(techereScrollPane, "Card2");

         //memoire page 
       memoire.setLayout(new BoxLayout(memoire, BoxLayout.Y_AXIS));
      JScrollPane memoireScrollPane = new JScrollPane(memoire,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            // Get the values from the search fields
        String reference = memoireReferenceInput.getText();
        String memoiretitle = memoiretitleInput.getText();
        String professor = memoireprofessorInput.getText();
           try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/porjet_ihm", "ihm", "ihm");

         List<String> pfes = getAllMemoires(connection,reference,memoiretitle,professor);
         memoire.add(memoiretitles);
         memoire.add(Box.createVerticalStrut(15));
   
         for (String pfe : pfes) {
            JPanel elmntBox1 = createListElementMemoire(pfe, memoire, memoireScrollPane);
            memoire.add(elmntBox1);
            memoire.add(Box.createVerticalStrut(15));
        }
       } catch (ClassNotFoundException | SQLException ex) {
        ex.printStackTrace(); 
       }
         btnrecherche.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("search button clicked");
        refreshMemoiresList(memoire, memoireScrollPane, reference, memoiretitle, professor);
    }
});

    contBox.add(memoireScrollPane, "Card3");

      
    
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
             
                titles.setPreferredSize(new Dimension(childWidth, 50));
                memoiretitles.setPreferredSize(new Dimension(childWidth, 50));
                contBox.setPreferredSize(new Dimension(parentWidth, parentHeight));
                searchField.setBackground(Color.WHITE);
                search.setPreferredSize(new Dimension(childWidth, 50));
                search.revalidate();
            }
        });
            contBox.add(home,"Card1");
            contBox.add(techereScrollPane,"Card2");
            contBox.add(memoireScrollPane,"Card3");
            contBox.add(searchpanel, "Card4");

           

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


private List<String> getAllProfesseurs(Connection connection) {


    List<String> professeurs = new ArrayList<>();

    try (Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM enseignant")) {

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String fullName = resultSet.getString("fullName");
            String specialite = resultSet.getString("specialite");

            // Ajout du professeur à la liste
            professeurs.add(id + " - " + fullName + " - " + specialite + "");
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Log or handle the exception appropriately
    }

    return professeurs;
}




private JPanel createListElement(String professeur, JPanel techere, JScrollPane techereScrollPane) {
     
 JPanel elmntBox = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width =700;
            int height = 70;

            RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(20, 0, width, height, 20, 20);
            g2d.setColor(Color.WHITE);
            g2d.fill(roundedRectangle);

            g2d.setColor(Color.WHITE);
            g2d.draw(roundedRectangle);

            g2d.dispose();
        }
    };
    elmntBox.setBackground(Color.WHITE);
    elmntBox.setLayout(new BoxLayout(elmntBox, BoxLayout.X_AXIS));
    elmntBox.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 10));

    String[] professeurInfo = professeur.split(" - ");
        String fullName = professeurInfo[1];
        String specialite = professeurInfo[2].substring(0, professeurInfo[2].length());

        JLabel proffullName = new JLabel(fullName);
        JLabel profSpecialite = new JLabel(specialite);

        proffullName.setPreferredSize(new Dimension(250, 50));
        elmntBox.add(proffullName);
        profSpecialite.setPreferredSize(new Dimension(250, 50));
        elmntBox.add(profSpecialite);

           

    return elmntBox;
};



private List<String> getAllMemoires(Connection connection, String reference, String memoiretitle, String professor) {
    List<String> pfes = new ArrayList<>();

    try (Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM memoire WHERE " +
                "Codem LIKE '%" + reference + "%' AND titre LIKE '%" + memoiretitle + "%' AND profEncadrant LIKE '%" + professor + "%'")) {

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String memoireTitle = resultSet.getString("title");
            String author = resultSet.getString("auteurs");
            String profId = resultSet.getString("profEncadrant");
            String cote = resultSet.getString("Codem");

            pfes.add(id + " - " + memoireTitle + " - " + author + "-" + profId + "-" + cote);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return pfes;
}


private void refreshMemoiresList(JPanel memoire, JScrollPane memoireScrollPane, String reference, String title, String professor) {
    List<String> pfes = getAllMemoires(connection, reference, title, professor);

    // Mettre à jour la liste des mémoires dans le panneau et la barre de défilement
    memoire.removeAll();
    memoire.add(memoiretitles);
    memoire.add(Box.createVerticalStrut(15));
    for (String pfe : pfes) {
        JPanel elmntBox1 = createListElementMemoire(pfe, memoire, memoireScrollPane);
        memoire.add(elmntBox1);
        memoire.add(Box.createVerticalStrut(15));
    }

    // Mettre à jour la barre de défilement
    memoireScrollPane.setViewportView(memoire);
    memoire.revalidate();
    memoire.repaint();
}


// Update the createMemoirePanel method to take a list of Memoire objects
private JPanel createListElementMemoire(String pfe, JPanel memoire, JScrollPane memoireScrollPane) {
     
 JPanel elmntBox1 = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width =900;
            int height = 70;

            RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(20, 0, width, height, 20, 20);
            g2d.setColor(Color.WHITE);
            g2d.fill(roundedRectangle);

            g2d.setColor(Color.WHITE);
            g2d.draw(roundedRectangle);

            g2d.dispose();
        }
    };
    elmntBox1.setBackground(Color.WHITE);
    elmntBox1.setLayout(new BoxLayout(elmntBox1, BoxLayout.X_AXIS));
    elmntBox1.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 10));

    String[] pfeInfo = pfe.split(" - ");
        String pfeetitle = pfeInfo[1];
        String author = pfeInfo[2].substring(0, pfeInfo[2].length());
       String pfereference = pfeInfo[4];
       String profId = pfeInfo[3];
     

        JLabel pfetitle = new JLabel(pfeetitle);
        JLabel pfeauthors = new JLabel(author);

        pfetitle.setPreferredSize(new Dimension(250, 50));
        elmntBox1.add(pfetitle);
        pfeauthors.setPreferredSize(new Dimension(250, 50));
        elmntBox1.add(pfeauthors);
         ButtonCustom btnAffichermemoire  = new ButtonCustom();
    btnAffichermemoire.setText("Ouvrir");
    btnAffichermemoire.setStyle(ButtonCustom.ButtonStyle.PRIMARY);
    btnAffichermemoire.setPreferredSize(new Dimension(100,30));
    elmntBox1.add(btnAffichermemoire);  
    elmntBox1.setPreferredSize(new Dimension(1000, 100));

  
    return elmntBox1;
};

    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
        new MainPageClient();
    });
    }
}
