//����˫����������Ա�

public interface Sequence {
    /**
     * �����Ա������Ԫ��
     * @param data Ҫ�洢��Ԫ��
     */
    void add(Object data);

    /**
     * ���Ա���ɾ��Ԫ��
     * @param index Ҫɾ����Ԫ���±�
     * @return �Ƿ�ɾ���ɹ�
     */
    boolean remove(int index);

    /**
     * �����Ա��в���ָ��������Ԫ��
     * @param index Ҫ���ҵ�����
     * @return
     */
    Object get(int index);

    /**
     * �ж����Ա����Ƿ���ָ��Ԫ��
     * @param data Ҫ���ҵ�Ԫ������
     * @return
     */
    boolean contains(Object data);

    /**
     * �޸����Ա���ָ������������
     * @param index Ҫ�޸ĵ�Ԫ���±�
     * @param newData �޸ĺ������
     * @return
     */
    Object set(int index, Object newData);

    /**
     * ���ص�ǰ���Ա�Ԫ�ظ���
     * @return
     */
    int size();

    /**
     * ֱ��������Ա�����
     */
    void clear();

    /**
     * �����Ա�תΪ����
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

    //β�巨
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


      }//����ǰ���ڵ�
      else {
            prev.next=next;
            node.prev=null;
      }if(next==null){
          tail=node.prev;
        }//���ں����ڵ�
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
    //�ҵ���ǰ�ڵ�
    private  Node node(int index){
        //��ʱҪ���ҵĽ�����м�λ�����
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
