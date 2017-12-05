/*
	Program:	        ArrayTables.java
	Date:		11/20/2017
	Author:		Braden England
	Purpose:	        To have helper methods to set Pinged IPs, the online state, and to return Pinged IPs.
	Notes:		N/A	
	Change Log:	BE: N/A |
*/
package pingapplication;
public class ArrayTables {
    
    /**
     * This method will set a pinged IP into the array.
     */
    public void setPingedIPs() {      
            PingApplication.ipAddressArray[PingApplication.X] = PingApplication.ipAddress;
    }
    
    /**
     * This method will set the online state based on the logic in PingApplication.java
     * @param State accepts Y or N and will set another array with those variables
     */
    public void setOnlineState(String State){
        
        if (State.equals("y")){
            PingApplication.OnlineStateArray[PingApplication.X] = "Online";       
        } else if (State.equals("n")) {
            PingApplication.OnlineStateArray[PingApplication.X] = "Offline";
        }
        
    }
    /**
     * This method checks if the IP address is valid by splitting it into 4 segments and checking if each segment is less than 255 (max number one section an IP address can be)
     * And greater than or equal to 0 (an IP address cannot be less than 0 in any segment)
     * @return 
     * @param ipAddress
     * //Just included those to make netbeans happy.
     */
    public boolean checkIfValid(String ipAddress) {
        boolean isValid;
        String Segment1, Segment2, Segment3, Segment4;
        Segment1 = ipAddress.substring(0, ipAddress.indexOf("."));
        Segment2 = ipAddress.substring(ipAddress.indexOf(".")+1, 
                ipAddress.lastIndexOf(".")-2);
        Segment3 = ipAddress.substring(ipAddress.indexOf(".")+3, 
                ipAddress.lastIndexOf("."));
        Segment4 = ipAddress.substring(ipAddress.lastIndexOf(".")+1, 
                ipAddress.length());        
        if ((Integer.parseInt(Segment1) <= 255 && Integer.parseInt(Segment1) >= 0) && (Integer.parseInt(Segment2) <= 255 && Integer.parseInt(Segment2) >= 0) && (Integer.parseInt(Segment3) <= 255 && Integer.parseInt(Segment3) >= 0) && (Integer.parseInt(Segment4) <= 255 && Integer.parseInt(Segment4) >= 0)){
            isValid = true;
        } else {
        isValid = false;
        }
        
        return isValid;
    }
    /**
     * This method returns the IP addresses that the user pinged.
     */
    public void getPingedIPs(){
        for (int k =0; k < PingApplication.X;k++) {
            System.out.println(PingApplication.ipAddressArray[k] + " " +PingApplication.OnlineStateArray[k]);                  
        }
    }
    
}
