import java.util.Scanner;

class student {
    int score;

    public student(String name, int id) throws Exception {
        System.out.printf(" NAME %18s %22s \n", ":", name);
        Thread.sleep(1000);
        System.out.printf(" STUDENT's ID %10s %22d \n", ":", id);
    }

    int total_marks(int[] score) {
        int sum = 0;
        for (int i = 0; i < score.length; i++) {
            sum = sum + score[i];
        }
        return sum;

    }

    float avg_percentage(int total_marks, int n) {
        return (float) total_marks / n;

    }

    public String grade(float per) {
        if (per >= 90)
            return "A";
        else if (per >= 80 && per < 90)
            return "B";
        else if (per >= 70 && per < 80)
            return "C";
        else if (per >= 55 && per < 70)
            return "D";
        else
            return "E";
    }
}

public class student_grade_calculator {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("-> Enter the name of student");
        String name = sc.nextLine();
        System.out.println("-> Enter the id of student");
        int id = sc.nextInt();
        System.out.print("-> Number of subjects: ");
        int n = sc.nextInt();
        int[] score = new int[n];

        // taking input of subjects
        System.out.println("-> Enter the marks you got in subjects");
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }
        System.out.println("   ");
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.println("\n");
        student s = new student(name, id);

        // displaying output
        Thread.sleep(1000);
        System.out.printf(" TOTAL MARKS  %10s %22d \n", ":", s.total_marks(score));
        Thread.sleep(1000);
        System.out.printf(" PERCENTAGE  %11s %22.2f \n", ":", s.avg_percentage(s.total_marks(score), n));
        Thread.sleep(1000);
        System.out.printf(" GRADE %17s %22s", ":", s.grade(s.avg_percentage(s.total_marks(score), n)));

        System.out.println("");
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
    }
}
