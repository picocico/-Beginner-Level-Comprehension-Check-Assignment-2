package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StudentManagement {

  private final Map<String, Integer> students;
  private static final String FILE_NAME = "studentsInformation.txt";

  public StudentManagement() {
    this.students = new HashMap<>();
  }

  public void saveToFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
      for (Map.Entry<String, Integer> entry : students.entrySet()) {
        writer.write(entry.getKey() + "," + entry.getValue());
        writer.newLine();
      }
      System.out.println("学生情報をファイルに保存しました。");
    } catch (IOException e) {
      System.out.println("ファイルへの保存中にエラーが発生しました：" + e.getMessage());
    }
  }

  public void loadFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length == 2) {
          String studentName = parts[0];
          int testScore = Integer.parseInt(parts[1]);
          students.put(studentName, testScore);
        }
      }
      System.out.println("ファイルから学生情報を読み込みました。");
    } catch (IOException e) {
      System.out.println("ファイルの読み込み中にエラーが発生しました：" + e.getMessage());
    }
  }
  
  public void addStudent(String studentName, int testScore) {
    students.put(studentName, testScore);
    System.out.println(studentName + "を追加しました。");
    saveToFile();
  }

  public void removeStudent(String studentName) {
    if (students.containsKey(studentName)) {
      students.remove(studentName);
      System.out.println(studentName + "を削除しました。");
      saveToFile();
    } else {
      System.out.println(studentName + "は存在しません。");
    }
  }

  public void updateScore(String studentName, int testScore) {
    if (students.containsKey(studentName)) {
      students.put(studentName, testScore);
      System.out.println(studentName + "の点数を更新しました。");
      saveToFile();
    } else {
      System.out.println(studentName + "は存在しません。");
    }
  }

  public double calculateAverage() {
    if (students.isEmpty()) {
      return 0.00;
    }
    int total = 0;
    for (int score : students.values()) {
      total += score;
    }
    return (double) total / students.size();
  }

  public void displayAllStudents() {
    if (students.isEmpty()) {
      System.out.println("学生情報がありません。");
    } else {
      System.out.println("学生一覧：");
      for (Map.Entry<String, Integer> entry : students.entrySet()) {
        System.out.println(entry.getKey() + ":" + entry.getValue() + "点");
      }
    }
  }
}
