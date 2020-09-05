/*
Задача – сформировать коробку со сладостями. Она может включать в себя разные сладости, у каждой есть название, вес, цена и уникальный параметр.
Найти общий вес подарка, общую стоимость подарка и вывести на консоль информацию о всех сладостях в коробке.

Сущности:
-Базовый абстрактный класс для всех видов сладостей и конкретные сладости, наследующиеся от базового.
-Интерфейс для коробки сладостей с методами: добавить, удалить (по индексу/либо последний) сладость, вывести вес, стоимость коробки, вывести всю информацию обо всех сладостях.
-Конкретные реализации интерфейса коробки. Внутри коробка содержит массив сладостей и работает с ним. Вне коробки массив недоступен.
-(*)Два метода для умной оптимизации подарка, для удаления сладостей с меньшим весом и с меньшей ценой из коробки до тех пор, пока вес\цена коробки не станет меньше входного параметра.
 */

import java.util.ArrayList;

public class CandyBox implements CandyBoxActions {

    public static void main(String[] args) {

        CandyBox candyBox = new CandyBox();
        candyBox.add(new Chocolate());
        candyBox.add(new Marmalade());
        candyBox.add(new Lollipop());
        candyBox.add(new Marmalade());
        candyBox.add(new Chocolate());
        candyBox.remove();
        candyBox.add(new Marmalade());
        candyBox.remove(1);

        System.out.println();
        System.out.println("Коробка сладостей стоит " + candyBox.getPrice() + " руб.");
        System.out.println("Коробка сладостей весит " + candyBox.getWeight() + " гр.");
        System.out.println();

        candyBox.getInfo();

        candyBox.optimizeWeight(301);

        System.out.println();
        System.out.println("Коробка сладостей стоит " + candyBox.getPrice() + " руб.");
        System.out.println("Коробка сладостей весит " + candyBox.getWeight() + " гр.");
        System.out.println();

        candyBox.getInfo();

        candyBox.optimizePrice(139);

        System.out.println();
        System.out.println("Коробка сладостей стоит " + candyBox.getPrice() + " руб.");
        System.out.println("Коробка сладостей весит " + candyBox.getWeight() + " гр.");
        System.out.println();

        candyBox.getInfo();

    }

    private ArrayList<CandyItem> candyItems = new ArrayList<CandyItem>();



    public void add(CandyItem candy) {
        candyItems.add(candy);
        System.out.println(candy.getCandyName() + " добавили в коробку.");
    }

    public void remove() {
        if (candyItems.size() > 0){
            candyItems.remove(candyItems.size()-1);
            System.out.println("Последняя сладость удалена.");
        }
        else {
            System.out.println("Коробка для сладостей и так пуста.");
        }
    }

    public void remove(int index) {
        candyItems.remove(index);
    }

    public int getWeight() {
        int boxWeight = 0;
        for (CandyItem candy : candyItems){
            boxWeight += candy.getWeight();
        }
        return boxWeight;
    }

    public int getPrice() {
        int boxPrice = 0;
        for (CandyItem candy : candyItems){
            boxPrice += candy.getPrice();
        }
        return boxPrice;
    }

    public void getInfo() {
        System.out.println("Коробка со сладостями состоит из: ");
        if (candyItems.size() > 0){
            for (CandyItem candy : candyItems){
                System.out.println(candy.getCandyName() + " стоит " + candy.getPrice() + " руб., весит " + candy.getWeight() + " гр. и содержит " + candy.getKkal() + " ккал.");
            }
        }
        else {
            System.out.println("Пусто.");
        }

    }

    public void optimizeWeight(int maxWeight){
        if (candyItems.size() > 0){
            while (getWeight() > maxWeight){
                candyItems.remove(candyItems.indexOf(getLowWeightCandy()));
            }
        }
        else {
            System.out.println("Коробка пуста!");
        }
    }

    public void optimizePrice(int maxPrice){
        if (candyItems.size() > 0){
            while (getPrice() > maxPrice){
                candyItems.remove(candyItems.indexOf(getLowPriceCandy()));
            }
        }
        else {
            System.out.println("Коробка пуста!");
        }
    }



    public CandyItem getLowWeightCandy(){
        CandyItem lowWeightCandy = candyItems.get(0);
        int minWeight = candyItems.get(0).getWeight();
        for (CandyItem candy : candyItems){
            if (candy.getPrice() < minWeight){
                minWeight = candy.getWeight();
                lowWeightCandy = candy;
            }
        }
        return lowWeightCandy;

    }

    public CandyItem getLowPriceCandy(){
        CandyItem lowPriceCandy = candyItems.get(0);
        int minPrice = lowPriceCandy.getPrice();
        for (CandyItem candy : candyItems){
            if (candy.getPrice() < minPrice){
                minPrice = candy.getPrice();
                lowPriceCandy = candy;
            }
        }
        return lowPriceCandy;
    }
}
