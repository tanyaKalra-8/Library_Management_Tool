package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class IssuedBook extends JFrame
{
    String x[] ={"bookid","bookno","bookname","studentid","studentname","studentcontact","date"};
    JButton bt;
    String y[][]=new String[20][7];
    int i=0,j=0;
    JTable t;
    Font f1;
    
    IssuedBook()
    {
       super("Issued Books Info");
        setLocation(1,1);
        setSize(1000,400);
        
        f1 =new Font("Arial",Font.BOLD,15);
         
        try
            {
                ConnectionClass obj = new ConnectionClass();
                String q= "select * from issuebook";
                ResultSet rest =obj.stm.executeQuery(q);
                while(rest.next()){
                    y[i][j++] = rest.getString("bookid");
                    y[i][j++] = rest.getString("bookno");
                    y[i][j++] = rest.getString("bookname");
                    y[i][j++] = rest.getString("studentid");
                    y[i][j++] = rest.getString("studentname");
                    y[i][j++] = rest.getString("studentcontact");
                    y[i][j++] = rest.getString("date");
                    i++;
                    j=0;
                }
                t=new JTable(y,x);
                t.setFont(f1);
                
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        JScrollPane sp=new JScrollPane(t);
         add(sp);
    }
    public static void main(String[] args)
    {
        new IssuedBook().setVisible(true);
    }
}
