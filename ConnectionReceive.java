/*
 * Copyright (C) Sdigos to present all rights reserved.
 */

package work;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import javax.swing.JOptionPane;

public class ConnectionReceive extends Thread {

    @SuppressWarnings("unused")
	private int port;
    private byte Buffer[];
    private String Owner;
    private DatagramSocket SocketReceived;
    private DatagramPacket PaquetReceived;
    private final int Longueur = 1024;

    public ConnectionReceive(int port,String Owner) throws SocketException {
        this.port = port;
        this.Owner = Owner;
        SocketReceived = new DatagramSocket(port);
    }

    public void run() {
        work();
    }

    private void work() {

        try {

            Buffer = new byte[Longueur];

            while (true) {

                // Receive 
                PaquetReceived = new DatagramPacket(Buffer, Buffer.length);
                SocketReceived.receive(PaquetReceived);
                System.out.println("\nMessage recu "+Owner+" : "+new String(Buffer, 0, PaquetReceived.getLength()));
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error details", JOptionPane.ERROR_MESSAGE);

        }


    }

}