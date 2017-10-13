package br.com.gds.server;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import br.com.gds.codec.CodecFactory;
import br.com.gds.firewall.BlackList;
import br.com.gds.handler.TcpHandler;


public class TCPServer extends IoHandlerAdapter {

	private static final Integer PORT = 5000;
	
	public static void main(String[] args) throws IOException {
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast( "codec1", new ProtocolCodecFilter(new CodecFactory()));
        acceptor.getFilterChain().addLast( "blackListFilter", new BlackList());
        acceptor.setHandler(new TcpHandler());
        acceptor.setReuseAddress(true);
        acceptor.bind( new InetSocketAddress(PORT) );
        System.out.println("ONLINE");
	}
	
}
