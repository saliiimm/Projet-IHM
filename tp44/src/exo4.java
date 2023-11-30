import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class exo4 extends JFrame {
    private DefaultTableModel tableModel;

    public exo4() {
        this.setSize(400, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField nom = new JTextField(25);
        JTextField prenom = new JTextField(25);
        JTextField age = new JTextField(25);
        JLabel nomLabel = new JLabel("nom");
        JLabel prenomLabel = new JLabel("prenom");
        JLabel ageLabel = new JLabel("age");

        JButton ajouter = new JButton("ajouter");
        JButton supprimer = new JButton("supprimer");

        
        String[] columnNames = {"Nom", "Prénom", "Âge"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
     

        JPanel textJPanel = new JPanel();
        JPanel textJPanel1 = new JPanel();
        JPanel textJPanel2 = new JPanel();
        JPanel textJPanel3 = new JPanel();
        JPanel btnJPanel = new JPanel();

        textJPanel1.add(nomLabel);
        textJPanel1.add(nom);
        textJPanel2.add(prenomLabel);
        textJPanel2.add(prenom);
        textJPanel3.add(ageLabel);
        textJPanel3.add(age);

        textJPanel.add(textJPanel1);
        textJPanel.add(textJPanel2);
        textJPanel.add(textJPanel3);

        btnJPanel.add(ajouter);
        btnJPanel.add(supprimer);

 
       
      
        this.add(new JScrollPane(table), BorderLayout.NORTH); 
          this.add(textJPanel, BorderLayout.CENTER);
        this.add(btnJPanel, BorderLayout.SOUTH);

        

     
        ajouter.addActionListener(e -> {
            String[] rowData = {nom.getText(), prenom.getText(), age.getText()};
            tableModel.addRow(rowData);
  
            nom.setText("");
            prenom.setText("");
            age.setText("");
        });

    
        supprimer.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Sélectionnez une ligne à supprimer.");
            }
        });

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new exo4();
    }
}
