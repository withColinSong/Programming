package Vo_2;

import java.sql.Date;

public class Vo {
	private long EMPNO;
	private String ENAME;
	private String JOB;
	private String MGR;
	private Date HIREDATE;
	private long SAL;
	private long COMM;
	private long DEPTNO;
	
	public long getEMPNO() {
		return EMPNO;
	}
	public void setEMPNO(long eMPNO) {
		EMPNO = eMPNO;
	}
	public String getENAME() {
		return ENAME;
	}
	public void setENAME(String eNAME) {
		ENAME = eNAME;
	}
	public String getJOB() {
		return JOB;
	}
	public void setJOB(String jOB) {
		JOB = jOB;
	}
	public String getMGR() {
		return MGR;
	}
	public void setMGR(String mGR) {
		MGR = mGR;
	}
	public Date getHIREDATE() {
		return HIREDATE;
	}
	public void setHIREDATE(Date hIREDATE) {
		HIREDATE = hIREDATE;
	}
	public long getSAL() {
		return SAL;
	}
	public void setSAL(long sAL) {
		SAL = sAL;
	}
	public long getCOMM() {
		return COMM;
	}
	public void setCOMM(long cOMM) {
		COMM = cOMM;
	}
	public long getDEPTNO() {
		return DEPTNO;
	}
	public void setDEPTNO(long dEPTNO) {
		DEPTNO = dEPTNO;
	}

	@Override
	public String toString() {
		return "Vo [EMPNO=" + EMPNO + ", ENAME=" + ENAME + ", JOB=" + JOB + ", MGR=" + MGR + ", HIREDATE=" + HIREDATE
				+ ", SAL=" + SAL + ", COMM=" + COMM + ", DEPTNO=" + DEPTNO + "]";
	}

}
