package presentation;

import controller.DestinationController;
import controller.PackageController;
import controller.UserController;
import model.Pack;
import model.User;

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
    private JTextField periodField2;
    private JTextField priceField2;
    private JButton viewBookedButton;
    public static final PackageController packController = new PackageController();
    public static final DestinationController destController = new DestinationController();
    public static final UserController userController = new UserController();



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
    public UserFrame(User u){
        setHeader(table);
        viewButton.addActionListener(e->{
                setContent(packController.getAvailable(),table);});
        filterButton.addActionListener(e->{
            if(!packField.getText().isEmpty())
                setContent(packController.getByDst(packField.getText()),table);
            if(!priceField.getText().isEmpty()&&!priceField2.getText().isEmpty())
                setContent(packController.getSmallerPrice(Integer.parseInt(priceField.getText()),Integer.parseInt(priceField2.getText())),table);
            if(!periodField.getText().isEmpty()&&!periodField2.getText().isEmpty())
                setContent(packController.getLargerPeriod(Integer.parseInt(periodField.getText()),Integer.parseInt(periodField2.getText())),table);
            if(!packField.getText().isEmpty()&&!priceField.getText().isEmpty()&&!priceField2.getText().isEmpty()) {
                setContent(packController.getFilterDestPrice(packField.getText(), Integer.parseInt(priceField.getText()), Integer.parseInt(priceField2.getText())),table);
            }
            if(!packField.getText().isEmpty()&&!priceField.getText().isEmpty()&&!priceField2.getText().isEmpty()&&!periodField.getText().isEmpty()&&!periodField2.getText().isEmpty())
            {
                setContent(packController.getFilterAll(packField.getText(),Integer.parseInt(priceField.getText()),Integer.parseInt(priceField2.getText()),Integer.parseInt(periodField.getText()),Integer.parseInt(periodField2.getText())), table);}
            if(!priceField.getText().isEmpty()&&!priceField2.getText().isEmpty()&&!periodField.getText().isEmpty()&&!periodField2.getText().isEmpty()){
                setContent(packController.getFilterPricePeriod(Integer.parseInt(priceField.getText()),Integer.parseInt(priceField2.getText()),Integer.parseInt(periodField.getText()),Integer.parseInt(periodField2.getText())),table);

            }
            if(!packField.getText().isEmpty()&&!periodField.getText().isEmpty()&&!periodField2.getText().isEmpty()){
                setContent(packController.getFilterDestPeriod(packField.getText(), Integer.parseInt(periodField.getText()), Integer.parseInt(periodField2.getText())),table);
            }



        });
        setHeader(table1);
        viewBookedButton.addActionListener(e->{
            setContent(u.getPacks(), table1);

        });
        bookButton.addActionListener(e->{
            packController.updatePack(packController.findByName(packField.getText()));
            userController.bookPack(u,packController.findByName(packField.getText()));

        });
    }
}
