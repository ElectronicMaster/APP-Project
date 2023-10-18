import java.awt.*;  // Set font and For drop down
import java.awt.event.*;

import javax.swing.*;   // Frame class exists in this

import java.util.*; // For random numbers

public class AddStudent extends JFrame implements ActionListener{
    JTextField textfieldName;
    JTextField textfieldFName;
    JTextField textfieldAddress;
    JTextField textfieldPhone;
    JTextField textfieldEmail;
    JTextField textfieldYear;
    JTextField textfieldDOB;
    JTextField textfieldRollno;
    Random ran = new Random();
    long firstFour = Math.abs((ran.nextLong() % 9000L) + 1000L);
    JComboBox<String> course; // for label
    JComboBox<String> Department;
    JButton submit;
    JButton cancel;

    AddStudent(){
        setSize(900, 700);
        setLocation(300, 50);

        setLayout(null);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(325, 30, 500, 50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel lblname = new JLabel("Name : ");
        lblname.setBounds(100, 150, 100, 30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
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

        textfieldRollno = new JTextField();
        textfieldRollno.setBounds(200, 200, 150, 30);
        textfieldRollno.setFont(new Font("serif",Font.BOLD,20));
        add(textfieldRollno);

        JLabel lblDOB = new JLabel("Date of Birth : ");
        lblDOB.setBounds(400, 200, 300, 30);
        lblDOB.setFont(new Font("serif",Font.BOLD,20));
        add(lblDOB);

        textfieldDOB = new JTextField();
        textfieldDOB.setBounds(600, 200, 150, 30);
        textfieldDOB.setFont(new Font("serif",Font.BOLD,20));
        add(textfieldDOB);

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

        String arrCourse[] = {"B.Tech","B.Com","BSc","BCA"};
        course = new JComboBox<>(arrCourse);
        course.setBounds(200, 350, 150, 30);
        add(course);

        JLabel lblDepartment = new JLabel("Department : ");
        lblDepartment.setBounds(400, 350, 300, 30);
        lblDepartment.setFont(new Font("serif",Font.BOLD,20));
        add(lblDepartment);

        String arrDepartment[] = {"CSC","ECE","BDA","MECH","COMMERCE","CIVIL","IT"};
        Department = new JComboBox<>(arrDepartment);
        Department.setBounds(600, 350, 150, 30);
        add(Department);

        // BUTTON
        // LOGIN
        submit = new JButton("Submit");
        submit.setBounds(200,450,120,30);
        submit.setBackground(Color.CYAN);
        submit.setForeground(Color.BLACK);   // makes font white
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
            String name = textfieldName.getText();
            String fname = textfieldFName.getText();
            String rollno = textfieldRollno.getText();
            String dob = textfieldDOB.getText();
            String address = textfieldAddress.getText();
            String phone = textfieldPhone.getText();
            String email = textfieldEmail.getText();
            String year = textfieldYear.getText();
            String Course = (String) course.getSelectedItem();
            String department = (String) Department.getSelectedItem();

            try{
                String query = "insert into students values('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+year+"','"+Course+"','"+department+"')";
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
        new AddStudent();
    }
}