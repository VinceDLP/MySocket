package com.testmyserversocket.main;
import java.util.Vector;
public class ChatManager {
	private ChatManager(){}
	private static final ChatManager cm = new ChatManager();
	public static ChatManager getChatManager(){
		return cm;
	}
	//完成对ChatSocket的管理
	Vector<ChatSocket> vector = new Vector<ChatSocket>();
	
	public void add(ChatSocket cs){
		vector.add(cs);
	}
	//其中的某一个线程通过调用这个函数向其他的客户端发送信息
	public void publish(ChatSocket cs,String out){
		for(int i = 0;i < vector.size(); i++){
			ChatSocket csChatSocket = vector.get(i);
			if(!cs.equals(csChatSocket)){
				csChatSocket.out(out);
			}
		}
	}
}
