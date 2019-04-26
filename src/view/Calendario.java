//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Calendario extends JPanel {
    private JLabel jcomp1;
    private JLabel jcomp2;
    private JLabel jcomp3;
    private JTextField jcomp4;
    private JButton btAdicionar;
    private JLabel jcomp6;
    private JTextField jcomp7;
    private JButton jcomp8;

    public Calendario() {
        //construct components
        jcomp1 = new JLabel ("Calendario");
        jcomp2 = new JLabel ("Simple Solution");
        jcomp3 = new JLabel ("Evento:");
        jcomp4 = new JTextField (5);
        btAdicionar = new JButton ("Adicionar");
        jcomp6 = new JLabel ("Data:");
        jcomp7 = new JTextField (5);
        jcomp8 = new JButton ("Sair");

        //adjust size and set layout
        setPreferredSize (new Dimension (667, 366));
        setLayout (null);

        //add components
        add (jcomp1);
        add (jcomp2);
        add (jcomp3);
        add (jcomp4);
        add (btAdicionar);
        add (jcomp6);
        add (jcomp7);
        add (jcomp8);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (190, 40, 155, 25);
        jcomp2.setBounds (15, 15, 100, 25);
        jcomp3.setBounds (25, 100, 100, 25);
        jcomp4.setBounds (75, 100, 145, 25);
        btAdicionar.setBounds (240, 100, 100, 25);
        jcomp6.setBounds (25, 135, 100, 25);
        jcomp7.setBounds (75, 135, 100, 25);
        jcomp8.setBounds (240, 170, 100, 25);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("Calendario");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Calendario());
        frame.pack();
        frame.setVisible (true);
    }
}
