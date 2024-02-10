public abstract class Items {
    private int key;
    private String value;

    //Tenemos que revisar esto, ya que el hecho de que solo podamos almacenar Strings y ints no está bien, pero por algo podemos empezar.

    public Items(int inputKey, String inputValue) {
        key = inputKey;
        value = inputValue;
    }

    public void setKey(int newKey){
        key = newKey;
    }

    public int getKey() {
        return key;
    }

    public void setValue(String newValue) {
        value = newValue;
    }

    public String getValue() {
        return value;
    }

    public abstract void printDic();
}