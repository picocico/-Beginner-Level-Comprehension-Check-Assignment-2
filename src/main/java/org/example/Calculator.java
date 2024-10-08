package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

  // 計算を行うメソッド
  public BigDecimal calculator(BigDecimal firstNumber, char operator, BigDecimal secondNumber)
      throws IllegalStateException, ArithmeticException {
    BigDecimal result;

    // 演算子に応じて計算を実行
    switch (operator) {
      case '+':
        result = firstNumber.add(secondNumber);
        break;
      case '-':
        result = firstNumber.subtract(secondNumber);
        break;
      case '*':
        result = firstNumber.multiply(secondNumber);
        break;
      case '/':
        // 0で割ることを防ぐためのチェック
        if (secondNumber.compareTo(BigDecimal.ZERO) != 0) {
          //計算機の使用目的が不明なため、小数点以下6桁表示で行う。
          // （C言語、Pythonがデフォルトで小数点以下6桁表示設定であることを参考。）
          //計算結果の見栄えを考慮し、割り切れる場合は不要な末尾の0を削除する。
          result = firstNumber.divide(secondNumber, 6, RoundingMode.HALF_UP).stripTrailingZeros();
        } else {
          // 0で割った時のエラー
          throw new ArithmeticException();
        }
        break;
      default:
        // 無効な演算子が入力された場合のエラー
        throw new IllegalStateException();
    }
    return result;
  }
}
