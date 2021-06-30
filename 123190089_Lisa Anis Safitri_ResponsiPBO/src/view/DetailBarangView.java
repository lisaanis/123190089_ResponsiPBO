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
public class DetailBarangView extends JFrame implements ActionListener {
    private JLabel rNama, rMassa, rHarga;
    private String id;
    
    JLabel labelNama = new JLabel("Nama : ");
    JLabel labelMassa = new JLabel("Massa : ");
    JLabel labelHarga = new JLabel("Harga Satuan : ");
    JLabel labelBanyak = new JLabel("Banyak");
    JTextField fieldBanyak = new JTextField();
    
    JButton btnTotal = new JButton("Total Harga");
    JButton btnKembali = new JButton("Kembali");
    JButton btnEdit = new JButton("Edit");
    JButton btnHapus = new JButton("Hapus");
    
    public void lihatDetail(String[] data){
        this.id = data[0];
        setTitle(data[1]);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(340,325);  
        
        rNama = new JLabel(data[1]);
        rMassa = new JLabel(data[2]);
        rHarga = new JLabel(data[3]);
        
        setLayout(null);
        add(labelNama);
        add(labelMassa);
        add(labelHarga);
        add(labelBanyak);
        add(fieldBanyak);
        add(rNama);
        add(rMassa);
        add(rHarga);
        add(btnTotal);
        add(btnKembali);
        add(btnEdit);
        add(btnHapus);

        labelNama.setBounds(20,20,110,20);
        rNama.setBounds(130,20,150,20);
        labelMassa.setBounds(20,45,110,20);
        rMassa.setBounds(130,45,150,20);
        labelHarga.setBounds(20,70,110,20);
        rHarga.setBounds(130,70,150,20);
        labelBanyak.setBounds(20,95,110,20);
        fieldBanyak.setBounds(130,95,120,20);
        
        btnTotal.setBounds(80,150,150,20);
        btnTotal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnTotal.setBackground(Color.black);
        btnTotal.setForeground(Color.white);
        btnTotal.addActionListener(this);
        
        btnKembali.setBounds(20,230,80,20);
        btnKembali.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnKembali.setBackground(Color.DARK_GRAY);
        btnKembali.setForeground(Color.white);
        btnKembali.addActionListener(this);
        
        btnEdit.setBounds(120,230,80,20);
        btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnEdit.setBackground(Color.blue);
        btnEdit.setForeground(Color.white);
        btnEdit.addActionListener(this);
        
        btnHapus.setBounds(220,230,80,20);
        btnHapus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnHapus.setBackground(Color.red);
        btnHapus.setForeground(Color.white);
        btnHapus.addActionListener(this);

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnTotal){
            String[] data = {
                rNama.getText(), rMassa.getText(), rHarga.getText(), fieldBanyak.getText(), id
            };
            TotalHargaView htg = new TotalHargaView();
            htg.totalHarga(data);
            dispose();
        }
        else if(e.getSource()==btnEdit){
            BarangController edit = new BarangController();
            edit.updateBarang(id);
            dispose();
        }
        else if(e.getSource()==btnHapus){
            BarangController dlt = new BarangController();
            dlt.hapusBarang(id);
        }
        else if(e.getSource()==btnKembali){
            BarangController brg = new BarangController();
            brg.lihatBarang();
            dispose();
        }
    }
}
