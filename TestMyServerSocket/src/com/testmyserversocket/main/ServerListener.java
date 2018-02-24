package com.testmyserversocket.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

//继承在thread类就是一个线程了//serverlistener可以循环监听客户端发来的请求
public class ServerListener extends Thread {
	public void run(){
		try {
			ServerSocket serverSocket = new ServerSocket(12345);//1-65535
			while(true){
				//已经在监听12345这个端口了
				Socket socket = serverSocket.accept();
				//建立连接
				JOptionPane.showMessageDialog(null, "有客户端链接到了12345端口"); 
				//将socket传递给一个新的线程 独立的ChatSocket线程
				ChatSocket cs = new ChatSocket(socket);
				cs.start();
				ChatManager.getChatManager().add(cs);//添加到聊天管理器当中
			}
			//已经在监听12345这个端口了
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
