package Adem.Factory.Swing;

import javax.swing.JFrame;

public class AppMain {
    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AppWin app = new AppWin();
                app.setVisible(true);
                app.setExtendedState(JFrame.MAXIMIZED_BOTH);
                app.setUndecorated(true);
            }
        });
    }
}
