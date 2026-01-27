package web_ajax;
//Model (usercheck.java가 Controller) 연계
public class data_check {
	String[][] companyUsers = {
            {"user01", "pass111!", "테크노솔루션", "김철수", "123-45-67890"},
            {"alpha_biz", "alpha99@!", "알파소프트", "이영희", "234-56-78901"},
            {"global_trade", "gt7788#", "글로벌무역", "박준호", "345-67-89012"},
            {"nature_farm", "nf123456", "네이처팜", "최미경", "456-78-90123"},
            {"blue_ocean", "blue!@#", "블루오션기획", "정태양", "567-89-01234"},
            {"smart_factory", "sf9876", "스마트공방", "강산아", "678-90-12345"},
            {"k_design", "kd_7410", "케이디자인", "조현우", "789-01-23456"},
            {"mega_corp", "mc0000**", "메가코퍼레이션", "윤지민", "890-12-34567"},
            {"fast_logis", "fl_9988", "신속로지스", "한상원", "901-23-45678"},
            {"dream_edu", "dream_77", "드림에듀케이션", "임수아", "012-34-56789"}
    };
	String result = "ok";	//return 결과를 사용하기 위한 전역변수
	
	public String idsearch(String id) {	//아이디를 검색하여, 결과값을 Controller에게 return 한다.
		int w = 0;
		while(w < this.companyUsers.length) {
			if(id.equals(this.companyUsers[w][0])) {
				this.result = "no";
				break;
			}
			
			w++;
		}
		
		return this.result;
	}
	
	
}
