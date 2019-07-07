import objectdraw.*;
import java.awt.*;

// Class for an animated ball that falls down the canvas
public class BouncingBall extends ActiveObject {
  // The size of the ball
  private static final int SIZE = 10;
  // The delay between successive moves of the ball
  private static final int DELAY_TIME = 33,
                           X_WIDTH=390,
                           Y_HEIGHT=340;
  // Number of pixels ball falls in a single move
  private double xStep = 4,
                 yStep = 4;

  // The image of the ball
  private FilledOval ballGraphic;
  // The canvas
  private DrawingCanvas canvas;
  
  //The ball that move.
  public BouncingBall( Location initialLocation, DrawingCanvas aCanvas ) {
    canvas = aCanvas;
    ballGraphic = new FilledOval( initialLocation, SIZE, SIZE, canvas );
    start();
  }

  //How the ball moves.
  public void run() {
     //In canvas, ball rebound on edge of canvas.
     while ( ballGraphic.getX()+SIZE<=X_WIDTH+10 
             && ballGraphic.getY() +SIZE<=Y_HEIGHT+10) {
        ballGraphic.move( xStep, yStep);
        pause ( DELAY_TIME ) ;
        if(ballGraphic.getX()+SIZE>=X_WIDTH){
          xStep=-xStep;  
        }
        if(ballGraphic.getY()+SIZE>=Y_HEIGHT){
          yStep=-yStep;
        }
        if(ballGraphic.getX()<=0){
          xStep=-xStep;
        }
        if(ballGraphic.getY()<=0){
          yStep=-yStep;
        }
     }
  }
    
  public void setColor( Color aColor ){
     ballGraphic.setColor( aColor );
  }
}
