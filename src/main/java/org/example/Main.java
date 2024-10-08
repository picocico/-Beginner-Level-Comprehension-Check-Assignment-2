//mainクラス
package org.example;

import java.math.BigDecimal;

public class Main {

  public static void main(String[] args) {
    // Inputクラスのインスタンスを作成
    Input input = new Input();
    // Calculatorクラスのインスタンスを作成
    Calculator calculator = new Calculator();

    // 無限ループを開始
    while (true) {
      try {
        // 1番目の数字を入力
        BigDecimal firstNumber = input.getNumber("1番目の数字を入力してください：");
        // 演算子を入力
        char operator = input.getOperator("演算子を入力してください【 + , - , * , / 】：");
        // 2番目の数字を入力
        BigDecimal secondNumber = input.getNumber("2番目の数字を入力してください：");
        // 計算を実行
        BigDecimal result = calculator.calculator(firstNumber, operator, secondNumber);

        // 計算結果を出力
        System.out.println("計算結果：" + firstNumber + " " + operator + " " + secondNumber + " "
            + "=" + " " + result);
        // 正常に計算が完了したらループを抜ける
        break;
        // エラーが発生した場合、エラーメッセージを出力
      } catch (ArithmeticException e) {
        input.printDivideByZeroError();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    // ループの外でScannerを閉じる
    input.close();
  }
}


