##JAVA 용어 정리
- DTO : Data Transfer Object. 계층 간 데이터 교환을 위한 Java Beans 
- DAO : Data Access Object. DB의 data에 접근하는 데에 사용되는 객체
- VO : Value Object. read only 속성(literal)을 갖는 DTO. 
- Java Bean : Java Bean 규약을 따르는 Java의 Class. 명시적으로 존재하는 클래스는 아니다.
- Java Bean 규약 
    ```
    1. 모든 필드는 private이며, getter/setter메서드를 통해서만 접근이 가능하다.
    2. Argument가 없는(no-argument) 생성자가 존재한다.
    3. java.io.Serializable 인터페이스를 구현한다.
    ```
- Java Builder Pattern : lombok의 annotaion `@Builder`를 사용해 쉽게 구현 가능
    ```
    @Builder
    class Example { 
        private int a;
        private String b;
        ... 
    } 
    Example e = Example.builder()
        .a(1)
        .b("b")
        .build()
    ```
  
  
##Test
- Junit
- H2 : `@SpringBootTest` 사용 시, H2 DB 실행이 기본 값.~~(==SQLite of Django??)~~

