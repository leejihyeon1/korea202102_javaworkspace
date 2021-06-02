package jtable.vector;

//현실의 하나의 게시판을 db분야에서는 table로 정의하고, oop에서는 class로 표현한다
//이때 oop개발자는 게시판의 컬럼만 봐도 oop의 클래스로 변환할 줄 알아야한다!!!!!(기본임)
//프로젝트 진행시 db에 존재하는 table이 만일 197개일경우 적어도 이에 대응되는 VO의 개수는 197개이상 이다..
public class Notice {
	private int notice_id;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int hit;
	
	public int getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	


}
