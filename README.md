## JAVA 용어 정리
- `Java Bean` : Java Bean 규약을 따르는 Java의 Class. 명시적으로 존재하는 클래스는 아니다.
- `Java Bean 규약` 
    ```
    1. 모든 필드는 private이며, getter/setter메서드를 통해서만 접근이 가능하다.
    2. Argument가 없는(no-argument) 생성자가 존재한다.
    3. java.io.Serializable 인터페이스를 구현한다.
    ```
- `Java Builder Pattern` : lombok의 annotaion `@Builder`를 사용해 쉽게 구현 가능
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
- `lombok` : 
- `Entity` : `@Entity`를 통해서 지정. DB와 직접적으로 맞닿은 핵심 클래스. DB table의 기준이 됨.
- `DTO` : Data Transfer Object. 계층 간 데이터 교환을 위한 Java Beans. Entity 클래스의 구조를 기준으로, 
각각의 View마다 그 구조를 변경해서 사용해야 하는 클래스 
- `DAO` : Data Access Object. DB의 data에 접근하는 데에 사용되는 객체
- `VO` : Value Object. read only 속성(literal)을 갖는 DTO. 
- `Dirty Checking` : 

## Test
- `Junit`
- `H2` : `@SpringBootTest` 사용 시, H2 DB 실행이 기본 값.~~(==SQLite of Django??)~~