import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LogIn extends JFrame {

    
    public class UserHome extends JFrame {

    private String userName;

    public UserHome(String userName) {
        this.userName = userName;
        setTitle("Welcome " + userName);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

    public LogIn
    () {
        setTitle("Login Page");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(new Color(255,165,0));
        setLocationRelativeTo(null);
       
        // Créer un panel pour le contenu centré
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(new GridLayout(10,1,0,0));
        contentPanel.setMaximumSize(new Dimension(350,600));
        contentPanel.setMinimumSize(new Dimension(350,600));
        contentPanel.setPreferredSize(new Dimension(350, 600));


        // Ajouter les composants au contentPanel
        //logo:
        contentPanel.add(new JLabel("Logo", SwingConstants.CENTER));

        //welcome text:
        JLabel welcometext = new JLabel("Welcome Back !", SwingConstants.CENTER);
        Font WelcomeFont = new Font("Arial", Font.PLAIN , 14);
        welcometext.setFont(WelcomeFont);
        contentPanel.add(welcometext);

        //sign in text
        JLabel signInLabel = new JLabel("Sign in to continue to your digital Library", SwingConstants.CENTER);
        Font plainFont = new Font("Arial", Font.PLAIN , 12);
        signInLabel.setFont(plainFont);
        signInLabel.setForeground(Color.decode("#c5c5c5"));
        contentPanel.add(signInLabel);

        //email:
        contentPanel.add(new JLabel("Email"));
        JTextField emailField = new JTextField(SwingConstants.CENTER);
        emailField.setToolTipText("Enter your email");
        emailField.setPreferredSize(new Dimension(300, 20));
        contentPanel.add(emailField);

        //password:
        contentPanel.add(new JLabel("Password"));
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBackground(Color.WHITE);
        passwordField.setToolTipText("Enter your password");
        contentPanel.add(passwordField);

        // Ajouter l'icône pour montrer ou cacher le mot de passe
        JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setBackground(Color.WHITE);
        contentPanel.add(showPasswordCheckBox);

        

        // Ajouter le bouton de connexion
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.decode("#FA7C54"));
        contentPanel.add(loginButton);


       

        // Ajouter le contentPanel au centre du mainPanel
        Box mainPanel = new Box(BoxLayout.Y_AXIS);
        mainPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        mainPanel.add(Box.createVerticalGlue());
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
                        UserHome ah = new UserHome(userName);
                        ah.setTitle("Welcome");
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




    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LogIn();
            }
        });
    }
}
