package javaXtra;

public class processBuilder {
	public static void main(String args[]) {
		try {
			System.out.println("Running notepad");
			ProcessBuilder pb = new ProcessBuilder("notepad.exe");
	        Process proc = pb.start();
	        
	        //This line will make the process to wait for the return to the program.
	        proc.waitFor();
	        
	        System.out.println("Notepad was closed");
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
}