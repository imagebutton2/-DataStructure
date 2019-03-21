
//线性表基于泛型<T>的动态数组

import java.util.Arrays;

public class SequenceArrayImpl1<T>implements Sequence1 <T>{
    private  T[] elementData;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE=Integer.MAX_VALUE-8;
    private int size=0;

    public SequenceArrayImpl1() {
        this.elementData = (T[])new Object[DEFAULT_CAPACITY];
    }

    @Override
    public  void add(T t) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = t;
    }
    private void ensureCapacityInternal(int minCap){
            if(minCap-elementData.length>0){
                grow(minCap);
            }
    }
    private  void grow(int minCap){
        int oldCap = elementData.length;
        int newCap = oldCap << 1;
        if(newCap-minCap<0){
            newCap = minCap;
        }
        if(newCap-MAX_ARRAY_SIZE>0){
            throw new ArrayIndexOutOfBoundsException("超过数组最⼤阈值");
        }
        elementData = Arrays.copyOf(elementData, newCap);
    }
    private  boolean rangCheck(int index){
        if(index>=size){
            System.out.println("数组下标越界");
            return false;
        }
        return true;
    }
    @Override
    public boolean remove(int index) {
        if(rangCheck(index)){
            int moveIndex = size - index - 1;
            if(moveIndex>=0){
                System.arraycopy(elementData,index+1,elementData,index,moveIndex);
                elementData[size--]=null;
                return true;
            }

        }
        return false;
    }

    @Override
    public  T get(int index) {
        if(rangCheck(index)){
            return elementData[index];
        }
        return null;
    }

    @Override
    public  boolean contains(T t) {
        if(t==null){
            for(int i=0;i<elementData.length;i++){
                if(elementData[i]==null){
                    return true;
                }
            }

        }else {

                for(int i=0;i<elementData.length;i++){
                    if(t.equals(elementData[i])){
                        return true;
                    }

                }
        }
        return false;
    }

    @Override
    public  T set(int index, T t) {
        if(rangCheck(index)){
            T oldData=get(index);
            elementData[index] = t;
            return oldData;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size=0;
        elementData=(T[])new Object[DEFAULT_CAPACITY];

    }

    @Override
    public Object[] toArray() {

        return  Arrays.copyOf(elementData,size);
    }
}
