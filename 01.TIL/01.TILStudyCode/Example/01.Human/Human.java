  public class Human {
    private String name;
    private int height;
    private int weight;

    //작성
    public Human(String name, int height, int weight) {
      this.name = name;
      this.height = height;
      this.weight = weight;
    }


    public String getName() {
      return name;
    }

    public int getheight() {
      return height;
    }

    public int getWeight() {
      return weight;
    }



    //
    void gainWeight(int w) {
      weight += w;
    }

    void reduceWeigth(int w) {
      weight -= w;
    }
  }
