package GradeCalculator;
import java.util.Scanner;

public class GradeCalculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int subjects,mark, total = 0, maxTotal;
    int average;
    char grade;
    System.out.print("Enter the number of subjects you have : ");
    subjects = scanner.nextInt();
    String[] subjectNames = new String[subjects];
    System.out.print("Enter the name of the subjects: ");
    for (int i = 0; i < subjectNames.length; i++) {
      subjectNames[i] = scanner.next();
    }
    maxTotal=100*subjects;
    System.out.println("Enter the marks of each subject : ");
    for (int i = 0; i < subjects; i++) {
      System.out.print(subjectNames[i] +": ");
      mark = scanner.nextInt();
      if (mark > 100) {
        System.out.println("Mark exceeded maximum marks! Please enter the valid mark!");
        i--;
      }
      else {
        total += mark;
      }
    }
    average = total/subjects;
    System.out.println("Total marks obtained : " + total + " out of "+ maxTotal);
    System.out.println("Percentage : " + average+"%");
    if (average > 90 && average <=100) {
      grade = 'O';
    }
    else if (average > 80 && average <=90) {
      grade = 'A';
    }
    else if (average > 70 && average <=80) {
      grade = 'B';
    }
    else if (average > 60 && average <=50) {
      grade = 'C';
    }
    else if (average > 50&& average <=40) {
      grade = 'D';
    }
    else {
      grade = 'E';
    }
    System.out.println("Grade : " + grade);
    scanner.close();
  }
}