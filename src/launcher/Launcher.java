package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
		Student teststudent = new Student(126736,"Junca", "Matias", "matijunca@gmail.com", "https://github.com/MatixJ" , "/images/foto.png");
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SimplePresentationScreen screen = new SimplePresentationScreen(teststudent);
            	screen.setVisible(true);	
            }
        });
    }
}