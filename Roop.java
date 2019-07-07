import objectdraw.*;
import java.awt.*;

//This class is a regular square which can be turned.
public class Roop{
  private double xP3,yP3,xP4,yP4,//Coordinates of an two apexes of square.
                 xMidP1P2,yMidP1P2,
                 //Coordinates of the middle point between P1 and P2.
                 RADIAN_PLUS,RADIAN_MINUS;//Fixed number of an angle to turn.
  private Location P1,P2,P3,P4;//Four apexes of square.
  
  //Draw a square.
  public Roop(double xP1,double yP1, double xP2,double yP2,DrawingCanvas canvas){
    //Determined two opposite angle.
    P1=new Location(xP1,yP1);
    P2=new Location(xP2,yP2);
    //The middle point of line P1P2 is (xMidP1P2,yMidP1P2).
    xMidP1P2=(xP1+xP2)/2;
    yMidP1P2=(yP1+yP2)/2;
    //Translate from degree to radian.
    RADIAN_PLUS=Math.toRadians(90);
    RADIAN_MINUS=Math.toRadians(-90);
    
    //Calculate P3,P4.
    xP3=((xP1-xMidP1P2)*Math.cos(RADIAN_PLUS)-(yP1-yMidP1P2)*Math.sin(RADIAN_PLUS))+xMidP1P2;
    yP3=((xP1-xMidP1P2)*Math.sin(RADIAN_PLUS)+(yP1-yMidP1P2)*Math.cos(RADIAN_PLUS))+yMidP1P2;
    xP4=((xP1-xMidP1P2)*Math.cos(RADIAN_MINUS)-(yP1-yMidP1P2)*Math.sin(RADIAN_MINUS))+xMidP1P2;
    yP4=((xP1-xMidP1P2)*Math.sin(RADIAN_MINUS)+(yP1-yMidP1P2)*Math.cos(RADIAN_MINUS))+yMidP1P2;
    P3=new Location (xP3,yP3);
    P4=new Location (xP4,yP4);
    
    //Draw four lines for square
    new Line (P1,P3,canvas);
    new Line (P3,P2,canvas);
    new Line (P2,P4,canvas);
    new Line (P4,P1,canvas);
  }
  
  //Draw object.
  public Roop(Location P1,Location P2,DrawingCanvas canvas){
    this(P1.getX(),P1.getY(),P2.getX(),P2.getY(),canvas);  
  } 
 }