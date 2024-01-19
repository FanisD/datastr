/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datastructures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.logging.Logger;

/**
 *
 * @author fanis
 */
public class SubDS<E> implements DeQueue<E>{
    
    public static final int INITIAL_CAPACITY = 2;
    
    private Deque<E> deque;
    private E[] array;
    int f = 0;
    int r = 0;
    int size;

    public SubDS() {
        this.deque = new ArrayDeque<E>();
        this.array = (E[]) new Object[INITIAL_CAPACITY];
        this.size = array.length;
    }

    @Override
    public void pushFirst(E b) {
        if (f==0){
           f = (array.length-1);
           array[f] = b;
        }else{
            array[f-1]=b;
            f-=1;         
        } 
        if (f==r){
            array=resize();
        }
        System.out.println(f);
    }

    @Override
    public void pushLast(E b) {
        array[r]=b;
        r = (r+1)%array.length;
        System.out.println(r);
        if (f==r){
            array=resize();
        }
    }
    
    @Override
    public E popFirst() {
        E a = null;
        if (!isEmpty()){
            a = array[f];
            array[f]=null;
            f+=1;
            if (f==array.length){
                f=0;         
            }
            System.out.println(f);
            if (size()==array.length/4){
                array=desize();
            }
        }
        return a;
    }

    @Override
    public E popLast() {
        E a = null;
        if (!isEmpty()){
            r-=1;
            a = array[r];
            array[r]=null;    
        }
    
        if (size()==array.length/4){
            array=desize();
        }
        return a;
    }

    @Override
    public E first() {
        return array[f];
    }

    @Override
    public E last() {
        return array[r-1];
    }

    @Override
    public boolean isEmpty() {
        if (f == r) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int size() {
        if (f > r ) {
            return (r + array.length - f);
        }else{
            return (r - f);
        }
    }

    @Override
    public void clear() {
        this.array = (E[]) new Object[INITIAL_CAPACITY];
        f = 0;
        r = 0;
    }

    private void makeDeque(){
        deque.clear();
        for(int i = f; i < f+size(); i++){
            deque.add(array[i%array.length]);
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        
        makeDeque();
        Iterator<E> it = deque.iterator();
         System.out.println("iterator");
        while(it.hasNext()) {
           
            System.out.println(it.next());
        }
        return it;
        
    }

    @Override
    public Iterator<E> descendingIterator() {
        
        makeDeque();
        Iterator<E> descendingIterator = deque.descendingIterator();
        System.out.println("DISSiterator");
        while(descendingIterator.hasNext()){
             System.out.println(descendingIterator.next());
        }
        return descendingIterator;
        
    }
     
    private E[] resize(){
        
        E[] tmp = (E[]) new Object[2*array.length];
        for(int i=f;i<(f+array.length);i++){
            tmp[i]=array[i%array.length];
        }
        r = f+array.length;
        System.out.println(Arrays.toString(tmp));    
        System.out.println(r);
        return tmp;
    }
    /*private E[] resize(){
        
        E[] tmp = (E[]) new Object[2*array.length];
        int j = 0;
        for(int i=f;i<(f+array.length);i++){
            tmp[i]=this.array[i%array.length];
        }
        r = f+size();
        System.out.println(Arrays.toString(tmp));    
        System.out.println(r);
        return tmp;
        
    }*/
    
    private E[] desize(){
        
        E[] tmp = (E[]) new Object[array.length/2];
        int j = 0;
        for(int i = f; i < (f+array.length); i++){
            tmp[i%tmp.length] = this.array[i%array.length];
        }
        /*if (f>r){
            for (int i = f; i < array.length; i++) {
                tmp[j]=array[i];
                j+=1;
            }
            for (int i = 0; i < r ; i++ ) {
                tmp[j]=array[i];
                j+=1;
            }
        }else{
            for (int i=f;i<r;i++){
                tmp[j]=array[i];
                j+=1;
            }
        }*/
        f = f%tmp.length;
        r=j;
        System.out.println(Arrays.toString(tmp));
        return tmp;
    }
    
}
