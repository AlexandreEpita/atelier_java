package fr.epita.assistants.drawing;

public class Rectangle extends Sharp{
    private int width;
    public Rectangle(int _width, int _length)
    {
        super(_length);
        this.width = _width;
    }

    @Override
    public void draw() {
        if (lenght <= 0 || width <= 0)
            return;
        if (lenght == 1 && width == 1)
        {
            System.out.println("#");
            return;
        }
        for (int i = 0; i < width - 1; i++) {
            System.out.print("# ");
        }
        System.out.println("#");

        for (int i = 0; i < lenght - 2; i++)
        {
            System.out.print("# ");
            for (int j = 0; j < width - 2; j++)
            {
                System.out.print("  ");
            }
            System.out.println("#");
        }
        for (int i = 0; i < width - 1; i++)
            System.out.print("# ");
        System.out.println("#");
    }
}
