import objectdraw.*;
import java.awt.*;

//The class draw four circles like a face.
public class FunnyFace2 {
  //the variable of the dimention of a face
  private double size, 
                 faceHeight,
                 faceWidth, 
                 eyeOffset,
                 eyeRadius,
                 mouthHeight,
                 mouthWidth;

  // Parts of the face
  private FramedOval head,               
                     leftEye,
                     rightEye,
                     mouth;
                     
  // Create pieces of funny face
  public FunnyFace2( double left, double top, int size,DrawingCanvas canvas ) {
    faceHeight =size; // Dimensions of
    faceWidth = size; // the face

    eyeOffset =size/3; // Eye location and size
    eyeRadius = 2*size/15;

    mouthHeight = size/6; // Dimensions of
    mouthWidth = faceWidth/2; // the mouth
      
        
    head = new FramedOval( left, top, faceWidth, faceHeight, canvas );
    mouth = new FramedOval( left+(faceWidth-mouthWidth)/2,
                                top+2*faceHeight/3, mouthWidth,
                                mouthHeight, canvas );
    leftEye = new FramedOval( left+eyeOffset-eyeRadius/2,
                                  top+eyeOffset, eyeRadius,
                                  eyeRadius, canvas );
    rightEye = new FramedOval( left+faceWidth-eyeOffset-
                                   eyeRadius/2, top+eyeOffset,
                                   eyeRadius, eyeRadius, canvas );
  }
  
  //if a program cannot know the number of size, substitute 60 for size.
  public FunnyFace2( double left, double top,DrawingCanvas canvas ) {
   this(left,top,60,canvas);
  }
  
  // Move funny face by (dx, dy)
  public void move( double dx, double dy ) {
   head.move( dx, dy );
   leftEye.move( dx, dy );
   rightEye.move( dx, dy );
   mouth.move( dx, dy );
  }

  // Move funny face to (x, y)
  public void moveTo( double x, double y ) {
   this.move( x - head.getX(), y - head.getY() );
  }

  // Determine whether pt is inside funny face
  public boolean contains( Location pt ) {
   return head.contains( pt );
  }

  // Hide the funny face
  public void hide() {
   head.hide();
   leftEye.hide();
   rightEye.hide();
   mouth.hide();
  }
    
}