package com.da2win.springbootlesson13;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 聊天室
 */
@ServerEndpoint("/chat-room/{username}")
public class ChatRoomServerEndpoint {

    private static Map<String, Session> livingSessions = new ConcurrentHashMap<>();

    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {
        String sessionId = session.getId();
        livingSessions.put(sessionId, session);
        sendTextAll("欢迎用户[" + username + "]来到聊天室");
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, Session session, String message) {
//        sendText(session, "用户[" + username + "] : " + message);
        sendTextAll("用户[" + username + "] : " + message);
    }

    private void sendTextAll(String message) {
        livingSessions.forEach((sessionId, session)-> {
            sendText(session, message);
        });
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        String sessionId = session.getId();
        // 将当前的session移除, 并通知其他人当前用户已离开聊天室
        livingSessions.remove(sessionId);
        sendTextAll("用户["+username+"]已离开聊天室! ");
    }

    private void sendText(Session session, String message) {
        RemoteEndpoint.Basic basicRemote = session.getBasicRemote();

        try {
            basicRemote.sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
