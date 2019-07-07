import objectdraw.*;
import java.awt.*;

//This class draw four circles like a face.
public class FunnyFace {
    private static final int FACE_HEIGHT = 60, 
                             FACE_WIDTH = 60,  
                             // Dimensions of the face

                             // Eye location and size
                             EYE_OFFSET =20,
                             EYE_RADIUS = 8,

                             // Dimensions of the mouth
                             MOUTH_HEIGHT =10, 
                             MOUTH_WIDTH = FACE_WIDTH/2; 
    
    // Parts of the face
    private FramedOval head,             
                       leftEye,
                       rightEye,
                       mouth;

    // Create pieces of funny face.
    public FunnyFace( double left, double top, DrawingCanvas canvas ) {
        head = new FramedOval( left, top, FACE_WIDTH, FACE_HEIGHT, canvas );
        mouth = new FramedOval( left+(FACE_WIDTH-MOUTH_WIDTH)/2,
                                top+2*FACE_HEIGHT/3, MOUTH_WIDTH,
                                MOUTH_HEIGHT, canvas );
        leftEye = new FramedOval( left+EYE_OFFSET-EYE_RADIUS/2,
                                  top+EYE_OFFSET, EYE_RADIUS,
                                  EYE_RADIUS, canvas );
        rightEye = new FramedOval( left+FACE_WIDTH-EYE_OFFSET-
                                   EYE_RADIUS/2, top+EYE_OFFSET,
                                   EYE_RADIUS, EYE_RADIUS, canvas );
    }

    //Create funny face presentated location object.
    public FunnyFace( Location upperLeft, DrawingCanvas canvas ) {
        this( upperLeft.getX(), upperLeft.getY(), canvas );
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