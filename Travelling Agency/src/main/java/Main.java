import controller.DestinationController;
import presentation.LoginFrame;
import controller.PackageController;
import controller.UserController;

import javax.swing.*;

public class Main {

    public static final UserController userController = new UserController();
    public static final PackageController packController = new PackageController();
    public static final DestinationController destController = new DestinationController();
    public static void main(String[] args) {
        JFrame frame = new JFrame("Travelling");
        LoginFrame fr = new LoginFrame();
        frame.setContentPane(fr.getLoginPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
