package lab15;


/**
 Class for drawing simple shapes on the screen using keyboard
 characters. This class will draw an asterisk on the screen as a 
 test. It is not intended to create a "real" shape, but rather
 to be used as a base class for other classes of shapes.
*/
public class ShapeBasics implements ShapeInterface
{
    private int offset;

    public ShapeBasics()
    {
        offset = 0;
    }

    public ShapeBasics(int theOffset)
    {
        offset = theOffset;
    }

    public void setOffset(int newOffset)
    {
        offset = newOffset;
    }

    public int getOffset()
    {
        return offset;
    }

    /**
     Draws the shape at lineNumber lines down
     from the current line.
    */
    public void drawAt(int lineNumber)
    {
        for (int count = 0; count < lineNumber; count++)
            System.out.println( );
        drawHere( );
    }

    /**
     Draws the shape at the current line.
    */
    public void drawHere()
    {
        for (int count = 0; count < offset; count++)
            System.out.print(' ');
        System.out.println('*');
    }
 }