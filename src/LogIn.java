import javax.swing.*;
import javax.swing.border.LineBorder;
import CustomPasswordField.PasswordFieldWithVisibility;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class LogIn extends JFrame {


    public LogIn() {
        setTitle("Login Page");
        setSize(1500, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        
       
        // Créer un panel pour le contenu centré
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setMaximumSize(new Dimension(450,500));
        contentPanel.setMinimumSize(new Dimension(450,500));
        contentPanel.setPreferredSize(new Dimension(450, 500));


        // Ajouter les composants au contentPanel

        //space 
         contentPanel.add(Box.createVerticalStrut(30));

        //logo:
         ImageIcon imageIcon = new ImageIcon("src/assets/logo.png");
        Image originalImage = imageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(150, 80, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel label = new JLabel(resizedIcon);
        JPanel logo = new JPanel();
        logo.add(label);
        logo.setPreferredSize(new Dimension(150, 85));
        logo.setMinimumSize(new Dimension(150, 85));
        logo.setMaximumSize(new Dimension(150, 85));
        logo.setBackground(Color.WHITE);
        contentPanel.add(logo);

        //space 
         contentPanel.add(Box.createVerticalStrut(35));

        //welcome text:
        JLabel welcometext = new JLabel("Welcome Back !");
        Font WelcomeFont = new Font("Arial", Font.PLAIN , 20);
        welcometext.setFont(WelcomeFont);
        welcometext.setVerticalAlignment(SwingConstants.CENTER);
        welcometext.setHorizontalAlignment(SwingConstants.CENTER);
        welcometext.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        contentPanel.add(welcometext);

        //space 
         contentPanel.add(Box.createVerticalStrut(20));

        //sign in text
        JLabel signInLabel = new JLabel("Sign in to continue to your digital Library", SwingConstants.CENTER);
        Font plainFont = new Font("Arial", Font.PLAIN , 12);
        signInLabel.setFont(plainFont);
        signInLabel.setForeground(Color.decode("#594C4C"));
         signInLabel.setVerticalAlignment(SwingConstants.CENTER);
        signInLabel.setHorizontalAlignment(SwingConstants.CENTER);
        signInLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        contentPanel.add(signInLabel);

        //space 
         contentPanel.add(Box.createVerticalStrut(20));

        // Create a panel for email components
        JPanel emailPanel = new JPanel(new GridLayout(2, 1));
        emailPanel.setPreferredSize(new Dimension(305, 75));
        emailPanel.setMinimumSize(new Dimension(305, 75));
        emailPanel.setMaximumSize(new Dimension(305, 75));
        emailPanel.setBackground(Color.WHITE);

        JPanel topEmailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topEmailPanel.setBackground(Color.WHITE);
        topEmailPanel.add(new JLabel("Email"));

        emailPanel.add(topEmailPanel);

        JPanel secondEmailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        secondEmailPanel.setBackground(Color.WHITE);
        JTextField emailField = new JTextField(SwingConstants.CENTER);
        emailField.setToolTipText("Enter your email");
        setComponentSize(emailField, 300, 30);
        emailField.setBorder(new LineBorder(Color.decode("#DCD9D9"), 2, true));

        secondEmailPanel.add(emailField);
        
        emailPanel.add(topEmailPanel);
        emailPanel.add(secondEmailPanel);
        contentPanel.add(emailPanel);


         //space 
         contentPanel.add(Box.createVerticalStrut(20));

        // Create a panel for password components
        JPanel passwordPanel = new JPanel(new GridLayout(2, 1));
        passwordPanel.setPreferredSize(new Dimension(305, 75));
        passwordPanel.setMinimumSize(new Dimension(305, 75));
        passwordPanel.setMaximumSize(new Dimension(305, 75));
        passwordPanel.setBackground(Color.WHITE);

        JPanel topPasswordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPasswordPanel.setBackground(Color.WHITE);
        topPasswordPanel.add(new JLabel("Password"));

        passwordPanel.add(topPasswordPanel);

        JPanel bottomPasswordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPasswordPanel.setBackground(Color.WHITE);
        PasswordFieldWithVisibility passwordField = new PasswordFieldWithVisibility();
        passwordField.setToolTipText("Enter your password");
        setComponentSize(passwordField, 300, 30);
        passwordField.setBorder(new LineBorder(Color.decode("#DCD9D9"), 2, true));
        bottomPasswordPanel.add(passwordField);
        bottomPasswordPanel.add(passwordField);

        passwordPanel.add(bottomPasswordPanel);
        
        contentPanel.add(passwordPanel);


         //space 
         contentPanel.add(Box.createVerticalStrut(25));
        

        // Ajouter le bouton de connexion
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.decode("#FA7C54"));
        setComponentSize(loginButton, 300, 30);
        loginButton.setVerticalAlignment(SwingConstants.CENTER);
        loginButton.setHorizontalAlignment(SwingConstants.CENTER);
        loginButton.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        contentPanel.add(loginButton);

        //space 
         contentPanel.add(Box.createVerticalStrut(30));


       
       
        // Ajouter le contentPanel au centre du mainPanel
        Box mainPanel = new Box(BoxLayout.Y_AXIS);
        mainPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        mainPanel.add(Box.createVerticalGlue());
        contentPanel.setAlignmentX(0.5f);
        contentPanel.setAlignmentY(0.5f);
        mainPanel.add(contentPanel);
        mainPanel.add(Box.createVerticalGlue());
        
        
        //ajouter MainPnale au Frame
        add(mainPanel);




        // Rendre la frame visible
        setVisible(true);

        // ActionListener pour le bouton de connexion
        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String userName = emailField.getText();
                String password = new String(passwordField.getPassword());
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/porjet_ihm",
                        "ihm", "ihm");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select username, password from admin where username=? and password=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        MainPage ah = new MainPage();
                        ah.setTitle("My Book Shelf");
                        ah.setVisible(true);
                        JOptionPane.showMessageDialog(loginButton, "You have successfully logged in");
                    } else {
                        JOptionPane.showMessageDialog(loginButton, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

    }

    private void setComponentSize(JComponent component, int width, int height) {
    component.setPreferredSize(new Dimension(width, height));
    component.setMinimumSize(new Dimension(width, height));
    component.setMaximumSize(new Dimension(width, height));
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LogIn();
            }
        });
    }
}
