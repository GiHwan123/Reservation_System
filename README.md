# 🏟My Hotel Reservation
> 고객의 입장에서 객실 예약 관련 기능을 수행하는 호텔 예약 페이지
>> 회원가입/로그인/예약생성/예약조회/로그인정보조회


## 1. Entity Relationship

![호텔예약시스템](https://user-images.githubusercontent.com/57335699/132653026-68a04107-a4ee-4e2f-9fdf-ef5ce867ee40.PNG)

## 2. Tech Stack

* Java
  * JDBC/JPA/lombok/hibernate/JUnit
* DB
  * OracleDB
* Web
  * HTML/CSS/JavaScript/JSP

## 3. Function
* 회원가입
  * ID,PASSWORD 만을 입력받아 회원 등록 후 Customer 테이블에 저장

* 로그인
  * ID,PASSWORd 입력받아 DB내부의 값과 비교
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

## 4. TODO

1) 
