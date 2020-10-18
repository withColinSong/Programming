package Day1010;

public class PairOfDice {
	int dice;
	int faceValue1;
	int faceValue2;
	
	public PairOfDice() {
		faceValue1 = 1;
		faceValue2 = 1;
	}
	
	public void roll() {
		faceValue1 = (int)(Math.random()*6)+1;
		faceValue2 = (int)(Math.random()*6)+1;
	}
	
	public int getFaceValue1() {
		return faceValue1;
	}
	
	public int getFaceValue2() {
		return faceValue2;
	}
}
