import objectdraw.*;
import java.awt.*;
//This program draw squares nesting inside the other.
public class Spiral extends WindowController {
 //Two opposite points of squares.
 private Location P1,P2;
 private double xP1,yP1,//P1 is (xP1,yP2).
                xP2,yP2,//P2 is (xP2,yP2).
                smallxP1,smallyP1,//Temporary point of P1.
                smallxP2,smallyP2,//Temporary point of P2.
                centerX,centerY;//The middle point of P1P2 is (centerX,centerY).
 private final static double RADIAN=Math.toRadians(5);
 //Degree of nested square turned
 
 //Record where mouse button is pressed.
 //This location is P1.
 @Override public void onMousePress(Location point){ 
  P1=point;
  xP1=P1.getX();
  yP1=P1.getY();
 }
 
 //Record whre mouse buttom is released,that is P2.
 //Draw the squares whose diagonal is P1P2.
 @Override public void onMouseRelease(Location point){
  //Record the location of P2.
  P2=point;
  xP2=P2.getX();
  yP2=P2.getY();
  //Calculate the middle point of P1P2.
  centerX=(xP1+xP2)/2;
  centerY=(yP1+yP2)/2;
 
  //Draw squares nesting inside the other 
  //untill length of edges is shorter than 50 pixels.
  while((xP1-xP2)*(xP1-xP2)+(yP1-yP2)*(yP1-yP2)>50){
   new Roop(xP1,yP1,xP2,yP2,canvas);
 
   //Set up the temporary-P1(smallxP1,smallyP1) 
   //and temporary-P2(smallxP2,smallyP2),
   //the length of P1P2 are shorter 90%.
   smallxP1=0.9*(xP1-centerX)+centerX;
   smallyP1=0.9*(yP1-centerY)+centerY;
   smallxP2=0.9*(xP2-centerX)+centerX;
   smallyP2=0.9*(yP2-centerY)+centerY;
 
   //Turn temporary-P1 and temporary-P2 through 5 degree. 
   xP1=((smallxP1-centerX)*Math.cos(RADIAN)-(smallyP1-centerY)*Math.sin(RADIAN))+centerX;
   yP1=((smallxP1-centerX)*Math.sin(RADIAN)+(smallyP1-centerY)*Math.cos(RADIAN))+centerY;
   xP2=((smallxP2-centerX)*Math.cos(RADIAN)-(smallyP2-centerY)*Math.sin(RADIAN))+centerX;
   yP2=((smallxP2-centerX)*Math.sin(RADIAN)+(smallyP2-centerY)*Math.cos(RADIAN))+centerY;
  }
 }
}
//onMouseDragのLocationはマウスが通ったところすべてを指す。
//whileループはクラスとプログラムのどっちに書く？