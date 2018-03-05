package server.v2;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Asil on 5.03.2018.
 */
public class Server2Handler extends IoHandlerAdapter {
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String str = message.toString();
        System.out.println("Message read:" + str);
        // cast message to io buffer
        IoBuffer data = (IoBuffer) message;
// create a byte array to hold the bytes
        byte[] buf = new byte[data.limit()];
// pull the bytes out
        data.get(buf);
// look at the message as a string
        System.out.println("Message: " + new String(buf));

        Date date = new Date();
        session.write(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date).getBytes());
        session.close(false);//.closeNow();

    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status)
            throws Exception {
        System.out.println("IDLE " + session.getIdleCount(status));
    }
}