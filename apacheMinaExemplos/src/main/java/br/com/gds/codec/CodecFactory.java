package br.com.gds.codec;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

import br.com.gds.decoder.MinaDecoder;
import br.com.gds.encoder.MinaEncoder;

public class CodecFactory implements ProtocolCodecFactory{

	private ProtocolEncoder encoder;
    private ProtocolDecoder decoder;
    
    public CodecFactory() {
    	this.encoder = new MinaEncoder();
    	this.decoder = new MinaDecoder();
	}
	
	public ProtocolEncoder getEncoder(IoSession session) throws Exception {
		return encoder;
	}

	public ProtocolDecoder getDecoder(IoSession session) throws Exception {
		return decoder;
	}

}
