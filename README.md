# 이슈 관리 시스템  
깃허브의 이슈관리 시스템을 모방해 구현한 프로젝트  
---  

**Project duration** : 1개월 (2018.06)   
**Language** : Java 1.8, Javascript, HTML, CSS   
**Skill specification** : Spring boot, JPA, jQuery, JUnit, Gradle, Handlebars.java  
**개발 인원** : 1명  

**주요 기능**
- 회원 가입, 로그인 (Basic 인증)
- 이슈 등록
- 마일스톤, 라벨, 이슈 담당자 추가 기능
- 댓글 추가 기능

**구현 단계 및 성과**   
- Spring boot 기반의 웹 프로젝트 제작  
- ATDD(인수 테스트) 이해를 바탕으로 프로젝트 구현 순서 고려
- JPA 도입, 객체지향적인 도메인 설계 시 얻는 이점과 적절한 테이블 맵핑 방법 학습  
- Basic authentication 처리를 위한 AOP 코드 작성
- 파일 업로드 기능 구현

**아쉬운 점, 보완할 점**
- Controller가 아닌 RestController와 AJAX기반 처리 경험 부족
- Validation, Exception 일관성 있는 처리 미숙