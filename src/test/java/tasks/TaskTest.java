package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(15, "Позвонить маме");

        boolean actual = task.matches("Позвонить маме");
        Assertions.assertTrue(actual);


    }

    @Test
    public void testSimpleTaskNotMatches() {
        SimpleTask task = new SimpleTask(15, "Позвонить маме");

        boolean actual = task.matches("Написать маме");
        Assertions.assertFalse(actual);


    }

    @Test
    public void testEpicTaskMatches() {
        Epic task = new Epic (15, new String[] {"Молоко", "Яйца", "Хлеб"});

        boolean actual = task.matches("Молоко");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicTaskNotMatches() {
        Epic task = new Epic (15, new String[] {"Молоко", "Яйца", "Хлеб"});

        boolean actual = task.matches("Ягоды");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingTaskMatches() {
        Meeting task = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = task.matches("Выкатка");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingTaskMatches1() {
        Meeting task = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = task.matches("НетоБанка");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingTaskNotMatches() {
        Meeting task = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = task.matches("пятница");
        Assertions.assertFalse(actual);
    }

}