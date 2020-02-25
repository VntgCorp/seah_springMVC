Spring MVC Project

- 개발환경 셋팅
1. Java 설치<br> 
	https://jdk.java.net/ 접속후 java8버전 다운로드<br>
	
1.1. Java 환경변수 설정<br>
	[검색]에서 시스템(제어판)을 검색하여 선택합니다.<br>
	고급 시스템 설정 링크를 누릅니다.<br>
	환경 변수를 누릅니다. 시스템 변수 섹션에서 PATH 환경 변수를 찾아 선택합니다. 편집을 누릅니다. PATH 환경 변수가 존재하지 않을 경우 새로 만들기를 누릅니다.<br>
	시스템 변수 편집(또는 새 시스템 변수) 창에서 PATH 환경 변수의 값을 지정합니다. 확인을 누릅니다. 확인을 눌러 나머지 창을 모두 닫습니다.<br>
	명령 프롬프트 창을 Java -version 코드를 실행합니다.<br>


2. tomcat 설치 <br>
	https://tomcat.apache.org/download-80.cgi 윈도우용 설치.

3. Spring Tools 설치 (Eclipse)<br> 
	https://spring.io/tools 다운로드후 더블클릭 하여 압축 해제. SpringToolSuite4.exe 실행.

4. mysql 설치 <br>
	https://dev.mysql.com/downloads/mysql/

5. mysql workbench 설치 <br>
	https://dev.mysql.com/downloads/workbench/
	
	
- 디렉토리 구조
1. src/main/java ...<br> 
	java Source가 위치하는 폴더.

2. resources <br>
	웹 화면에서 사용될 자원이 저장되는 폴더 ex)css, js, image

3. servlet-context.xml<br> 
	Spring 웹 컨테이너 설정 파일

4. web.xml<br>
	DispatcherServlet 서블릿 맵핑<br>
	스프링 설정 파일 위치 정의<br>
	DispatchServlet? - 클라이언트의 요청을 최초로 받아 컨트롤러에 전달

4. views <br>
	웹 화면 파일

- Controller 클래스 제작 순서<br>
1. src/main/java/controller 패키지에서 우클릭 하여 New > Class 선택 후 클래스 생성
2. 클래스에 @Controller Annotation을 추가하여 Controller Bean으로 지정
3. Method를 생성한 후, @RequestMapping Annotaion을 추가하여 요청 경로 지정
4. 요청 처리 구현
5. 뷰 이름 리턴. (views folder 파일)