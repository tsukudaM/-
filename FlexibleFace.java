import objectdraw.*;
import java.awt.*;

//This program draw a funny face when mouse is dragged.
public class FlexibleFace extends WindowController {
  //The places of mouse clicked and lereased.
  private Location upperLeft,
                   lowerRight;
  //Two variables of distance between clicked and released.
  private double gap;
  private int size;
                        
  // Make the face when the program begin.
  @Override public void begin() {
    new FunnyFace2( 0, 0, canvas );
  }

  //Record where is clicked.
  @Override public void onMousePress(Location point){
    upperLeft=point;
  }
 
  //When a mouse is released, draw a face.  
  @Override public void onMouseRelease(Location point){
    //Record the place released.
    lowerRight=point;
    
    //Calculate a distance between x-coordinate clicked and one released.
    gap=lowerRight.getX()-upperLeft.getX();
    //Transform from double variable to instance variable.
    size=(int)gap;
    
    //If mouse move to the left, draw a face.
     if(size>0){
      new FunnyFace2(upperLeft.getX(),upperLeft.getY(),size,canvas);
     }
  }

}
