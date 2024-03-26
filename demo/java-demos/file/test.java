import java.io.File;

public class test {

    public static void main(String[] args) {
        if (!new File("test").exists()) {// 判断目录是否存在
            new File("test").mkdir();
            String fs = System.getProperties().getProperty("file.separator");
            System.out.println(fs);
        }
    }
}
