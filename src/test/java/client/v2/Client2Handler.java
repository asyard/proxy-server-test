package client.v2;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Created by Asil on 5.03.2018.
 */
public class Client2Handler extends IoHandlerAdapter
{
    //private final Logger logger = (Logger) LoggerFactory.getLogger(getClass());
    private final String values;
    private boolean finished;

    public Client2Handler(String values)
    {
        this.values = values;
    }

    public boolean isFinished()
    {
        return finished;
    }

    @Override
    public void sessionOpened(IoSession session) {
        session.write(IoBuffer.wrap(values.getBytes()));
    }

    @Override
    public void messageReceived(IoSession session, Object message)
    {
        System.out.println("Message received in the client..");
        System.out.println("Message is: " + message.toString());
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause)
    {
        session.close();
    }

}