//基于双向链表的线性表

public interface Sequence {
    /**
     * 向线性表中添加元素
     * @param data 要存储的元素
     */
    void add(Object data);

    /**
     * 线性表中删除元素
     * @param index 要删除的元素下标
     * @return 是否删除成功
     */
    boolean remove(int index);

    /**
     * 在线性表中查找指定索引的元素
     * @param index 要查找的索引
     * @return
     */
    Object get(int index);

    /**
     * 判断线性表中是否有指定元素
     * @param data 要查找的元素内容
     * @return
     */
    boolean contains(Object data);

    /**
     * 修改线性表中指定索引的内容
     * @param index 要修改的元素下标
     * @param newData 修改后的内容
     * @return
     */
    Object set(int index, Object newData);

    /**
     * 返回当前线性表元素个数
     * @return
     */
    int size();

    /**
     * 直接清空线性表内容
     */
    void clear();

    /**
     * 将线性表转为数组
     * @return
     */
    Object[] toArray();
}



public class DoubleLinkedImpl implements Sequence{
    private Node head;
    private Node tail;
    private  int size;

    private class Node{
        private Node prev;
        private Object data;

        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    //尾插法
    @Override
    public void add(Object data) {
        Node newNode=new Node(tail,data,null);
        if(head==null){
            head=newNode;
        }else {
            tail.next=newNode;
        }
        tail=newNode;
    }

    @Override
    public boolean remove(int index) {
        rangeCheck(index);
        Node node = node(index);
        Node prev=node.prev;
        Node next=node.next;
      if(prev==null){
          head=node.next;


      }//存在前驱节点
      else {
            prev.next=next;
            node.prev=null;
      }if(next==null){
          tail=node.prev;
        }//存在后驱节点
        else {
            next.prev=prev;
          node.next=null;


        }
        size--;
      return true;
    }

    @Override
    public Object get(int index) {
        return node(index).data;
    }

    @Override
    public boolean contains(Object data) {
        Object[] datas=toArray();
        if(data==null){
            for (int i=0;i<datas.length;i++){
                if(datas[i]==null)
                    return true;
            }
        }else {
            for (int i=0;i<datas.length;i++){
                if (data.equals(datas[i])){
                    return true;
                }

            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        rangeCheck(index);
        Node node = node(index);
        Object oldData=node.data;
        node.data = newData;
        return oldData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for(Node temp=head;temp!=null;){
        Node  next=temp.next;
        temp.prev=temp.next=null;
        temp.data=null;
        temp=next;
        size--;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] data = new Object[size];
        int i=0;
      for ( Node temp=head;temp!=null;temp=temp.next){
        data[i++]=temp.data;
      }
        return data;
    }
    private void rangeCheck(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Illengal Index!");
        }
    }
    //找到当前节点
    private  Node node(int index){
        //此时要查找的结点在中间位置左边
       if(index<(size>>1)){
           Node temp=head;
           for (int i=0;i<index;i++){
               temp=temp.next;
           }
           return temp;
       }else {
           Node temp=tail;
           for (int i=size-1;i>index;i--){
                tail = tail.prev;
           }
           return temp;
       }

    }
}
