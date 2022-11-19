package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class LibrarianSection extends JFrame implements ActionListener
{
    JLabel l1;
    JButton bt1;
    JPanel p1,p2;
    Font f,f1;
    
    LibrarianSection()
    {
        super("Librarian Page");
        setLocation(0,0);
        setSize(1500,800);
        
        f=new Font("Arial",Font.BOLD,20);
        f1 =new Font("Arial",Font.BOLD,15);
        
        ImageIcon ic= new ImageIcon(ClassLoader.getSystemResource("Library/icon/home2.jpg"));
        Image img = ic.getImage().getScaledInstance(1500,800,Image.SCALE_DEFAULT);
        ImageIcon ic1= new ImageIcon(img);
        l1=new JLabel(ic1);
        
        JMenuBar m1= new JMenuBar();
        JMenu men1= new JMenu("Add Info");
        JMenuItem ment1= new JMenuItem("Add Book");
        
        JMenu men2= new JMenu("View");
        JMenuItem ment2 = new JMenuItem("View Book");
        JMenuItem ment4 = new JMenuItem("View Issued books");
        
        JMenu men4= new JMenu("Return");
        JMenuItem ment5 = new JMenuItem("Return Book");
        
        JMenu men5= new JMenu("Exit");
        JMenuItem ment6 = new JMenuItem("Logout");
        
        JMenu men7= new JMenu("Issue");
        JMenuItem ment3 = new JMenuItem("Issue Book");
        
        men1.add(ment1);
        men2.add(ment2);
        men2.add(ment4);
        men7.add(ment3);
        men4.add(ment5);
        men5.add(ment6);
        
        m1.add(men1);
        m1.add(men2);
        m1.add(men7);
        m1.add(men4);
        m1.add(men5);
        
        men1.setFont(f);
        men2.setFont(f);
        men7.setFont(f);
        men4.setFont(f);
        men5.setFont(f);
        
        ment1.setFont(f1);
        ment2.setFont(f1);
        ment3.setFont(f1);
        ment4.setFont(f1);
        ment5.setFont(f1);
        ment6.setFont(f1);
        
        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);
        ment5.addActionListener(this);
        ment6.addActionListener(this);
        
        setJMenuBar(m1);
        add(l1);
        }
    public void actionPerformed(ActionEvent e)
    {
        String comd= e.getActionCommand();
        if(comd.equals("Add Book")){
            new AddBook().setVisible(true);
        }
        else if(comd.equals("View Book")){
            System.out.print("hello");
            new ViewBook().setVisible(true);
        }
        else if(comd.equals("Issue Book")){
            new ViewIssueBook().setVisible(true);
        }
        else if(comd.equals("View Issued books")){
            new IssuedBook().setVisible(true);
        }
        else if(comd.equals("Return Book")){
            new ReturnBook().setVisible(true);
        }
        if(comd.equals("Logout")){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new AdminSection().setVisible(true);
    }
}
