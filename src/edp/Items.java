package edp;

public class Items {
    private Object key;
    private Object value;

    public Items(Object inputKey, Object inputValue) {
        key = inputKey;
        value = inputValue;
    }

    public void setKey(Object newKey){
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
}
