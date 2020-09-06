/**
 * @author nanbeiyang
 * @version FildHasNo.java, v 0.1 2020/9/4 3:25 下午  Exp $$
 * @name
 */
public class FildHasNo {


    public static void main(String[] args) {
        Father gay = new Son(1);
        System.out.println("This. gay has $" + gay.money);
    }
}

class Father {
    public int money = 1;
    public int moneyA = 1;

    public Father() {
        money = 2;
        showMeTheMoney();
    }

    public void showMeTheMoney() {
        System.out.println("I am Father, i have $" + money);
    }

}

class Son  extends Father {
    public int money = 3;
    public  Son(int a) {
        money = 4;
        showMeTheMoney();
    }

    @Override
    public void showMeTheMoney() {
        System.out.println("I am Son, i have $" + money);
    }

}
