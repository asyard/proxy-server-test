package client.v2;

import client.ClientHandler;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by Asil on 5.03.2018.
 */
public class Proxy2Client {

    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException, InterruptedException
    {
        IoConnector connector = new NioSocketConnector();
        connector.getSessionConfig().setReadBufferSize(2048);

        connector.setHandler(new Client2Handler("219378619287369187236978123698127369712836127edh19dh917gd21"));
        ConnectFuture future = connector.connect(new InetSocketAddress("127.0.0.1", PORT));
        future.awaitUninterruptibly();

        if (!future.isConnected()) {
            return;
        }
        IoSession session = future.getSession();
        session.getConfig().setUseReadOperation(true);
        session.getCloseFuture().awaitUninterruptibly();
        System.out.println(session.read().getMessage());

        System.out.println("After Writing");
        connector.dispose();

    }
}
