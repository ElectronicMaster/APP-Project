import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class EnterMarks extends JFrame implements ActionListener{
    
    Choice cRollno;
    JComboBox cbsemester;
    JTextField tfSub1,tfSub2,tfSub3,tfSub4,tfSub5;
    JTextField tfMark1,tfMark2,tfMark3,tfMark4,tfMark5;
    JButton submit;
    JButton cancel;

    EnterMarks(){
        setSize(1000,500);
        setLocation(250,150);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("examPic.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,40,400,300);
        add(image);

        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);

        JLabel lblRollNumber = new JLabel("Select by Roll Number : ");
        lblRollNumber.setBounds(50, 70, 150, 20);
        add(lblRollNumber);

        cRollno = new Choice();
        cRollno.setBounds(200, 70, 150, 20);
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

        JLabel lblSemester = new JLabel("Select Semester : ");
        lblSemester.setBounds(50, 110, 150, 20);
        add(lblSemester);

        String semester[] = {"I","II","III","IV","V","VI","VII","VIII"};
        cbsemester = new JComboBox<>(semester);
        cbsemester.setBounds(200, 110, 150, 20);
        cbsemester.setBackground(Color.white);
        add(cbsemester);

        JLabel lblSubject = new JLabel("Enter Subject : ");
        lblSubject.setBounds(100, 150, 200, 20);
        add(lblSubject);

        JLabel lblMarks = new JLabel("Enet Marks : ");
        lblMarks.setBounds(320, 150, 200, 40);
        add(lblMarks);

        tfSub1 = new JTextField();
        tfSub1.setBounds(50, 200, 200, 20);
        add(tfSub1);

        tfSub2 = new JTextField();
        tfSub2.setBounds(50, 230, 200, 20);
        add(tfSub2);

        tfSub3 = new JTextField();
        tfSub3.setBounds(50, 260, 200, 20);
        add(tfSub3);

        tfSub4 = new JTextField();
        tfSub4.setBounds(50, 290, 200, 20);
        add(tfSub4);

        tfSub5 = new JTextField();
        tfSub5.setBounds(50, 320, 200, 20);
        add(tfSub5);

        tfMark1 = new JTextField();
        tfMark1.setBounds(250, 200, 200, 20);
        add(tfMark1);

        tfMark2 = new JTextField();
        tfMark2.setBounds(250, 230, 200, 20);
        add(tfMark2);

        tfMark3 = new JTextField();
        tfMark3.setBounds(250, 260, 200, 20);
        add(tfMark3);

        tfMark4 = new JTextField();
        tfMark4.setBounds(250, 290, 200, 20);
        add(tfMark4);

        tfMark5 = new JTextField();
        tfMark5.setBounds(250, 320, 200, 20);
        add(tfMark5);

        // BUTTON
        // LOGIN
        submit = new JButton("Submit");
        submit.setBounds(70,360,150,25);
        submit.setBackground(Color.CYAN);
        submit.setForeground(Color.BLACK);   // makes font white
        // BUTTON FUNCTION
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,15));
        add(submit);

        // CANCEL
        cancel = new JButton("Cancel");
        cancel.setBounds(280,360,150,25);
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
            try{
                Conn c = new Conn();
                String query1 = "insert into subject values('"+cRollno.getSelectedItem()+"', '"+cbsemester.getSelectedItem()+"', '"+tfSub1.getText()+"', '"+tfSub2.getText()+"', '"+tfSub3.getText()+"', '"+tfSub4.getText()+"', '"+tfSub5.getText()+"')";
                String query2 = "insert into marks values('"+cRollno.getSelectedItem()+"', '"+cbsemester.getSelectedItem()+"', '"+tfMark1.getText()+"', '"+tfMark2.getText()+"', '"+tfMark3.getText()+"', '"+tfMark4.getText()+"', '"+tfMark5.getText()+"')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Marks Inserted Sucessfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new EnterMarks();
    }   
}