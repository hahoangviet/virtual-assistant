package calendar;

public class Schedule {

    public static Node buildSchedule() {
        Node tree = new Node("calendar");
        // add schedule
        Lecture lec1 = new Lecture("monday", "9", "Computer Science");
        Lecture lec2 = new Lecture("friday", "13", "Mathematical Modelling");
        Lecture lec3 = new Lecture("wednesday", "15", "Machine Learning");
        Lecture lec4 = new Lecture("monday", "17", "Numerical Theory");
        lec1.addLectureNodeTo(tree);
        lec2.addLectureNodeTo(tree);
        lec3.addLectureNodeTo(tree);
        lec4.addLectureNodeTo(tree);
        return tree;
    }
}
