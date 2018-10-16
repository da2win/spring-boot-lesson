package com.da2win.springbootlesson13;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * 聊天室
 */
@ServerEndpoint("/chat-room/{username}")
public class ChatRoomServerEndpoint {

    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {
        RemoteEndpoint.Basic basicRemote = session.getBasicRemote();

        sendText(session, "欢迎用户[" + username + "]来到聊天室");
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, Session session, String message) {
        sendText(session, "用户[" + username + "] : " + message);
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        // TODO
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
