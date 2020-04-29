
package electricitybill;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.JFrame.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3,lw;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2;
    JPanel p1,p2,p3,p4;

    Login() {
        super("Login Page");
        l1=new JLabel("Username");
        l2=new JLabel("Password");
        tf1=new JTextField(15);
        pf2=new JPasswordField(15);
        
        //ImageIcon ic1=new ImageIcon(ClassLoader.getSystemResource("path.................."));
        ImageIcon ic1=new ImageIcon("C:\\Users\\SANOJ\\Desktop\\Electricity Project\\image\\loginicon.jpg");
        Image i1=ic1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b1=new JButton("Login",new ImageIcon(i1));
        
        ImageIcon ic2=new ImageIcon("C:\\Users\\SANOJ\\Desktop\\Electricity Project\\image\\cancelicon.png");
        Image i2=ic2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b2=new JButton("Cancel",new ImageIcon(i2));
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        ImageIcon ic3=new ImageIcon("C:\\Users\\SANOJ\\Desktop\\Electricity Project\\image\\loginuser.png");
        Image i3=ic3.getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT);
        ImageIcon icc3=new ImageIcon(i3);
        l3=new JLabel(icc3);   
        
        
        ImageIcon ic9=new ImageIcon("C:\\Users\\SANOJ\\Desktop\\Electricity Project\\image\\lw.png");
        Image i9=ic9.getImage().getScaledInstance(440, 15, Image.SCALE_DEFAULT);
        ImageIcon icc9=new ImageIcon(i9);
        lw=new JLabel(icc9);
        
        setLayout(new BorderLayout());
        
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        
        
        p1.add(l3);
        add(p1,BorderLayout.WEST);
        
        p2.add(l1);
        p2.add(tf1);
        p2.add(l2);
        p2.add(pf2);
        add(p2,BorderLayout.CENTER);
        
        p4.add(b1);
        p4.add(b2);
        add(p4,BorderLayout.SOUTH);
        
        p2.setBackground(Color.white);
        p4.setBackground(Color.white);
        p1.setBackground(Color.white);
        p3.setBackground(Color.white);
        
        p3.add(lw);
        add(p3,BorderLayout.NORTH);
        
        setSize(440,250);
        setLocation(600,400);
        setVisible(true);
 
    }
    
    public void actionPerformed(ActionEvent ae){
        
        try{
            conn c1=new conn();
            String a=tf1.getText();
            String b=pf2.getText();
            String q="select * from login where username = '"+a+"' and password = '"+b+"'";
            ResultSet rs=c1.s.executeQuery(q);
            if (rs.next()){
                new Project().setVisible(true);
                this.setVisible(false);
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Login");
                setVisible(false);
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("error: "+e);
                }     
        }
    
    public static void main(String[] args){
        new Login().setVisible(true);
    
       
}
}
