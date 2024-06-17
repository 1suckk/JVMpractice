package com.example.vmac;

public class ReferenceCountingGC {
	public Object instance = null;
	private static final int _1MB = 1024*1024;
	private byte[] bigSize = new byte[2 * _1MB];
	
	public static void testGC() {
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();

    //서로 참조하도록 설정
		objA.instance = objB; 
		objB.instance = objA; 

    //참조 해제
		objA = null;
		objB = null;
		
		System.gc();
	}
	
	public static void main(String[] args) {
		testGC();
	}
}
