package com.example.android.brushalgorithm;

import android.util.Log;
import android.util.Xml;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    public int X = -120;
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        test(-120);
    }

    public int test(int x){
        int xxx = 0;
        String A = Integer.toString(x);
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (i != A.length()){
                strings.add(A.substring(i, i + 1));
            }else {
                strings.add(A.substring(i, i));
            }
        }
        for (int i = 0; i < strings.size(); i++) {
            Log.i("ajkdhasjfh","strings" + strings.get(i));
        }

        return xxx;
    }
}