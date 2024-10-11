//StudentManagementクラス
// パッケージの宣言
package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// StudentManagementクラスの宣言
public class StudentManagement {

  // フィールドの宣言
  private final Map<String, Integer> students; // 学生の名前と点数を管理するマップ
  private static final String FILE_NAME = "studentsInformation.txt"; // 学生情報を保存するファイル名

  // コンストラクタの宣言
  public StudentManagement() {
    this.students = new HashMap<>(); // 学生情報を格納するためのハッシュマップを初期化
  }

  // 学生情報をファイルに保存するメソッド
  public void saveToFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
      for (Map.Entry<String, Integer> entry : students.entrySet()) {
        writer.write(entry.getKey() + "," + entry.getValue()); // 学生の名前と点数をカンマで区切って書き込む
        writer.newLine(); // 改行
      }
      System.out.println("学生情報をファイルに保存しました。"); // 保存完了メッセージ
    } catch (IOException e) {
      System.out.println("ファイルへの保存中にエラーが発生しました：" + e.getMessage()); // エラーメッセージ
    }
  }

  // ファイルから学生情報を読み込むメソッド
  public void loadFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(","); // カンマで分割
        if (parts.length == 2) {
          String studentName = parts[0];
          int testScore = Integer.parseInt(parts[1]);
          students.put(studentName, testScore); // 学生情報をマップに追加
        }
      }
      System.out.println("ファイルから学生情報を読み込みました。"); // 読み込み完了メッセージ
    } catch (IOException e) {
      System.out.println(
          "ファイルの読み込み中にエラーが発生しました：" + e.getMessage()); // エラーメッセージ
    }
  }

  // 学生を追加するメソッド
  public void addStudent(String studentName, int testScore) {
    students.put(studentName, testScore); // 学生情報をマップに追加
    System.out.println(studentName + "を追加しました。"); // 追加完了メッセージ
    saveToFile(); // ファイルに保存
  }

  // 学生を削除するメソッド
  public void removeStudent(String studentName) {
    if (students.containsKey(studentName)) {
      students.remove(studentName); // 学生情報をマップから削除
      System.out.println(studentName + "を削除しました。"); // 削除完了メッセージ
      saveToFile(); // ファイルに保存
    } else {
      System.out.println(studentName + "は存在しません。"); // 学生が存在しない場合のメッセージ
    }
  }

  // 学生の点数を更新するメソッド
  public void updateScore(String studentName, int testScore) {
    if (students.containsKey(studentName)) {
      students.put(studentName, testScore); // 学生の点数を更新
      System.out.println(studentName + "の点数を更新しました。"); // 更新完了メッセージ
      saveToFile(); // ファイルに保存
    } else {
      System.out.println(studentName + "は存在しません。"); // 学生が存在しない場合のメッセージ
    }
  }

  // 平均点を計算するメソッド
  public double calculateAverage() {
    if (students.isEmpty()) {
      return 0.00; // 学生がいない場合は0.00を返す
    }
    int total = 0;
    for (int score : students.values()) {
      total += score; // 総点数を計算
    }
    return (double) total / students.size(); // 平均点を計算して返す
  }

  // 全学生の情報を表示するメソッド
  public void displayAllStudents() {
    if (students.isEmpty()) {
      System.out.println("学生情報がありません。"); // 学生がいない場合のメッセージ
    } else {
      System.out.println("学生一覧：");
      for (Map.Entry<String, Integer> entry : students.entrySet()) {
        System.out.println(entry.getKey() + ":" + entry.getValue() + "点"); // 学生の名前と点数を表示
      }
    }
  }
}

