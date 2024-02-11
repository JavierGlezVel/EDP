package edp;

public abstract class Items {
    private String key;
    private Object value;

    //Tenemos que revisar esto, ya que el hecho de que solo podamos almacenar Strings y ints no está bien, pero por algo podemos empezar.

    public Items(String inputKey, Object inputValue) {
        key = inputKey;
        value = inputValue;
    }

    public void setKey(String newKey){
        key = newKey;
    }

    public String getKey() {
        return key;
    }

    public void setValue(Object newValue) {
        value = newValue;
    }

    public Object getValue() {
        return value;
    }

    public abstract void printDic();
}