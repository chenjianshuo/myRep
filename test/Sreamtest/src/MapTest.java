import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by chenjianshuo on 2017/12/18 10:27.
 */
public class MapTest {
    public static void main(String[] args) {
       a();

    }

    public  static List<Item> a (){
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
        Map sum=items.stream().sorted(Comparator.comparing(Item::getPrice)).collect(Collectors.groupingBy(Item::getName,Collectors.summingInt(Item::getCount)));
        System.out.println(sum);
        return items;
    }
}

 class Item{
    String name;
    Integer count;
    BigDecimal price;

    public Item(String name, Integer count, BigDecimal price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

     @Override
     public String toString() {
         return "Item{" +
                 "name='" + name + '\'' +
                 ", count=" + count +
                 ", price=" + price +
                 '}';
     }
 }