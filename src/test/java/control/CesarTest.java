package control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import control.Cesar;

public class CesarTest{

    @Test
    public void criptografarTest1(){
        Cesar cripto = new Cesar();
        assertEquals("0000", cripto.criptografar("7777"));
    }

    @Test
    public void criptografarTest2(){
        Cesar cripto = new Cesar();
        assertEquals("1111", cripto.criptografar("8888"));
    }

    @Test
    public void criptografarTest3(){
        Cesar cripto = new Cesar();
        assertEquals("2222", cripto.criptografar("9999"));
    }

    @Test
    public void criptografarTest4(){
        Cesar cripto = new Cesar();
        assertEquals("aaaa", cripto.criptografar("xxxx"));
    }

    @Test
    public void criptografarTest5(){
        Cesar cripto = new Cesar();
        assertEquals("bbbb", cripto.criptografar("yyyy"));
    }

    @Test
    public void criptografarTest6(){
        Cesar cripto = new Cesar();
        assertEquals("cccc", cripto.criptografar("zzzz"));
    }

    @Test
    public void descriptografarTest1(){
        Cesar cripto = new Cesar();
        assertEquals("7777", cripto.descriptografar("0000"));
    }

    @Test
    public void descriptografarTest2(){
        Cesar cripto = new Cesar();
        assertEquals("8888", cripto.descriptografar("1111"));
    }

    @Test
    public void descriptografarTest3(){
        Cesar cripto = new Cesar();
        assertEquals("9999", cripto.descriptografar("2222"));
    }

    @Test
    public void descriptografarTest4(){
        Cesar cripto = new Cesar();
        assertEquals("xxxx", cripto.descriptografar("aaaa"));
    }

    @Test
    public void descriptografarTest5(){
        Cesar cripto = new Cesar();
        assertEquals("yyyy", cripto.descriptografar("bbbb"));
    }

    @Test
    public void descriptografarTest6(){
        Cesar cripto = new Cesar();
        assertEquals("zzzz", cripto.descriptografar("cccc"));
    }
}