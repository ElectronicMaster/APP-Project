import javax.swing.*;   
import java.awt.*;  
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login,cancel;
    JTextField textFieldUsername,textFieldPassword;

    Login(){
        getContentPane().setBackground(Color.CYAN); 
        setLayout(null);

        JLabel labelUsername = new JLabel("Username : ");
        labelUsername.setFont(new Font("Tahoma",Font.PLAIN,17));
        labelUsername.setBounds(40,20,100,20);  
        add(labelUsername);

        textFieldUsername = new JTextField();   
        textFieldUsername.setBounds(150,20,150,20);
        add(textFieldUsername);

        JLabel labelPassword = new JLabel("Password  : ");
        labelPassword.setFont(new Font("Tahoma",Font.PLAIN,17));
        labelPassword.setBounds(40,70,100,20);  
        add(labelPassword);

        textFieldPassword = new JPasswordField();
        textFieldPassword.setBounds(150,70,150,20);
        add(textFieldPassword);

        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.DARK_GRAY);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("serif",Font.BOLD,15));
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.DARK_GRAY);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);

        cancel.setFont(new Font("serif",Font.BOLD,15));
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("student-login.jpeg")); 
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,20,200,200);
        add(image);

        setSize(600,300);
        setLocation(500,250); 
        setVisible(true);
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