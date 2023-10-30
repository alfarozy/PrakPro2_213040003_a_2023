package Pertemuan4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Muhammad Alfarozi
 * @nrp     213040003
 * @version 1.0
 */
public class HelloGridLayout extends JFrame implements ActionListener  {
    //> deklarasi 9 variabel buttton
    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;
    private JButton buttonE;
    private JButton buttonF;
    private JButton buttonG;
    private JButton buttonH;
    private JButton buttonI;
    
    private JButton[] buttons; //> deklarasi array buttons
    private boolean gameOver; //> deklrasasi state gmae over

    public HelloGridLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gameOver = false; //> state awal
        //> inisialisasi objek JButton
        buttonA = new JButton("");
        buttonB = new JButton("");
        buttonC = new JButton("");
        buttonD = new JButton("");
        buttonE = new JButton("");
        buttonF = new JButton("");
        buttonG = new JButton("");
        buttonH = new JButton("");
        buttonI = new JButton("");
      
        //> simpan kedalam array
        buttons = new JButton[9];
        buttons[0] = buttonA;
        buttons[1] = buttonB;
        buttons[2] = buttonC;
        buttons[3] = buttonD;
        buttons[4] = buttonE;
        buttons[5] = buttonF;
        buttons[6] = buttonG;
        buttons[7] = buttonH;
        buttons[8] = buttonI;
        
        buttonA.addActionListener(this);
        buttonB.addActionListener(this);
        buttonC.addActionListener(this);
        buttonD.addActionListener(this);
        buttonE.addActionListener(this);
        buttonF.addActionListener(this);
        buttonG.addActionListener(this);
        buttonH.addActionListener(this);
        buttonI.addActionListener(this);
        //> setup tata letak dengan 3 bari dan 3 kolom
        this.setLayout(new GridLayout(3, 3));
        //> menampilkan button pada layar
        this.add(buttonA);
        this.add(buttonB);
        this.add(buttonC);
        this.add(buttonD);
        this.add(buttonE);
        this.add(buttonF);
        this.add(buttonG);
        this.add(buttonH);
        this.add(buttonI);
        //> setup ukuran frame
        this.setSize(300, 400);
    }

    //> algoritma 
    //> klick salah satu tombol maka akan muncul 0
    //> dansecara random muncul X secara bergantian
    //> cek state game over jika false lakukan pemanggilan function CheckWinner()
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            JButton button = (JButton) e.getSource();
            if (button.getText().isEmpty()) {
                button.setText("O");
                checkWinner(); //> pemanggilanfunction checkWinner, untuk mengetahui pemenang
                if (!gameOver) {
                    for (int i = 0; i < buttons.length; i++) {
                        if(buttons[i].getText().isEmpty()) {
                            buttons[i].setText("X");
                            break;
                        }               
                    }
                    checkWinner();//> pemanggilanfunction checkWinner, untuk mengetahui pemenang
                }
            }
        }
    }
    
    //> baris kode ini menjelaskan bahwa winner itu digunakan untuk menyimpan simbol X dan O dari 
    //> pemain yang menang dalam permainan dan di inisialisasikan dengan string kosong.
    private void checkWinner() {
        String winner = "";
        //> kode baris ini fungsinya untuk pengecekan apakah tombol A ini memiliki teks yang tidak kosong dan apakah tombol A tersebut memiliki teks yang sama dengan tombol B dan C jika ada kesamaan, maka pemain yang memiliki tanda pada tombol A dialah pemenangnya dan variabel winner yang ada di baris 115 tersebut akan merubah tombol A,B dan C menjadi warna merah untuk menunjukkan bahwa pemain tersebut telah menang.
        if (!buttonA.getText().isEmpty()
            && buttonA.getText().equals(buttonB.getText())
            && buttonA.getText().equals(buttonC.getText())) 
        {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonB.setForeground(Color.RED);
            buttonC.setForeground(Color.RED);
        } else if (!buttonD.getText().isEmpty()
            && buttonD.getText().equals(buttonE.getText())
            && buttonD.getText().equals(buttonF.getText()))
        {
            winner = buttonD.getText();
            buttonD.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonF.setForeground(Color.RED);
        } else if (!buttonG.getText().isEmpty()
            && buttonG.getText().equals(buttonH.getText())
            && buttonG.getText().equals(buttonI.getText()))
        {
            winner = buttonG.getText();
            buttonG.setForeground(Color.RED);
            buttonH.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        } else if (!buttonA.getText().isEmpty()
            && buttonA.getText().equals(buttonD.getText())
            && buttonA.getText().equals(buttonG.getText()))
        {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonD.setForeground(Color.RED);
            buttonG.setForeground(Color.RED);
        } else if (!buttonB.getText().isEmpty()
            && buttonB.getText().equals(buttonE.getText())
            && buttonB.getText().equals(buttonH.getText()))
        {
            winner = buttonB.getText();
            buttonB.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonH.setForeground(Color.RED);
        } else if (!buttonC.getText().isEmpty()
            && buttonC.getText().equals(buttonF.getText())
            && buttonC.getText().equals(buttonI.getText()))
        {
            winner = buttonC.getText();
            buttonC.setForeground(Color.RED);
            buttonF.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        } else if (!buttonA.getText().isEmpty()
            && buttonA.getText().equals(buttonE.getText())
            && buttonA.getText().equals(buttonI.getText()))
        {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        } else if (!buttonC.getText().isEmpty()
            && buttonC.getText().equals(buttonE.getText())
            && buttonC.getText().equals(buttonG.getText()))
        {
            winner = buttonC.getText();
            buttonC.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonG.setForeground(Color.RED);
        } 

        gameOver = !winner.isEmpty();
    }
    
        //> functoin main dan pemanggilan swing untuk ditampilkan ke layar

    public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloGridLayout f = new HelloGridLayout();
                f.setVisible(true);
            }
        });
    }   
}
