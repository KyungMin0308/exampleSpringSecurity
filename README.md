# exampleSpringSecurity

### **1. Description**
* **Spring Security 5**를 활용한 Spring Security 예제 프로그램입니다.
* **Custom Login Form**을 사용하여 인증/인가를 수행합니다.


### **2. Environment**
* **Eclispe**
  + Spring Legacy Project
    - Template : Spring MVC 선택
* **Server**
  + Tomcat
* **Database**
  + MySQL
  
  
### **3. Packages**
* **controller**
  + 사용자의 요청(request)을 처리하는 Class
  + Service Class의 객체를 사용하여 필요한 작업을 수행
  + **Custom Login Form**을 사용하기 위해 LoginController 클래스 사용
  + **HomeController, OfferController, LoginController(★)**
* **dao**
  + DAO Class를 위한 패키지
  + DB에 접근하여 수행할 작업을 메서드로 구현
  + **OfferDao**
* **model**
  + 애플리케이션에서 사용할 Model Class를 위한 패키지
  + Annotation을 통해 Data Validation을 위한 제약 조건 설정
  + **Offer**
* **service**
  + Service Layer를 구현하는 Class
  + DAO Class의 객체를 사용하여 필요한 작업을 수행
  + **OfferService**
* **filter**
  + 기본 Filter 클래스를 포함하는 패키지
  + 사용자의 URL 요청을 콘솔에 출력
  + **TestFilter**


### **4. 주요 Files**
* **pom.xml**
  + 기본적인 Spring Legacy Project의 POM에 추가된 Dependency들
    - lombok
    - hibernate-validator
    - spring-jdbc
    - mysql-connector-java
    - commons-dbcp2
    - spring-security-core
    - spring-security-web
    - spring-security-config
* **web.xml**
  + contextConfigLocation 설정(dao-context.xml, service-context.xml, security-context.xml)
  + DispatcherServlet 설정(servlet-context.xml)
* **jdbc.properties**
  + Database를 접근하기 위한 Property 정보
  + username과 password에는 본인의 MySQL 정보 입력
  + webapp/WEB-INF/**props**
* **dao-context.xml**
  + DataSource와 관련된 설정 수행
  + DAO 패키지를 스캔
  + webapp/WEB-INF/**spring/appServlet**
* **service-context.xml**
  + Service 패키지를 스캔
  + webapp/WEB-INF/**spring/appServlet**
* **servlet-context.xml**
  + DispatcherServlet에 의해 로드
  + Controller 패키지를 스캔
  + webapp/WEB-INF/**spring/appServlet**
* **security-context.xml(★)**
  + Spring Security를 위한 설정 파일
  + Authentication과 Authorization 조건을 설정
  + webapp/WEB-INF/**spring/appServlet**
* **offer.sql**
  + 예제 프로그램을 위한 MySQL Table Schema & Data 파일
  + Model 클래스에 대한 정보
    - **offer** 테이블
* **security.sql**
  + 예제 프로그램을 위한 MySQL Table Schema & Data 파일
  + Security를 위한 정보
    - **users** 테이블
    - **authorities** 테이블
