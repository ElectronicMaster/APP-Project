import java.awt.*;  // Set font and For drop down
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;   // Frame class exists in this

import java.util.*; // For random numbers

public class UpdateStudent extends JFrame implements ActionListener{
    JTextField textfieldName;
    JTextField textfieldFName;
    JTextField textfieldAddress;
    JTextField textfieldPhone;
    JTextField textfieldEmail;
    JTextField textfieldYear;
    Choice cRollno;
    Random ran = new Random();
    long firstFour = Math.abs((ran.nextLong() % 9000L) + 1000L);
    JButton submit;
    JButton cancel;

    UpdateStudent(){
        setSize(900, 650);
        setLocation(300, 50);

        setLayout(null);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel lblRollNumber = new JLabel("Select by Roll Number : ");
        lblRollNumber.setBounds(50, 100, 200, 20);
        lblRollNumber.setFont(new Font("serif",Font.PLAIN,20));
        add(lblRollNumber);

        cRollno = new Choice();
        cRollno.setBounds(250, 100, 200, 20);
        add(cRollno);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from students");
            while(rs.next()){
                cRollno.add(rs.getString("rollno"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("Name : ");
        lblname.setBounds(100, 150, 100, 30);
        lblname.setFont(new Font("Tahoma",Font.ITALIC,20));
        add(lblname);

        textfieldName = new JTextField();
        textfieldName.setBounds(200, 150, 150, 30);
        add(textfieldName);

        JLabel lblFName = new JLabel("Father's Name : ");
        lblFName.setBounds(400, 150, 300, 30);
        lblFName.setFont(new Font("serif",Font.BOLD,20));
        add(lblFName);

        textfieldFName = new JTextField();
        textfieldFName.setBounds(600, 150, 150, 30);
        add(textfieldFName);

        JLabel lblRollNo = new JLabel("Reg No : ");
        lblRollNo.setBounds(100, 200, 300, 30);
        lblRollNo.setFont(new Font("serif",Font.BOLD,20));
        add(lblRollNo);

        JLabel JLabelRollno = new JLabel();
        JLabelRollno.setBounds(200, 200, 150, 30);
        JLabelRollno.setFont(new Font("serif",Font.BOLD,20));
        add(JLabelRollno);

        JLabel lblDOB = new JLabel("Date of Birth : ");
        lblDOB.setBounds(400, 200, 300, 30);
        lblDOB.setFont(new Font("serif",Font.BOLD,20));
        add(lblDOB);

        JLabel JLabelDOB = new JLabel();
        JLabelDOB.setBounds(600, 200, 150, 30);
        JLabelDOB.setFont(new Font("serif",Font.BOLD,20));
        add(JLabelDOB);

        JLabel lblAddress = new JLabel("Address : ");
        lblAddress.setBounds(100, 250, 300, 30);
        lblAddress.setFont(new Font("serif",Font.BOLD,20));
        add(lblAddress);

        textfieldAddress = new JTextField();
        textfieldAddress.setBounds(200, 250, 150, 30);
        textfieldAddress.setFont(new Font("serif",Font.BOLD,20));
        add(textfieldAddress);
        
        JLabel lblPhone = new JLabel("Phone Number : ");
        lblPhone.setBounds(400, 250, 300, 30);
        lblPhone.setFont(new Font("serif",Font.BOLD,20));
        add(lblPhone);

        textfieldPhone = new JTextField();
        textfieldPhone.setBounds(600, 250, 150, 30);
        textfieldPhone.setFont(new Font("serif",Font.BOLD,20));
        add(textfieldPhone);

        JLabel lblEmail = new JLabel("Email ID : ");
        lblEmail.setBounds(100, 300, 300, 30);
        lblEmail.setFont(new Font("serif",Font.BOLD,20));
        add(lblEmail);

        textfieldEmail = new JTextField();
        textfieldEmail.setBounds(200, 300, 150, 30);
        textfieldEmail.setFont(new Font("serif",Font.BOLD,20));
        add(textfieldEmail);
        
        JLabel lblYear = new JLabel("Year : ");
        lblYear.setBounds(400, 300, 300, 30);
        lblYear.setFont(new Font("serif",Font.BOLD,20));
        add(lblYear);

        textfieldYear = new JTextField();
        textfieldYear.setBounds(600, 300, 150, 30);
        textfieldYear.setFont(new Font("serif",Font.BOLD,20));
        add(textfieldYear);

        JLabel lblCourse = new JLabel("Course : ");
        lblCourse.setBounds(100, 350, 300, 30);
        lblCourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblCourse);

        JLabel labelCourse = new JLabel();
        labelCourse.setBounds(200, 350, 150, 30);
        add(labelCourse);

        JLabel lblDepartment = new JLabel("Department : ");
        lblDepartment.setBounds(400, 350, 300, 30);
        lblDepartment.setFont(new Font("serif",Font.BOLD,20));
        add(lblDepartment);

        JLabel labelDepartment = new JLabel();
        labelDepartment.setBounds(600, 350, 150, 30);
        add(labelDepartment);

        // ROllNo,DOB,Course,Department

        try{
            Conn c = new Conn();
            String query = "select * from students where rollno='"+cRollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){   
                textfieldName.setText(rs.getString("nme"));
                textfieldFName.setText(rs.getString("fname"));
                JLabelRollno.setText(rs.getString("rollno"));
                JLabelDOB.setText(rs.getString("dob"));
                textfieldAddress.setText(rs.getString("address"));
                textfieldPhone.setText(rs.getString("phone"));
                textfieldEmail.setText(rs.getString("email"));
                textfieldYear.setText(rs.getString("yr"));
                labelCourse.setText(rs.getString("course"));
                labelDepartment.setText(rs.getString("department"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        cRollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String query = "select * from students where rollno='"+cRollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){   
                        textfieldName.setText(rs.getString("nme"));
                        textfieldFName.setText(rs.getString("fname"));
                        JLabelRollno.setText(rs.getString("rollno"));
                        JLabelDOB.setText(rs.getString("dob"));
                        textfieldAddress.setText(rs.getString("address"));
                        textfieldPhone.setText(rs.getString("phone"));
                        textfieldEmail.setText(rs.getString("email"));
                        textfieldYear.setText(rs.getString("yr"));
                        labelCourse.setText(rs.getString("course"));
                        labelDepartment.setText(rs.getString("department"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        // BUTTON
        // LOGIN
        submit = new JButton("Update");
        submit.setBounds(200,450,120,30);
        submit.setBackground(Color.CYAN);
        submit.setForeground(Color.BLACK);   // makes font white
        // BUTTON FUNCTION
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,15));
        add(submit);

        // CANCEL
        cancel = new JButton("Cancel");
        cancel.setBounds(600,450,120,30);
        cancel.setBackground(Color.LIGHT_GRAY);
        cancel.setForeground(Color.BLACK);   // makes font white
        // BUTTON FUNCTION
        cancel.addActionListener(this);

        cancel.setFont(new Font("serif",Font.BOLD,15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String rollno = cRollno.getSelectedItem();
            String name = textfieldName.getText();
            String fname = textfieldFName.getText();
            String address = textfieldAddress.getText();
            String phone = textfieldPhone.getText();
            String email = textfieldEmail.getText();
            String year = textfieldYear.getText();

            try{
                String query = "update students set nme = '"+name+"',fname = '"+fname+"',address = '"+address+"',phone = '"+phone+"',email = '"+email+"',yr = '"+year+"' where rollno = '"+rollno+"'";
                Conn con = new Conn();
                con.s.executeLargeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student Details Inserted Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new UpdateStudent();
    }
}