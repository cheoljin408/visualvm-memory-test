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
