package br.com.gds.handler;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import br.com.gds.util.BlackListUtil;

public class TcpHandler extends IoHandlerAdapter{

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println(" ip: " + session.getRemoteAddress());
	}
	
	@Override
	public void messageReceived(final IoSession session, final Object message) throws Exception {
		System.out.println("recebendo: " + message.toString());
		if(message.toString().replaceAll("\n", "").equals("blackList")) {
			String[] str = session.getRemoteAddress().toString().split(":");
			BlackListUtil.blocked.add(str[0]);
			session.closeOnFlush();
		}
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
