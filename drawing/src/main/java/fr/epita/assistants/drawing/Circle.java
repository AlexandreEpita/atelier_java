package fr.epita.assistants.drawing;

public class Circle extends Entity{
    private int radius;
    public Circle(int _radius)
    {
        this.radius = _radius;
    }

    public void draw()
    {
        int sqDist;
        for (int i = -radius; i < radius + 1; i++)
        {
            int j = -radius;
            for (; j < radius + 1; j++)
            {
                sqDist = Math.abs(this.radius * this.radius - (i * i + j * j));
                if (sqDist < radius)
                    System.out.print("#");
                else
                    System.out.print(" ");
                if (j < radius)
                    System.out.print(" ");
            }
            if (i < radius)
                System.out.println();
        }
    }
}
