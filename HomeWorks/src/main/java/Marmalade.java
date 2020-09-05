public class Marmalade extends CandyItem {

    private String candyName = "Мармелад";
    private int weight = 50;
    private int price = 30;
    private int kkal = 78;

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
