//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Desempenho extends JPanel {
    private JLabel jcomp1;
    private JLabel jcomp2;
    private JLabel jcomp3;
    private JTextField jcomp4;
    private JButton btPesquisar;
    private JTextArea jcomp6;
    private JLabel jcomp7;
    private JLabel jcomp8;
    private JTextField jcomp9;
    private JTextField jcomp10;
    private JButton jcomp11;

    public Desempenho() {
        //construct components
        jcomp1 = new JLabel ("Desempenho");
        jcomp2 = new JLabel ("Simple Solution");
        jcomp3 = new JLabel ("Nome:");
        jcomp4 = new JTextField (5);
        btPesquisar = new JButton ("Pesquisar");
        jcomp6 = new JTextArea (5, 5);
        jcomp7 = new JLabel ("Turma:");
        jcomp8 = new JLabel ("Nivel:");
        jcomp9 = new JTextField (5);
        jcomp10 = new JTextField (5);
        jcomp11 = new JButton ("Sair");

        //adjust size and set layout
        setPreferredSize (new Dimension (440, 284));
        setLayout (null);

        //add components
        add (jcomp1);
        add (jcomp2);
        add (jcomp3);
        add (jcomp4);
        add (btPesquisar);
        add (jcomp6);
        add (jcomp7);
        add (jcomp8);
        add (jcomp9);
        add (jcomp10);
        add (jcomp11);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (160, 35, 155, 25);
        jcomp2.setBounds (15, 15, 100, 25);
        jcomp3.setBounds (25, 100, 100, 25);
        jcomp4.setBounds (75, 100, 145, 25);
        btPesquisar.setBounds (305, 180, 100, 25);
        jcomp6.setBounds (30, 175, 260, 70);
        jcomp7.setBounds (230, 100, 100, 25);
        jcomp8.setBounds (230, 135, 100, 25);
        jcomp9.setBounds (280, 100, 100, 25);
        jcomp10.setBounds (280, 135, 100, 25);
        jcomp11.setBounds (305, 220, 100, 25);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("Desempenho");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Desempenho());
        frame.pack();
        frame.setVisible (true);
    }
}
