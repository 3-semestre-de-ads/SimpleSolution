//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TeladeLogin extends JPanel {
    private JLabel lb1;
    private JPasswordField tf1;
    private JLabel lb2;
    private JPasswordField tf2;
    private JButton btEntrar;
    private JLabel lb3;
    private JButton jcomp7;

    public TeladeLogin() {
        //construct components
        lb1 = new JLabel ("Login:");
        tf1 = new JPasswordField (10);
        lb2 = new JLabel ("Senha:");
        tf2 = new JPasswordField (5);
        btEntrar = new JButton ("Entrar");
        lb3 = new JLabel ("Simple Solution");
        jcomp7 = new JButton ("Retornar");

        //adjust size and set layout
        setPreferredSize (new Dimension (334, 157));
        setLayout (null);

        //add components
        add (lb1);
        add (tf1);
        add (lb2);
        add (tf2);
        add (btEntrar);
        add (lb3);
        add (jcomp7);

        //set component bounds (only needed by Absolute Positioning)
        lb1.setBounds (5, 75, 100, 25);
        tf1.setBounds (55, 70, 140, 25);
        lb2.setBounds (5, 110, 100, 25);
        tf2.setBounds (55, 105, 140, 25);
        btEntrar.setBounds (215, 70, 100, 25);
        lb3.setBounds (20, 10, 100, 25);
        jcomp7.setBounds (215, 105, 100, 25);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("TeladeLogin");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new TeladeLogin());
        frame.pack();
        frame.setVisible (true);
    }
}
