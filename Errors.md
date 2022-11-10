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

- 로그인해야 하는 기능 테스트
    https://shinsunyoung.tistory.com/70
    https://velog.io/@jkijki12/Spring-MockMvc

- VO객체를 api로 리턴 시 필드명이 언더바(_) 앞부분만 소문자로 변형되어 나타남
    ![221109_1](./md_resources/221109_1.PNG)
    왜??
    - 필드명 위에 `@JsonProperty("abstract_txt")` 이런 식으로 전부 소문자화한 annotation을 모두 달아주면 소문자로 통일시킬 수 있지만, 필드마다 일일이 달아주기엔 필드가 너무 많음..
    - https://stackoverflow.com/questions/26744885/jackson-objectmapper-upper-lower-case-issues 여기 밑에 있는 답변 중 https://stackoverflow.com/questions/7854030/configuring-objectmapper-in-spring/32842962#32842962 잭슨 configuration class를 이용하는 방식
        - mapper.configure가 deprecated
        - 결국 그냥 필드명을 모두 소문자로 변경하고 소문자로 일치시킴

## 221110 (목)

- review 인서트나 업데이트할 때 각 string 필드 값들의 공백을 제거하고 넣고 싶은데 (trim), 각 필드를 수작업으로 갖고와서 get, null체크, trim, set 해주자니 너무 필드가 많고 반복작업이라 방법을 찾아봄
    - java reflection 이용
    - https://stackoverflow.com/questions/17461442/how-to-get-string-value-from-a-java-field-via-reflection
    - https://goodgid.github.io/Java-Reflection-Field-Value/
    - https://goodgid.github.io/Java-Reflection-Modify-Class-Information/
    - 그런데.. 사용하지 않는 것이 좋다고 한다
        - https://tecoble.techcourse.co.kr/post/2020-07-16-reflection-api/
    - 하지만 여기서도 이렇게 했다
        - https://whitepro.tistory.com/527
        - https://blog.gangnamunni.com/post/Annotation-Reflection-Entity-update/
    - 더 좋은 방법이 있다면.. 나중에 리팩토링
    - 코드는 엄청 간결해짐

- DTO vs VO vs Entity
    - 생각없이 VO라고 이름짓고 쓰고 있었는데 나혼자 만들면서도 뭔가 이게 모두 다 VO가 아닌것 같은데 라는 생각이 들었고 구글링하다가 한번 확실히 해야겠다는 생각이 들어서 개념정리
    - https://youngjinmo.github.io/2021/04/dto-vo-entity/
    - https://tecoble.techcourse.co.kr/post/2021-05-16-dto-vs-vo-vs-entity/ 
    개념은 알겠는데 그래서 어디에 어떤걸 써야하는지 감이 잘 안온다..
    - https://sas-study.tistory.com/404 오히려 여기서 이 사람이 쓰는 Param Entity Result 객체의 구분이 활용상 더 와닿음
    - https://parkadd.tistory.com/53 사용예시가 조금 있음