import java.awt.*;  // Set font and For drop down
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;   // Frame class exists in this

public class UpdateTeacher extends JFrame implements ActionListener{
    JTextField textfieldName;
    JTextField textfieldSubject;
    JTextField textfieldAddress;
    JTextField textfieldPhone;
    JTextField textfieldEmail;
    JTextField textfieldQualification;
    JComboBox<String> Department;
    Choice cempID;
    JButton submit;
    JButton cancel;

    UpdateTeacher(){
        setSize(900, 650);
        setLocation(300, 50);

        setLayout(null);

        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel lblRollNumber = new JLabel("Select by Employee ID : ");
        lblRollNumber.setBounds(50, 100, 200, 20);
        lblRollNumber.setFont(new Font("serif",Font.PLAIN,20));
        add(lblRollNumber);

        cempID = new Choice();
        cempID.setBounds(250, 100, 200, 20);
        add(cempID);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from teacher");
            while(rs.next()){
                cempID.add(rs.getString("empID"));
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

        JLabel lblSubject = new JLabel("Subject : ");
        lblSubject.setBounds(400, 150, 300, 30);
        lblSubject.setFont(new Font("serif",Font.BOLD,20));
        add(lblSubject);

        textfieldSubject = new JTextField();
        textfieldSubject.setBounds(600, 150, 150, 30);
        add(textfieldSubject);

        JLabel lblempID = new JLabel("Emp ID : ");
        lblempID.setBounds(100, 200, 300, 30);
        lblempID.setFont(new Font("serif",Font.BOLD,20));
        add(lblempID);

        JLabel JLabelempID = new JLabel();
        JLabelempID.setBounds(200, 200, 150, 30);
        JLabelempID.setFont(new Font("serif",Font.BOLD,20));
        add(JLabelempID);

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
        
        JLabel lblQualification = new JLabel("Qualification : ");
        lblQualification.setBounds(400, 300, 300, 30);
        lblQualification.setFont(new Font("serif",Font.BOLD,20));
        add(lblQualification);

        textfieldQualification = new JTextField();
        textfieldQualification.setBounds(600, 300, 150, 30);
        textfieldQualification.setFont(new Font("serif",Font.BOLD,20));
        add(textfieldQualification);

        JLabel lblDepartment = new JLabel("Department : ");
        lblDepartment.setBounds(100, 350, 300, 30);
        lblDepartment.setFont(new Font("serif",Font.BOLD,20));
        add(lblDepartment);

        String arrDepartment[] = {"CSC","ECE","BDA","MECH","COMMERCE","CIVIL","IT"};
        Department = new JComboBox<>(arrDepartment);
        Department.setBounds(225, 350, 150, 30);
        add(Department);

        // empID,DOB

        try{
            Conn c = new Conn();
            String query = "select * from teacher where empID='"+cempID.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){   
                textfieldName.setText(rs.getString("nme"));
                textfieldSubject.setText(rs.getString("subject"));
                JLabelempID.setText(rs.getString("empID"));
                JLabelDOB.setText(rs.getString("dob"));
                textfieldAddress.setText(rs.getString("address"));
                textfieldPhone.setText(rs.getString("phone"));
                textfieldEmail.setText(rs.getString("email"));
                textfieldQualification.setText(rs.getString("qualification"));
                Department.setSelectedItem(rs.getString("department"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        cempID.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String query = "select * from teacher where empID='"+cempID.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){   
                        textfieldName.setText(rs.getString("nme"));
                        textfieldSubject.setText(rs.getString("subject"));
                        JLabelempID.setText(rs.getString("empID"));
                        JLabelDOB.setText(rs.getString("dob"));
                        textfieldAddress.setText(rs.getString("address"));
                        textfieldPhone.setText(rs.getString("phone"));
                        textfieldEmail.setText(rs.getString("email"));
                        textfieldQualification.setText(rs.getString("qualification"));
                        Department.setSelectedItem(rs.getString("department"));
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
            String empID = cempID.getSelectedItem();
            String name = textfieldName.getText();
            String subject = textfieldSubject.getText();
            String address = textfieldAddress.getText();
            String phone = textfieldPhone.getText();
            String email = textfieldEmail.getText();
            String qualification = textfieldQualification.getText();
            String department = Department.getSelectedItem().toString();
    
            try{
                String query = "update teacher set nme = '"+name+"', subject = '"+subject+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', qualification = '"+qualification+"', department = '"+department+"' where empID = '"+empID+"'";
                Conn con = new Conn();
                con.s.executeUpdate(query);  // Use executeUpdate instead of executeLargeUpdate
                JOptionPane.showMessageDialog(null, "Teacher Details Updated Successfully");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    


    public static void main(String[] args){
        new UpdateTeacher();
    }
}