package javaConc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;
 
public class javaCallable {
	public static class TestLogger {
		TestLogger() {}
		public static void writeLog(String strLog) {
			System.out.println(String.format("%s: %s", formatDate(LocalDateTime.now()), strLog));
		}
		
		public static String formatDate(LocalDateTime localDateTime) {
		    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
		    return localDateTime.format(dateTimeFormatter);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static class mathPower implements Callable {
		private Integer iVal;
		 
		mathPower(Integer iVal) {
			TestLogger.writeLog("mathPower Constrctor for " + iVal.toString());
			this.iVal = iVal;
		}
		 
		@Override
		public Integer call() throws Exception {
			TestLogger.writeLog("Calculating Power for " + iVal.toString() + " in the thread (" + Thread.currentThread().getName() + ")");			
			return ((int)(Math.pow(iVal, iVal)));
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static class mathFactorial implements Callable {		 
		private Integer iVal;		 
		mathFactorial(Integer iVal) {
			TestLogger.writeLog("mathFactorial Constrctor for " + iVal.toString());
			this.iVal = iVal;
		}
		 
		@Override
		public Integer call() throws Exception {
			TestLogger.writeLog("Calculating Factorial for " + iVal.toString() + " in the thread (" + Thread.currentThread().getName() + ")");
			Integer iRet = 1;
			for (int i = 2; i <= iVal; i++) {
				iRet *= i;
			}
			
			return iRet;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) throws InterruptedException, ExecutionException {
    	TestLogger.writeLog("=======START=======");
    	ExecutorService executorService=Executors.newFixedThreadPool(3);
    	
    	TestLogger.writeLog("Creating Future for mathPower(25)");
    	Future futPow25;    	 
    	futPow25 = executorService.submit(new mathPower(25));    	
    	TestLogger.writeLog("Future for mathPower(25) was created");
    	
    	TestLogger.writeLog("Creating Futer for mathFactorial(10)");
    	Future futFac10;
    	TestLogger.writeLog("Creating Futer for mathFactorial(15)");
    	Future futFac15;         
    	futFac10 = executorService.submit(new mathFactorial(10));
    	TestLogger.writeLog("Futer for mathFactorial(10) was created");
    	futFac15 = executorService.submit(new mathFactorial(15));
    	TestLogger.writeLog("Futer for mathFactorial(15) was created");
    	
    	try {
    		TestLogger.writeLog("=======Getting results from the Callables =======");
    		TestLogger.writeLog(String.format("Calling mathPower(25) => %d", futPow25.get()));
    		TestLogger.writeLog(String.format("Calling mathFactorial(10) => %d", futFac10.get()));
    		TestLogger.writeLog(String.format("Calling mathFactorial(15) => %d", futFac15.get()));
			executorService.shutdown();
    	} catch (InterruptedException | ExecutionException e) {
    		e.printStackTrace();
    	} 
    	
    	TestLogger.writeLog("=======END=======");
    }
}