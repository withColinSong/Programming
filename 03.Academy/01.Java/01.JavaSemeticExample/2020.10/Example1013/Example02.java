package Day15;

class Sample2 {
    public static void main(String[] args)
    {
        iVehicle[] ivc;
        ivc = new iVehicle[2];
        
        ivc[0] = new Car1(1234, 20.5);
        ivc[1] = new Plane1(232);
        
        for(int i=0; i<ivc.length; i++) {
        	ivc[i].show();
        }
    }
}
