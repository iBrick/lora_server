package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Socket_Server implements Runnable {
	private int port;
	private DatagramSocket dsock;
	private InetSocketAddress socketAddress = null;
	private static final int PKT_PUSH_DATA = 0x00;
	private static final int PKT_PUSH_ACK = 0x01;
	private static final int PKT_PULL_DATA = 0x02;
	private static final int PKT_PULL_RESP = 0x03;
	private static final int PKT_PULL_ACK = 0x04;
	private byte ack_command = 4;
	public Socket_Server(int port){
		this.port = port;
		this.socketAddress = new InetSocketAddress("127.0.0.1", this.port);
		try {
			this.dsock = new DatagramSocket(this.socketAddress);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public Socket_Server(){
		this(1680);
	}
	

	@Override
	public void run() {
		int num = 0;
		// 创建 buffer 缓冲区
		byte[] buffer = new byte[8192];
		
		System.out.println("等待客户请求...");
		
		while(true){
			// 构造一个接收的数据包
			DatagramPacket recv_pkt = new DatagramPacket(buffer, buffer.length);
			try {
				dsock.receive(recv_pkt);
				num++;
				System.out.println("收到第" + num + "客户的数据！");
				// 根据收到的数据做出处理
				String recv_info = new String(recv_pkt.getData(), 12, recv_pkt.getLength());
				
			//	buffer = recv_pkt.getData();
				switch(buffer[3]){
				case PKT_PUSH_DATA:
					System.out.println("收到了PUSH_DATA");
					System.out.println(recv_info);
					ack_command = PKT_PUSH_ACK;
					break;
				case PKT_PULL_DATA:
					System.out.println("收到了PULL_DATA");
					System.out.println(recv_info);
					ack_command = PKT_PULL_ACK;
					break;
				default:
	                  System.out.println(", unexpected command");
				}
				
				buffer[3] = ack_command;
				DatagramPacket send_pkt = new DatagramPacket(
						buffer, recv_pkt.getLength(),
						recv_pkt.getAddress(), recv_pkt.getPort());
				dsock.send(send_pkt);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
}
