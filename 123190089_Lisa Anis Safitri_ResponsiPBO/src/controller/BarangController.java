package controller;

import javax.swing.JOptionPane;
import model.BarangModel;
import view.BarangFormView;
import view.DetailBarangView;
import view.MainMenuView;
import view.TabelBarangView;
import view.UpdateBarangView;

/**
 *
 * @author Lisa Anis Safitri
 */
public class BarangController {
    public void tambahBarang(){
        BarangFormView fbarang = new BarangFormView();
        fbarang.bukaForm();
    }
    
    public void tambahBarang(String[] data){
        BarangModel tb = new BarangModel();
        tb.tambahBarang(data);
    }
    
    public void lihatBarang(){
        BarangModel lb = new BarangModel();
        String[][] data = lb.lihatBarang();
        if(data == null)
            new MainMenuView();
        else
            new TabelBarangView(data);
    }
    
    public void lihatBarang(String y) {
        BarangModel brgModel = new BarangModel();
        DetailBarangView detail = new DetailBarangView();
        detail.lihatDetail(brgModel.lihatBarang(y));
    }
    
    public void updateBarang(String id){
        BarangModel model = new BarangModel();
        String kode = model.getData("id", "barang", "id", id);
        UpdateBarangView ubah = new UpdateBarangView();
        ubah.bukaForm(model.lihatBarang(kode));
    }
    
    public void updateBarang(String[] data){
        BarangModel ub = new BarangModel(); 
        ub.updateData(data);
    }
    
    public void hapusBarang(String id){
        int confirm = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus ?", "Message", JOptionPane.YES_NO_OPTION);
        if(confirm == 0){
            BarangModel hapus = new BarangModel();
            hapus.delete(id);}
    }
}
