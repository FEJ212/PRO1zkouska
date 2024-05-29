import funkce.ukladani;
import javax.swing.*;
import java.awt.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.*;

public class Mince extends JFrame{
    DefaultTableModel model = new DefaultTableModel();
    JTable tabulka = new JTable(model);
    public static void main(String [] args) {
        new Mince();
    }
    public Mince(){
        model.addColumn("Typ platidla");
        model.addColumn("nominální hodnota");
        model.addColumn("počet ks");
        JToolBar panelUI = new JToolBar();
        JTextField textovePole = new JTextField ("", 10);
        textovePole.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                textovePole.setText("");
            }
        });
        JButton submit = new JButton("vypočítat");
        submit.addActionListener(e -> {
            if (!(textovePole.getText().isEmpty())&&((int)Double.parseDouble(textovePole.getText())>0)) {
                vypocet((int) Double.parseDouble(textovePole.getText()));
            } else {
                System.out.println("Chyba vstupu");
            }
        });
        JButton vycetka = new JButton("výčetka");
        vycetka.addActionListener(e -> ukladani.zapis(tabulka));
        JLabel popis = new JLabel("Zadejte finanční hodnotu: ");
        panelUI.add(popis);
        panelUI.add(textovePole);
        panelUI.add(submit);
        panelUI.add(vycetka);
        this.setSize(800, 600);
        this.setTitle("Počítadlo hotovosti");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panelUI, BorderLayout.NORTH);
        this.setVisible(true);
    }
    public void vypocet(int hodnota){
        while (model.getRowCount()!=0){
            model.removeRow(0);
        }
        JTable tabulka = new JTable(model);
        while (hodnota != 0) {
            if (hodnota>=5000) {
                int petK = hodnota / 5000;
                hodnota = hodnota - (petK * 5000);
                model.insertRow(0, new Object[]{"bankovka", "5000kč", petK});
            } else if (hodnota>=2000) {
                int dveK = hodnota / 2000;
                hodnota = hodnota - (dveK * 2000);
                model.insertRow(0, new Object[]{"bankovka", "2000kč", dveK});
            } else if (hodnota>=1000) {
                int jednaK = hodnota / 1000;
                hodnota = hodnota - (jednaK * 1000);
                model.insertRow(0, new Object[]{"bankovka", "1000kč", jednaK});
            } else if (hodnota>=500) {
                int petS = hodnota / 500;
                hodnota = hodnota - (petS * 500);
                model.insertRow(0, new Object[]{"bankovka", "500kč", petS});
            } else if (hodnota>=200) {
                int dveS = hodnota / 200;
                hodnota = hodnota - (dveS * 200);
                model.insertRow(0, new Object[]{"bankovka", "200kč", dveS});
            } else if (hodnota>=100) {
                int jednaS = hodnota / 100;
                hodnota = hodnota - (jednaS * 100);
                model.insertRow(0, new Object[]{"bankovka", "100kč", jednaS});
            } else if (hodnota>=50) {
                int pade = hodnota / 50;
                hodnota = hodnota - (pade * 50);
                model.insertRow(0, new Object[]{"mince", "50kč", pade});
            } else if (hodnota>=20) {
                int dvacet = hodnota / 20;
                hodnota = hodnota - (dvacet * 20);
                model.insertRow(0, new Object[]{"mince", "20kč", dvacet});
            } else if (hodnota>=10) {
                int deset = hodnota / 10;
                hodnota = hodnota - (deset * 10);
                model.insertRow(0, new Object[]{"mince", "10kč", deset});
            } else if (hodnota>=5) {
                int pet = hodnota / 5;
                hodnota = hodnota - (pet * 5);
                model.insertRow(0, new Object[]{"mince", "5kč", pet});
            } else if (hodnota>=2) {
                int dve = hodnota / 2;
                hodnota = hodnota - (dve * 2);
                model.insertRow(0, new Object[]{"mince", "2kč", dve});
            } else {
                int jedna = hodnota;
                hodnota -= jedna;
                model.insertRow(0, new Object[]{"mince", "1kč", jedna});
            }
        }
        this.add(tabulka, BorderLayout.CENTER);
        this.add(new JScrollPane(tabulka));
        this.setVisible(true);
    }
}
