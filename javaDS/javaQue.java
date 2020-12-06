package javaDS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class javaQue {
	public static void main(String[] args) {
		System.out.println("deqStr is Queue<String>");
		Queue<String> queStr = new LinkedList<String>();
		
		System.out.println();
		Iterator<String> itr1 = queStr.iterator();
	    System.out.println("Printing in a loop");
	    while(itr1.hasNext()) {
	    	String strTmp = itr1.next();
	    	System.out.println(strTmp);
	    }
	    System.out.println("Printing in a loop: DONE!");
	    System.out.println();
	   
	    System.out.println(String.format("%s is pushed in to deqStr", "1234"));
	    queStr.add("1234");
	    System.out.println(String.format("deqStr.size() => %d", queStr.size()));
	    System.out.println(String.format("%s is pushed in to deqStr", "!@#"));
	    queStr.add("!@#");
	    System.out.println(String.format("deqStr.size() => %d", queStr.size()));
	    System.out.println(String.format("%s is pushed in to deqStr", "ABCD"));
	    queStr.add("ABCD");
	    System.out.println(String.format("deqStr.size() => %d", queStr.size()));
	    System.out.println(queStr);
	    
	    System.out.println();
	    Iterator<String> itr2 = queStr.iterator();	    
	    System.out.println("Printing in a loop again");
	    while(itr2.hasNext()) {
	    	String strTmp = itr2.next();
	    	System.out.println(strTmp);
	    }
	    System.out.println("Printing in a loop again: DONE!");
	}
}
