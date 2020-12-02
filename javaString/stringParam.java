package javaString;

public class stringParam {
	public static class MyString {
		private String value;
		
		public String getValue() { return value; }
		public void setValue(String strVal) { this.value = strVal; }
		
		public MyString() { value = ""; }
		public MyString(String str) { value = str; }		
	}
	
	private String changeString(String strParam) {
		strParam = "Changed";
		return strParam;
	}
	
	private MyString changeMyString(MyString myStrParam) {
		myStrParam.value = "Changed";
		return myStrParam;
	}
	
	private MyString changeMyString2(MyString myStrParam) {
		myStrParam = new MyString("Changed");
		return myStrParam;
	}

	public static void main(String args[]) {
		System.out.println("Java always passes the parameter by value!!!");
		String strJava = "Java";
		stringParam obj = new stringParam();
		System.out.println(String.format("obj.changeString(strJava) => %s", obj.changeString(strJava)));
		System.out.println(String.format("strJava => %s", strJava));
		System.out.println("Original string is still the same.\n");
		
		MyString myStr = new MyString("Java");
		System.out.println(String.format("return from changeMyString => %s", obj.changeMyString(myStr).value));
		System.out.println(String.format("myStr => %s", myStr.value));
		System.out.println("Original object is changed in changeMyString.\n");

		MyString myStr2 = new MyString("Java");
		System.out.println(String.format("return from changeMyString2 => %s", obj.changeMyString2(myStr2).value));
		System.out.println(String.format("myStr2 => %s", myStr2.value));
		System.out.println("Original object is not changed, because a new copy was made in changeMyString2");
	}
}