package javaString;

public class basicString {
	public static void main(String args[]) {
		String strJava = "Java";
		String strJava2 = "Java";
		String strJava3 = "JavaThree";
		System.out.println(String.format("strJava is %s : strJava2 is %s : strJava3 is %s", strJava, strJava2, strJava3));
		
		System.out.println("======= String Length & Index =======");		
		System.out.println(String.format("strJava.length() => %s", strJava.length()));
		System.out.println(String.format("strJava.charAt(0) => %s.", strJava.charAt(0)));
		System.out.println("strJava.charAt(-1) and strJava.charAt(4) will give you the exception: java.lang.StringIndexOutOfBoundsException.");
		
		System.out.println("======= String Comparison =======");
		System.out.println(String.format("strJava.equals(\"Java\") => %s.", strJava.equals("Java")));
		System.out.println(String.format("strJava.equals(strJava2) => %s.", strJava.equals(strJava2)));
		System.out.println(String.format("strJava == \"Java\" => %s.", strJava == "Java"));
		System.out.println(String.format("strJava == strJava2 => %s.", strJava == strJava2));
		
		System.out.println("======= String Operations =======");
		System.out.println(String.format("strJava.substring(2) => %s : Start from index 2 until the end.", strJava.substring(2)));
		System.out.println(String.format("strJava.substring(1, 3) => %s : Start from index 1 until index 3 (but not include 3).", strJava.substring(1, 3)));
		System.out.println(String.format("strJava.concat(strJava2) => %s.", strJava.concat(strJava2)));	
		System.out.println(String.format("strJava + strJava2 => %s.", strJava + strJava2));
		String[] strJavas = strJava.split("a");
		String[] strJava3s = strJava3.split("a");
		System.out.println(String.format("strJavas is strJava.split(\"a\") and its length is %d, they are %s and %s.", strJavas.length, strJavas[0], strJavas[1]));
		System.out.println(String.format("strJava3s is strJava3.split(\"a\") and its length is %d, they are %s, %s and %s.", strJava3s.length, strJava3s[0], strJava3s[1], strJava3s[2]));
		
		System.out.println("======= Checking String =======");
		System.out.println(String.format("strJava.startsWith(\"J\") => %s.", strJava.startsWith("J")));
		System.out.println(String.format("strJava.startsWith(\"v\") => %s.", strJava.startsWith("v")));
		System.out.println(String.format("strJava.startsWith(\"v\", 2) => %s.", strJava.startsWith("v", 2)));
		System.out.println(String.format("strJava.startsWith(\"J\", 2) => %s.", strJava.startsWith("J", 2)));	
		
		System.out.println("=======*******=======");
	}
}