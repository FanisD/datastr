/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.datastructures.DeQueue;
import com.mycompany.datastructures.SubDS;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author fanis
 */
public class DeQueueTest {
    
    @Test
    public void testDeQueue() {
        DeQueue<Integer> q = new SubDS<>();
        assertTrue(q.isEmpty());
        int count = 100000;
        for (int i = 0; i < count; i++) {
        q.pushFirst(i);
        assertTrue(q.size() == i + 1);
        assertTrue(q.first() == 0);
        }
        int current = 0;
        while (!q.isEmpty()) {
        assertTrue(q.first() == current);
        assertTrue(q.popFirst() == current);
        current++;
        }
        assertTrue(q.isEmpty());
    }
    
}
