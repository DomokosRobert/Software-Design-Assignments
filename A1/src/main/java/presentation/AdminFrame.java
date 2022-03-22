package presentation;

import controller.DestinationController;
import controller.PackageController;
import model.Pack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AdminFrame {
    private JPanel AdminPanel;
    private JButton viewButton;
    private JButton addButton;
    private JButton addDestinationButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JTextField destField;
    private JTextField priceField;
    private JTextField packageField;
    private JTextField periodField;
    private JTextField slotsField;
    private JButton deleteDestinationButton;
    private JTable table1;
    private JTextField detailsField;
    public static final PackageController packController = new PackageController();
    public static final DestinationController destController = new DestinationController();


    public JPanel getAdminPanel() {
        return AdminPanel;
    }
    public void setHeader(){

        DefaultTableModel tb = (DefaultTableModel) table1.getModel();
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
    public void setContent(List<Pack> pack){

        DefaultTableModel tb = (DefaultTableModel) table1.getModel();
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
    public AdminFrame(){
        setHeader();
        viewButton.addActionListener(e->{
            setContent(packController.getAllPacks());
        });
        addDestinationButton.addActionListener(e->{

            destController.createDestination(destController.getAllDest().size()+1, destField.getText(),null);
        });
        addButton.addActionListener(e->{
            packController.createPackage(packController.getAllPacks().size()+1,packageField.getText(),Integer.parseInt(priceField.getText()),Integer.parseInt(slotsField.getText()),Integer.parseInt(periodField.getText()),detailsField.getText(),destController.getByCity(destField.getText()));
        });
        updateButton.addActionListener(e->{

            if(!priceField.getText().isEmpty())
                packController.updatePrice(packageField.getText(), Integer.parseInt(priceField.getText()));
            if(!periodField.getText().isEmpty())
                packController.updatePeriodTime(packageField.getText(), Integer.parseInt(periodField.getText()));
            if(!slotsField.getText().isEmpty())
                packController.updateSlots(packageField.getText(), Integer.parseInt(slotsField.getText()));
            if(!detailsField.getText().isEmpty())
                packController.updateDetails(packageField.getText(), detailsField.getText());

        });
        deleteButton.addActionListener(e->{
            packController.deletePack(packageField.getText());
        });
        deleteDestinationButton.addActionListener(e->{
            packController.deleteDestPack(destController.getByCity(destField.getText()).getId());
            destController.deleteDest(destField.getText());
        });
    }
}
