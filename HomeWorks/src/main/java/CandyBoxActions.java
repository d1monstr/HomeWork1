public interface CandyBoxActions {
    void add(CandyItem candy);
    void remove();
    void remove(int index);
    int getWeight();
    int getPrice();
    void getInfo();
}
