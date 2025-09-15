package UI;

import javax.swing.*;

import java.util.List;
import model.Druggist;
import model.FilesLoader;


public class LoginGUI{

    private List<Druggist>druggistList;

    public static void startLogin() {

        boolean logged=false;
        boolean found=false;

        while (!logged) {
            
            //Load Druggists
            List<Druggist> druggList=FilesLoader.LoadDruggists("src/druggistList.txt");

            //Ask User
            String log_user=JOptionPane.showInputDialog(null, "Enter username:", "Login", JOptionPane.QUESTION_MESSAGE);

            if (log_user == null) { // Cancel
                System.exit(0);
            }

            //Ask Password
            JPasswordField pf = new JPasswordField();
            int option = JOptionPane.showConfirmDialog(null, pf, "Enter password:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (option!=JOptionPane.OK_OPTION) {
                System.exit(0);
            }

            String pass=new String(pf.getPassword());

            //Validate
            for (Druggist d : druggList) {
            if (d.getDruggist_user().equals(log_user)&&d.getDruggist_password().equals(pass)) {
                JOptionPane.showMessageDialog(null,"Welcome "+d.getName(),"Login Success", JOptionPane.INFORMATION_MESSAGE);
                    
                SwingUtilities.invokeLater(() -> { //Shows main menu
                new UI.MainMenuGUI().setVisible(true);
                });

                logged = true;
                found = true;
                break;
            }}
            if (!found) {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials", "error", JOptionPane.ERROR_MESSAGE);
             }
         }
     }
 }

