//��������
//����������������ظ�Ԫ�ع��ർ�·�����ɵ����������������ز�����״̬,��ɷֲ�������O(n)�㵼�¿����˻�ΪO(n^2)
//˫·����:���ظ�Ԫ�ؽ���λ����ʵ�������������鶼��Ԫ�أ�������鲻��������������

public class Sort {
  private static void quickSort(int []array){
        int n = array.length;
        if(n<=1){
            return;
        }else {
            quickInternal(array,0,n-1);
        }

    }

    private static void quickInternal(int []array,int l,int r) {
        if(l>=r){
            return;
        }
        int q = partition(array,l,r);
        quickInternal(array,l,q-1);
        quickInternal(array,q+1,r);
    }
    private static int partition(int []array,int l,int r){
        int randomIndex = (int)(Math.random()*(r-l+1)+l);
        swap(array,l,randomIndex);
        int v = array[l];
        int i = l + 1;
        int j = r;
        while (true){
            while (i<=r&&array[i]<v){
                i++;
            }  while (j>=l+1&&array[j]>v){
                j--;
            }
            if(i>j){
                break;
            }
            swap(array,i,j);
            i++;
            j--;

        }
        swap(array,l,j);
        return j;
    }
    private static void swap(int []array,int indexA,int indexB){
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }
}