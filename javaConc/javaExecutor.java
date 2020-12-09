package javaConc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class javaExecutor {
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
	
	public static void main(String[] args) {
    	TestLogger.writeLog("START");
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.submit(() -> {
		    String threadName = Thread.currentThread().getName();
		    TestLogger.writeLog(String.format("Running => %s", threadName));
		});
		
		try {
			TestLogger.writeLog("Shutting down executor");
			executorService.shutdown();
			executorService.awaitTermination(5, TimeUnit.SECONDS);/*Comment line 33, 34, 35 and 36. The outcome will be different*/
		}
		catch (InterruptedException e) {
			TestLogger.writeLog("InterruptedException while shutting down");		    
		}
		finally {
			TestLogger.writeLog("Checking executorService - terminated or not?");
		    if (!executorService.isTerminated()) {
		        TestLogger.writeLog("executorService not yet terminated");
		        executorService.shutdownNow();		    
		    	TestLogger.writeLog("executorService was forced to be terminated");
		    } else {
		    	TestLogger.writeLog("executorService already terminated");
		    }
		}
		
		TestLogger.writeLog("END");
	}
}
