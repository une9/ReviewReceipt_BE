# Error 해결

## 221108 (화)

- postmapping, insertUser로 요청보냈을 때

> 2022-11-08 13:34:03.067  WARN 19992 --- [nio-8080-exec-2] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.web.method.annotation.MethodArgumentTypeMismatchException: Failed to convert value of type 'java.lang.String' to required type 'int'; nested exception is java.lang.NumberFormatException: For input string: "insert"]

--> 이런.. POST로 보내야하는데 GET으로 보내서 getUser로 요청 들어가서 그런거였음

<br>

## 에러처리
*** https://bamdule.tistory.com/92

## 221109 (수)

- spring security로 비밀번호 암호화하기
https://seungyooon.tistory.com/245
https://velog.io/@jupiter-j/SpringSecurity-JWT-%EB%A1%9C%EA%B7%B8%EC%9D%B8%EC%8B%9C-401-%EC%97%90%EB%9F%AC

    - 최근에 구현 방식이 변경되어 다수의 블로그에 있는 방식 그대로 적용 어려움
    https://velog.io/@pjh612/Deprecated%EB%90%9C-WebSecurityConfigurerAdapter-%EC%96%B4%EB%96%BB%EA%B2%8C-%EB%8C%80%EC%B2%98%ED%95%98%EC%A7%80

- UserService 파일이 validation 함수들과 같이 있어 너무 길어져서 UserServiceUtil로 별도 클래스 분리
https://okky.kr/articles/508171


