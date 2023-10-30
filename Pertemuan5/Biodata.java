/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author koji
 */
public class Biodata extends JFrame {

    //> init variabel untuk selected checkbox
    private boolean checkBoxSelected;

    public Biodata() {
        //> kasih nilai default false
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //> tampilkan text header
        JLabel headerLabel = new JLabel("Form Biodata", JLabel.CENTER);

        JPanel controPanel = new JPanel();
        controPanel.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setSize(800, 1000);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        //> inisialisasi objek untuk inputan 
        JLabel labelInputNama = new JLabel("Nama:");
        JTextField textFieldNama = new JTextField();
        JLabel labelInputNotelp = new JLabel("Nomor HP:");
        JTextField textFieldNotelp = new JTextField();
        JLabel labelJenisKelamin = new JLabel("Jenis Kelamin:");
        JRadioButton radioButtonL = new JRadioButton("Laki-Laki", true);
        JRadioButton radioButtonP = new JRadioButton("Perempuan");
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        JButton button = new JButton("Simpan");
        JButton buttonReset = new JButton("Hapus Output");
        JTextArea txtOutput = new JTextArea(10, 30); // Atur tinggi dan lebar JTextArea

        //>  atur posisi label nama 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // Menambahkan jarak di sekitar komponen
        panel.add(labelInputNama, gbc);
        //>  atur posisi inputan nama
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(textFieldNama, gbc);
        //>  atur posisi label nomor telpon
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelInputNotelp, gbc);
        //>  atur posisi inputan nomor telpon
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(textFieldNotelp, gbc);

        //>  atur posisi label jenis kelamin
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(labelJenisKelamin, gbc);
        //> atur posisi radio button untuk jenis kelamin laki laki
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(radioButtonL, gbc);
        //> atur posisi radio button untuk jenis kelamin perempuan
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(radioButtonP, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(checkBox, gbc);
        //> atur posisi button simpan
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(button, gbc);
        //> atur posisi button reset output
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(buttonReset, gbc);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButtonL);
        bg.add(radioButtonP);

        //> tambahkan event listener untuk checkbox yang di select
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == 1;
            }
        });

        //> tambahkan even listener untuk melakukan reset output dan menampilkan pesan berhasil mengosongkan data
        buttonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtOutput.setText("");
                JOptionPane.showMessageDialog(null, "Data berhasil dikosongkan", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        //> menambahkan event listener untuk tombol simpan untuk menampilkan text ke output
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String noTelp = textFieldNotelp.getText();
                String jenisKelamin = "";
                String WNA = "";

                //> tambahkan validasi nama dan nomor telpon
                if (nama.isEmpty()) {
                    // tampilkan pesan error validasi
                    JOptionPane.showMessageDialog(null, "Nama harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (noTelp.isEmpty()) {
                    //> tampilkan pesan error validasi
                    JOptionPane.showMessageDialog(null, "Nomor Telepon harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (radioButtonL.isSelected()) {
                    jenisKelamin = radioButtonL.getText();
                }
                if (radioButtonP.isSelected()) {
                    jenisKelamin = radioButtonP.getText();
                }

                if (checkBoxSelected) {
                    WNA = "Ya";
                } else {
                    WNA = "Tidak";
                }
                //> tambahakan text dari form ke output
                txtOutput.append("Nama  :" + nama + "\n"
                        + "Nomor HP   :" + noTelp + "\n"
                        + "Jenis Kelamin  :" + jenisKelamin + "\n"
                        + "WNA    :" + WNA + "\n===============================\n");
                //> kosongkan fields
                textFieldNama.setText("");
                textFieldNotelp.setText("");
            }
        });

        //> atur ukuran panel 
        controPanel.add(panel);
        this.setSize(800, 1000);
        this.setLayout(new GridLayout(5, 3));
        this.add(headerLabel);
        this.add(controPanel);
        this.add(txtOutput);
    }

    public static void main(String[] args) {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //> init class biodata dan tampilkan
                Biodata b = new Biodata();
                b.setVisible(true);
            }
        });
    }
}
