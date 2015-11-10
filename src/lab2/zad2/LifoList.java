package lab2.zad2;

import lab2.zad1.MySimpleList;

/**
 * Created by 7_lol_000 on 2015-11-10.
 */
public class LifoList<E> implements AbstractList{
    MySimpleList<E> list;
    LifoList(){
        list =new MySimpleList<>();
    }
    @Override
    public E getElement() {
        return ((E)list.remove(list.getSize()-1));
    }

    @Override
    public Integer getSize() {
        return list.getSize();
    }


    @Override
    public void putElement(Object obj) {
        list.putLast((E) obj);
    }
}
