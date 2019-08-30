package sample1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Server
{
 
    private static Socket socket;
 
    public static void main(String[] args)
    {
        try
        {
 
            int port = 25000;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port 25000");
 
            //Server is running always. This is done using this while(true) loop
           
                //Reading the message from the client
                socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String number = br.readLine();
                System.out.println("Message received from client is "+number);
                
 
                //Multiplying the number by 2 and forming the return message
                String returnMessage;
               
               
                    int numberInIntFormat = Integer.parseInt(number);
                    String returnValue = Integer.toBinaryString(numberInIntFormat);
                    returnMessage = String.valueOf(returnValue) + "\n";
                    OutputStream os = socket.getOutputStream();
                    OutputStreamWriter osw = new OutputStreamWriter(os);
                    BufferedWriter bw = new BufferedWriter(osw);
                    bw.write(returnMessage);
                    System.out.println("Message sent to the client is "+returnMessage);
                    bw.flush();
                    
                    
                    is = socket.getInputStream();
                    isr = new InputStreamReader(is);
                    br = new BufferedReader(isr);
                    String bnumber = br.readLine();
                    System.out.println("Message received from client is "+bnumber);
     
                    String returnMessage1;
                    int bnumberInIntFormat = Integer.parseInt(bnumber,2);
                    String returnValue1 = Integer.toString(bnumberInIntFormat);
                    returnMessage1 = String.valueOf(returnValue1) + "\n";
                
                
 
                //Sending the response back to the client.
                
                os = socket.getOutputStream();
                osw = new OutputStreamWriter(os);
                bw = new BufferedWriter(osw);
                bw.write(returnMessage1);
                System.out.println("Message sent to the client is "+returnMessage1);
                bw.flush();
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                socket.close();
            }
            catch(Exception e){}
        }
    }
}