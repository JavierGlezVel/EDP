package edp;

public class Dic extends Items {
    private Items[] items;
    private static final int size = items.length();

    public Dic() {
        dic = new Items[size];
        for (int i = 0; i < size; i++){
            dic[i] = null;
        }
    }

    public void remove(Object key) {
        if (key == null){
            return;
        }

        for (int i = 0; i < size; i++) {
            if (items[i].getKey() == key) {
                items[i] = items[size - 1];
                size--;
                break;
            }
        }
    }

    public void add(Object )
    
    
}