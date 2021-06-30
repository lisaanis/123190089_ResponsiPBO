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
public class UpdateBarangView extends JFrame implements ActionListener {
    private String id, nama;
    private JTextField fieldNama, fieldMassa, fieldHarga;
    JLabel labelTitle = new JLabel("Update Barang");
    
    JLabel labelNama = new JLabel("Nama");   
    JLabel labelMassa = new JLabel("Massa (gr)");
    JLabel labelHarga = new JLabel("Harga Satuan");
   
    JButton btnSubmit = new JButton("Submit");
    JButton btnReset = new JButton("Reset");
    JButton btnKembali = new JButton("Kembali");
    
    public void bukaForm(String[] data){
        id = data[0];
        setTitle("Update Barang");
        setSize(310,250);
        
        fieldNama = new JTextField(data[1],10);
        fieldMassa = new JTextField(data[2],10);
        fieldHarga = new JTextField(data[3],10);
        
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
            if (fieldMassa.getText().equals("")) {
                setMessage("Massa harus diisi");
            }
            if (fieldHarga.getText().equals("")) {
                setMessage("Harga harus diisi");
            }
            else {
                String[] data = {
                        id, fieldNama.getText(), fieldMassa.getText(), fieldHarga.getText()
                };
                BarangController barang = new BarangController();
                barang.updateBarang(data);
            }
        }
        else if(e.getSource()==btnReset){
            fieldNama.setText("");
            fieldMassa.setText("");
            fieldHarga.setText("");
        }
        else if(e.getSource()==btnKembali){
            dispose();
            BarangController bc = new BarangController();
            bc.lihatBarang(id);
        }
    }

    public void setMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
