If you prefer using an IDE (e.g. Eclipse), you can create a 'Java Project' using it and then import these files. 

Here, I will be compiling and running the files in a very basic way.

Inside this 'Java' folder, open the command line (Windows). Then compile by running 'javac' command giving the path correctly. Then run 'java' command to run the compliled result which is a class file. For example, helloWorld is compiled and run as follows:

javac basicJava/helloWorld.java
java basicJava.helloWorld

Note 1: Windows environment varialbe PATH needs to be set up first pointing to the path where JDK is installed, e.g: C:\Program Files\Java\jdk1.8.0_261\bin
Note 2: javac will point to the file accordingly mentioning the relative path 
Note 3: java will need to give the classpath accordingly as well, if not, error like 'Could not find or load main class helloWorld' will show up

