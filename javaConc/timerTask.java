package javaConc;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class timerTask {
	private static Timer timerCheck;
	
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
	
	public static class TimerTaskCheckStatus extends TimerTask { 
        private Date dateEnd;
        
        
        public Date getLocalNowDate() {
            return Date.from(Instant.now());
        }

        public Date addMilliSecondsToDate(Date date, int mseconds) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MILLISECOND, mseconds);
            return calendar.getTime();
        }
        
        TimerTaskCheckStatus(int iTimeout) {
            dateEnd = addMilliSecondsToDate(getLocalNowDate(),iTimeout);
            TestLogger.writeLog(String.format("TimerTaskCheckStatus sets to end the task at %s", TestLogger.formatDate(dateEnd.toInstant()
            	      .atZone(ZoneId.systemDefault())
            	      .toLocalDateTime())));
        }
        
        public void run() { 
        	TestLogger.writeLog("TimerTaskCheckStatus => run()");
            if (dateEnd.compareTo(getLocalNowDate()) > 0) {
            	TestLogger.writeLog("TimerTaskCheckStatus => run() ... continue ...");
            } 
            else {
            	TestLogger.writeLog("TimerTaskCheckStatus => run() ... DONE!");
                timerCheck.cancel();
                TestLogger.writeLog("TimerTaskCheckStatus => timerCheck was cancelled.");
            }
        } 
    } 
	
    public static void main(String args[]){
    	TestLogger.writeLog("Main: Start");
		/*
			This is just a demonstration of a task which will be running separately while the main task is in sleep state.
			The two time settings below are important.
			The process will sleep for 10 seconds.
			The total time taken for the task will be 8 seconds. So the task will be done before the sleep is over.
			If iTaskTimePlan is more than 10 (some buffer will be needed according to iDelay and iInterval as well), then the sleep will be over and the task will not be done.
		*/
		int iSleep = 10;
		int iTaskTimePlan = 8;
		int iDelay = 2;
		int iInterval = 3;
		if(args.length > 0) {
			iTaskTimePlan = Integer.parseInt(args[0]);
		}
		
		TestLogger.writeLog("Main Before Sleep");		
    	TimerTaskCheckStatus timerTaskCheckStatus = new TimerTaskCheckStatus(iTaskTimePlan * 1000);
    	TestLogger.writeLog("Main TimerTaskCheckStatus was created");
    	timerCheck = new Timer(true);
        timerCheck.scheduleAtFixedRate(timerTaskCheckStatus, iDelay * 1000, iInterval * 1000);
        TestLogger.writeLog("Main Timer was created");
        try {
        	TestLogger.writeLog("Main Before Sleep");
			Thread.sleep(iSleep * 1000);
			TestLogger.writeLog("Main After Sleep");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        TestLogger.writeLog("Main End");
    }
}