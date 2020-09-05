public class Chocolate extends CandyItem {

    private String candyName = "Плитка шоколада";
    private int weight = 200;
    private int price = 80;
    private int kkal = 356;

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
