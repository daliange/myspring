package com.util; 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Util {

    private MD5Util() {
    }
    
    static MessageDigest getDigest() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String bytes2Hex(byte[] bs) {		
		StringBuffer sb=new StringBuffer();
    	for (int i = 0; i < bs.length; i++) {
    		int nn = bs[i]< 0 ? bs[i] + 256 : bs[i];
    		String t = Integer.toHexString(nn).toUpperCase();
    		sb.append(t.length()<2?"0"+t:t);
		}
    	return sb.toString();
	}
    
    
    public static byte[] getBytes (char[] chars) {
    	   Charset cs = Charset.forName ("GBK");
    	   CharBuffer cb = CharBuffer.allocate (chars.length);
    	   cb.put (chars);
    	                 cb.flip ();
    	   ByteBuffer bb = cs.encode (cb);
    	  
    	   return bb.array();
    	         }
    
   
    public static byte[] md5(byte[] data) {
        return getDigest().digest(data);
    }


    public static String md5(String fileName) throws IOException {
    	
    	String md5=null;
    	String line=null;
    	BufferedReader reader = null;
    	StringBuffer buffer=new StringBuffer();
    	File file = new File(fileName);
		if (!file.isFile()) {
			return null;
		}
    	
		reader = new BufferedReader(new FileReader(file));
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		if(reader!=null)
		{
			reader.close();
		}
		md5=MD5Util.bytes2Hex(getDigest().digest(buffer.toString().getBytes("GBK")));
        return md5.toLowerCase();
    	
    }

 
}
