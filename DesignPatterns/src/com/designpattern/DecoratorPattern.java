package com.designpattern;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class LowerCaseInputStream extends FilterInputStream{

	protected LowerCaseInputStream(InputStream in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		int c = super.read();
		return (c==-1?c:Character.toLowerCase(c));
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		int result = super.read(b, off, len);
		for(int i=off;i<off+result;i++) {
			b[i]=(byte)Character.toLowerCase(b[i]);
		}
		return result;
	}
	
	
	
}

public class DecoratorPattern {
	 public static void main(String[] args) {
		int c;
		InputStream in = new LowerCaseInputStream(new BufferedInputStream(System.in));
		try {
			while((c=in.read())!=-1) {
				System.out.print((char)c);
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
