# Error 해결

## 221108 (화)

- postmapping, insertUser로 요청보냈을 때

> 2022-11-08 13:34:03.067  WARN 19992 --- [nio-8080-exec-2] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.web.method.annotation.MethodArgumentTypeMismatchException: Failed to convert value of type 'java.lang.String' to required type 'int'; nested exception is java.lang.NumberFormatException: For input string: "insert"]

--> 이런.. POST로 보내야하는데 GET으로 보내서 getUser로 요청 들어가서 그런거였음

<br>

## 에러처리
*** https://bamdule.tistory.com/92

##