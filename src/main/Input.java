package org.example;

import java.math.BigDecimal;
import java.util.Scanner;

public class Input {

  private final Scanner scanner;

  // コンストラクタでScannerを初期化
  public Input() {
    scanner = new Scanner(System.in);
  }

  // 数字を入力するメソッド
  public BigDecimal getNumber(String prompt) {
    System.out.println(prompt);
    while (true) {
      try {
        // 入力された文字列をBigDecimalに変換
        return new BigDecimal(scanner.nextLine());
      } catch (NumberFormatException e) {
        // 数字以外が入力された場合のエラーメッセージ
        printNumberError();
      }
    }
  }

  // 演算子を入力するメソッド
  public char getOperator(String prompt) {
    System.out.println(prompt);
    while (true) {
      String input = scanner.nextLine();
      // 入力が1文字であり、かつ有効な演算子であるかをチェック
      if (input.length() == 1 && "+-*/".indexOf(input.charAt(0)) != -1) {
        return input.charAt(0);
      } else {
        // 無効な演算子が入力された場合のエラーメッセージ
        printOperatorError();
      }
    }
  }

  // 数字入力エラーのメッセージを表示
  public void printNumberError() {
    System.out.println("エラー：数字以外のものが入力されています。改めて数字を入力してください。");
  }

  // 演算子入力エラーのメッセージを表示
  public void printOperatorError() {
    System.out.println(
        "無効な演算子です。改めて【 + , - , * , / 】の4つの中から選んで入力してください。");
  }

  // 0で割るエラーのメッセージを表示
  public void printDivideByZeroError() {
    System.out.println("エラー：0で割ることはできません。0以外の数字を入力してください。");
  }

  // Scannerを閉じるメソッド
  public void close() {
    scanner.close();
  }
}

