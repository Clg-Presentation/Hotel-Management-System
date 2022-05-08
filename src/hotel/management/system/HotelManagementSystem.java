package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.awt.Font;

import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    
    HotelManagementSystem()
    {
        setBounds(300,300,1600,680);
        //setSize(400,400);
        setLocation(0,0);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/hotel1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366, 665,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1366, 665);
        add(l1);
        
        JLabel l2 = new JLabel("HOTEL MANAGEMENT SYSTEM");
        l2.setBounds(330,0, 1000, 70);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif",Font.PLAIN,60));
        l1.add(l2);
        
        JButton b1 = new JButton("Next");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setBounds(1080,  580,  160, 30);
        b1.addActionListener(this);
        l1.add(b1);
        
        setLayout(null);
        
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
    	new Login().setVisible(true);
    	this.setVisible(false);
    }

    
    public static void main(String[] args) {
        // TODO code application logic here
        new HotelManagementSystem();
    }
    
}