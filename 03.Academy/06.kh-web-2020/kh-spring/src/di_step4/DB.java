package di_step4;

import java.util.List;

public interface DB {
	
	
	public List<String> select(String mid);
	public String insert(String mid, String pw);
	public String delete(String mid, String pw);
	public int update(String mid, String pw, int serial);
	
}
