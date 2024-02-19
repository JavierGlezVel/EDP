package edp;

public class Dic extends Items {
    private Items[] items;
    private int size;

    public void remove(Object key) {
        for(int i=0; i<size; i++) {
            if(items[i].getKey() == key) {
                items[i] = items[size - 1];
                size--;
            }
        }
    }
    
    
}