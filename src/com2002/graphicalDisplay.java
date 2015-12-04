package com2002;

/**
 * Created by Abigail on 04/12/2015.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.util.ArrayList;

public class graphicalDisplay {
    private static final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private static final char[] DAYS = {'M','T','W','T','F'};
    private static JButton[] calendar = new JButton[5];
    private static JPanel outerBoard;
    private static JFrame main;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Dimension screenDimensions = toolkit.getScreenSize();

    public static void main(String[] args){
        graphicalDisplay g = new graphicalDisplay();
        g.startMenu();
    }

    public void startMenu() {
        //Sets up the JFrame
        JFrame menu = new JFrame("Employee Selection");
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton secretary = new JButton("Secretary");
        secretary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //secretaryMenu();
            }
        });
        JButton partner = new JButton("Partner");
        partner.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //partnerMenu();
            }
        });
        menu.setContentPane(gui);
        JPanel employeeType = new JPanel(new FlowLayout());
        employeeType.add(secretary);
        employeeType.add(partner);
        gui.add(employeeType);
        menu.setSize(screenDimensions.width/4- menu.getWidth()/2,screenDimensions.height/6 - menu.getWidth()/2);
        menu.setLocation(new Point(screenDimensions.width/2 - menu.getWidth()/2,screenDimensions.height/2 - menu.getWidth()/2));
        menu.setVisible(true);
    }

    public void secretaryMenu() {

    }



}
