public class Controller {
	public static void main(String[] args) {
		Dao dao = new Dao();
		Memo m = dao.selectOne(101);
		if(m == null) {
			System.out.println("데이터가 없습니다.");
		}else {
			System.out.println("NO\tNAME\tMSG\tWRITEDAY");
			System.out.println("-----------------------------------");
			System.out.println(m.getNo() + "\t" + m.getName() + "\t" + m.getMsg() + "\t" + m.getWriteday());			
			
		}
		
	}
}
