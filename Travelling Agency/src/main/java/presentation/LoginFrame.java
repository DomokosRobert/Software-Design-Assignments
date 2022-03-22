package presentation;

import controller.UserController;
import model.User;

import javax.swing.*;

public class LoginFrame {
    private final UserController cont;

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JPanel LoginPanel;

    public LoginFrame(){
        cont= new UserController();
        loginButton.addActionListener(e->{
            String u,p;
            u = usernameField.getText();
            p = passwordField.getText();
            if(u.equals("admin")&&p.equals("admin")){
                JFrame frame = new JFrame("AdministratorGUI");
                AdminFrame fr = new AdminFrame();
                frame.setContentPane(fr.getAdminPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
            else
            {
                User u1= cont.getByUsername(u);
                if(u1!=null){
                    if(u1.getPassword().equals(p))
                    {
                        JFrame frame = new JFrame("UserGUI");
                        UserFrame fr = new UserFrame();
                        frame.setContentPane(fr.getUserPanel());
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(LoginPanel, "Wrong password!");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(LoginPanel, "User not existent!");
                }

            }

        });
        registerButton.addActionListener(e->{
            String u,p;
            u = usernameField.getText();
            p = passwordField.getText();
            int newId = cont.getAllUsers().size();
            cont.createUser(newId+1,u,p);
        });
    }

    public JPanel getLoginPanel() {
        return LoginPanel;
    }
}
