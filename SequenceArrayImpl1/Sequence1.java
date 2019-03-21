public interface Sequence1<T> {
    /**
     * 向线性表中添加元素
     * @param data 要存储的元素
     */
   public void add(T t);

    /**
     * 线性表中删除元素
     * @param index 要删除的元素下标
     * @return 是否删除成功
     */
    public boolean remove(int index);

    /**
     * 在线性表中查找指定索引的元素
     * @param index 要查找的索引
     * @return
     */
    public  T get(int index);

    /**
     * 判断线性表中是否有指定元素
     * @param data 要查找的元素内容
     * @return
     */
    public boolean contains(T t);

    /**
     * 修改线性表中指定索引的内容
     * @param index 要修改的元素下标
     * @param newData 修改后的内容
     * @return
     */
    public  T set(int index, T t);

    /**
     * 返回当前线性表元素个数
     * @return
     */
    public int size();

    /**
     * 直接清空线性表内容
     */
    public void clear();

    /**
     * 将线性表转为数组
     * @return
     */
    public Object[] toArray();
}
