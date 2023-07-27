package TabletsOfStone;

import java.io.*;
import java.net.*;

public class ClientScript {
  public static void main(String[] args) throws UnknownHostException, IOException{
    System.out.println("Hello to Tablets of Stone Client");

    System.out.println("Connecting...");
    Socket socket;

    Boolean remote = false;
    if(remote)
      socket = new Socket(TabletsOfStoneMsg._ADDRESS, TabletsOfStoneMsg._PORT);
    else{
      InetAddress inetAdd = InetAddress.getLocalHost();
      socket = new Socket(inetAdd, TabletsOfStoneMsg._PORT);
    }

    System.out.println("Connected!");

    OutputStream outStr = socket.getOutputStream();
    ObjectOutputStream objOutStream = new ObjectOutputStream(outStr);

    TabletsOfStoneMsg myMsg = new TabletsOfStoneMsg(0, "Demo Message");
    objOutStream.writeObject(myMsg);
    socket.close();
  }
}