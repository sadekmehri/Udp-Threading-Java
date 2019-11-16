/*
 * Copyright (C) Sdigos to present all rights reserved.
 */

package work;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ConnectionSend extends Thread {

    private int port;
    private byte Buffer[];
    private String Owner;
    private static Scanner sc;
    private DatagramSocket SocketSend;
    private DatagramPacket paquetSend;

    public ConnectionSend(int port,String Owner) throws SocketException {
        this.port = port;
        this.Owner = Owner;
        SocketSend = new DatagramSocket();
    }

    public void run() {
        work();
    }

    private void work() {

        try {

            InetAddress ip = InetAddress.getLocalHost();
            sc = new Scanner(System.in);

            while (true) {

                // Send 
                System.out.println("Donner votre message "+Owner+" :");
                sc = new Scanner(System.in);
                String ch = sc.nextLine();
                int lg = ch.length();
                Buffer = new byte[lg];
                Buffer = ch.getBytes();
                paquetSend = new DatagramPacket(Buffer, lg, ip, port);
                SocketSend.send(paquetSend);

                if (ch.equals("end")) {
                    SocketSend.close();
                    System.exit(0);
                }

            }


        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error details", JOptionPane.ERROR_MESSAGE);

        }

    }

}