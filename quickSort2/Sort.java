//快速排序
//当待排序的数组中重复元素过多导致分组造成的左右两个区间严重不均衡状态,造成分层趋向于O(n)层导致快排退化为O(n^2)
//双路快排:将重复元素交换位置来实现左右两个数组都有元素，避免分组不均衡的情况发生。

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