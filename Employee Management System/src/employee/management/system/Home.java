package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    JButton view, add, update, remove;
    Home(){
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.png"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);

        JLabel heading = new JLabel(("Employee Management System"));
        heading.setBounds(600,90,400,40);
        heading.setFont(new Font("serif",Font.BOLD,28));
        //heading.setForeground(Color.red);
        image.add(heading);

         add = new JButton("ADD EMPLOYEE");
        add.setBounds(650,150,150,40);
        add.setForeground(Color.red);
        add.addActionListener(this);
        image.add(add);

         view = new JButton("VIEW EMPLOYEES");
        view.setBounds(800,150,150,40);
        view.setForeground(Color.red);
        view.addActionListener(this);
        image.add(view);

         update = new JButton("UPDATE DETAILS");
        update.setBounds(650,200,150,40);
        update.setForeground(Color.red);
        update.addActionListener(this);
        image.add(update);

         remove = new JButton("REMOVE EMPLOYEE");
        remove.setBounds(800,200,150,40);
        remove.setForeground(Color.red);
        remove.addActionListener(this);
        image.add(remove);


        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            setVisible(false);
            new AddEmployee();
        }
        else if(ae.getSource() == view){
            setVisible(false);
            new ViewEmployee();
        }
        else if(ae.getSource() == update){
            setVisible(false);
            new ViewEmployee();
        }
        else{
            setVisible(false);
            new RemoveEmployee();
        }

    }

    public static void main(String[] args) {
        new Home();
    }
}
