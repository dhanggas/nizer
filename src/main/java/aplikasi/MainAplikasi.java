/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi;

import aplikasi.view.MainMenuView;
import java.awt.Dimension;
import java.awt.Window;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author dhiskar
 */
public class MainAplikasi {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("in", "ID"));
        SwingUtilities.invokeLater(() -> {
            MainMenuView mainMenu = new MainMenuView();
            mainMenu.setTitle("DATA DESA SARAKAN - Aplikasi");
//            mainMenu.setLocationRelativeTo(null);
            mainMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);
//            mainMenu.setUndecorated(true);
            mainMenu.setVisible(true);
        });
    }
}
