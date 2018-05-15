import java.awt.Color;

public class ColorCard implements Card
{
    private Color color;
    private int numSpaces;
    
    public ColorCard(Color col, int numOfSpaces)
    {
        color = col;
        numSpaces = numOfSpaces;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public int getNumSpaces()
    {
        return numSpaces;
    }
    
    public void moveTo(Path p) 
    {
        if (numSpaces == 1)
        {
            p.findNextColorTile(this);
        }
        else
        {
            p.findNext2ColorTile(this);
        }
    }
    
}
