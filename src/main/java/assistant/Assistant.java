package assistant;

import calendar.Schedule;
import calendar.Lecture;
import calendar.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assistant implements Skills {

    private String command;
    private final String[] days = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
    private final String[] time = {"9", "10", "11", "12", "13", "14", "15", "16", "17"};

    @Override
    public String listen(String input) {
        String answer = "";
        this.command = input.toLowerCase();
        for (String d : days) {
            if (command.contains(d))
                answer = calendar(d);
        }
        if (command.contains("to do list") || command.contains("to-do list")) {
            answer = toDoList();
        }
        if (command.contains("make a note") || command.contains("to-do list")) {
            answer = makeNote();
        }
        return answer;
    }

    @Override
    public String toDoList() {
        return showToDo("todo");
    }

    private String showToDo(String todo) {
        String todos = "";
        try (Scanner scanner = new Scanner(new File(todo))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                todos += line + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("no such file");
        }
        return todos;
    }

    @Override
    public String calendar(String day) {
        Node schedule = Schedule.buildSchedule();
        for(String t : time) {
            if(command.contains(t)) {
                return Lecture.showLecture(schedule, day, t);
            }
        }
        return Lecture.showLecture(schedule, day);
    }

    @Override
    public String makeNote() {
        return null;
    }

    @Override
    public void hi() {

    }

    public static void main(String[] args) {
        Assistant assistant = new Assistant();
        String answer = assistant.listen("show to do list");
        System.out.println(answer);
    }

}
