package edp;

private static abstract class Items {
    private Object key;
    private Object value;
    private int hashCode;
    private int next;

    //Tenemos que revisar esto, ya que el hecho de que solo podamos almacenar Strings y ints no está bien, pero por algo podemos empezar.

    public Items(String inputKey, Object inputValue, int inputHashCode, int inputNext) {
        key = inputKey;
        value = inputValue;
    }

    public void setKey(String newKey){
        key = newKey;
    }

    public Object getKey() {
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