
//线性表基于数组的
public class SequenceArrayImpl implements Sequence {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE=Integer.MAX_VALUE-8;
    private int size=0;
    private Object[] elementData=new Object[DEFAULT_CAPACITY];

    /**
     * 向线性表中添加元素
     * @param data 要存储的元素
     */
    @Override
    //默认的数组没有满，就加在默认数组里面
    public void add(Object data) {
        ensureCapacity(size+1);
        elementData[size++] = data;

    }
    private void ensureCapacity(int minCap){
     if(minCap-elementData.length>0){
         grow(minCap);
     }
    }
    private void grow(int minCap){
        int oldCap = elementData.length;
        int newCap=oldCap<<1;
        if(newCap-minCap<0){
            newCap=minCap;
        }
        if(newCap-MAX_ARRAY_SIZE>0){
            throw new ArrayIndexOutOfBoundsException("超过数组最⼤阈值");
        }
        elementData = Arrays.copyOf(elementData, newCap);


    }
    //写一个函数判断下标是否存在
    private boolean rangCheck(int index) {
        if(index>=size){
            System.out.println("数组下标越界");
            return false;
        }
        return true;
    }
    /**
     * 线性表中删除元素
     * @param index 要删除的元素下标
     * @return 是否删除成功
     */
    @Override
    public boolean remove(int index) {
       if(rangCheck(index)){
           int moveSize=size-index-1;
           if(moveSize>=0){
               System.arraycopy(elementData,index+1,elementData,index,moveSize);
               elementData[--size]=null;
               return true;
           }
       }

        return false;
    }

    @Override
    public Object get(int index) {
        if(rangCheck(index)){
            return elementData[index];
        }
        return null;
    }

    @Override
    public boolean contains(Object data) {
        if(data==null){
           for (int i=0;i<elementData.length;i++){
               if(elementData[i]==null)
                   return true;
           }
        }else {
            for (int i=0;i<elementData.length;i++){
                if(data.equals(elementData[i])){
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        if(rangCheck(index)){
            Object oldData=elementData[index];
            elementData[index] = newData;
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

        Object []temp=new Object[DEFAULT_CAPACITY];
        size=0;
        elementData=temp;
    }

    @Override
    public Object[] toArray() {

        return Arrays.copyOf(elementData,size);
    }
}
