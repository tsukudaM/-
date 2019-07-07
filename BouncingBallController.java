import objectdraw.*;
import java.awt.*;

//A program display a ball moving in the canvas.
public class BouncingBallController extends WindowController {
 public void onMouseClick( Location point ) {
  // Make a new ball when the player clicks
  if(point.getX()<390 && point.getY()<340){
   new BouncingBall( point, canvas );
  }
 }
}
