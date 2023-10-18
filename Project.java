import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{
    Project(){
        // FRAM SIZE
        setSize(2880, 1800);

        // IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("College.png")); 
        Image i2 = i1.getImage().getScaledInstance(1400, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        // MENU BAR [new information]
        JMenuBar mb = new JMenuBar();
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.darkGray);
        mb.add(newInformation);
        
        // MENU BAR DROP DOWN
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setForeground(Color.BLUE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setForeground(Color.BLUE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        // MENU BAR [Details]
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.darkGray);
        mb.add(details);
        
        // MENU BAR DROP DOWN
        JMenuItem facultyDetails = new JMenuItem("Faculty Details");
        facultyDetails.setForeground(Color.BLUE);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("Student Details");
        studentDetails.setForeground(Color.BLUE);
        studentDetails.addActionListener(this);
        details.add(studentDetails);

        // MENU BAR [Apply Leave]
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.darkGray);
        mb.add(leave);
        
        // MENU BAR DROP DOWN
        JMenuItem facultyLeave = new JMenuItem("New Faculty Leave");
        facultyLeave.setForeground(Color.BLUE);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem studentLeave = new JMenuItem("New Student Leave");
        studentLeave.setForeground(Color.BLUE);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        // MENU BAR [Leave Details]
        JMenu leaveDetails = new JMenu("View Leave Details");
        leaveDetails.setForeground(Color.darkGray);
        mb.add(leaveDetails);
        
        // MENU BAR DROP DOWN
        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setForeground(Color.BLUE);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setForeground(Color.BLUE);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        // MENU BAR [Examination]
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.darkGray);
        mb.add(exam);
        
        // MENU BAR DROP DOWN
        JMenuItem examinationDetails = new JMenuItem("Examination Results");
        examinationDetails.setForeground(Color.BLUE);
        examinationDetails.addActionListener(this);
        exam.add(examinationDetails);

        JMenuItem enterMarks = new JMenuItem("Add Marks");
        enterMarks.setForeground(Color.BLUE);
        enterMarks.addActionListener(this);
        exam.add(enterMarks);

        // MENU BAR [UpdateInfo]
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.darkGray);
        mb.add(updateInfo);
        
        // MENU BAR DROP DOWN
        JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Details");
        updateFacultyInfo.setForeground(Color.BLUE);
        updateFacultyInfo.addActionListener(this);
        updateInfo.add(updateFacultyInfo);

        JMenuItem updateStudentDetails = new JMenuItem("Update Student Details");
        updateStudentDetails.setForeground(Color.BLUE);
        updateStudentDetails.addActionListener(this);
        updateInfo.add(updateStudentDetails);

        // MENU BAR [Fee]
        JMenu feeDetail = new JMenu("Fee Details");
        feeDetail.setForeground(Color.darkGray);
        mb.add(feeDetail);
        
        // MENU BAR DROP DOWN
        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setForeground(Color.BLUE);
        feeStructure.addActionListener(this);
        feeDetail.add(feeStructure);

        setJMenuBar(mb);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String msg  = ae.getActionCommand();
        if(msg.equals("New Faculty Information")){
            new AddTeacher();
        }else if(msg.equals("New Student Information")){
            new AddStudent();
        }else if(msg.equals("Faculty Details")){
            new TeacherDetails();
        }else if(msg.equals("Student Details")){
            new StudentDetail();
        }else if(msg.equals("New Faculty Leave")){
            new TeacherLeave();
        }else if(msg.equals("New Student Leave")){
            new StudentLeave();
        }else if(msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        }else if(msg.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();
        }else if(msg.equals("Update Student Details")){
            new UpdateStudent();
        }else if(msg.equals("Update Faculty Details")){
            new UpdateTeacher();
        }else if(msg.equals("Add Marks")){
            new EnterMarks();
        }else if(msg.equals("Examination Results")){
            new ExaminationDetails();
        }else if(msg.equals("Fee Structure")){
            new FeeStructure();
        }
    }

    public static void main(String[] args){
        new Project();
    }
}
