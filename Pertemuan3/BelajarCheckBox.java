/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

/**
 *
 * @author koji
 */
public class BelajarCheckBox extends JFrame {

    private boolean checkBoxSelected;

    public BelajarCheckBox() {
        this.checkBoxSelected = false;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelName = new JLabel("Nama lengkap");
        labelName.setBounds(15, 40, 500, 10);
        
        JTextField name = new JTextField();
        name.setBounds(15,60,500,30);
        
        JCheckBox agrrement= new JCheckBox("Saya menyetujui syarat dan ketentuan");
        agrrement.setBounds(15,100,500,30);
        
        JButton btnSubmit = new JButton("Simpan");
        btnSubmit.setBounds(15, 150, 500, 40);
        
        JTextArea textOutput = new JTextArea("");
        textOutput.setBounds(15, 200, 500, 100);
        
        
        agrrement.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                checkBoxSelected = ie.getStateChange()==1;
            }
        });
        
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(checkBoxSelected){
                    String fullname = name.getText();
                    textOutput.append("Hi "+fullname+"\n");
                    
                    name.setText("");
                }else{
                    textOutput.append("Mohon Setujui agreement untuk melanjutkan");
                }
            }
        });
        
        this.add(btnSubmit);
        this.add(name);
        this.add(agrrement);
        this.add(labelName);
        this.add(textOutput);
        
        this.setSize(600,800);
        this.setLayout(null);
        
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BelajarCheckBox bc = new BelajarCheckBox();
                bc.setVisible(true);
            }
        });
    }
}
