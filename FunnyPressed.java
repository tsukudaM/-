import objectdraw.*;
import java.awt.*;

// A program that displays the object of funny face wherever
// the mouse is pressed
public class FunnyPressed extends WindowController {    
    @Override public void onMousePress( Location point ) {
        new FunnyFace ( point, canvas );
    }
}
