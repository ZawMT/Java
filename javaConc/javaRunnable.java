package ocp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class javaRunnable {
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
    	
    	TestLogger.writeLog("A Runnable will be defined.");
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            TestLogger.writeLog("Thread => " + threadName);
        };
        TestLogger.writeLog("A Runnable was defined.");
        
        TestLogger.writeLog("Running the Runnable");
        task.run();
        TestLogger.writeLog("Running the Runnable DONE");

        TestLogger.writeLog("Sleeping 5 seconds");
        try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        TestLogger.writeLog("Sleeping 5 seconds DONE");
        
        TestLogger.writeLog("Running again the Runnable");
        task.run();
        TestLogger.writeLog("Running again the Runnable DONE");
        
        Thread thread = new Thread(task);
        TestLogger.writeLog("Running the Thread");
        thread.start();/*The log from this calling might come in late*/
        TestLogger.writeLog("Running the Thread DONE");
        
        TestLogger.writeLog("Running the last time the Runnable");
        task.run();
        TestLogger.writeLog("Running the last time the Runnable DONE");
        
        TestLogger.writeLog("END");
    }
}