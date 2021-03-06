package bean;

public class Page {
	// tot -> total
	int totListSize;
	int totPage;
	int startPage;
	int endPage;
	int startNo;
	int endNo;
	int nowPage;
	int listSize = 12;
	int blockSize = 5;
	
	String findStr;

	public Page() {
		
	}
	
	public Page(int tot, int now) {
		this.totListSize = tot;
		this.nowPage = now;
		pageCompute();
	}
	
	public void pageCompute() { // totListSize, nowPage가 기준이 된다.
		totPage = (int)Math.ceil(totListSize / (double)listSize);
		endNo = nowPage * listSize;
		startNo = endNo - listSize + 1;
		
		// 보정작업
		if(endNo > totListSize) {
			endNo = totListSize;
		}
		
		endPage = (int)(Math.ceil(nowPage/(double)blockSize))*blockSize;
		startPage = endPage-blockSize+1;
	
		// 보정작업
		if(endPage > totPage) { 
			endPage = totPage;
		}
		
	}
	
	public int getTotListSize() {
		return totListSize;
	}

	public void setTotListSize(int totListSize) {
		this.totListSize = totListSize;
	}

	public int getTotPage() {
		return totPage;
	}

	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartNo() {
		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getEndNo() {
		return endNo;
	}

	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public String getFindStr() {
		return findStr;
	}

	public void setFindStr(String findStr) {
		this.findStr = findStr;
	}
	
}
