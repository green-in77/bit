package DI_06_Spring;

public class ArticleService {
	
	//사용자 요청에 따라서 
	
	//글쓰기
	//목록보기
	//수정하기
	
	//서비스를 하기 위해서는 DB작업 -> DAO단
	//서비스는 DAO 가 필요하다. 받는 방법이 2가지 : DI : 생성자, setter 
	private ArticleDao articledao; //이 변수가 실 객체의 주소를 가지면 된다.
	
	public ArticleService(ArticleDao articledao) { //클래스 다이어그램에서 집합연관
		this.articledao = articledao; //주소값 할당
		System.out.println("ArticleService 생성자 함수 호출");
	}
	
	//글쓰기 서비스
	public void write(Article article) { //클래스 다이어그램에서 순수한 의존관계
		this.articledao.insert(article);
	}
	
}
