package edp;

import org.junit.Before;
import org.junit.Test; 
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class TestApp {
    private Dic dic;

    @Before
    public void setUp() {
        dic = new Dic();
    }

    @Test
    public void testTamaño() {
        try {
            dic.add("Nombre", "Wafa");
            dic.add("Color", "Azul");
            dic.add("Edad", "30");
        } catch (Excepciones.DuplicateKeyException e) {
            e.printStackTrace();
        }

        assertEquals(3, dic.size());
    }

    @Test
    public void testComprobacion(){
        try{
            dic.add("Nombre", "Pepito");
        } catch(Excepciones.DuplicateKeyException e){
            e.printStackTrace();
        }

        assertEquals(true, dic.containsKey("Nombre"));
    }

    @Test
    public void testAdd() {
        try {
            dic.add("Nombre", "Wafa");
            dic.add("Color", "Azul");
            dic.add("Edad", "30");
        } catch (Excepciones.DuplicateKeyException e) {
            e.printStackTrace();
        }

        assertNotEquals(5, dic.size());
        assertEquals(true, dic.containsKey("Nombre"));
        assertEquals(true, dic.containsKey("Color"));
        assertEquals(true, dic.containsKey("Edad"));

        assertEquals("Nombre", dic.getKey("Wafa"));
        assertEquals("Color", dic.getKey("Azul"));
        assertEquals("Edad", dic.getKey("30"));
    }

    @Test
    public void testRemove() {
        try {
            dic.add("Nombre", "Wafa");
            dic.add("Color", "Azul");
            dic.add("Edad", "30");
        } catch (Excepciones.DuplicateKeyException e) {
            e.printStackTrace();
        }

        assertEquals(3, dic.size());
        assertEquals(true, dic.containsKey("Nombre"));
        assertEquals(true, dic.containsKey("Color"));
        assertEquals(true, dic.containsKey("Edad"));

        try {
            dic.remove("Edad");
        } catch (Excepciones.EmptyDictionaryException e) {
            e.printStackTrace();
        } catch (Excepciones.KeyNotFoundException e) {
            e.printStackTrace();
        }

        assertNotEquals(3, dic.size());
        assertEquals(false, dic.containsKey("Edad"));
    }
}
