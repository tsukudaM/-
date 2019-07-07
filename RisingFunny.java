import objectdraw.*;
import java.awt.*;

//In this program, when mouse is cliked,
//the funny face on the dhisplay rises up.
public class RisingFunny extends WindowController {
    //The face to be risen.
    private FunnyFace happy;
    //The text to instruct to click the mouse.
    private Text instructions;

    //When a program is begun, there is a face and text on the canvas.
    @Override public void begin() {
        happy=new FunnyFace ( 70,170,canvas);
        instructions = new Text( "Please Click the mouse repeatedly", 20, 20, canvas );
    }
    
    //When a player clicked mouse, the face rises up.
    //and the text is hiden.
    @Override public void onMouseClick( Location point ) {
        happy.move( 0, -5);
        instructions.hide();
    }

    //When the mouse is left from the window, return to
    //the condition program begin.
    @Override public void onMouseExit( Location point ){
        happy.moveTo( 70, 170);
        instructions.show();
    }

}
