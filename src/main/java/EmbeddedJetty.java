import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.InetSocketAddress;

public class EmbeddedJetty {

    public static void main(String[] args) throws Exception {
        String hostname = System.getProperty("BIND_ADDRESS", "0.0.0.0");
        int port = Integer.getInteger("PORT", 3000);

        String warPath = Boolean.getBoolean("DEV_MODE") ?
                "webapp" :
                EmbeddedJetty.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        Server server = new Server(new InetSocketAddress(hostname, port));

        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setWar("webapp");
        server.setHandler(context);

        server.start();
        server.join();
    }
}
