package edp;

private static abstract class Items {
    private Object key;
    private Object value;

    public Items(String inputKey, Object inputValue) {
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