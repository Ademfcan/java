package Adem.Factory.Swing;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class AppWin extends JFrame {
    /**
     * Creates new form AppWin
     */
    public AppWin() {
        initComponents();
    }
    
    private void initComponents() {
        button1 = new JButton();
        button1.setText("Go to panel 2");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                tabbedPane.setSelectedIndex(1);
            }
        });
        label1 = new JLabel();
        label1.setText("This is panel1");
        panel1 = new JPanel();
        panel1.add(label1);
        panel1.add(button1);

        button2 = new JButton();
        button2.setText("Go to panel 1");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                tabbedPane.setSelectedIndex(0);
            }
        });
        label2 = new JLabel();
        label2.setText("This is panel2");
        panel2 = new JPanel();
        panel2.add(label2);
        lblImage = new JLabel();
        lblImage.setText("Click to load image");
        lblImage.onclick(new ActionListener() {
            
        })
        panel2.add(lblImage);
        panel2.add(button2);

        tabbedPane = new JTabbedPane();
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.addTab("Panel1", panel1);
        tabbedPane.addTab("Panel2", panel2);
        
        this.add(tabbedPane);
    }

    private JLabel label1;
    private JButton button1;
    private JPanel panel1;

    private JLabel label2;
    private JLabel lblImage;
    private JButton button2;
    private JPanel panel2;

    private JTabbedPane tabbedPane;
}
