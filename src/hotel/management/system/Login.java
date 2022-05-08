package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	
	JLabel l1,l2,l0;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	
	
	Login()
	{       
                JLabel l0 = new JLabel("PLEASE LOGIN");
                l0.setBounds(170,0, 300, 40);
                //l0.setForeground(Color.BLACK);
                l0.setFont(new Font("serif",Font.PLAIN,30));
                add(l0);
                
		l1 = new JLabel("Username");
		l1.setBounds(40,60,100,30);
		add(l1);
		
		l2 = new JLabel("Password");
		l2.setBounds(40,110,100,30);
		add(l2);
		
		t1 = new JTextField();
		t1.setBounds(150, 60, 150, 30);
		add(t1);
		
		t2 = new JPasswordField();
		t2.setBounds(150, 110, 150, 30);
		add(t2);
		
		b1 = new JButton("Login");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(40,180,100,30);
                b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(160,180,100,30);
                b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(210, 210, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
		JLabel l3 = new JLabel(i3);
        l3.setBounds(350, 10, 200, 180);
        add(l3);
        getContentPane().setBackground(Color.WHITE);
		
		
		setLayout(null);
		setBounds(350,200,600,300);
		setVisible(true);
	}
        
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==b1)
            {
                String username = t1.getText();
                var password = t2.getText();
                conn c = new conn();
                
                String str = "select * from login where username = '"+username+"' and password = '"+password+"'";
                try{
                    ResultSet rs = c.s.executeQuery(str);
                    
                    if(rs.next())
                    {
                        new Dashboard().setVisible(true);
                        this.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Invalid Username or Password!!");
                        this.setVisible(false);
                        new Login().setVisible(true);
                    }
                }
                catch(Exception e)
                {
                    
                }
            }
            else if(ae.getSource()==b2)
            {
                System.exit(0);
            }
        }
	
	public static void main(String[] args)
	{
            new Login();
	}

}