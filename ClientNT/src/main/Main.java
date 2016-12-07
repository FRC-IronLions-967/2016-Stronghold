package main;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
		public static void main(String[] args){
			new Main().run();
		}
		
		public void run() {
			
			NetworkTable.setClientMode();
			NetworkTable.setIPAddress("10.9.67.2");
			NetworkTable table = NetworkTable.getTable("datatable");
			
			while(true){
				try{
					Thread.sleep(1000);
				}
				catch (InterruptedException ex) {
					Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				}
				double x = table.getNumber("x", 0.0);
				double y = table.getNumber("y", 0.0);
				System.out.println("x: " + x + "Y: " + y);
				
			}
		}
	}

