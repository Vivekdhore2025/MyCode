import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
class Server extends WindowAdapter implements ActionListener
{
    public JFrame mainframe;
    public JButton b1;
    public JTextField t1;
    public JLabel lobj;
    Integer no1, no2;

public Server(int width , int height,String Title)
{
    mainframe = new JFrame(Title);
    mainframe.setSize(width,height);
    mainframe.addWindowListener(this);
b1 = new JButton("server says : ");
t1 = new JTextField();
b1.setBounds(10,280,80,40);  // x,y,w,h
t1.setBounds(70,100,100,40);
mainframe.add(b1);
mainframe.add(t1);

lobj = new JLabel();
lobj.setBounds(150,25,200,100);
b1.addActionListener(this);
mainframe.setLayout(null);        
mainframe.setVisible(true);                                                         

}
public void widowClosing(WindowEvent obj)
{
    System.exit(0);
}
public void actionPerformed(ActionEvent e)
 {
   try{
    no1 = Integer.parseInt(t1.getText());
    if(obj.getSource() == b1)
    {
        lobj.setText("Server massage is : \n");
    }
   } 
   catch(Exception eobj)
   {

   }
}

}
class Server
{
    public static void main(String[] args) throws Exception
    {

        Server sobj = new Server(400 , 400," Client massanger : ");
        System.out.println("Server of marvellous chat messanger is running.....");
        ServerSocket ssobj = new ServerSocket(2100);
        System.out.println("Server is in Listing mode at port no : 2100");

        Socket sobj = ssobj.accept();
        System.out.println("Client and server connetion is successfull.......");

        PrintStream ps = new PrintStream(sobj.getOutputStream());
        BufferedReader br1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Marvellous chat Messanger started...");

        String str1,str2;
        while((str1 = br1.readLine())!= null)
        {
            System.out.println("Client says : "+str1);
            System.out.println("Enter message for client :");
            str2 = br2.readLine();
            ps.println(str2);
        }
        System.out.println("thank you for using that chat messanger..");
        ssobj.close();
        sobj.close();
        ps.close();
        br1.close();
        br2.close();
    }
        
    }
