package br.com.gds.decoder;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineDecoder;

public class MinaDecoder extends TextLineDecoder {

	public MinaDecoder() {
		// o caracter de identifica��o de quebra de linha pode mudar de acordo com a mensagem
		// verifique qual � no seu sistema operacional, ex: \r \n etc
		super(new LineDelimiter("\r"));
	}

	@Override
	public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		super.decode(session, in, out);
	}

	@Override
	protected void writeText(IoSession session, String text, ProtocolDecoderOutput out) {
		super.writeText(session, text, out);
	}

}
