package fr.epita.assistants.exceptions;

public class Student {

    private int age;
    private String name;
    private String major;
    public Student(String _name, int _age, String _major) throws InvalidNameException, InvalidAgeException, InvalidMajorException {
        if (_name.matches(".*\\d.*"))
            throw new InvalidNameException(_name);
        if (_age <= 0 || _age >= 130)
            throw new InvalidAgeException(Integer.toString(_age));
        if (!(_major.equalsIgnoreCase("IMAGE") || _major.equalsIgnoreCase("GISTRE") || _major.equalsIgnoreCase("SRS") || _major.equalsIgnoreCase("SCIA") ||
                _major.equalsIgnoreCase("MTI") || _major.equalsIgnoreCase("TCOM") || _major.equalsIgnoreCase("SIGL") || _major.equalsIgnoreCase("GTIM") ||
                _major.equalsIgnoreCase("ICE") || _major.equalsIgnoreCase("SANTE")
                || _major.equalsIgnoreCase("SSIE") || _major.equalsIgnoreCase("IF") || _major.equalsIgnoreCase("STARTUP") || _major.equalsIgnoreCase("Q")))
            throw new InvalidMajorException(_major);

        this.name = _name;
        this.major = _major.toUpperCase();
        this.age = _age;
    }

    @Override
    public String toString()
    {
        return "Name: " + name + ", Age: " + age + ", Major: " + major;
    }
}
