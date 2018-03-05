package server;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Asil on 5.03.2018.
 */
public class ServerHandler extends IoHandlerAdapter {
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String str = message.toString();
        System.out.println("Message read:");
        System.out.println(str);

        Date date = new Date();
        session.write(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        session.close(false);//.closeNow();

    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status)
            throws Exception {
        System.out.println("IDLE " + session.getIdleCount(status));
    }
}