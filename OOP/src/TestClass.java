import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {
	static int row=12;
	static int col=12;
	static String Grid[][] = new String[row][col];
	public static ArrayList<Group> groups = new ArrayList<Group>();
	public static void main(String[] args) {
		Group Group0 = new Group(0,"+");
		Group Group1 = new Group(1,"*");
		Group Group2 = new Group(2,"$");
		Group Group3 = new Group(3,"@");
		groups.add(Group0); groups.add(Group1); groups.add(Group2); groups.add(Group3);
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<Grid.length;i++) {
			for(int j=0;j<Grid[0].length;j++) {
				Grid[i][j]="-";
			}
		}
		int xval,yval;
		FileDialog dialog = new FileDialog((Frame)null, "Pick 'Locations' file.");
		dialog.setMode(FileDialog.LOAD);
		dialog.setVisible(true);
		generatePoints(dialog.getDirectory()+"\\"+dialog.getFile());
		System.out.println("Enter X Coordinate:");
		xval=sc.nextInt();
		System.out.println("Enter Y Coordinate:");
		yval=sc.nextInt();
		printMatrix();
		System.out.println("("+xval+","+yval+")"+" belongs to the group "+findNearest(xval,yval));
		
	}
	 public static String findNearest(int x,int y) {
		 String nearestSymbol="";
		 double closest=99;
		 int closex=0,closey=0;
		 for(int i=0;i<Grid.length;i++) {
			 for(int j=0;j<Grid[0].length;j++) {
				 if(!Grid[i][j].equals("-")) {
					 if(DistanceBetween(x,y,i,j)<closest) {
						 closex=i; closey=j; closest=DistanceBetween(x,y,i,j);
					 }
				 }
			 }
		 }
		 for(Group g:groups) {
			 for(point pnt:g.points) {
				 if(pnt.getxCoord()==closex&&pnt.getyCoord()==closey)return pnt.getSymbol();
			 }
		 }
		 return "Not Found";
	 }
	 public static void printMatrix(){
	        for(int i=0;i<Grid.length;i++){
	            for(int j=0;j<Grid[i].length;j++){
	                System.out.print(" "+Grid[i][j]);
	            }
	            System.out.println();
	        }
	    }
	 public static double DistanceBetween(int x,int y,int a,int b){
	        return Math.sqrt((b - y) * (b - y) + (a - x) * (a - x));
	    }
	 public static void generatePoints(String file) {
		 Scanner scanfile;
		 int x,y,group;
		try {
			scanfile = new Scanner(new BufferedReader(new FileReader(file)));
			while(scanfile.hasNextLine()) {
	            String[] ln = scanfile.nextLine().trim().split(",");
	             x =Integer.parseInt(ln[0]); y=Integer.parseInt(ln[1]); group=Integer.parseInt(ln[2]);
	            point pnt = new point(x,y,group);
	            Grid[x][y]=pnt.getSymbol();
	        }
	        scanfile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	 }
}