package edp;

import edp.Excepciones.IndexOutOfRangeException;

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
        while (items[index] != null && !items[index].getKey().equals(key)) {
            index = (index + 1) % items.length;
        }
        items[index] = new Items(key, value);
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
                try{
                    add(item.getKey(), item.getValue());
                } catch (Excepciones.DuplicateKeyException e){
                    System.out.println("Error encontrado: Clave duplicado durante el rehash");
                }
            }
        }
    }

    //Mirar de nuevo este metodo.
    public void remove(Object key) throws Excepciones.KeyNotFoundException, Excepciones.EmptyDictionaryException{
        if (key == null) {
            return;
        }
        if(size == 0){
            throw new Excepciones.EmptyDictionaryException("El diccionario esta vacio.");
        }

        boolean keyFound = false;
        for (int i = 0; i < size; i++) {
            if (items[i].getKey().equals(key)) {
                items[i] = items[size - 1];
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
        try{
            for (int i = 0; i < size; i++) {
                if (items[i] == null){
                    throw new Excepciones.IndexOutOfRangeException("El elemento " + i + " es nulo.");
                }
                System.out.println("Key: " + items[i].getKey() + ", Valor: " + items[i].getValue());
            }
        } catch (Excepciones.IndexOutOfRangeException e){
            System.out.println("El error es: " + e.getMessage());
        }
    }

    public boolean containsKey(Object key) {
        for (int i = 0; i < size; i++) {
            if (items[i] != null && items[i].getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

}
