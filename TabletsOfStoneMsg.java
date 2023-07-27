package TabletsOfStone;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class TabletsOfStoneMsg implements Serializable{
  public static final String _ADDRESS = "192.168.5.157";
  public static final int _PORT = 5025;

  // Message type code for this message
  private Integer _msgType;

  private String from;
  private String to;
  private String _msgData;

  static int varx;

  @Override
  public String toString(){
    String output = "Type=" + _msgType + " Data=" + _msgData;
    return output;
  }

  public Integer getType(){
    return _msgType;
  }
  public String getMsg(){
    return _msgData;
  }

  private void writeObject(ObjectOutputStream out) throws IOException{
    out.writeObject(_msgType);
    out.writeObject(_msgData);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
    _msgType = (int)in.readObject();
    _msgData = (String)in.readObject();
  }

  public static int getPort(){
    return varx;
  }

  public TabletsOfStoneMsg(int nr, String msg) {
    _msgType = nr;
    _msgData = msg;
  }
}