package fr.epita.assistants.grades;

import fr.epita.assistants.grades.model.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class GradeHandler {
    private final List<Activity> activities;
    private final List<Student> students;

    public GradeHandler() {
        this.activities = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    /**
     * @param activity The {@link Activity} to be added
     * @return {@code true} (as specified by {@link List#add})
     */
    public boolean addActivity(Activity activity) {
        this.activities.add(activity);
        return true;
    }

    /**
     * @param student The {@link Student} to be added
     * @return {@code true} (as specified by {@link List#add})
     */
    public boolean addStudent(Student student) {
        this.students.add(student);
        return true;
    }

    /**
     * @param name The name of the desired {@link Student}
     * @return The desired student
     * @throws EntryNotFoundException No known {@link Student} with the given name
     */
    public Student getStudent(String name) throws EntryNotFoundException {
        for (Student s : this.students)
            if (name.equals(s.name()))
                return s;
        throw new EntryNotFoundException(Student.class, name);
    }

    /**
     * @param grade The {@link Grade} to be added to the {@link Student}
     * @param name  The name of the desired {@link Student}
     * @return {@code true} (as specified by {@link List#add})
     * @throws EntryNotFoundException No known {@link Student} with the given name
     */
    public boolean addGradeToStudent(Grade grade, String name) throws EntryNotFoundException {
        Student s = getStudent(name);
        s.grades().add(grade);
        return true;
    }

    /**
     * @param name The name of the desired {@link Student} to remove
     * @return The removed {@link Student}
     * @throws EntryNotFoundException No known {@link Student} with the given name
     */
    public Student removeStudent(String name) throws EntryNotFoundException {
        Student s = getStudent(name);
        this.students.remove(s);
        return s;
    }

    /**
     * @param name     The name of the desired {@link Student}
     * @param function A {@link Function} returning an updated {@link Student} from the given one
     * @throws EntryNotFoundException No known {@link Student} with the given name
     */
    public void updateStudent(String name, Function<Student, Student> function) throws EntryNotFoundException {
        Student s = getStudent(name);
        function.apply(s);
    }

    /**
     * @param name    The name of the {@link Student} from which to get grades
     * @param subject The {@link Subject} from which we want the student's average
     * @return The student's average grade in the specified subject (0 if no grades are available)
     * @throws EntryNotFoundException No known {@link Student} with the given name
     */
    public double getStudentAverageInSubject(String name, Subject subject) throws EntryNotFoundException {
        Student s = getStudent(name);
        List<Grade> l = s.grades();
        return l.stream().filter(i -> i.activity().subject().equals(subject)).map(i -> i.grade()).toList().stream().mapToDouble(i -> i).average().orElse(Double.NaN);
    }
}
