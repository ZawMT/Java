package javaDS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
 
public class javaDeq {
    public static void main(String[] args) {
    	System.out.println("deqStr is Deque<String>");
        Deque<String> deqStr = new ArrayDeque<>();
        System.out.println(String.format("%s is pushed in to deqStr", "1234"));
        deqStr.push("1234");
        System.out.println(String.format("deqStr.size() => %d", deqStr.size()));
        System.out.println(String.format("%s is pushed in to deqStr", "!@#"));
        deqStr.push("!@#");
        System.out.println(String.format("deqStr.size() => %d", deqStr.size()));
        System.out.println(String.format("%s is pushed in to deqStr", "ABCD"));
        deqStr.push("ABCD");
        System.out.print(String.format("deqStr.size() => %d =>", deqStr.size()));
        System.out.println(deqStr);
        
        //Trying some operations
        System.out.println();
        System.out.println(String.format("deqStr.contains(\"ABCD\") => %b", deqStr.contains("ABCD")));
        System.out.println(String.format("deqStr.contains(\"ABCDE\") => %b", deqStr.contains("ABCDE")));
        System.out.println(String.format("deqStr.getFirst => %s", deqStr.getFirst()));
        System.out.println(String.format("deqStr.getLast() => %s", deqStr.getLast()));
        System.out.println();       
        
        System.out.println("Printing in a loop");
        Iterator<String> itr1 = deqStr.iterator();        
        while(itr1.hasNext()) {
        	String strTmp = itr1.next();
        	System.out.println(strTmp);
        }
        System.out.println("Printing in a loop: DONE");
        System.out.println();
        
        System.out.println(String.format("deqStr.peek() => %s", deqStr.peek()));
        System.out.print("After calling peek =>");
        System.out.println(deqStr);
        System.out.println(String.format("deqStr.pop() => %s", deqStr.pop()));
        System.out.print("After calling pop =>");
        System.out.println(deqStr);
        deqStr.clear();
        System.out.print("After calling clear =>");
        System.out.println(deqStr);
        System.out.println();
        
        System.out.println("Printing in a loop ... again");
        Iterator<String> itr2 = deqStr.iterator();        
        while(itr2.hasNext()) {
        	String strTmp = itr2.next();
        	System.out.println(strTmp);
        }
        System.out.println("Printing in a loop ... again: DONE");
        System.out.println();
    }
}