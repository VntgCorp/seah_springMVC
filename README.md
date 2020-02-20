# seah_springMVC
Spring MVC Project

- 개발환경 셋팅

1. Java 설치
https://jdk.java.net/ 접속후 java8버전 다운로드

2. tomcat 설치
https://tomcat.apache.org/download-80.cgi 윈도우용 설치.

3. Spring Tools 설치 (Eclipse)
https://spring.io/tools
다운로드후 더블클릭 하여 압축 해제. SpringToolSuite4.exe 실행.

4. mysql 설치
https://dev.mysql.com/downloads/mysql/


- 디렉토리 구조
1. src/main/java ...
	java Source가 위치하는 폴더.

2. resources
	웹 화면에서 사용될 자원이 저장되는 폴더 ex)css, js, image
	
3. servlet-context.xml
	Spring 웹 컨테이너 설정 파일
	
4. web.xml
	- DispatcherServlet 서블릿 맵핑
	- 스프링 설정 파일 위치 정의
	
	DispatchServlet?
		- 클라이언트의 요청을 최초로 받아 컨트롤러에 전달

5. views
	웹 화면 파일
	

	
- Controller 클래스 제작 순서
1. src/main/java/controller 패키지에서 우클릭 하여 New > Class 선택 후 클래스 생성
2. 클래스에 @Controller Annotation을 추가하여 Controller Bean으로 지정
3. Method를 생성한 후, @RequestMapping Annotaion을 추가하여 요청 경로 지정
4. 요청 처리 구현
5. 뷰 이름 리턴. (views folder 파일)



