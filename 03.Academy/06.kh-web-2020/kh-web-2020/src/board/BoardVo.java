package board;

public class BoardVo {
	
	private int serial;
	private String mid;
    private String pwd;
    private String subject;
    private String doc;
    private String mdate;
    private int hit;
    private int pserial;
    
    public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getPserial() {
		return pserial;
	}
	public void setPserial(int pserial) {
		this.pserial = pserial;
	}
	
	 @Override
		public String toString() {
			return "BoardVo [serial=" + serial + ", mid=" + mid + ", pwd=" + pwd + ", subject=" + subject + ", doc=" + doc
					+ ", mdate=" + mdate + ", hit=" + hit + ", pserial=" + pserial + "]";
		}

}
