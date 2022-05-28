# VisualVM을 사용한 원격 JVM 모니터링

# 발표내용

개발용 AWS EC2의 Spring 웹 서비스에 SSH 터널링 방식으로 JMX 설정을 추가하여 재기동하고

로컬 PC에서 VisualVM을 사용하여 원격 JVM의 메모리 사용과 메소드 호출 발생 건수 확인

# 목차

- VisualVM이란?
- VisualVM 설치와 원격 서버 JMX 설정
    - VisualVM 설치
    - 원격 서버 JMX 설정
    - AWS EC2 인바운드 규칙 추가(JMX가 들어올 포트 열어주기)
- VisualVM 연결 및 사용
- VisualVM의 장단점
# VisualVM이란?

![https://visualvm.github.io/images/visualvm_logo_big.png](https://visualvm.github.io/images/visualvm_logo_big.png)

VisualVM은 **JVM을 실시간으로 모니터링 할 수 있는 오픈소스 기반 GUI 툴** 입니다.

- 로컬에서 실행중인 애플리케이션 뿐만 아니라 원격에서 실행중인 애플리케이션 또한 모니터링 가능
- 메모리 사용량 모니터링
- 쓰레드 상태 모니터링
- 가상머신에 로드된 클래스 데이터 모니터링

# VisualVM 설치와 원격 서버 JMX 설정

## VisualVM 설치

[VisualVM: Home](https://visualvm.github.io/)

위 링크에서 다운로드 후 실행

## 원격 서버 JMX 설정

JMX(Java Management eXtensions)는 애플리케이션 및 서비스 지향 네트워크 등을 감시 관리하기 위한 도구를 제공하는 자바 API

JMX를 사용하여 JVM에서 실행중인 자바 기반의 애플리케이션을 모니터링 및 관리

JMX Remote 설정을 추가한 실행 스크립트 생성 `run.sh`
```java
java \
-Dcom.sun.management.jmxremote=true \
-Dcom.sun.management.jmxremote.local.only=false \
-Dcom.sun.management.jmxremote.port=[JMX PORT] \
-Dcom.sun.management.jmxremote.ssl=false \
-Dcom.sun.management.jmxremote.authenticate=false \
-Djava.rmi.server.hostname=[REMOTE SERVER IP] \
-Dcom.sun.management.jmxremote.rmi.port=[JMX PORT] \
-jar [실행할 파일명].jar
```

`run.sh` 를 실행해서 원격 서버에 Spring 웹 서비스 실행

## AWS EC2 인바운드 규칙 추가(JMX가 들어올 포트 열어주기)

<img src="https://user-images.githubusercontent.com/52393564/170829485-29c48299-baa3-4672-a1d2-c13f85d4cd67.png"/>

포트번호 1099로 설정

# VisualVM 연결 및 사용

<img width="506" src="https://user-images.githubusercontent.com/52393564/170829545-6431973d-b271-4344-876d-5861bd4a6ae9.png"/>

- Add Remote Host… 클릭하여 Remote Host 추가

<img width="506" src="https://user-images.githubusercontent.com/52393564/170829596-92501e55-00da-4f7e-bbe5-0c3330661209.png"/>

- Host name 입력
- 원격 서버(aws ec2) 퍼블릭 IPv4 주소 입력

<img width="506" src="https://user-images.githubusercontent.com/52393564/170829618-43522a63-dd1b-45eb-a57e-bb974316df96.png">

- Add JMX Connection… 클릭하여 원격 서버와 JMX 연결

<img width="506" alt="스크린샷 2022-05-25 오후 10 55 27" src="https://user-images.githubusercontent.com/52393564/170829638-888c490c-8eef-40d7-bb1c-b2d7596c5a57.png">

- 원격 서버 IP는 이미 입력되어 있고, 이 전에 인바운드 규칙에서 추가한 1099 포트번호를 입력

# VisualVM의 장단점

## 장점

- JVM의 전반적인 상태를 시각적으로 확인할 수 있다.
- Heap Dump, Thread Dump 등을 GUI 기반으로 생성할 수 있다.

## 단점

- 분석 보다는 모니터링에 최적화 되어있는 것으로 보인다.
- Heap Dump, Thread Dump로 Memory와 Thread 상태를 분석할 때 별도의 툴을 사용한다.
