package edp;
import edp.Dic;

public class App {
    public static void main(String[] args) throws Exception {
        Dic dic = new Dic();

        dic.add("Nombre", "wafa");
        dic.add("Color", "azul");
        dic.add("hola", "adios");

        dic.printDic();
                

    }
}
