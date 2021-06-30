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
public class TotalHargaView extends JFrame implements ActionListener {
    private JLabel rNama, rMassa, rHarga, rTotal;
    String id;
    
    JLabel labelNama = new JLabel("Nama : ");
    JLabel labelMassa = new JLabel("Massa (gr) : ");
    JLabel labelHarga = new JLabel("Harga Satuan : ");
    JLabel labelTotal = new JLabel("Total Harga : ");
    
    JButton btnKembali = new JButton("Kembali");
    
    public void totalHarga(String[] data){
        setTitle(data[0]);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(340,325);
        
        this.id = data[4];
        double a = Double.parseDouble(data[2]);
        double b = Double.parseDouble(data[3]);
        double total=a*b;
        if(b == 12) 
            {total=total-(0.05*total);}
        else if(b == 20)
            {total=total-(0.1*total);}
        else if(b == 144)
            {total=total-(0.25*total);}
        
        String Total=String.valueOf(total);
        
        rNama = new JLabel(data[0]);
        rMassa = new JLabel(data[1]);
        rHarga = new JLabel(data[2]);
        rTotal = new JLabel(Total);
        
        setLayout(null);
        add(labelNama);
        add(labelMassa);
        add(labelHarga);
        add(labelTotal);
        add(rNama);
        add(rMassa);
        add(rHarga);
        add(rTotal);
        add(btnKembali);
        
        labelNama.setBounds(20,20,110,20);
        rNama.setBounds(130,20,150,20);
        labelMassa.setBounds(20,45,110,20);
        rMassa.setBounds(130,45,150,20);
        labelHarga.setBounds(20,70,110,20);
        rHarga.setBounds(130,70,150,20);
        labelTotal.setBounds(20,95,110,20);
        rTotal.setBounds(130,95,150,20);
        
        btnKembali.setBounds(20,250,80,20);
        btnKembali.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnKembali.setBackground(Color.DARK_GRAY);
        btnKembali.setForeground(Color.white);
        btnKembali.addActionListener(this);
        
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnKembali){
            dispose();
            BarangController bc = new BarangController();
            bc.lihatBarang(id);
        }
    }
}
