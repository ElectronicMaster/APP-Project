import java.awt.*;  // color
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class TeacherLeave extends JFrame implements ActionListener{

    Choice cempID;
    Choice cduration;
    JTextField textfieldDate;
    JButton submit;
    JButton cancel;

    TeacherLeave(){
        setSize(500, 550);
        setLocation(525, 100);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Apply leave (Teacher) : ");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel lblRollNo = new JLabel("Search by Emp ID : ");
        lblRollNo.setBounds(60, 100, 300, 20);
        lblRollNo.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lblRollNo);

        cempID = new Choice();
        cempID.setBounds(60, 130, 200, 20);
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

        JLabel lbldate = new JLabel("Date : ");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lbldate);

        textfieldDate = new JTextField();
        textfieldDate.setBounds(60, 210, 200, 20);
        add(textfieldDate);

        JLabel lblDuration = new JLabel("Date : ");
        lblDuration.setBounds(60, 260, 200, 20);
        lblDuration.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lblDuration);

        cduration = new Choice();
        cduration.setBounds(60, 290, 200, 20);
        cduration.add("Full Day");
        cduration.add("Half Day");
        add(cduration);

        submit = new JButton("Submit");
        submit.setBounds(60,350,100,30);
        submit.setBackground(Color.CYAN);
        submit.setForeground(Color.BLACK);   // makes font white
        // BUTTON FUNCTION
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,15));
        add(submit);

        // CANCEL
        cancel = new JButton("Cancel");
        cancel.setBounds(200,350,100,30);
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
            String date = textfieldDate.getSelectedText();
            String duration = cduration.getSelectedItem();
            
            String query = "insert into teacherleave values('"+ empID +"','"+ date +"','"+ duration +"')";

            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirm");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new TeacherLeave();
    }
}
