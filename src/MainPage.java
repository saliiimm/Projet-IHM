import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import CustomButton.ButtonCustom;
import CustomJComboBox.ComboBoxSuggestion;
import org.apache.commons.io.FileUtils;
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
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainPage extends JFrame {

    private JPanel titles;
    private JPanel memoiretitles;
    private Connection connection;

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
     titles=new JPanel();
     memoiretitles = new JPanel();
    JLabel title=new JLabel("Full Name") ;
    JLabel Category=new JLabel("Specialité") ;
    JLabel edite=new JLabel("Modifier") ;
    JLabel delete=new JLabel("Supprimer") ;
    JLabel memoiretitle=new JLabel("PFE title") ;
    JLabel memoireauthors=new JLabel("PFE authors ") ;
    JLabel memoireedite=new JLabel("Modifier") ;
    JLabel memoiredelete=new JLabel("Supprimer") ;
      Font font = new Font("Inter", Font.PLAIN, 16);
        title.setFont(font);
        Category.setFont(font);
        edite.setFont(font);
        delete.setFont(font);
        memoiretitle.setFont(font);
        memoireauthors.setFont(font);
        memoireedite.setFont(font);
        memoiredelete.setFont(font);
     title.setPreferredSize(new Dimension(250, 50));
      Category.setPreferredSize(new Dimension(250, 50));
       edite.setPreferredSize(new Dimension(70, 50));
        delete.setPreferredSize(new Dimension(80, 50));
         memoiretitle.setPreferredSize(new Dimension(250, 50));
      memoireauthors.setPreferredSize(new Dimension(250, 50));
       memoireedite.setPreferredSize(new Dimension(70, 50));
        memoiredelete.setPreferredSize(new Dimension(80, 50));
    titles.add(title);
     titles.add(Category);
     titles.add(edite);
    titles.add(delete);
      titles.setLayout(new BoxLayout(titles, BoxLayout.X_AXIS));
        memoiretitles.add(memoiretitle);
     memoiretitles.add(memoireauthors);
     memoiretitles.add(memoireedite);
    memoiretitles.add(memoiredelete);
      memoiretitles.setLayout(new BoxLayout(memoiretitles, BoxLayout.X_AXIS));
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

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
      memoire.add(memoiretitles);
      JScrollPane memoireScrollPane = new JScrollPane(memoire,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

           try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/porjet_ihm", "ihm", "ihm");

         List<String> pfes = getAllMemoires(connection);

         memoire.add(Box.createVerticalStrut(15));
   
         for (String pfe : pfes) {
            JPanel elmntBox1 = createListElementMemoire(pfe, memoire, memoireScrollPane);
            memoire.add(elmntBox1);
            memoire.add(Box.createVerticalStrut(15));
        }
       } catch (ClassNotFoundException | SQLException ex) {
        ex.printStackTrace(); 
       }

       contBox.add(memoireScrollPane, "Card3");

    
        this.add(sideBar, BorderLayout.WEST);
        this.add(main, BorderLayout.CENTER);
        main.add(search, BorderLayout.NORTH);
        
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
             
                titles.setPreferredSize(new Dimension(childWidth, 50));
                memoiretitles.setPreferredSize(new Dimension(childWidth, 50));
                contBox.setPreferredSize(new Dimension(parentWidth, parentHeight));
                searchField.setBackground(Color.WHITE);
                contentPane.setPreferredSize(new Dimension(childWidth, 100));
                search.setPreferredSize(new Dimension((childWidth*2)/3, 50));
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


private void refreshProfesseursList(JPanel techere, JScrollPane techereScrollPane) {
    // Récupérer la nouvelle liste des professeurs depuis la base de données
    List<String> professeurs = getAllProfesseurs(connection);

    // Mettre à jour la liste des professeurs dans le panneau et la barre de défilement
    techere.removeAll();
    techere.add(titles);
    techere.add(Box.createVerticalStrut(15));
    for (String professeur : professeurs) {
        JPanel elmntBox = createListElement(professeur, techere, techereScrollPane);
        techere.add(elmntBox);
        techere.add(Box.createVerticalStrut(15));
    }

    // Mettre à jour la barre de défilement
    techereScrollPane.setViewportView(techere);
    techere.revalidate();
    techere.repaint();
}

private JPanel createListElement(String professeur, JPanel techere, JScrollPane techereScrollPane) {
     
 JPanel elmntBox = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width =1100;
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


   

    // Bouton de modification
    ButtonCustom btnEdit  = new ButtonCustom();
    btnEdit.setText("Edit");
    btnEdit.setStyle(ButtonCustom.ButtonStyle.PRIMARY);
    btnEdit.setPreferredSize(new Dimension(100,30));

    btnEdit.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
    System.out.println("Edit button clicked");
    String[] professeurInfoUpdate = professeur.split(" - ");
    int professeurId = Integer.parseInt(professeurInfo[0]);

    JTextField fullNameField = new JTextField();
    JTextField specialiteField = new JTextField();

    fullNameField.setText(professeurInfoUpdate[1]);
    specialiteField.setText(professeurInfoUpdate[2].substring(0, professeurInfoUpdate[2].length()));

    Object[] fields = {"Full Name:", fullNameField, "Specialité:", specialiteField};
    int result = JOptionPane.showConfirmDialog(null, fields, "Modifier le professeur", JOptionPane.OK_CANCEL_OPTION);

    if (result == JOptionPane.OK_OPTION) {
        String newFullName = fullNameField.getText();
        String newSpecialite = specialiteField.getText();

        try (Statement statement = connection.createStatement()) {
            String updateProfQuery = "UPDATE enseignant SET fullName = '" + newFullName + "', specialite = '" + newSpecialite + "' WHERE id = " + professeurId;
            statement.executeUpdate(updateProfQuery);

            // Refresh the interface after modification
            refreshProfesseursList(techere,techereScrollPane);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }
    });

    elmntBox.add(btnEdit);
     // Bouton de suppression
    ButtonCustom deleting = new ButtonCustom();
    deleting.setText("Delete");
    deleting.setStyle(ButtonCustom.ButtonStyle.DESTRUCTIVE);
    deleting.setPreferredSize(new Dimension(100,30));
    elmntBox.add(deleting);
        deleting.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
             System.out.println("delete btn clicked");
             int result = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer ce professeur ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
        String[] professeurInfoDelete = professeur.split(" - ");
        int professeurId = Integer.parseInt(professeurInfoDelete[0]);

        try (Statement statement = connection.createStatement()) {

            String updateMemoireQuery = "UPDATE memoire SET profEncadrant  = NULL WHERE profEncadrant = " + professeurId;
            statement.executeUpdate(updateMemoireQuery);

            String deleteProfQuery = "DELETE FROM enseignant WHERE id = " + professeurId;
            statement.executeUpdate(deleteProfQuery);

         
            // Refresh the interface after deletion
            refreshProfesseursList(techere,techereScrollPane);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        }
    });
     
    elmntBox.setPreferredSize(new Dimension(1000, 100));

  
    return elmntBox;
};


private List<String> getAllMemoires(Connection connection) {
    List<String> pfes = new ArrayList<>();

    try (Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM memoire")) {

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("titre");
            String author = resultSet.getString("auteurs");

            pfes.add(id + " - " + title + " - " + author + "");
        }
    } catch (SQLException e) {
        e.printStackTrace();
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


// Update the createMemoirePanel method to take a list of Memoire objects
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

    // Bouton de modification
    ButtonCustom btnEditmemoire = new ButtonCustom();
    btnEditmemoire.setText("Edit");
    btnEditmemoire.setStyle(ButtonCustom.ButtonStyle.PRIMARY);
    btnEditmemoire.setPreferredSize(new Dimension(100, 30));

    btnEditmemoire.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Edit button clicked");

            // Retrieve the current values
            String currentTitle = pfetitle.getText();
            String currentAuthor = pfeauthors.getText();

            // Create input fields for editing
            JTextField titleField = new JTextField(currentTitle);
            JTextField authorField = new JTextField(currentAuthor);

            // Add UI components for the additional fields
            JComboBox<String> profComboBox = new JComboBox<>();
            JComboBox<Integer> yearComboBox = new JComboBox<>();
            JTextField themeField = new JTextField();
            JTextField codeField = new JTextField();
            JTextField resumeField = new JTextField();
            // You can add a file chooser for updating PDF content, or use a text field to enter the file path
            JTextField pdfContentField = new JTextField();

            // Populate professor combo box with existing professors
            populateProfessorComboBox(profComboBox);

            // Populate year combo box with years from 1999 to the current year
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            for (int i = 1999; i <= currentYear; i++) {
                yearComboBox.addItem(i);
            }

            // Create an array of UI components for the input fields
            Object[] fields = {
                    "Titre:", titleField,
                    "Auteurs:", authorField,
                    "Professeur Encadrant:", profComboBox,
                    "Année:", yearComboBox,
                    "Thème:", themeField,
                    "Résumé:", resumeField,
                    "CodeM:", codeField,
                    "PDF Content:", pdfContentField
            };

            // Show the dialog for editing
            int editResult = JOptionPane.showConfirmDialog(null, fields, "Modifier le PFE", JOptionPane.OK_CANCEL_OPTION);

            if (editResult == JOptionPane.OK_OPTION) {
                String newTitle = titleField.getText();
                String newAuthor = authorField.getText();
                String newProf = (String) profComboBox.getSelectedItem();
                int newYear = (int) yearComboBox.getSelectedItem();
                String newTheme = themeField.getText();
                String newResume = resumeField.getText();
                // Update pdfContent accordingly

                try (Statement statement = connection.createStatement()) {
                    String updatePfeQuery = "UPDATE memoire SET " +
                            "titre = '" + newTitle + "', " +
                            "auteurs = '" + newAuthor + "', " +
                            "profEncadrant = (SELECT id FROM enseignant WHERE fullName = '" + newProf + "'), " +
                            "theme = '" + newTheme + "', " +
                            "pdfContent = ?, " +
                            "resume = '" + newResume + "', " +
                            "annee = " + newYear + ", " +
                            "Codem = '" + codeField.getText() + "' " +
                            "WHERE id = " + pfeId;

                    // Use PreparedStatement for updating with a blob parameter for pdfContent
                    try (PreparedStatement updateStatement = connection.prepareStatement(updatePfeQuery)) {
                        // Update the pdfContent field
                        updateStatement.setBytes(1, readFileToByteArray(pdfContentField.getText()));

                        // Execute the update query
                        updateStatement.executeUpdate();
                    }

                    // Refresh the interface after modification
                    refreshMemoiresList(memoire, memoireScrollPane);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    });

    elmntBox1.add(btnEditmemoire);

    ButtonCustom deletingmemoire = new ButtonCustom();
    deletingmemoire.setText("Delete");
    deletingmemoire.setStyle(ButtonCustom.ButtonStyle.DESTRUCTIVE);
    deletingmemoire.setPreferredSize(new Dimension(100,30));
    elmntBox1.add(deletingmemoire);
        deletingmemoire.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("delete memoire btn clicked");
        int resultmemoire = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer ce pfe ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
        if (resultmemoire == JOptionPane.YES_OPTION) {
            String[] pfeInfoDelete = pfe.split(" - ");
            int pfeId = Integer.parseInt(pfeInfoDelete[0]);

            try (Statement statement = connection.createStatement()) {
                // Delete memoire from the database
                String deleteMemoireQuery = "DELETE FROM memoire WHERE id = " + pfeId;
                statement.executeUpdate(deleteMemoireQuery);
                
                // Refresh the interface after deletion
                refreshMemoiresList(memoire, memoireScrollPane);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
});

     
    elmntBox1.setPreferredSize(new Dimension(1000, 100));

  
    return elmntBox1;
};

          private void populateProfessorComboBox(JComboBox<String> profComboBox) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/porjet_ihm", "ihm", "ihm");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT fullName FROM enseignant");

        while (resultSet.next()) {
            String fullName = resultSet.getString("fullName");
            profComboBox.addItem(fullName);
        }

        connection.close();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
        new MainPage();
    });
    }
}
