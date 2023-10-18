import javax.swing.*;   // frame [1]
import java.awt.*;  // for color [1]
import java.awt.event.*;
import java.sql.*;

// JLabel class is used to write information onto the frame

public class Login extends JFrame implements ActionListener {

    JButton login,cancel;
    JTextField textFieldUsername,textFieldPassword;

    Login(){
        getContentPane().setBackground(Color.CYAN); // Frame bg color [1]
        setLayout(null);

        // USERNAME
        JLabel labelUsername = new JLabel("Username : ");
        labelUsername.setFont(new Font("Tahoma",Font.PLAIN,17));
        labelUsername.setBounds(40,20,100,20);  // it explicitly places it ["Username"] [1] 
                            // (location x,location y, label width, label height)
        add(labelUsername);

        textFieldUsername = new JTextField();    // to get input box
        textFieldUsername.setBounds(150,20,150,20);
        add(textFieldUsername);

        // PASSWORD
        JLabel labelPassword = new JLabel("Password  : ");
        labelPassword.setFont(new Font("Tahoma",Font.PLAIN,17));
        labelPassword.setBounds(40,70,100,20);  // it explicitly places it ["Username"] [1] 
                            // (location x,location y, label width, label height)
        add(labelPassword);

        textFieldPassword = new JPasswordField();    // to get input box but for password
        textFieldPassword.setBounds(150,70,150,20);
        add(textFieldPassword);

        // BUTTON
        // LOGIN
        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.DARK_GRAY);
        login.setForeground(Color.WHITE);   // makes font white
        // BUTTON FUNCTION
        login.addActionListener(this);
        login.setFont(new Font("serif",Font.BOLD,15));
        add(login);

        // CANCEL
        cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.DARK_GRAY);
        cancel.setForeground(Color.WHITE);   // makes font white
        // BUTTON FUNCTION
        cancel.addActionListener(this);

        cancel.setFont(new Font("serif",Font.BOLD,15));
        add(cancel);

        // IMAGE
        // class : ImageIcon , Object : i1 [1]
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("student-login.jpeg")); 
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,20,200,200);
        add(image);

        // FRAME
        setSize(600,300);   // To set size of frame [1]
        setLocation(500,250);   // To set frame location [1]
        setVisible(true);   // to make fram visible [1]
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String username = textFieldUsername.getText();
            String password = textFieldPassword.getText();

            String query = "Select * from login where username='" + username + "' and password='" + password + "'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){
                    setVisible(false);
                    new Project();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new Login();
    }
}