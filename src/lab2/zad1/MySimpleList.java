package lab2.zad1;

import java.util.Arrays;

import static java.lang.System.*;

/**
 * Created by 7_lol_000 on 2015-11-10.
 */
public class MySimpleList<E> {
    private Object[] list;
    private Integer size = 0;

    public MySimpleList() {
        list = new Object[10];
    }

    MySimpleList(int max) {
        list = new Object[max];
    }

    public E get(int index) {
        if (index < size && index >= 0)
            return ((E) list[index]);
        else throw new ArrayIndexOutOfBoundsException();
    }

    public int getSize() {
        return size;
    }


    public void add(E obj) {
        if (list.length - 1 <= size) {
            increaseListSize();
        }
        list[size] = obj;
        size++;
    }

    public void putOnPosition(E obj, int index) {
        if (index <= size && index >= 0) {
            if (list.length - 1 <= size) {
                increaseListSize();
            }
            size++;
            arraycopy(list, index, list, index + 1, size - index);
            list[index] = obj;
        } else throw new ArrayIndexOutOfBoundsException();
    }

    public void putFirst(E obj){
        putOnPosition(obj,0);
    }

    public void putLast(E obj){
        add(obj);
    }

    public Object remove(int index) {
        if (index < size) {
            Object deletedObject = list[index];
            arraycopy(list, index + 1, list, index, size + 1 - index);
            list[size--] = null;
            return deletedObject;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void remove(E obj) {
        while (getIndexOf(obj) != null)
            remove(getIndexOf(obj));
    }

    public boolean contains(E obj) {
        return getIndexOf(obj) != null;
    }

    public Integer getIndexOf(E obj) {
        for (int i = 0; i < size; i++) {
            if ( get(i).equals(obj)) {
                return i;
            }
        }
        return null;
    }

    public void printAllElements() {
        for (int i = 0; i < size; i++) {
            out.println(get(i));
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0;
    }

    private void increaseListSize() {
        list = Arrays.copyOf(list, (int) (list.length * 1.5 + 1));
    }
}
