/*
	Program:	        PingApplication.java
	Date:		11/19/2017
	Author:		Braden England
	Purpose:	        To ping a website or an IP address and see if the host is online
	Notes:		N/A	
	Change Log:	BE: N/A |
*/
package pingapplication;
import java.io.IOException;
import java.net.InetAddress;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.PrintWriter;          
/**
 *
 * @author Braden
 */
public class PingApplication extends JFrame{

    public static String[] ipAddressArray = new String[100];
    public static String[] OnlineStateArray = new String[100];
    public static String ipAddress;
    public static Integer X;
    public static String State;
    public static String fileName;
    public static PrintWriter outputStream = null;
    public static int dialogButton = 0;
   
    public static void main(String[] args) {
        ArrayTables name = new ArrayTables();
        X = 0;
        String userChoice = "Y";
        
        
        while (userChoice.equalsIgnoreCase("Y")) {
            try {
                ipAddress = JOptionPane.showInputDialog("Enter the IP address you would like to ping.");
                if (name.checkIfValid(ipAddress)){
                    JOptionPane.showMessageDialog(null, "IP address is valid.");
                    InetAddress iNet = InetAddress.getByName(ipAddress);
                    JOptionPane.showMessageDialog(null, "Sending Ping Request to " + ipAddress);
                    name.setPingedIPs();
                    if (iNet.isReachable(5000)) {
                        JOptionPane.showMessageDialog(null, "Host " + ipAddress + " is reachable");
                        name.setOnlineState("y");
                    } else if (!iNet.isReachable(5000)) {  
                        JOptionPane.showMessageDialog(null, "Host " + ipAddress + " is not reachable");
                        name.setOnlineState("n");
                    }
                } else if (name.checkIfValid(ipAddress) == false) {
                    JOptionPane.showMessageDialog(null, "IP address is not valid. Exiting program.");
                    System.exit(0);
                }
            }
            catch (IOException e){
                JOptionPane.showMessageDialog(null, "Unkown exception. Please restart the program.");
            }
            X++;
            userChoice = JOptionPane.showInputDialog("Enter Y if you would like to ping another IP address or website. Enter anything else to exit.");
        }
        JOptionPane.showMessageDialog(null, "Here is the list of IP addresses you pinged: ");
        name.getPingedIPs();
        name.createTxtFile();
    }
}
