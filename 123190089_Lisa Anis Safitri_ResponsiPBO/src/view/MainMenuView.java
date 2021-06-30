package view;

import controller.BarangController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Lisa Anis Safitri
 */
public class MainMenuView extends JFrame implements ActionListener {
    JLabel labelMenu = new JLabel("=== Main Menu ===");
    JLabel labelMenu2 = new JLabel("Kelola Data Barang");
    JButton btnTambah = new JButton(" Tambah Barang");
    JButton btnLihat = new JButton(" Lihat Barang");
    
    public MainMenuView(){
        setTitle("Main Menu");
        setSize(200,200); //menentukan ukuran panjang & lebar pada objek frame
        labelMenu.setHorizontalAlignment(SwingConstants.CENTER);
        
        //menentukan jenis layout yg dipakai
        setLayout(null); 
        //add component
        add(labelMenu);
        add(labelMenu2);
        add(btnTambah);
        add(btnLihat);
        
        //set bounds(m,n,o,p)
        labelMenu.setBounds(20, 20, 150, 20);
        labelMenu2.setBounds(40, 40, 180, 20);
        btnTambah.setBounds(30, 80, 130, 20);
        btnLihat.setBounds(30, 120, 130, 20);
        
        setResizable(false); //agar ukuran window bersifat tetap
        setLocationRelativeTo(null); //menempatkan JFrame tepat di tengah layar monitor
        setDefaultCloseOperation(EXIT_ON_CLOSE); //menjalankan perintah close saat eksekusi output dijalankan
        btnTambah.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLihat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnTambah.addActionListener(this);
        btnLihat.addActionListener(this);
        setVisible(true); // menampilkan objek JFrame
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnTambah){
            BarangController barang = new BarangController();
            barang.tambahBarang();
            dispose();
        }
        else if(e.getSource()== btnLihat){
            BarangController lihat = new BarangController();
            lihat.lihatBarang();
            dispose();
        }
    }
}
