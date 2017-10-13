package br.com.gds.firewall;

import java.net.InetSocketAddress;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.firewall.BlacklistFilter;

import br.com.gds.util.BlackListUtil;

/**
 * @author tr_gdiniz
 *
 */
public class BlackList extends BlacklistFilter {

	@Override
	public void sessionCreated(NextFilter nextFilter, IoSession session) {
		System.out.println("executado blacklist");
		System.out.println("analisando: "+session.getRemoteAddress());
		String[] str = session.getRemoteAddress().toString().split(":");
		InetSocketAddress socketAddress = (InetSocketAddress) session.getRemoteAddress();

		for(String host : BlackListUtil.blocked){
			if(host.equals(str[0])) {
				block(socketAddress.getAddress());
			}
		}
	}
}
