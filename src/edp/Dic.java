package edp;

public class Dic extends Items {
    private Items[] items
    private int size;

    public Dic(Object inputValue, Object inputKey) {
        super(inputValue, inputKey);
        items = new Items[100];
        size = 0;
    }

    private int hash(Object key) {
        int hash = 0;
        if (key != null) {
            String strKey = key.toString();
            for (int i = 0; i < strKey.length(); i++) {
                hash = hash * 31 + strKey.charAt(i);
            }
        }
        return Math.abs(hash % items.length);
    }

    public void add(Object key, Object value) {
        int index = hash(key);
        while (items[index] != null && !items[index].getKey().equals(key)) {
            index = (index + 1) % items.length;
        }
        items[index] = new Dic(key, value);
        size++;
        if (size < items.length % 0.75) {
            rehash();
        }
    }

    private void rehash() {
        Items[] oldItems = items;
        items = new Items[oldItems.length * 2];
        size = 0;

        for (Items item : oldItems) {
            if (item != null) {
                add(item.getKey(), item.getValue());
            }
        }
    }

    //Mirar de nuevo este metodo.
    public void remove(Object key) {
        if (key == null) {
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

    public void printDic() {
        for (int i = 0; i < size; i++) {
            System.out.println("Key: " + items[i].getKey() + ", Valor: " + items[i].getValue());
        }
    }

    public boolean containsKey(Object key) {
        for (int i = 0; i < size; i++) {
            if (items[i].getKey() == key) {
                return true;
            }
        }
        return false;
    }

    
}
