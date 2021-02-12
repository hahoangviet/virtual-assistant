package calendar;

public class Test {

    public static void main(String[] args) {
        // test calendar

        Node tree = Schedule.buildSchedule();
        tree.printTree(tree, " ");
        // a day is not in the schedule
        System.out.println(Lecture.showLecture(tree, "saturday", "9"));
        // a day is in the schedule
        System.out.println(Lecture.showLecture(tree, "monday", "9"));
        // a day is in the schedule, but the time is not
        System.out.println(Lecture.showLecture(tree, "monday", "13"));
    }

}
