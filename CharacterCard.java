
public class CharacterCard implements Card
{
    private String character;
    private int points;
    
    public CharacterCard( String charac, int point )
    {
        character = charac;
        points = point;
    }
     
    public String getCharacter()
    {
        return character;
    }
    
    public int getPoints()
    {
        return points;
    }
    
    public void moveTo(Path p)
    {
        p.findCharacterTile();
    }
}
