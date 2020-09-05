public class Lollipop extends CandyItem {

    private String candyName = "Леденец";
    private int weight = 16;
    private int price = 21;
    private int kkal = 55;

    @Override
    public String getCandyName() {
        return candyName;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getKkal() {
        return kkal;
    }
}
