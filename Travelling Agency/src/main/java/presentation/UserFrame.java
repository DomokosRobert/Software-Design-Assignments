package presentation;

import controller.DestinationController;
import controller.PackageController;
import model.Pack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class UserFrame {

    private JPanel userPanel;
    private JTextField periodField;
    private JTextField priceField;
    private JTextField packField;
    private JButton bookButton;
    private JButton viewButton;
    private JTable table;
    private JButton filterButton;
    private JTable table1;
    public static final PackageController packController = new PackageController();
    public static final DestinationController destController = new DestinationController();


    public JPanel getUserPanel() {
        return userPanel;
    }
    public void setHeader(JTable table){

        DefaultTableModel tb = (DefaultTableModel) table.getModel();
        String[] col= new String[7];
        col[0]="Name";
        col[1]="Price";
        col[2]="Places";
        col[3]="Period";
        col[4]="Details";
        col[5]="Status";
        col[6]="Destination";

        tb.setColumnIdentifiers(col);

    }
    public void setContent(List<Pack> pack,JTable table){

        DefaultTableModel tb = (DefaultTableModel) table.getModel();
        tb.setRowCount(0);
        for(Pack m: pack)
        {

            Object[] ob=new Object[7];
            ob[0]=m.getName();
            ob[1]=m.getPrice();
            ob[2]=m.getPeopleNum();
            ob[3]=m.getPeriodTime();
            ob[4]=m.getDetails();
            ob[5]=m.getStat();
            ob[6]=m.getDestinations().getCity();
            tb.addRow(ob);

        }
    }
    public UserFrame(){
        setHeader(table);
        viewButton.addActionListener(e->{
                setContent(packController.getAvailable(),table);});
        filterButton.addActionListener(e->{
            if(!packField.getText().isEmpty())
                setContent(packController.getByDst(packField.getText()),table);
            if(!priceField.getText().isEmpty())
                setContent(packController.getSmallerPrice(Integer.parseInt(priceField.getText())),table);
            if(!periodField.getText().isEmpty())
                setContent(packController.getLargerPeriod(Integer.parseInt(periodField.getText())),table);

        });
        setHeader(table1);
        bookButton.addActionListener(e->{


        });
    }
}
