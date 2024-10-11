//mainクラス
// パッケージの宣言
package org.example;

// Mainクラスの宣言
public class Main {

  // mainメソッドの宣言。プログラムのエントリーポイント
  public static void main(String[] args) {
    // StudentManagementオブジェクトの作成
    StudentManagement studentManagement = new StudentManagement();

    // ファイルからデータを読み込むメソッドの呼び出し
    studentManagement.loadFromFile();

    // Processingオブジェクトの作成。studentManagementを引数として渡す
    Processing processing = new Processing(studentManagement);

    // Processingオブジェクトのrunメソッドを呼び出し、処理を開始
    processing.run();
  }
}



