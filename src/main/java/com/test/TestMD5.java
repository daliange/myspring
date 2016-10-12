package com.test;

import java.io.IOException;

import com.util.MD5Util;


public class TestMD5 {
	
	public static void main(String[] args) throws IOException {
		String md5=MD5Util.md5("c:\\wk_jnlcheck_20161011_19990f93280036fee2a2e00d2b1acd66.txt");
		System.out.println(md5);
		md5=MD5Util.md5("c:\\wk_jnlcheck_20161012_092ee134eb7f01eff22ea4ff9af559bc.txt");
		System.out.println(md5);
	}
	
	

}
