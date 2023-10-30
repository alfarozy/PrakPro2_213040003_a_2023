/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author koji
 */
public class HelloMessageDialog extends JFrame {

    public HelloMessageDialog() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        JButton button = new JButton("Info");
        JButton buttonWarning = new JButton("Warning");
        JButton buttonError = new JButton("Error");
        JButton buttonQ = new JButton("Nanya Aja");
        JButton buttonP = new JButton("Plain Text");
        
        button.setBounds(130, 100, 100, 40);
        buttonWarning.setBounds(130, 100, 100, 40);
        buttonError.setBounds(130, 100, 100, 40);
        buttonQ.setBounds(130, 100, 100, 40);
buttonP.setBounds(130, 100, 100, 40);
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HelloMessageDialog.this,
                        "Hallo, Selamat Datang di Praktikum Pemrograman II");
            }
        });
        buttonWarning.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HelloMessageDialog.this, "I'm Warning You", "Warning",
                        JOptionPane.WARNING_MESSAGE);

            }
        });
        buttonError.addActionListener(new ActionListener() {
         //> ERROR_MESSAGE
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HelloMessageDialog.this, "Something Error, please reset your brain", "Error",
                        JOptionPane.ERROR_MESSAGE);

            }
        });
        //> QUESTION_MESSAGE
        buttonQ.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HelloMessageDialog.this, "Are You Happy ?", "Question",
                        JOptionPane.QUESTION_MESSAGE);

            }
        });
        //> PLAIN_MESSAGE
        buttonP.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HelloMessageDialog.this, "Test Plain text with no icon", "Plain text",
                        JOptionPane.PLAIN_MESSAGE);

            }
        });
        
        this.add(button);
        this.add(buttonWarning);
        this.add(buttonError);
        this.add(buttonQ);
        this.add(buttonP);
        this.setSize(200, 200);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloMessageDialog h = new HelloMessageDialog();
                h.setVisible(true);
            }
        });
    }
}
