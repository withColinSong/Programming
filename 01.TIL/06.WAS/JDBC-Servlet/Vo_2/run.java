package Vo_2;

import java.sql.SQLException;

public class run {
	public static void main(String[] args) {
		
		// INSERT
//		Dao01 dao = new Dao01();
//		try {
//			dao.insertUsers();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// SELECT
		 SELECT select = new SELECT();
		try {
			select.SELECT();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
