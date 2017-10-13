package br.com.gds.handler;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class TcpHandler extends IoHandlerAdapter{

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println(" ip: " + session.getRemoteAddress());
	}
	
	@Override
	public void messageReceived(final IoSession session, final Object message) throws Exception {
		System.out.println("recebendo: " + message.toString());
	}
	
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("Sessão aberta - ip: " + session.getRemoteAddress());
		super.sessionOpened(session);
	}
	
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("sessão fechada - ip: " + session.getRemoteAddress());
		super.sessionClosed(session);
	}
	
//	public void validaCmdsCanalOnline(IoSession session, String messages) {
//		if (messages.equals("alive")) {
//			session.write("online");
//		}
//	}
	
}
