package calendar;

import java.util.List;

public class Lecture {
    private Node day;
    private Node time;
    private Node course;

    public Lecture(String day, String time, String course) {
        this.day = new Node(day);
        this.time = new Node(time);
        this.course = new Node(course);
    }

    public boolean addLectureNodeTo(Node root) {
        Node onSchedule = root.find((String) day.getData());
        Node n = null;
        if(onSchedule.getData().equals("not found")) {
            n = root.addChild(day).addChild(time).addChild(course);
        } else {
            n = onSchedule.addChild(time).addChild(course);
        }
        return !n.equals(null);
    }

    public static String showLecture(Node tree, String day) {
        Node node = tree.find(day);
        if(!node.getData().equals("not found")) {
            List<Node> time = node.getChildren();
            String result = "On " + day + " we have lectures: ";
            for(Node n : time) {
                Node lec = (Node) n.getChildren().get(0);
                result +=  (String) lec.getData() + " at " + (String) n.getData() + " ";
            }
            return result;
        }
        return "There are no lectures on " + day;
    }

    public static String showLecture(Node tree, String day, String time) {
        Node node = tree.find(day);
        if(!node.getData().equals("not found")) {
            node = node.find(time);
            if(!node.getData().equals("not found")) {
                node = (Node) node.getChildren().get(0);
                return "On " + day + " at " + time + " we have " + (String) node.getData() + " lecture.";
            }
        }
        return "There are no lectures on " + day + " at " + time;
    }
}
