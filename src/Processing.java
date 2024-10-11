package org.example;

import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Processing {

  private final StudentManagement studentManagement;
  private final Scanner scanner;
  private static final Pattern NAME_PATTERN = Pattern.compile(
      "[\\p{L}\\p{M}\\p{Zs}]+");
  private static final String RTL_MARK = "\u200F";

  public Processing(StudentManagement studentManagement) {
    this.studentManagement = studentManagement;
    this.scanner = new Scanner(System.in, StandardCharsets.UTF_8);
  }

  public void run() {
    while (true) {
      System.out.println("1. 学生を追加");
      System.out.println("2. 学生を削除");
      System.out.println("3. 点数を更新");
      System.out.println("4. 平均点を計算");
      System.out.println("5. 全学生の情報を表示");
      System.out.println("6. 終了");
      System.out.println("選択してください：");

      int choice;
      try {
        choice = scanner.nextInt();
        scanner.nextLine();
      } catch (InputMismatchException e) {
        System.out.println("無効な選択です。数字を再度入力してください。");
        scanner.nextLine();
        continue;
      }

      switch (choice) {
        case 1:
          addStudent();
          break;
        case 2:
          removeStudent();
          break;
        case 3:
          updateScore();
          break;
        case 4:
          calculateAverage();
          break;
        case 5:
          displayAllStudents();
          break;
        case 6:
          System.out.println("プログラムを終了します。");
          return;
        default:
          System.out.println("無効な選択です。もう一度選んでください。");
      }
    }
  }

  private void calculateAverage() {
    double average = studentManagement.calculateAverage();
    System.out.printf("平均点：%.2f点\n", average);
  }

  private void displayAllStudents() {
    studentManagement.displayAllStudents();
  }

  private void addStudent() {
    String studentName;
    while (true) {
      System.out.println("追加する学生の名前を入力してください（外国語に対応／"
          + "アラビア語を入力すると、文章が左右反転表示となります。）：");
      studentName = scanner.nextLine();
      if (NAME_PATTERN.matcher(studentName).matches()) {
        break;
      } else {
        System.out.println("無効な名前です。もう一度入力してください。");
      }
    }

    int testScore;
    while (true) {
      try {
        System.out.println(studentName + "の点数を入力してください：");
        testScore = scanner.nextInt();
        scanner.nextLine();
        break;
      } catch (InputMismatchException e) {
        System.out.println("無効な入力です。数字を入力してください。");
        scanner.nextLine();
      }
    }
    if (studentName.matches(".*\\p{InArabic}.*")) {
      studentName = RTL_MARK + studentName;
    }
    studentManagement.addStudent(studentName, testScore);
  }

  private void removeStudent() {
    System.out.println("削除する学生の名前を入力してください：");
    String studentName = scanner.nextLine();
    studentManagement.removeStudent(studentName);
  }

  private void updateScore() {
    System.out.println("点数を更新する学生の名前を入力してください：");
    String studentName = scanner.nextLine();
    int testScore;
    while (true) {
      try {
        System.out.println(studentName + "の新しい点数を入力してください：");
        testScore = scanner.nextInt();
        scanner.nextLine();
        break;
      } catch (InputMismatchException e) {
        System.out.println("無効な入力です。数字を入力してください。");
        scanner.nextLine();
      }
    }
    studentManagement.updateScore(studentName, testScore);
  }
}


