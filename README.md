# 🏟My Hotel Reservation
> 고객의 입장에서 객실 예약 관련 기능을 수행하는 호텔 예약 페이지
>> 회원가입/로그인/예약생성/예약조회/로그인정보조회


## 1. Entity Relationship

![호텔예약시스템](https://user-images.githubusercontent.com/57335699/132653026-68a04107-a4ee-4e2f-9fdf-ef5ce867ee40.PNG)

## 2. Tech Stack

* **Java**
  * JDBC/JPA/lombok/hibernate/JUnit
* **DB**
  * OracleDB
* **Web**
  * HTML/CSS/JavaScript/JSP

## 3. Program Structure

![Structure](https://user-images.githubusercontent.com/57335699/132658530-ec9f10b4-449c-4f22-8f90-c41f78c698f4.PNG)

## 4. Function
* 회원가입
  * ID,PASSWORD 만을 입력받아 회원 등록 후 Customer 테이블에 저장

* 로그인
  * ID,PASSWORd 입력받아 DB내부의 값과 비교(세션 사용)
    * 값이 존재 할 경우 : 로그인 메세지와 함께 정상 로그인
    * 존재하지 않거나 ID,PASSWORD 둘 중 하나라도 일치하지 않는 경우 : ID,PASSWORD 가 정확하지 않다는 메세지와 함께 로그인 불가능

* 예약
  * Main 페이지에서 날짜를 입력받아 예약 생성
    * 이미 예약된 날짜가 존재 할 경우 : 중복 예약 불가능 메세지 출력과 함께 예약불가능
    * 예약된 날짜가 존재하지 않을 경우 : 해당 회원번호로 정상 예약
  * Main 페이지에서 날짜를 입력받아 예약 취소
    * 로그인 되어있는 세션의 ID 값을 이용, 회원번호를 도출해 예약 정보 조회
    * 해당 날짜에 해당하는 회원번호의 예약이 존재할 경우 : 예약 정보 삭제
    * 해당 날짜에 해당하는 회원 번호의 예약이 존재하지 않을 경우 : 예약 정보 확인 불가 메세지 출력

* 마이페이지
   * 로그인 정보 확인
   * 예약 내역 확인

## 5. TODO

1) 예약 가능/불가능한 날짜 표현 기능
2) 마이페이지 내부 회원정보 수정
3) 마이페이지 내부 예약 정보 수정
4) 관리자 페이지 및 관리자 로그인 기능
5) 회원가입/로그인/정보 생성/수정/삭제/조회에 관한 로그 기록 
6) 발생할 수 있는 모든 상황에 관한 사용자 측면에서의 예외처리(ex. null 값에 관한처리)
7) etc...

## 6. ISSUES

1. 회원가입

 * Controller로 전송할 변수명인 "command"에 오타가 발생한 것을 인지하지 못해 약 25분간 딜레이
    * 정확한 변수명 기입을 통해 해결
  
2. 로그인

 * 세션값을 유지한 채 로그인하여 로그인 화면은 비로그인 화면과 기능이 다르므로 상이한 구축을 원했음.
    * main.html과 loginmain.html 두 페이지로 나누어 구축하여 해결했지만 추후에 한 페이지 내부에서 동적으로
  작동하는 형식으로 변경되어야 할 것으로 생각됨
  
 * 로그인 시, 정상/비정상 로그인 여부를 띄워주는 alert 메세지가 노출되기를 원했음.
    * jsp 파일로 넘어가며 response.Write 내부에 alert 사용하여 해결
 
3. 예약

 * 예약 테이블이 생성되지 않는 치명적인 문제(3시간 이상 딜레이)
    * 원인 : 테이블 내부 컬럼으로 Date라는 변수명을 사용하였는데 이는 오라클 DB에서 기본 변수명처럼 취급되기 때문에 사용이 불가능
    * 해결 : resDate라는 변수명으로 변경하였더니 해결
  
 * primary key가 아닌 입력받은 날짜 데이터로 테이블 내부를 조회하는것을 원함
    * But, JPA의 find 명령어를 활용해 primary key 이외의 탐색하는 방법을 인지하지 못하였음
    * 결국 JDBC를 활용할 수 밖에 없었고 상황에 따라 JPA와 JDBC를 혼용하여 해결
  
 * Main 페이지에서 한가지의 공통적인 날짜 입력으로 두가지 버튼에 각각 다른 전송을 원하였음
    * 두개의 form 을 활용하면 공간이 낭비되니 한가지 form으로 해결하고 싶었음
    * submit을 href 태그로 바꿔서 command를 각각 다르게 전송해 보았지만, 이 방법은 입력받은
  날짜 데이터를 Controller에 전송하지 못하였음
    * JavaScript를 사용할 수 밖에 없었고 아직 JavaScript 사용법에 미숙하여서 강사님께 도움받아
  코드를 구현하여 해결하였음
