/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan3;

import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author  Muhammad Alfarozi
 * @nrp     213040003
 * @version 1.0
 */
public class Latihan3 extends JFrame{
    
    private boolean checkBoxSelected;
    private String jenisKelamin;
    private boolean wnaSelected;

    public Latihan3() {
        this.checkBoxSelected = false;
        this.jenisKelamin = "";
        this.wnaSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Untuk label nama
        JLabel labelNama = new JLabel("Nama:"); 
        labelNama.setBounds(15, 40, 350, 10);
        
        //Untuk menampilkan form input nama
        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        //Untuk label no HP
        JLabel labelNoHP = new JLabel("No HP:");
        labelNoHP.setBounds(15, 100, 350, 10);

        //Untuk menampilkan form input no HP
        JTextField textFieldNoHP = new JTextField();
        textFieldNoHP.setBounds(15, 120, 350, 30);

        //Untuk label jenis kelamin
        JLabel labelKelamin = new JLabel("Jenis Kelamin:");
        labelKelamin.setBounds(15, 160, 350, 10);

        //Untuk button pilihan jenis kelamin laki-laki
        JRadioButton radioButtonLaki = new JRadioButton("Laki-laki");
        radioButtonLaki.setBounds(15, 180, 100, 30);

        //Untuk button pilihan jenis kelamin perempuan
        JRadioButton radioButtonPerempuan = new JRadioButton("Perempuan");
        radioButtonPerempuan.setBounds(130, 180, 100, 30);

        //Untuk memilih salah satu radiobutton (tidak bisa memilih keduanya)
        ButtonGroup jenisKelaminGroup = new ButtonGroup();
        jenisKelaminGroup.add(radioButtonLaki);
        jenisKelaminGroup.add(radioButtonPerempuan);

        //Untuk label Warga Negara Asing
        JLabel labelWNA = new JLabel("WNA:");
        labelWNA.setBounds(15, 220, 350, 10);

        //Untuk mencentang pilihan WNA
        JCheckBox checkBoxWNA = new JCheckBox("Warga Negara Asing");
        checkBoxWNA.setBounds(15, 240, 200, 30);

        //Untuk menyimpan data diatas
        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 280, 100, 40);

        //Untuk menampilkan data diatas (output di textarea)
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 330, 350, 400);

        //Untuk menangani peristiwa (events) yang terkait dengan
        //komponen GUI yang memiliki item untuk dipilih
        checkBoxWNA.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                wnaSelected = e.getStateChange() == 1;
            }
        });

        buttonSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBoxWNA.isSelected()) {
                    wnaSelected = true;
                } else {
                    wnaSelected = false;
                }

                String nama = textFieldNama.getText();
                String noHP = textFieldNoHP.getText();

                //Output jika user meng klik jenis kelamin laki-laki
                if (radioButtonLaki.isSelected()) {
                    jenisKelamin = "Laki-laki";
                //Output jika user meng klik jenis kelamin perempuan
                } else if (radioButtonPerempuan.isSelected()) {
                    jenisKelamin = "Perempuan";
                }

                //Output jika user meng klik checkbox WNA atau tidak
                String wnaStatus = wnaSelected ? "Ya" : "Bukan";

                //Output dari data yang di isi user
                txtOutput.append("Nama : " + nama + "\n");
                txtOutput.append("No HP : " + noHP + "\n");
                txtOutput.append("Jenis Kelamin : " + jenisKelamin + "\n");
                txtOutput.append("WNA : " + wnaStatus + "\n");
                txtOutput.append("=========================================== \n");

                textFieldNama.setText("");
                textFieldNoHP.setText("");
                checkBoxWNA.setSelected(false);
                jenisKelaminGroup.clearSelection();
            }
        });

        this.add(textFieldNama);
        this.add(textFieldNoHP);
        this.add(radioButtonLaki);
        this.add(radioButtonPerempuan);
        this.add(checkBoxWNA);
        this.add(labelNama);
        this.add(labelNoHP);
        this.add(labelKelamin);
        this.add(labelWNA);
        this.add(buttonSimpan);
        this.add(txtOutput);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Latihan3 h = new Latihan3();
                h.setVisible(true);
            }
        });
    }
    
    
    
}
