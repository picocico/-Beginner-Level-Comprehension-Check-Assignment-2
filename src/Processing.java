//Processingクラス
// パッケージの宣言
package org.example;

// 必要なクラスのインポート

import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

// Processingクラスの宣言
public class Processing {

  // フィールドの宣言
  private final StudentManagement studentManagement; // StudentManagementオブジェクト
  private final Scanner scanner; // ユーザー入力を受け取るためのScannerオブジェクト
  private static final Pattern NAME_PATTERN = Pattern.compile(
      "[\\p{L}\\p{M}\\p{Zs}]+"); // 名前のパターンを定義する正規表現
  private static final String RTL_MARK = "\u200F"; // 右から左へのマーク

  // コンストラクタの宣言
  public Processing(StudentManagement studentManagement) {
    this.studentManagement = studentManagement; // 引数で受け取ったStudentManagementオブジェクトをフィールドに設定
    this.scanner = new Scanner(System.in,
        StandardCharsets.UTF_8); // UTF-8エンコーディングでScannerオブジェクトを初期化
  }

  // runメソッドの宣言。メインの処理を行う
  public void run() {
    while (true) { // 無限ループ
      // メニューの表示
      System.out.println("1. 学生を追加");
      System.out.println("2. 学生を削除");
      System.out.println("3. 点数を更新");
      System.out.println("4. 平均点を計算");
      System.out.println("5. 全学生の情報を表示");
      System.out.println("6. 終了");
      System.out.println("選択してください：");

      int choice;
      try {
        choice = scanner.nextInt(); // ユーザーの選択を取得
        scanner.nextLine(); // 改行を消費
      } catch (InputMismatchException e) {
        System.out.println("無効な選択です。数字を再度入力してください。");
        scanner.nextLine(); // 無効な入力をクリア
        continue; // ループの先頭に戻る
      }

      // ユーザーの選択に応じた処理を実行
      switch (choice) {
        case 1:
          addStudent(); // 学生を追加するメソッドを呼び出し
          break;
        case 2:
          removeStudent(); // 学生を削除するメソッドを呼び出し
          break;
        case 3:
          updateScore(); // 点数を更新するメソッドを呼び出し
          break;
        case 4:
          calculateAverage(); // 平均点を計算するメソッドを呼び出し
          break;
        case 5:
          displayAllStudents(); // 全学生の情報を表示するメソッドを呼び出し
          break;
        case 6:
          System.out.println("プログラムを終了します。"); // プログラムを終了するメッセージを表示
          return; // メソッドを終了し、プログラムを終了
        default:
          System.out.println("無効な選択です。もう一度選んでください。"); // 無効な選択の場合のメッセージを表示
      }
    }
  }

  // 平均点を計算して表示するメソッド
  private void calculateAverage() {
    double average = studentManagement.calculateAverage(); // StudentManagementクラスのcalculateAverageメソッドを呼び出して平均点を計算
    System.out.printf("平均点：%.2f点\n", average); // 平均点を小数点以下2桁で表示
  }

  // 全学生の情報を表示するメソッド
  private void displayAllStudents() {
    studentManagement.displayAllStudents(); // StudentManagementクラスのdisplayAllStudentsメソッドを呼び出して全学生の情報を表示
  }

  // 学生を追加するメソッド
  private void addStudent() {
    String studentName;
    while (true) {
      System.out.println("追加する学生の名前を入力してください（外国語に対応／"
          + "アラビア語を入力すると、文章が左右反転表示となります。）：");
      studentName = scanner.nextLine(); // ユーザーから学生の名前を入力
      if (NAME_PATTERN.matcher(studentName).matches()) { // 名前が正規表現にマッチするか確認
        break; // マッチしたらループを抜ける
      } else {
        System.out.println("無効な名前です。もう一度入力してください。"); // 無効な名前の場合のメッセージを表示
      }
    }

    int testScore;
    while (true) {
      try {
        System.out.println(studentName + "の点数を入力してください：");
        testScore = scanner.nextInt(); // ユーザーから点数を入力
        scanner.nextLine(); // 改行を消費
        break; // 正しい入力があればループを抜ける
      } catch (InputMismatchException e) {
        System.out.println("無効な入力です。数字を入力してください。"); // 無効な入力の場合のメッセージを表示
        scanner.nextLine(); // 無効な入力をクリア
      }
    }
    if (studentName.matches(".*\\p{InArabic}.*")) { // 名前にアラビア語が含まれているか確認
      studentName = RTL_MARK + studentName; // 含まれていれば右から左へのマークを追加
    }
    studentManagement.addStudent(studentName,
        testScore); // StudentManagementクラスのaddStudentメソッドを呼び出して学生を追加
  }

  // 学生を削除するメソッド
  private void removeStudent() {
    System.out.println("削除する学生の名前を入力してください：");
    String studentName = scanner.nextLine(); // ユーザーから学生の名前を入力
    studentManagement.removeStudent(
        studentName); // StudentManagementクラスのremoveStudentメソッドを呼び出して学生を削除
  }

  // 点数を更新するメソッド
  private void updateScore() {
    System.out.println("点数を更新する学生の名前を入力してください：");
    String studentName = scanner.nextLine(); // ユーザーから学生の名前を入力
    int testScore;
    while (true) {
      try {
        System.out.println(studentName + "の新しい点数を入力してください：");
        testScore = scanner.nextInt(); // ユーザーから新しい点数を入力
        scanner.nextLine(); // 改行を消費
        break; // 正しい入力があればループを抜ける
      } catch (InputMismatchException e) {
        System.out.println("無効な入力です。数字を入力してください。"); // 無効な入力の場合のメッセージを表示
        scanner.nextLine(); // 無効な入力をクリア
      }
    }
    studentManagement.updateScore(studentName,
        testScore); // StudentManagementクラスのupdateScoreメソッドを呼び出して点数を更新
  }
}



