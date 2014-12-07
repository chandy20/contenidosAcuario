/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenidosacuario;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Alex
 */
public class ContenidosAcuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(e);
        }
        Principal principal = new Principal();
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        principal.setLocation((int)(screenSize.getWidth()/2 -200), (int)(screenSize.getHeight())/2-150);
        principal.setVisible(true);
    }

}
