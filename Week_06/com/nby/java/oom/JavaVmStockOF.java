package oom;

/**
 * @author nanbeiyang
 * @version JavaVmStockOF.java, v 0.1 2020/8/12 6:32 下午  Exp $$
 * @name
 */
public class JavaVmStockOF {
    private int stackLength = 1;
    public void stackLeak() {
        stackLength ++;
        stackLeak();
    }

    public static void main(String[] args) {
        int a = 1;
//        int b
//        Arrays.copyOfRange()
//        JavaVmStockOF stockOF = new JavaVmStockOF();
//        try {
//             stockOF.stackLeak();
//        } catch (Exception e) {
//            System.out.println("length ;" + stockOF.stackLength);
//            throw e;
//        }

        String str1 = new StringBuilder("计算器").append("软件").toString();
        System.out.println(str1.intern() == str1);
        System.out.println("计算器软件" == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}