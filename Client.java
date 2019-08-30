package sample1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.*;
 
public class Client
{
 
    private static Socket socket;
 
    public static void main(String args[])
    {
    		Scanner sc=new Scanner(System.in);
        try
        {
            String host = "localhost";
            int port = 25000;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);
 
            
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            System.out.println("Enter a integer number");
            int number = sc.nextInt();
 
            String sendMessage = number + "\n";
            bw.write(sendMessage);
            bw.flush();
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
            System.out.println("Message received from the server : " +message);
            
            
            os = socket.getOutputStream();
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
            System.out.println("Enter a binary number");
            int bnumber = sc.nextInt();
 
            String sendMessage1 = bnumber + "\n";
            bw.write(sendMessage1);
            bw.flush();
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String message1 = br.readLine();
            System.out.println("Message received from the server : " +message1);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            //Closing the socket
            try
            {
                socket.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
