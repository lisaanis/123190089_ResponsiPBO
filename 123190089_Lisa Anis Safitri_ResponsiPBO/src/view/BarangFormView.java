package view;

import controller.BarangController;
import controller.MainMenuController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Lisa Anis Safitri
 */
public class BarangFormView extends JFrame implements ActionListener {
    JLabel labelTitle = new JLabel("Input Barang");
    
    JLabel labelNama = new JLabel("Nama");
    final JTextField fieldNama = new JTextField();
    
    JLabel labelMassa = new JLabel("Massa (gr)");
    final JTextField fieldMassa = new JTextField();
    
    JLabel labelHarga = new JLabel("Harga Satuan");
    final JTextField fieldHarga = new JTextField();
    
    JButton btnSubmit = new JButton("Submit");
    JButton btnReset = new JButton("Reset");
    JButton btnKembali = new JButton("Kembali");
    
    public void bukaForm(){
        setTitle("Input Barang");
        setSize(310,250);
        
        //setLayout
        setLayout(null);
        add(labelTitle);
        add(labelNama);
        add(fieldNama);
        add(labelMassa);
        add(fieldMassa);
        add(labelHarga);
        add(fieldHarga);
        add(btnSubmit);
        add(btnReset);
        add(btnKembali);
        
        //set bounds(m,n,o,p)
        labelTitle.setBounds(120, 10, 90, 25);
        labelNama.setBounds(20, 40, 120, 20);
        fieldNama.setBounds(120, 40, 150, 20);
        labelMassa.setBounds(20, 65, 120, 20);
        fieldMassa.setBounds(120, 65, 150, 20);
        labelHarga.setBounds(20, 90, 120, 20);
        fieldHarga.setBounds(120, 90, 150, 20);
        
        btnSubmit.setBounds(70, 125, 80, 20);
        btnSubmit.setBackground(Color.blue);
        btnSubmit.setForeground(Color.white);
        btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnReset.setBounds(165, 125, 80, 20);
        btnReset.setBackground(Color.red);
        btnReset.setForeground(Color.white);
        btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnKembali.setBounds(20, 170, 250, 20);
        btnKembali.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnSubmit.addActionListener(this);
        btnReset.addActionListener(this);
        btnKembali.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSubmit) {
            if (fieldNama.getText().equals("")) {
                setMessage("Nama barang harus diisi");
            }
            else if (fieldMassa.getText().equals("")) {
                setMessage("Massa harus diisi");
            }
            else if (fieldHarga.getText().equals("")) {
                setMessage("Harga harus diisi");
            }
            else if(Integer.valueOf(fieldHarga.getText())<0){
                    setMessage("Harga harus bernilai positif");
            }
            else if(Integer.valueOf(fieldMassa.getText())<0){
                    setMessage("Massa harus bernilai positif");
            }
            else {
                String[] x = {
                        fieldNama.getText(), fieldMassa.getText(), fieldHarga.getText()
                };
                BarangController barang = new BarangController();
                barang.tambahBarang(x);
            }
        }
        else if(e.getSource()==btnReset){
            fieldNama.setText("");
            fieldMassa.setText("");
            fieldHarga.setText("");
        }
        else if(e.getSource()==btnKembali){
            dispose();
            MainMenuController mn = new MainMenuController();
            mn.openHome();
        }
    }

    public void setMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
