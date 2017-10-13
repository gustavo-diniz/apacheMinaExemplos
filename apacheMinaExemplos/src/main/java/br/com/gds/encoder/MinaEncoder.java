package br.com.gds.encoder;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.textline.TextLineEncoder;

public class MinaEncoder extends ProtocolEncoderAdapter {
    
	private final TextLineEncoder textLineEnconder = new TextLineEncoder(Charset.forName("UTF-8"));

	public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
		// o caracter de identificaçãod e quebra de linha pode mudar de acordo com a mensagem
		// verifique qual é no seu sistema operacional, ex: \r \n etc
		textLineEnconder.encode(session, message+"\n", out);
	}
}
