package Test_Pro;

public class Goods implements Comparable {
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Test_Pro.Goods) {
            Test_Pro.Goods goods = (Test_Pro.Goods) o;
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else {
//                return 0;
                // 返回价格从低到高，然后名称从低到高
                return this.name.compareTo(goods.name);
            }
//                方式二
//                Double.compare(this.price, goods.price);
        }
        throw new RuntimeException("传入的数据类型不一致！");
    }
}
