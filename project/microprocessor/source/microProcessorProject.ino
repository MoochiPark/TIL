#include<Servo.h>      //서보 모터 라이브러리
#include<SoftwareSerial.h>     //블루투스 라이브러리
#include "U8glib.h"     //OLED 라이브러리

  SoftwareSerial BTSerial(9,8);      //블루투스 

  U8GLIB_SSD1306_128X64 u8g(U8G_I2C_OPT_NONE);      //OLED

  Servo hor;      //수평 서보 모터
  int moh = 90;
  Servo ver;      //수직 서보 모터
  int mov = 90;

  int bz = 2;     //부저
  int sw1 = 3;    //스위치

  int tones[] = {261, 294, 330, 349, 392, 440, 494, 523};     //부저에서 사용할 음계

  int cdslt = A3;     //왼쪽 위 조도 센서
  int cdsrt = A2;     //오른쪽 위 조도 센서
  int cdslb = A1;     //왼쪽 아래 조도 센서
  int cdsrb = A0;     //오른쪽 아래 조도 센서
  float amount = 0;   //태양광 발전량 합

  int echo = 6;       //초음파 센서 에코
  int trig = 7;       //초음파 센서 트리거

  boolean manual = false;     //수동 모드를 false로 선언

  void setup() {
    Serial.begin(9600);         //시리얼 통신
    BTSerial.begin(9600);        //블루투스 통신
    hor.attach(4);               //수평 서보 모터
    ver.attach(5);               //수직 서보 모터
    //두 서보 모터 초기각도를 90도로 지정
    hor.write(moh);
    ver.write(mov);
    //초음파 센서의 echo를 입력, tigger를 출력으로 지정
    pinMode(echo, INPUT);
    pinMode(trig, OUTPUT);

    pinMode(bz, OUTPUT);        //부저

    pinMode(sw1, INPUT_PULLUP); //스위치핀을 풀업저항으로 사용
  }


  void loop() {
    //조도 센서 입력받기
    int lt = analogRead(cdslt);
    int rt = analogRead(cdsrt);
    int lb = analogRead(cdslb);
    int rb = analogRead(cdsrb);
    //오차 한계 범위
    int tol = 10;
    //상, 하, 좌, 우의 조도값 평균 값을 구함
    int avgt = (lt + rt) / 2;
    int avgb = (lb + rb) / 2;
    int avgl = (lt + lb) / 2;
    int avgr = (rt + rb) / 2;

    amount += (lt + rt + lb + rb) / 100000.0;      //받은 조도값을 발전량에 더해줌
    oledStart();                             //oled 출력

    //상하의 차이와 좌우의 차이를 구함
    int verd = avgt - avgb;
    int hord = avgl - avgr;

    //스위치가 눌릴 경우 수동모드로 전환
    if (digitalRead(sw1) == LOW) {
      manual = !manual;
      delay(500);
    }

    if (!manual) {     //수동모드가 아닐 경우
      //초음파 센서 사용
      digitalWrite(trig, LOW);
      digitalWrite(echo, LOW);
      delayMicroseconds(2);
      digitalWrite(trig, HIGH);
      delayMicroseconds(10);
      digitalWrite(trig, LOW);
      unsigned long duration = pulseIn(echo, HIGH);
      float distance = ((float) (340 * duration) / 10000) / 2;

      if (0 < distance && distance < 3)     //거리가 3cm보다 가까울 경우 경고
        alert();

      if (-1 * tol > verd || verd > tol) {      //상하의 조도센서의 차이가 tol값보다 클 경우
        //아래의 조도값이 더 클 경우 패널을 아래로 회전
        if (avgt < avgb) {
          mov = ++mov;
          if (mov >= 160)
            mov = 160;
        }
        //반대의 경우
        else if (avgt > avgb) {
          mov = --mov;
          if (mov <= 20)
            mov = 20;
        }
        ver.write(mov);
      }

      if (-1 * tol > hord || hord > tol) {      //좌우의 조도센서의 차이가 tol값보다 클 경우
        //오른쪽의 조도값이 더 클 경우 패널을 오른쪽으로 회전
        if (avgl < avgr) {
          moh = --moh;
          if (moh <= 0)
            moh = 0;
        }
        //반대의 경우
        else if (avgl > avgr) {
          moh = ++moh;
          if (moh >= 180)
            moh = 180;
        }
        hor.write(moh);
      }
    } else if (manual) {        //수동 모드일 경우
      oledPrint("  Manual Mode");      //oled에 Manual Mode라고 표시.
      boolean run = true;
      while (run) {
        char val = BTSerial.read();     //블루투스로 값을 받아서 val변수에 넣는다.
        if (BTSerial.available())
          Serial.write(BTSerial.read());

        switch (val) {
          case 'L':       //val이 L일 경우 왼쪽으로 회전
            moh -= 5;
            hor.write(moh);
            break;
          case 'R':       //val이 R일 경우 오른쪽으로 회전
            moh += 5;
            hor.write(moh);
            break;
          case 'T':       //val이 T일 경우 위로 회전
            mov += 5;
            ver.write(mov);
            break;
          case 'B':       //val이 B일 경우 아래로 회전
            mov -= 5;
            ver.write(mov);
            break;
          case 'S':       //val이 S일 경우 수동 모드를 중단
            manual = !manual;
            run = false;
            break;
        }
      }
    }
  }

  void oledStart() {      //oled에 발전총량을 표시해주는 함수
    u8g.firstPage();
    do {
      u8g.setFont(u8g_font_unifont);
      u8g.setPrintPos(0, 10);
      u8g.print("OOOOOOOOOOOOOOOOO");

      u8g.setPrintPos(0, 30);
      u8g.print("Amount : ");
      u8g.print(amount);
      u8g.print("W");

      u8g.drawStr(0, 50, "OOOOOOOOOOOOOOOOO");
    } while (u8g.nextPage());

  }

  void oledPrint(String str) {        //oled에 원하는 문자열을 출력해주는 함수
    u8g.firstPage();
    do {
      u8g.setFont(u8g_font_unifont);

      u8g.drawStr(0, 10, "OOOOOOOOOOOOOOOOO");

      u8g.setPrintPos(0, 30);
      u8g.print(str);

      u8g.drawStr(0, 50, "OOOOOOOOOOOOOOOOO");
    } while (u8g.nextPage());

  }

  void alert() {        //서보 모터를 좌우로 회전하고 경고음과 화면을 출력해주는 함수
    oledPrint("      ALERT!");
    hor.write(120);
    tone(bz, tones[7]);
    delay(200);
    hor.write(60);
    tone(bz, tones[1]);
    delay(200);
    hor.write(120);
    tone(bz, tones[7]);
    delay(200);
    hor.write(60);
    tone(bz, tones[1], 200);
    delay(200);

  }
  
