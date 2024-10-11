##  **初級理解度チェック課題 問題2**

### **実装内容**

##### **学生の名前と点数を入力して管理するプログラムです。**<br>
名前を追加、削除、点数の更新、平均点を計算、全学生の情報を表示が行えます。<br>
作業を終えたらプログラムを終了させることが出来ます。<br>
学生の情報は「studentsInformation.txt」に記録保存されます。<br>
※留学生の情報管理も行えるよう、公用語として用いられる言語の上位10ヶ国語に対応。<br>

#### **1.学生の名前を追加**<br>

**画面表示**<br>
<img width="735" alt="初級理解度チェック課題2／学生の名前追加-1" src="https://github.com/user-attachments/assets/c54d8b89-405b-4108-951f-175cbcdafe76">

**「studentsInformation.txt」の表示**<br>
<img width="420" alt="初級理解度チェック課題2／学生の名前追加-2" src="https://github.com/user-attachments/assets/fda877c6-2822-40b5-b2ca-c1a2c3e49e8f">

**留学生の入力例**<br>
<img width="735" alt="初級理解度チェック課題2／学生の名前追加-3" src="https://github.com/user-attachments/assets/bac1a71d-a716-4718-bd14-d9bbb4bfb0f8">

**留学生入力時の「studentsInformation.txt」の表示**<br>
<img width="420" alt="初級理解度チェック課題2／学生の名前追加-4" src="https://github.com/user-attachments/assets/44b86c53-7ea9-4c66-968c-adf72cc05b08">

**アラビア語入力時の表示**<br>
<img width="735" alt="初級理解度チェック課題2／学生の名前追加-5" src="https://github.com/user-attachments/assets/68264243-4127-4a57-8105-38d956e1ab8e">

**アラビア語入力時の「studentsInformation.txt」の表示**<br>
<img width="420" alt="初級理解度チェック課題2／学生の名前追加-6" src="https://github.com/user-attachments/assets/ce3754f2-2b2e-427c-bffc-9fa920c6f20c">

#### **2.学生の名前を削除**<br>

**画面表示**<br>
<img width="420" alt="初級理解度チェック課題2／学生の名前削除-1" src="https://github.com/user-attachments/assets/6ab5e0db-a2f7-446a-9352-de9a2d619a88">

**削除時の「studentsInformation.txt」の表示**<br>
<img width="430" alt="初級理解度チェック課題2／学生の名前削除-2" src="https://github.com/user-attachments/assets/ef06b668-8de3-43c6-b38c-187e2963ccf1">

#### **3.点数の更新**<br>

**画面表示**<br>
<img width="347" alt="初級理解度チェック課題2／点数の更新-1" src="https://github.com/user-attachments/assets/3f7123fc-640d-4f41-865f-411adf376630">

**更新時の「studentsInformation.txt」の表示**<br>
<img width="419" alt="初級理解度チェック課題2／点数の更新-2" src="https://github.com/user-attachments/assets/c28c9820-8d96-4cda-98b7-2f3a1fc28c4e">

#### **4.平均点を計算**<br>

<img width="206" alt="初級理解度チェック課題2／平均点を計算" src="https://github.com/user-attachments/assets/58e8ae40-3050-4435-9ab9-c3c67fb62242">

#### **5.全学生の情報表示**<br>

**画面表示**<br>
<img width="305" alt="初級理解度チェック課題2／全学生の情報表示" src="https://github.com/user-attachments/assets/b4b20546-5b1b-4bf1-bba1-c6df658c1a35">

**アラビア語の表記**<br>
<img width="225" alt="初級理解度チェック課題2／全学生表示のアラビア語表記" src="https://github.com/user-attachments/assets/d8d293e4-101c-49ac-a8de-16b5618d41f2">

#### **6.プログラム終了**<br>
<img width="220" alt="初級理解度チェック課題2／プログラム終了" src="https://github.com/user-attachments/assets/e71d714a-5f1d-450e-a4be-c7b0c0dce2a7">

### *（問題）*
配列とリストまたはStreamAPIを使用して、学生の名前と点数を管理するプログラムを作成してください。<br>
名前の追加、削除、点数の更新、平均点の計算ができるようにしてください。<br>
処理をループさせるにはWhile文を使って実現してください。<br>

```
入力例:
    1. 学生を追加
    2. 学生を削除
    3. 点数を更新
    4. 平均点を計算
    5. 全学生の情報を表示
    6. 終了
    選択してください: 1

    学生の名前を入力してください: 山田太郎
    山田太郎の点数を入力してください: 85

    1. 学生を追加
    2. 学生を削除
    3. 点数を更新
    4. 平均点を計算
    5. 全学生の情報を表示
    6. 終了
    選択してください: 1

    学生の名前を入力してください: 鈴木花子
    鈴木花子の点数を入力してください: 92

期待される出力例:
    1. 学生を追加
    2. 学生を削除
    3. 点数を更新
    4. 平均点を計算
    5. 全学生の情報を表示
    6. 終了
    選択してください: 5

    学生一覧:
    山田太郎: 85点
    鈴木花子: 92点

    1. 学生を追加
    2. 学生を削除
    3. 点数を更新
    4. 平均点を計算
    5. 全学生の情報を表示
    6. 終了
    選択してください: 4

    平均点: 88.5点

    1. 学生を追加
    2. 学生を削除
    3. 点数を更新
    4. 平均点を計算
    5. 全学生の情報を表示
    6. 終了
    選択してください: 6

    プログラムを終了します。
```
#### *（特記事項）*
実施するコード、成果物は下記を満たすようにしてください。<br>

```
・コードフォーマット（環境設定で行ったものです）
・命名規則に従った名前付け（安直な名前付けや間違った名前をつけないこと）
・コード全文と動作結果の共有
・値の入力を受け付けるには「Scannerクラス」を使うこと
・例外処理は可能な範囲で実装（空文字や想定していない値の入力時など）
```




