import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Marks extends JFrame implements ActionListener{

    String rollno;
    JButton cancel;

    Marks(String rollno){
        this.rollno = rollno;

        setSize(500, 600);
        setLocation(500, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("SRM UNIVERSITY");
        heading.setBounds(150, 10, 500, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel subheading = new JLabel("Result of Examination 2023");
        subheading.setBounds(115, 50, 500, 30);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(subheading);

        JLabel lblRollNo = new JLabel("Roll Number : " + rollno);
        lblRollNo.setBounds(60, 100, 500, 30);
        lblRollNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblRollNo);

        JLabel lblSemester = new JLabel();
        lblSemester.setBounds(60, 130, 500, 30);
        lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblSemester);

        JLabel Sub1 = new JLabel();
        Sub1.setBounds(100, 200, 500, 30);
        Sub1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(Sub1);

        JLabel Sub2 = new JLabel();
        Sub2.setBounds(100, 230, 500, 30);
        Sub2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(Sub2);

        JLabel Sub3 = new JLabel();
        Sub3.setBounds(100, 260, 500, 30);
        Sub3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(Sub3);

        JLabel Sub4 = new JLabel();
        Sub4.setBounds(100, 290, 500, 30);
        Sub4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(Sub4);

        JLabel Sub5 = new JLabel();
        Sub5.setBounds(100, 320, 500, 30);
        Sub5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(Sub5);

        try{
            Conn c = new Conn();
            ResultSet rs1 = c.s.executeQuery("select * from subject where rollno = '" + rollno + "'");
            while(rs1.next()){
                Sub1.setText(rs1.getString("subject1"));
                Sub2.setText(rs1.getString("subject2"));
                Sub3.setText(rs1.getString("subject3"));
                Sub4.setText(rs1.getString("subject4"));
                Sub5.setText(rs1.getString("subject5"));
            }

            ResultSet rs2 = c.s.executeQuery("select * from marks where rollno = '" + rollno + "'");
            while(rs2.next()){
                Sub1.setText(Sub1.getText() + "-------------" + rs2.getString("marks1"));
                Sub2.setText(Sub2.getText() + "-------------" + rs2.getString("marks2"));
                Sub3.setText(Sub3.getText() + "-------------" + rs2.getString("marks3"));
                Sub4.setText(Sub4.getText() + "-------------" + rs2.getString("marks4"));
                Sub5.setText(Sub5.getText() + "-------------" + rs2.getString("marks5"));
                lblSemester.setText("Semester : " + rs2.getString("semester"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        cancel = new JButton("Cancel");
        cancel.setBounds(175,500,120,25);
        cancel.setBackground(Color.LIGHT_GRAY);
        cancel.setForeground(Color.BLACK);   // makes font white
        // BUTTON FUNCTION
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String[] args){
        new Marks("");
    }
}