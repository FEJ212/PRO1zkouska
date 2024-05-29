package funkce;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;

public class Ukladani {
    public static void zapis(JTable tabulka){
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Text file", "txt"));
            fileChooser.setCurrentDirectory(new File("P:\\PRO1"));
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File soubor = fileChooser.getSelectedFile();
                FileWriter myWriter = new FileWriter(soubor.getAbsolutePath()+".txt");
                for (int row = 0; row < tabulka.getRowCount(); row++) {
                    for (int col = 0; col < tabulka.getColumnCount(); col++) {
                        myWriter.write(tabulka.getColumnName(col));
                        myWriter.write(": ");
                        myWriter.write(tabulka.getValueAt(row, col).toString());
                        myWriter.write("\n");
                    }
                    myWriter.write("\n");
                }
                myWriter.close();
            } else {
                System.out.println("Soubor nevybrán!");
            }
        } catch (IOException e) {
            System.out.println("Objevila se chyba: " + e.getMessage());
        }
    }
}
