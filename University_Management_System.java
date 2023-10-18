import java.awt.Image;

import javax.swing.*;

/*
    To open multiple fram 1 for main other for login we will use multi threading concept
*/

public class University_Management_System extends JFrame{
    Thread t;

    University_Management_System(){
        // // class : ImageIcon , Object : i1 [1]
        // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("College.png")); 
        // Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        // ImageIcon i3 = new ImageIcon(i2);
        // JLabel image = new JLabel(i3);
        // add(image);

        // setLocation(250,100); // Frame default location is at top left to change it we use this [1]
        // setSize(1000, 700);
        // setVisible(true); // makes frame visibility true [1]

        new Login();
    }

    public static void main(String [] args){
        new University_Management_System(); // Ananimous Object [1]
    }
}