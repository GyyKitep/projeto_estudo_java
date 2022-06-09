package br.com.java.io.teste;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteUnicodeEEnconde {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "ç";
		System.out.println(s.codePointAt(0)); // unicode
		
		Charset charset = Charset.defaultCharset();
		
		System.out.println(charset.displayName());
		
		byte[] bytes = s.getBytes("UTF-8");		
		System.out.print(bytes.length + ", UTF-8, ");		
		String sNovo = new String(bytes, "UTF-8");
		System.out.println(sNovo);
		
		bytes = s.getBytes("UTF-16");		
		System.out.print(bytes.length + ", UTF-16, ");			
	    sNovo = new String(bytes, "UTF-16");
		System.out.println(sNovo);
		
		bytes = s.getBytes(StandardCharsets.US_ASCII);		
		System.out.print(bytes.length + ", US_ASCII, ");			
	    sNovo = new String(bytes, "US_ASCII");
		System.out.println(sNovo);		
	}

}
