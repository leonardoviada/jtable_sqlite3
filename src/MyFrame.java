import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.nio.charset.Charset;
import java.util.Random;

public class MyFrame extends JFrame {

    JTable tblTable = null;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame();
            }
        });
    }

    private MyFrame() {
        setTitle("Frame inizio anno 2020-2021");
        setSize(500, 300);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initUI();

        setVisible(true);

        loadTable();
    }

    private void initUI() {
        tblTable = new JTable();
        DefaultTableModel model = (DefaultTableModel) tblTable.getModel();

        String[] columns = {"id", "nome", "value"};
        for (String col: columns)
            model.addColumn(col);
        tblTable.setModel(model);

        JScrollPane pnlTable = new JScrollPane(tblTable);
        this.add(pnlTable, BorderLayout.CENTER);
    }

    private void addNewRow(int id, String nome, int value) {
        String[] row = {"" + id, nome, "" + value};
        DefaultTableModel model = (DefaultTableModel) tblTable.getModel();
        model.addRow(row);
        tblTable.setModel(model);
    }

    private void loadTable() {
        for(int id = 0; id<50; id++) {
            addNewRow(id, randomString() , id*100);
        }
    }

    private String randomString() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}