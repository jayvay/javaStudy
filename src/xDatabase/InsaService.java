package xDatabase;

import java.util.Calendar;

public class InsaService {

	InsaVO vo = null;	
	
	//오늘 날짜 구하기
	public InsaVO getDefaultDate() {
		vo = new InsaVO();
		
		//캘린더 객체는 싱글톤 객체. 싱글톤 객체는 getInstance()로 부른다.
		Calendar cal = Calendar.getInstance();
		vo.setStrYY(cal.get(Calendar.YEAR) + "");
		vo.setStrMM(cal.get(Calendar.MONTH)+1 + "");
		vo.setStrDD(cal.get(Calendar.DATE) + "");
		
		return vo;
	}


}
