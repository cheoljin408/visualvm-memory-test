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
- 시연
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
