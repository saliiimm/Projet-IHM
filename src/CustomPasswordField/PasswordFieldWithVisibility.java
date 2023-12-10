package CustomPasswordField;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PasswordFieldWithVisibility extends JPasswordField {

    private boolean passwordVisible = false;

    public PasswordFieldWithVisibility() {
      

        // Ajouter une icône d'œil
        Icon showIcon = new ImageIcon("src/assets/eyeoff.png"); // Remplacez par le chemin de votre icône
        JButton showButton = new JButton(showIcon);
        showButton.setBorderPainted(false);
        showButton.setContentAreaFilled(false);
        showButton.setFocusPainted(false);
        showButton.setOpaque(false);
        showButton.setFocusable(false);
        showButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        showButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                passwordVisible = !passwordVisible; // Inverser l'état actuel

                if (passwordVisible) {
                    setEchoChar((char) 0);
                    showButton.setIcon(new ImageIcon("src/assets/eyeon.png"));
                } else {
                    setEchoChar('\u2022');
                    showButton.setIcon(new ImageIcon("src/assets/eyeoff.png"));
                }
            }
        });
       

        // Ajouter le bouton à droite du champ de mot de passe
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(Box.createHorizontalGlue());
        add(showButton);
    }
}
