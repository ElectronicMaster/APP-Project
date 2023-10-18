import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ExaminationDetails extends JFrame implements ActionListener{

    JTextField search;

    JTable table;

    JButton result;
    JButton cancel;

    ExaminationDetails() {
        setSize(1000, 475);
        setLocation(300, 100);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80, 15, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        setLayout(null);
        add(heading);

        search = new JTextField();
        search.setBounds(80, 90, 200, 30);
        search.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(search);

        // BUTTON
        // LOGIN
        result = new JButton("Result");
        result.setBounds(300,90,120,30);
        result.setBackground(Color.CYAN);
        result.setForeground(Color.BLACK);   // makes font white
        // BUTTON FUNCTION
        result.addActionListener(this);
        result.setFont(new Font("serif",Font.BOLD,15));
        add(result);

        // CANCEL
        cancel = new JButton("Cancel");
        cancel.setBounds(440,90,120,30);
        cancel.setBackground(Color.LIGHT_GRAY);
        cancel.setForeground(Color.BLACK);   // makes font white
        // BUTTON FUNCTION
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,15));
        add(cancel);

        table = new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN,16));

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,130,1000,310);
        add(jsp);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from students");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == result){
            setVisible(false);
            new Marks(search.getText());
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ExaminationDetails();
    }
}