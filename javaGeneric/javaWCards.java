package javaGeneric;

import java.util.ArrayList;
import java.util.List;

public class javaWCards {
	public static void main(String[] args) {
        List<Integer> lstInteger = new ArrayList<Integer>();
        lstInteger.add(5);
        lstInteger.add(10);
        System.out.println(lstInteger);
        System.out.println(String.format("Addition => %f", addAllUBound(lstInteger)));  
        
        List<Double> lstDouble = new ArrayList<Double>();
        lstDouble.add(10.0);
        lstDouble.add(20.0);
        System.out.println(lstDouble);
        System.out.println(String.format("Addition => %f", addAllUBound(lstDouble)));          

        List<Object> lstObject = new ArrayList<Object>();
        lstObject.add(15.0);
        lstObject.add(30.0);
        System.out.println(lstObject);
        //System.out.println(String.format("Addition => %f", addAllUBound(lstObject))); => Compilation error
        System.out.println(String.format("Addition => %f", addAllLBound(lstObject))); 
	}
	
	public static Double addAllUBound(List<? extends Number> lstIntegers) {
		Double dAns = 0.0;
		for(Number n : lstIntegers) {
			dAns += n.doubleValue();
		}
		return dAns;
	}

	public static Double addAllLBound(List<? super Number> lstIntegers) {
		Double dAns = 0.0;
		for(Object n : lstIntegers) {
			String strVal = n.toString();
			Double dTmp = Double.parseDouble(strVal);
			dAns = dAns + dTmp;
		}
		return dAns;
	}
}
