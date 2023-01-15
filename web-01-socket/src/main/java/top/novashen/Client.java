package top.novashen;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        OutputStream os = null;
        Socket socket = null;
        //前置定义扩展作用域
        //方便关闭asd
        try {
            InetAddress addr = Inet4Address.getByName("127.0.0.1");
            int port=9999;
            socket = new Socket(addr, port);
            os = socket.getOutputStream();
            os.write("SYH666".getBytes());

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


        }
    }
}
