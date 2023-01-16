package top.novashen.demo03;

import java.io.IOException;
import java.net.*;

public class UDP01 {
    public static void main(String[] args) throws IOException {
        //新建一个报文套接字，udp协议
        DatagramSocket socket = new DatagramSocket();
        //新建一个数据包
        String msg="HELLO WORLD SYH!!!!!!";
        byte[] data = msg.getBytes();
        InetAddress address = Inet4Address.getByName("127.0.0.1");
        int port =9999;
        //封装包完成
        DatagramPacket packet = new DatagramPacket(data, data.length, address , port);
        //发送包
        socket.send(packet);

        //关闭资源
        socket.close();

    }
}
