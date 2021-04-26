# Spring boot project

ci, cd - continue indegration / continue develope

프로젝트 개발, 변경사항, 수정 유지

지속적 통합, 배포를 위함

### Spring 개발방법

1> git command

spring 개발방법 다양 (xml + @annotation)

* spring mvc project / spring boot project

2> git sts 연동

* spring boot project = spring starter project
  * spring mvc - 다양한 @, xml파일 다수
  * spring boot project - xml이 줄어들거나 없을 수 있음
    * web.xml, servlet-context, spring bean 설정파일.xml >> 없어짐
    * mybatis sql_mapping.xml >> 여전히 존재함
    * 새로운 annotation 다수 존재 ex) @Springbootxxxx 

### Spring boot project 생성

##### new spring starter project

* 생성
  * Type - maven
  * Packaging - War
  * java version - 8 ( 현재 )

* next
  * Available - Web - Spring web선택

* finish
  * project명 뒤에 boot가 붙음

* 생성한 패키지 내 ServletInitializer
  * web.xml대신 존재하는 application.properties 파일 설정을 읽어옴
* 프로젝트명Application.java (ex myprojApplication.java)
  * spring boot tomcat 내장 서버 자동 실행
  * 부트 시작 클래스 ( main 클래스 존재 )

* 실행
  * Run - Run as - Spring boot app로 반드시 실행
    * port충돌 문제
    * application.properties에서 server.port=0000 설정
    * 한글 주석 설정 시 save-utf-8
* resources - application.properties
  * 모든 설정은 application.properties에서 설정
* 간단한 예제

```java
@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String test() {
		return "hello";
	}
}
```

* chrome창을 열어 http://localhost:9091/hello url입력시 "hello" 표시
* pom.xml에 추가 설정

```xml
		<!-- for jsp -->
		<dependency>
	        <groupId>org.apache.tomcat.embed</groupId>
	        <artifactId>tomcat-embed-jasper</artifactId>
	        <scope>provided</scope>
	    </dependency>
	    
			<!-- for jsp jstl -->
	    <dependency>
	        <groupId>javax.servlet</groupId>
	        <artifactId>jstl</artifactId>
	    </dependency>
	    
	    <!-- for tomcat auto restart -->
	    <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>

		<!-- for mybatis setting -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>2.1.4</version>
		</dependency>
		<dependency>
			<groupId>com.oracle.database.jdbc</groupId>
			<artifactId>ojdbc8</artifactId>
			<scope>runtime</scope>
		</dependency>
	</dependencies>
```

* application.properties 설정

```properties
# 서버포트변경
server.port=9091

#Spring MVC
spring.mvc.view.prefix=/WEB-INF/views
spring.mvc.view.suffix=.jsp

#file upload size - 1mb default
spring.servlet.multipart.maxFileSize=100MB
spring.servlet.multipart.maxRequestSize=100MB

#mybatis db connection infomation
spring.datasource.driver-class-name= oracle.jdbc.driver.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@127.0.0.1:1521:xe
spring.datasource.username=hr
spring.datasource.password=hr

#mybatis 연결설정파일명
# classpath >> src/main/resources
# db-config.xml은 src/main/resources에 저장
mybatis.config-location=classpath:db-config.xml
```

##### Spring boot 환경설정

1> application.properties 파일 설정

2> jsp 사용 설정 추가 필요

* pom.xml / application.properties

3> 컨텍스트가 따로 없음

*  http://ip:port/ > default address

4> main 메소드 존재 (ProjectNameApplication.java)

* main클래스 우클릭 - run as - spring boot app

5> 내장 tomcat 동작

* application.properties > 포트설정 변경

6> tomcat 자동 재시작 설정 변경

7> 주소 입력으로 브라우저 수동 실행

8> src/main/resources/application.properties

* src/main/resources/static/html css js gif 저장

* src/main/resources/static/templates/타임리프포함 html파일 (설정 추가)
  * boot는 기본적으로 타임리프라는 뷰(*.html)를 기본 템플릿으로 가짐

\<th:xxx>

| src/main/webapp | resources | html css js gif 저장 |             |
| --------------- | --------- | -------------------- | ----------- |
|                 | WEB-INF   | web.xml              |             |
|                 |           | views                | jsp포함     |
|                 |           | spring               | 설정xml포함 |

9> \<script src="/static/jquery-3.2.1.min.js">

* 경로는 다음과 같이 resources 폴더가 기본

10> spring mvc - pom.xml 라이브러리 추가

*  ajax > boot에선 라이브러리 이미 포함
  * @ResponseBody 어노테이션만 사용하면 됨

*  file upload > boot에선 라이브러리 이미 포함
  * mvc >> MultipartFile api 이용하려면 >> CommonsMultipartFileResolver선언
  * boot >> 자동 포함

* mybatis 추가
  * 프로젝트 우클릭 - spring - add starter - SQL - JDBC api, mybatis framework, oracle driver 추가 - next - pom.xml  선택(구성내용 자동추가)

* mybatis - spring mvc에서 설정 방법
  * 1> sql 매핑 xml 단독설정
  * 2> sql매핑 xml + dao 파일들 같이 매핑

* mybatis - spring boot에서 설정 방법
  * sql매핑 xml + dao 파일들 같이 매핑
  * DAO > 인터페이스로 설정 후 @Mapper 선언

| @Mapper<br />@Repository<br />interface EmpDAO<br />List\<EmpVO> <u>**getEmpList()**</u>; | sql 매핑 xml                                                 |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| @Repository<br />class EmpDAO<br />@Autowired<br />SqlSession session<br />List\<EmpVO> getEmpList(){<br />(기존 mvc에서 dao선언) | \<mapper: EmpDAO<br />\<select id="**<u>getEmpList()</u>**" resultType="empVO"<br />mapper 동일하게, id=메서드이름 |

* EmpDAO - interface 선언, @Mapper로 변경
* Annotation 설정
  * ProjectNameApplication.java 에서 @ComponentScan, @MapperScan 등록
    * ex) @ComponentScan(basePackageClasses = EmpController.class)
      * EmpController 클래스가 존재하는 package 자동 스캔
      * EmpController 클래스 위에 @Controller Annotation 첨부
    * @ComponentScan >>>  ProjectNameApplication.java 가 포함된 패키지와 같은 패키지의 컨트롤러 자동 스캔

* Mapper 설정
  * ex) @MapperScan(basePackageClasses = EmpDAO.class)
    * EmpDAO 인터페이스가 존재하는 package 자동 매핑
    * EmpDAO 에서 @Mapper / @Repository("dao") annotation 설정

#### mybatis.xml 설정

```xml
<!--1. 데이터 연결 conn 설정 -->
<bean id="dataSource" 
class=
"org.springframework.jdbc.datasource.DriverManagerDataSource" >
	<property name="driverClassName" 
	value="oracle.jdbc.driver.OracleDriver" />
	<property name="url" 
	value="jdbc:oracle:thin:@localhost:1521:xe" />
	<property name="username" value="name" />
	<property name="password" value="pw" />			
</bean>

<!-- SqlSessionFactoryBean 설정 -->
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
	<property name="dataSource" ref="dataSource" />
	<property name="configLocation" 
	value="classpath:spring_mybatis/db-config.xml" />	 
	<property name="mapperLocations"
	value="classpath:spring_mybatis/*-mapping.xml" />
</bean>

<!-- SqlSessionTemplate api-->
<bean id="sqlSession" 
class="org.mybatis.spring.SqlSessionTemplate">
	<constructor-arg ref="sqlSessionFactory" />
</bean>
```

#### db-config.xml 설정

```xml
<configuration>
	<!-- 
	타입 alias : 
	mybatis.EmpVO : SQL결과 데이터 저장 
	별명 : emp 
	-->
	<typeAliases>
		<typeAlias type="spring_mybatis.EmpVO" alias="empVO"/>
	</typeAliases> 
	

<!-- sql mapping 파일 설정 -->
	<mappers>
		<mapper resource="mybatis/sql-mapping.xml"/>  
	</mappers> 
</configuration>
```



##### 번외

### File upload

* uploadVO

```java
public class UploadVO { 
	String name;
	String description;
	MultipartFile file1;
	MultipartFile file2;
    //이하 setter/getter 생략
```

* uploadController

```java
@Controller
public class UploadController{
    
    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0,10);
    }
    
    @RequestMapping(value="/fileupload", method=RequestMethod.GET)
    public String uploadform(){
        return "/upload/uploadform"
    }
    
    @RequestMapping(value="fileupload", method=RequestMethod.POST)
    public String uploadresult(@ModelAttribute("vo") UploadVO vo) throws IOException{
        MultipartFile multipartfile1 = vo.getFile1();
        MultipartFile multipartfile2 = vo.getFile2();
        
        String filename1 = multipartfile1.getOriginalFilename();
        String filename2 = multipartfile2.getOriginalFilename();
        
        String savePath = "c:/upload/";
        
        //중복파일처리
        String path [] = filename1.split("[.]");
        String ext1 = filename1.substring(filename1.lastIndexOf("."));
        String ext2 = filename2.substring(filename2.lastIndexOf("."));
        
       	filename1 = getUuid() + "("+multipartfile1.getOriginalFilename()+")" + ext1;
		filename2 = getUuid() + "("+multipartfile2.getOriginalFilename()+")" + ext2;

		
		// path+name
		File file1 = new File(savePath+filename1);
		File file2 = new File(savePath+filename2);
		
		//서버 저장
		multipartfile1.transferTo(file1);
		multipartfile2.transferTo(file2);
		
		return "/upload/uploadresult"; 
    }
}
```

