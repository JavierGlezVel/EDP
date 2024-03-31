package edp;

import java.util.Objects;

public class Dic {
    private Items[] items;
    private int size;

    public Dic() {
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

    public void add(Object key, Object value) throws Excepciones.DuplicateKeyException{
        if (containsKey(key)){
            throw new Excepciones.DuplicateKeyException("La clave ya existe en el diccionario");
        }

        int index = hash(key);
        while (items[index] != null) {
            index = (index + 1) % items.length;
        }
        items[index] = new Items(key, value);
        size++;
        if (size > items.length * 0.75) {
            rehash();
        }
    }

    private void rehash() {
        Items[] oldItems = items;
        items = new Items[oldItems.length * 2];
        int oldSize = size;
        size = 0;

        for (int i = 0; i < oldSize; i++) {
            if (oldItems[i] != null) {
                try{
                    add(oldItems[i].getKey(), oldItems[i].getValue());
                } catch (Excepciones.DuplicateKeyException e){
                    throw new RuntimeException("Error encontrado: Clave duplicado durante el rehash", e);
                }
            }
        }
    }

    public void remove(Object key) throws Excepciones.KeyNotFoundException, Excepciones.EmptyDictionaryException{
        if (key == null) {
            return;
        }
        if(size == 0){
            throw new Excepciones.EmptyDictionaryException("El diccionario esta vacio.");
        }

        boolean keyFound = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getKey().equals(key)) {
                items[i] = null;
                size--;
                keyFound = true;
                break;
            }
        }
        if (!keyFound){
            throw new Excepciones.KeyNotFoundException("La clave no se encuentra en el diccionario");
        }
    }

    public void printDic() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.println("Key: " + items[i].getKey() + ", Valor: " + items[i].getValue());
            }
        }
    }

    public boolean containsKey(Object key) {
        for (Items item : items) {
            if (item != null && Objects.equals(item.getKey(), key)) {
                return true;
            }
        }
        return false;
    }
    
    public String getKey(Object key) {
        for (Items item : items) {
            if (item != null && item.getValue().equals(key)) {
                return item.getKey().toString();
            }
        }
        return null;
    }
    
    public String getItem(Object key) {
        for (Items item : items) {
            if (item != null && item.getKey().equals(key)) {
                return item.getValue().toString();
            }
        }
        return null;
    }
    
    
    public int size() {
        return size;
    }
}

