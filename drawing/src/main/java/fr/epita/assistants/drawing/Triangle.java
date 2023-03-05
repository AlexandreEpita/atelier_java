package fr.epita.assistants.drawing;

public class Triangle extends Sharp{
    public Triangle(int length)
    {
        super(length);
    }

    @Override
    public void draw() {
        if (lenght == 1) {
            System.out.println("#");
            return;
        }
        System.out.println("#");
        for (int i = 0; i < lenght - 2; i++)
        {
            System.out.print("# ");
            for (int j = 0; j < i; j++)
                System.out.print("  ");
            System.out.println("#");
        }
        for (int i = 0; i < lenght - 1; i++)
            System.out.print("# ");
        System.out.println("#");
    }
}
