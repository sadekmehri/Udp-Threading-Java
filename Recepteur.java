/*
 * Copyright (C) Sdigos to present all rights reserved.
 */

package work;

import java.net.SocketException;
import javax.swing.JOptionPane;


public class Recepteur {
	
	private static int portSend = 8081;
	private static int portReceive = 8080;
	private ConnectionReceive receive;
	private ConnectionSend send;
	
	public Recepteur() {}
	
	public void Work() {
		
		try {
			send = new ConnectionSend(portSend,Introduce());
			receive = new ConnectionReceive(portReceive,Introduce());
			receive.start();
			send.start();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.toString(), "Error details", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private String Introduce() 
	{
		return getClass().getSimpleName();
	}

    public static void main(String[] args) throws SocketException {
        // TODO Auto-generated method stub
    	
    	Recepteur e = new Recepteur();
    	e.Work();
       
    }
}