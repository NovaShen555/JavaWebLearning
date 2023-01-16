package top.novashen.demo03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

public class UDP02 {
    public static void main(String[] args) throws IOException {
        //建立一个套接字并准备一个包去等待数据并监听
        int port =9999;
        DatagramSocket socket = new DatagramSocket(port);
        //建立一个包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        while (true) {
            //开始监听这个包的信息
            socket.receive(packet);
            //收到信息后输出，选择恰当的构造函数使得length正确
            String msg= new String(packet.getData(),0,packet.getLength());
            System.out.println(msg);
        }
    }
}
