import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class StudentDetail extends JFrame implements ActionListener{
    Choice cRollno;
    JTable table;
    JButton search, update, add, cancel;

    StudentDetail(){
        getContentPane().setBackground(Color.white);    // color of frame
        setLayout(null);

        JLabel heading = new JLabel("Search by Roll Number : ");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        cRollno = new Choice();
        cRollno.setBounds(180, 20, 150, 20);
        add(cRollno);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from studentleave");
            while(rs.next()){
                cRollno.add(rs.getString("rollno"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        table = new JTable();

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from students");
            table.setModel(DbUtils.resultSetToTableModel(rs));  // to add data from data base
        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        add = new JButton("Add");
        add.setBounds(120, 70, 80, 20);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(320, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query = "select * from students where rollno = '"+ cRollno.getSelectedItem() +"'";
            try{
                Conn c = new  Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == add){
            setVisible(false);
            new AddStudent();
        }else if(ae.getSource() == update){
            setVisible(false);
            // new UpdateStudent();
        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new StudentDetail();
    }
}
