package lesson8.homework2;

public class Demo {
    Course[] course = {};

    Student createHighestParent() {
        Student student = new Student("Anton", "Mi", 31, course);
        return student;
    }

    SpecialStudent createLowestChild() {
        SpecialStudent specialStudent = new SpecialStudent("Anton", "Mi", 31, course, 1311, "gmail.com");
        return specialStudent;
    }
}
