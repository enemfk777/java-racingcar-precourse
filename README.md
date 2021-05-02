# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. 
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이
 하의 값이면 멈춘다. 
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 프로그래밍 요구사항
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  * https://naver.github.io/hackday-conventions-java/
* indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
  * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다. 
  * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
* 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다.
* else 예약어를 쓰지 않는다.
  * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
* 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  * 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
* 일급콜렉션을 활용해 구현한다. 
* 모든 원시값과 문자열을 포장한다. 
* 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in, Scanner) 로직은 제외
    * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
* JUnit5와 AssertJ 사용법에 익숙하지 않은 개발자는 첨부한 "학습테스트를 통해 JUnit 학습하기.pdf" 문서를 참고해 사용법을 익힌 후 JUnit5 기반 단위테스트를 구현한다.

## 개발 환경
### JDK 11

## 기능 목록
### Domain
* CarName
  * 자동차 이름을 포장하는 클래스. 
  * 이름에 빈 문자열이 들어왔는지 확인하는 기능을 갖는다.
  * 이름의 길이가 5 이하인지 확인하는 기능을 갖는다.
* Distance
  * 자동차가 이동한 거리를 포장하는 클래스.
  * 이동거리가 0 이상인지 확인하는 기능을 갖는다.
* Car
  * 자동차를 나타내는 클래스.
  * 자동차 이름과 현재 위치, 그리고 이동 전략을 갖는다.
  * 생성시 이동 전략을 주입받아 확장성과 테스트 용이성을 갖는다.
  * 스스로 전략에 따라 이동하는 메서드를 갖고, 해당 메서드는 이동 결과를 반환한다.
* MoveStrategy
  * 이동 전략을 나타내는 인터페이스.
  * 이동 가능 여부를 반환하는 추상 메서드를 갖는다.
* DiceMoveStrategy
  * MoveStrategy 구현체인 클래스.
  * 나오는 숫자 범위를 조절할 수 있게 주사위 전략을 주입받는다.
  * 이동 기준이 되는 숫자를 주입받는다.
  * 이동 가능 여부 추상 메서드를 구현한 메서드를 갖는다.
* DiceStrategy
  * 주사위 전략을 나타내는 인터페이스.
  * 이번 주사위 굴림의 값을 반환하는 추상 메서드를 갖는다.
* SingleDigitDiceStrategy
  * DiceStrategy 구현체인 클래스.
  * 추상메서드를 0 - 9 사이의 숫자만 반환하게 구현한 메서드를 갖는다.
* RunResult
  * 이동 결과를 나타내는 클래스
  * CarName과 Distance를 갖는다.
* LapCount
  * 시도할 횟수를 포장하는 클래스.
  * 시도할 횟수가 1 이상인지 확인하는 기능을 갖는다.
*RacingCars
  * 경주에 참가하는 자동차 목록 나타내는 일급 콜렉션
  * 한 Lap당 Car의 이동결과 목록을 모아서 반환하는 기능을 갖는다.
* LapResult
  * 한 Lap의 이동결과 목록을 나타내는 일급 콜렉션
  * 현재 Lap의 1위를 반환할 수 있다. (복수일 수 있음)
* RacingResult
  * 랩 당 결과 목록을 나타내는 일급 콜렉션
  * 최종 1위를 반환할 수 있다.
* ControlTower
  * LapCount와 RacingCars 갖는 클래스.
  * 레이싱을 시작하는 메서드를 갖고, 해당 메서드는 RacingResult를 반환한다.
### DTO

* ParticipationForm
  * 참가 자동차 이름 목록과 시도할 횟수를 전달할 때 사용하는 클래스
  * 입력값 validation을 수행할 수 있다.
    * 참가자 이름은 5자 이하여야 한다.
    * 시도 횟수는 1회 이상이어야 한다.
  * 도메인 객체에 주입해 줄 형태로 데이터를 가공할 수 있어야 한다.
* AnnouncementSheet
  * 경기 결과를 출력할 때 사용하는 클래스
  * 참가 이름 - 결과 포맷 의 형태를 갖는 리스트와 최종 우승자의 이름을 갖는다.

### UI
* Reception
  * 참가 자동차 목록을 입력받는 기능을 갖는다.
  * 시도할 횟수 (Lap 수)를 입력받는 기능을 갖는다.
* Announcer
  * 경기 결과를 출력하는 기능을 갖는다.

### Main
* Main
  * 프로그램 실행용 클래스
