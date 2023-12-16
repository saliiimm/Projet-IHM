import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import CustomButton.ButtonCustom;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    private CardLayout cardLayout;
    private JPanel details;
    private JPanel contBox;
    private JTextField memoireReferenceInput;
    private JTextField memoiretitleInput;
    private JTextField memoireprofessorInput;
    private String idProf;
;
    private MemoireDetails currentMemoireDetails;
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
     memoireReferenceInput=new JTextField() ;
    JLabel memoiretitleLabel=new JLabel("Enter Title:") ;
     memoiretitleInput=new JTextField() ;
    JLabel memoireprofessorLabel=new JLabel("Enter Professor:") ;
     memoireprofessorInput=new JTextField() ;
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
     memoiretitles.add(btnrecherche);



      memoiretitles.setLayout(new FlowLayout( FlowLayout.LEFT));
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        ul.setPreferredSize(new Dimension(400, 150));

        JButton homePanel = createLabelAndIconButton("Home", resizedIcon1);
        JButton bookPanel = createLabelAndIconButton("Professsors", resizedIcon5);
        JButton memoirePanel = createLabelAndIconButton("Memoire", resizedIcon2);
        JButton searchPanel = createLabelAndIconButton("Search", resizedIcon5);

        sideBar.setBackground(Color.WHITE);
        homePanel.setBackground(Color.WHITE);
        bookPanel.setBackground(Color.WHITE);
        memoirePanel.setBackground(Color.WHITE);
        searchPanel.setBackground(Color.WHITE);

        ul.add(homePanel);
        ul.add(bookPanel);
        ul.add(memoirePanel);
         cardLayout = new CardLayout();
       contBox=new JPanel(cardLayout);
      
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
     
           try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/porjet_ihm", "ihm", "ihm");

         List<String> pfes = getAllMemoires(connection);
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
       refreshMemoiresList(memoire, memoireScrollPane);
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



private List<String> getAllMemoires(Connection connection) {
    List<String> pfes = new ArrayList<>();
    String reference = memoireReferenceInput.getText();
    String memoiretitle = memoiretitleInput.getText();
    String memoireProfId = memoireprofessorInput.getText();

    if (memoiretitle == null) {
        memoiretitle = "";
    }
    if (reference == null) {
        reference = "";
    }

    if (memoireProfId.isEmpty()) {
        if (reference.isEmpty() && memoiretitle.isEmpty()) {
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM memoire")) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String title = resultSet.getString("titre");
                    String author = resultSet.getString("auteurs");
                    pfes.add(id + " - " + title + " - " + author);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            if (memoiretitle.isEmpty()) {
                String sql = "SELECT * FROM memoire WHERE  Codem LIKE ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, "%" + reference + "%");

                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            int id = resultSet.getInt("id");
                            String title = resultSet.getString("titre");
                            String author = resultSet.getString("auteurs");
                            pfes.add(id + " - " + title + " - " + author);
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                String sql = "SELECT * FROM memoire WHERE  titre LIKE ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, "%" + memoiretitle + "%");

                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            int id = resultSet.getInt("id");
                            String title = resultSet.getString("titre");
                            String author = resultSet.getString("auteurs");
                            pfes.add(id + " - " + title + " - " + author);
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    } else {
        // Professor search
        String idProf = ""; // Initialize idProf here
        String sqlProf = "SELECT * FROM enseignant WHERE fullName LIKE ?";
        try (PreparedStatement statementProf = connection.prepareStatement(sqlProf)) {
            statementProf.setString(1, "%" + memoireProfId + "%");

            try (ResultSet resultSetProf = statementProf.executeQuery()) {
                while (resultSetProf.next()) {
                    idProf = resultSetProf.getString("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (reference.isEmpty() && memoiretitle.isEmpty()) {
            // Only professor search
            String sql = "SELECT * FROM memoire WHERE profEncadrant LIKE ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "%" + idProf + "%");

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String title = resultSet.getString("titre");
                        String author = resultSet.getString("auteurs");
                        pfes.add(id + " - " + title + " - " + author);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            // Both professor and other criteria search
            if (memoiretitle.isEmpty()) {
                String sql = "SELECT * FROM memoire WHERE Codem LIKE ? AND profEncadrant LIKE ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, "%" + reference + "%");
                    statement.setString(2, "%" + idProf + "%");

                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            int id = resultSet.getInt("id");
                            String title = resultSet.getString("titre");
                            String author = resultSet.getString("auteurs");
                            pfes.add(id + " - " + title + " - " + author);
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                String sql = "SELECT * FROM memoire WHERE titre LIKE ? AND profEncadrant LIKE ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, "%" + memoiretitle + "%");
                    statement.setString(2, "%" + idProf + "%");

                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            int id = resultSet.getInt("id");
                            String title = resultSet.getString("titre");
                            String author = resultSet.getString("auteurs");
                            pfes.add(id + " - " + title + " - " + author);
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    return pfes;
}


private void refreshMemoiresList(JPanel memoire, JScrollPane memoireScrollPane) {
    // Récupérer la nouvelle liste des mémoires depuis la base de données
    List<String> pfes = getAllMemoires(connection);

    // Mettre à jour la liste des mémoires dans le panneau et la barre de défilement
    memoire.removeAll();
    memoire.add(memoiretitles);
    memoire.add(Box.createVerticalStrut(15));
    for (String pfe : pfes) {
        JPanel elmntBox1 = createListElementMemoire(pfe, memoire, memoireScrollPane);
        memoire.add(elmntBox1);
        memoire.add(Box.createVerticalStrut(15));
    }
    memoireScrollPane.setViewportView(memoire);
    memoire.revalidate();
    memoire.repaint();
}



private JPanel createListElementMemoire(String pfe, JPanel memoire, JScrollPane memoireScrollPane) {
    JPanel elmntBox1 = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width = 1100;
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
    int pfeId = Integer.parseInt(pfeInfo[0]);
    String title = pfeInfo[1];
    String author = pfeInfo[2].substring(0, pfeInfo[2].length());

    JLabel pfetitle = new JLabel(title);
    JLabel pfeauthors = new JLabel(author);

    pfetitle.setPreferredSize(new Dimension(250, 50));
    elmntBox1.add(pfetitle);
    pfeauthors.setPreferredSize(new Dimension(250, 50));
    elmntBox1.add(pfeauthors);
         ButtonCustom affichermemoire = new ButtonCustom();
    affichermemoire.setText("Afficher Details");
    affichermemoire.setStyle(ButtonCustom.ButtonStyle.PRIMARY);
    affichermemoire.setPreferredSize(new Dimension(150,30));
    elmntBox1.add(affichermemoire);

     affichermemoire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             
           showDetailsPanel(pfeId);         
    
            }

        });
   
            
 
    


    elmntBox1.setPreferredSize(new Dimension(1000, 100));

  
    return elmntBox1;
};

private List<MemoireDetails> getAllMemoiresDetails(Connection connection) {
    List<MemoireDetails> memoiresDetails = new ArrayList<>();
        

    try (Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM memoire")) {

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("titre");
            String author = resultSet.getString("auteurs");
            String profEncadrant = resultSet.getString("profEncadrant");
            String theme = resultSet.getString("theme");
            String pdfContent = resultSet.getString("pdfContent");
            String resume = resultSet.getString("resume");
            int annee = resultSet.getInt("annee");
            String codeM = resultSet.getString("Codem");

            // Créez un objet MemoireDetails pour stocker toutes les informations
            MemoireDetails memoireDetails = new MemoireDetails(id, title, author, profEncadrant, theme, pdfContent, resume, annee, codeM);

            // Ajoutez cet objet à la liste
            memoiresDetails.add(memoireDetails);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return memoiresDetails;
}

private void showDetailsPanel(int pfeId) {
        details = new JPanel();
            
    // Fetch detailed memoire data based on the selected pfeId
    MemoireDetails memoireDetails = getMemoireDetailsById(pfeId);
            
         //card
         JButton Ouvrir = new JButton("Ouvrir");
         Ouvrir.setBackground(Color.decode("#fa7c54"));
         Ouvrir.setForeground(Color.WHITE);
      Ouvrir.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Récupérer le contenu PDF à partir de MemoireDetails (utilisez la méthode getPDFContent)
        String pdfContent = memoireDetails.getPdfContent();

        // Appeler la méthode pour ouvrir le PDF
        openPdfContent(pdfContent);
    }
});
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
        JLabel titleD=new JLabel("");
       titleD.setFont(font2);
        JLabel AuteurD=new JLabel("");
         AuteurD.setFont(font3);
        JLabel encardarntD=new JLabel("");
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
        JTextArea resumé=new JTextArea("");
         JScrollPane scrollPane=new JScrollPane(resumé);
        resumé.setLineWrap(true);
        resumé.setEditable(false);
       
        
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
        
          titleD.setText("Title: " + memoireDetails.getTitle());
    Id.setText("ID: " + memoireDetails.getId());
    AuteurD.setText("Author: " + memoireDetails.getAuthor());
    encardarntD.setText("Supervisor: " + memoireDetails.getProfEncadrant());
    resumé.setText("Summary: " + memoireDetails.getResume());

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
       

         cardLayout.show(contBox, "Card4");

         contBox.add(details, "Card4");
}
private MemoireDetails getMemoireDetailsById(int pfeId) {
    // Fetch memoire details from the database based on the given ID
    String query = "SELECT * FROM memoire WHERE id = ?";
    String enseignantQuery = "SELECT fullName FROM enseignant WHERE id = ?";
    
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, pfeId);

        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("titre");
                String author = resultSet.getString("auteurs");
                
                // Utilisation de PreparedStatement pour la deuxième requête
                try (PreparedStatement statement2 = connection.prepareStatement(enseignantQuery)) {
                    String proffEncadrant = resultSet.getString("profEncadrant");
                    statement2.setString(1, proffEncadrant);
                    
                    try (ResultSet resultSet2 = statement2.executeQuery()) {
                        if (resultSet2.next()) {
                            String profEncadrant = resultSet2.getString("fullName");
                            String theme = resultSet.getString("theme");
                            String pdfContent = resultSet.getString("pdfContent");
                            String resume = resultSet.getString("resume");
                            int annee = resultSet.getInt("annee");
                            String codeM = resultSet.getString("Codem");

                            return new MemoireDetails(id, title, author, profEncadrant, theme, pdfContent, resume, annee, codeM);
                        }
                    }
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null; // Return null if memoire details are not found
}

public class MemoireDetails {
    private int id;
    private String title;
    private String author;
    private String profEncadrant;
    private String theme;
    private String pdfContent;
    private String resume;
    private int annee;
    private String codeM;

    // Constructors
    public MemoireDetails() {
    }

    public MemoireDetails(int id, String title, String author, String profEncadrant, String theme,
                          String pdfContent, String resume, int annee, String codeM) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.profEncadrant = profEncadrant;
        this.theme = theme;
        this.pdfContent = pdfContent;
        this.resume = resume;
        this.annee = annee;
        this.codeM = codeM;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProfEncadrant() {
        return profEncadrant;
    }

    public void setProfEncadrant(String profEncadrant) {
        this.profEncadrant = profEncadrant;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getPdfContent() {
        return pdfContent;
    }

    public void setPdfContent(String pdfContent) {
        this.pdfContent = pdfContent;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getCodeM() {
        return codeM;
    }

    public void setCodeM(String codeM) {
        this.codeM = codeM;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "MemoireDetails{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", profEncadrant='" + profEncadrant + '\'' +
                ", theme='" + theme + '\'' +
                ", pdfContent='" + pdfContent + '\'' +
                ", resume='" + resume + '\'' +
                ", annee=" + annee +
                ", codeM='" + codeM + '\'' +
                '}';
    }
}


private void openPdfContent(String pdfContent) {
    try {
        // Convertir la chaîne PDF en tableau de bytes
        byte[] pdfBytes = pdfContent.getBytes();

        // Charger le document PDF depuis le tableau de bytes
        PDDocument document = PDDocument.load(pdfBytes);

        // Utiliser PDFTextStripper pour extraire le texte du document
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        String text = pdfTextStripper.getText(document);

        // Fermer le document PDF
        document.close();

        // Afficher le texte (vous pouvez choisir comment afficher le texte, par exemple, dans une zone de texte ou une console)
        System.out.println(text);
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
        new MainPageClient();
    });
    }
}
