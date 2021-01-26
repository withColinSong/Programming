# 스프링 프로젝트 간단 정리
## Dynamic Web Project -> Convert Maven Project

![](https://images.velog.io/images/withcolinsong/post/39ba9698-d7fd-4e67-a63d-9be486281a8b/image.png)

### src/bean/MemberFactory 
- Mybatis Factory

### src/bean/member
- `Dao`
  - 기능
- Dao 인터페이스를 구현한 클래스 `MemberDao`
    - SqlSession을 통해 데이터베이스를 얻어옴
- `MemberController` -> Controller
- `MemberVo, UserJoin` -> Entity
- `config.xml` -> Mybatis 매핑 -> member.xml
- `member.xml` -> Mybatis SQL 쿼리문

### WebContent/WEB-INF/view
- View

### WebContent/WEB-INF/-servlet.xml
- DispatcherServlet

### web-xml
- HandlerMapping

### pom.xml
- Maven 라이브러리


