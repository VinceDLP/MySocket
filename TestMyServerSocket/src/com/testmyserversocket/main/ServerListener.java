package com.testmyserversocket.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

//�̳���thread�����һ���߳���//serverlistener����ѭ�������ͻ��˷���������
public class ServerListener extends Thread {
	public void run(){
		try {
			ServerSocket serverSocket = new ServerSocket(12345);//1-65535
			while(true){
				//�Ѿ��ڼ���12345����˿���
				Socket socket = serverSocket.accept();
				//��������
				JOptionPane.showMessageDialog(null, "�пͻ������ӵ���12345�˿�"); 
				//��socket���ݸ�һ���µ��߳� ������ChatSocket�߳�
				ChatSocket cs = new ChatSocket(socket);
				cs.start();
				ChatManager.getChatManager().add(cs);//��ӵ��������������
			}
			//�Ѿ��ڼ���12345����˿���
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
