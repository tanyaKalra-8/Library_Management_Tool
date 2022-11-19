package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class DeleteLibrarian extends JFrame implements ActionListener
{
    String x[] ={"Id","Username","Password","Email","Contact","Address","City"};
    JButton bt1;
    String y[][]=new String[20][7];
    int i=0,j=0;
    JTable t;
    Font f;
    JLabel l1;
    JTextField tf1;
    JPanel p1;
    
    DeleteLibrarian()
    {
        super("Delete Librarian");
        setLocation(1,1);
        setSize(1000,400);
        
        f=new Font("Arial",Font.BOLD,15);
        
        try
            {
                ConnectionClass obj = new ConnectionClass();
                String q= "select * from librarian";
                ResultSet rest =obj.stm.executeQuery(q);
                while(rest.next()){
                    y[i][j++] = rest.getString("Lid");
                    y[i][j++] = rest.getString("name");
                    y[i][j++] = rest.getString("password");
                    y[i][j++] = rest.getString("email");
                    y[i][j++] = rest.getString("contact");
                    y[i][j++] = rest.getString("address");
                    y[i][j++] = rest.getString("city");
                    i++;
                    j=0;
                }
                t=new JTable(y,x);
                t.setFont(f);
                
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
         JScrollPane sp=new JScrollPane(t);
         
         l1=new JLabel("Delete Librarian");
         tf1=new JTextField();
         bt1=new JButton("Delete");
         bt1.addActionListener(this);
         
         l1.setFont(f);
         tf1.setFont(f);
         bt1.setFont(f);
         
         p1=new JPanel();
         p1.setLayout(new GridLayout(1,3,10,10));
         p1.add(l1);
         p1.add(tf1);
         p1.add(bt1);
         
        setLayout(new BorderLayout(10,10));
        add(sp,"Center");
        add(p1,"South");
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            int id = Integer.parseInt(tf1.getText());
            try
            {
                ConnectionClass obj = new ConnectionClass();
                String q="delete from librarian where Lid='"+id+"'";
                int aa=obj.stm.executeUpdate(q);
                if(aa==1){
                    JOptionPane.showMessageDialog(null,"Your data successfully deleted");
                    this.setVisible(false);
                    new DeleteLibrarian().setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please try Again :( ");
                    this.setVisible(false);
                    new DeleteLibrarian().setVisible(true);
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args)
    {
        new DeleteLibrarian().setVisible(true);
    }
}
