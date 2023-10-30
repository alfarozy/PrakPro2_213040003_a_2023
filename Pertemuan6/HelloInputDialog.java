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
public class HelloInputDialog extends JFrame {

    public HelloInputDialog() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        JButton button = new JButton("Login ");
        button.setBounds(130, 100, 100, 40);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = JOptionPane.showInputDialog(HelloInputDialog.this, "Who Are You ?", JOptionPane.QUESTION_MESSAGE);
                if (nama == null) {
                    // tampilkan pesan error validasi
                    JOptionPane.showMessageDialog(null, "Nama harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {

                    JOptionPane.showMessageDialog(HelloInputDialog.this, "Hello, " + nama);
                }

            }
        });

        this.add(button);
        this.setSize(200, 200);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloInputDialog h = new HelloInputDialog();
                h.setVisible(true);
            }
        });
    }
}
