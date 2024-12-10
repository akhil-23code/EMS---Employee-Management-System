package employee.management.system;


import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class AddEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tfname,tffname,tfsalary,tfaddress,tfphone,tfemail,tfjob,tfaadhar;
    JDateChooser dcdob;
    JComboBox cbedu;
    JButton back,add;
    JLabel lblempId;

    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN SERIF",Font.BOLD,25));
        add(heading);

        JLabel labelname = new JLabel("Name:");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif", Font.PLAIN,20));
        add(labelname);

         tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

        JLabel labelfname = new JLabel("Father's Name:");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif", Font.PLAIN,20));
        add(labelfname);

         tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);

        JLabel labeldob = new JLabel("Date of Birth:");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif", Font.PLAIN,20));
        add(labeldob);
         dcdob = new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);

        JLabel labelsalary = new JLabel("Salary:");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif", Font.PLAIN,20));
        add(labelsalary);

         tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);

        JLabel labeladdress = new JLabel("Address:");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif", Font.PLAIN,20));
        add(labeladdress);

         tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel labelphone = new JLabel("Phone Number:");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif", Font.PLAIN,20));
        add(labelphone);

         tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

        JLabel labelemail = new JLabel("E-mail:");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif", Font.PLAIN,20));
        add(labelemail);

         tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel labeledu = new JLabel("Qualification:");
        labeledu.setBounds(400,300,150,30);
        labeledu.setFont(new Font("serif", Font.PLAIN,20));
        add(labeledu);

        String courses[] = {"None","BE","B-TECH","B.COM","BCA","BA","BCA","BBA","BSC","MSC","MCA","M-TECH"};
         cbedu = new JComboBox(courses);
        cbedu.setBackground(Color.white);
        cbedu.setBounds(600,300,150,30);
        add(cbedu);

        JLabel labeljob = new JLabel("Designation:");
        labeljob.setBounds(50,350,150,30);
        labeljob.setFont(new Font("serif", Font.PLAIN,20));
        add(labeljob);

         tfjob = new JTextField();
        tfjob.setBounds(200,350,150,30);
        add(tfjob);

        JLabel labelaadhar = new JLabel("Aadhaar Number:");
        labelaadhar.setBounds(400,350,150,30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN,20));
        add(labelaadhar);

         tfaadhar = new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);

        JLabel labelempId = new JLabel("Employee ID:");
        labelempId.setBounds(50,400,150,30);
        labelempId.setFont(new Font("serif", Font.PLAIN,20));
        add(labelempId);

         lblempId = new JLabel(""+ number );
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("serif", Font.PLAIN,20));
        add(lblempId);

         add = new JButton("ADD DETAILS");
        add.setBounds(250,550,150,40);
        add.setForeground(Color.gray);
        add.addActionListener(this);
        add(add);

         back = new JButton("BACK");
        back.setBounds(450,550,150,40);
        back.setForeground(Color.gray);
        back.addActionListener(this);
        add(back);


        setSize(900,700);
        setLocation(300,50);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbedu.getSelectedItem();
            String designation = tfjob.getText();
            String aadhar = tfaadhar.getText();
            String empId = lblempId.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into employ values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
