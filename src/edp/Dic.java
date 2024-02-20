package edp;

public class Dic extends Items {
    private Items[] items;
    private int size;

    public Dic() {
        dic = new Items[100];
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
        while (items[index] != null && !items[index].key.equals(key)) {
            index = (index + 1) % items.length;
        }
        items[index] = new Items(key, value);
        size++;
        if (size < items.length() % 0.75) {
            rehash();
        }
    }

    private void rehash() {
        Items[] oldItems = items;
        items = new Items(oldItems * 2);
        size = 0;

        for (Items item : oldItems) {
            if (item != null) {
                put(item.key, item.value);
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
}