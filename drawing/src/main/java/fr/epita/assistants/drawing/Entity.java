package fr.epita.assistants.drawing;

public abstract class Entity implements IDrawable{
    private long id;
    static private long SEQUENCE = 0;

    public Entity()
    {
        this.id = SEQUENCE;
        SEQUENCE++;
    }

    public long getId()
    {
        return this.id;
    }

    public void draw()
    {
    }
}
