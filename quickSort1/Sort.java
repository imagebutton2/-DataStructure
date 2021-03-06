//快速排序  随机选取一个基准值来避免分组造成的左右两个区间严重不均衡状态,造成分层趋向于O(n)层导致快排退化为O(n^2)


public class Sort {
 private static void quickSort(int[] array) {
        int n = array.length;
        if (n<=1)
            return;
        quickInternal(array,0,n-1);
    }

    private static void quickInternal(int[] array, int l, int r) {
        if(l>=r)
            return;
        else {
            int q = partition(array, l, r);
            quickInternal(array,l,q-1);
            quickInternal(array,q+1,r);
        }
    }
 
    private static int partition(int[] array, int l, int r) {
        int randomIndex =(int) (Math.random()*(r-l+1)+l);
        swap(array,l,randomIndex);
        int j = l;
        int i = l + 1;
        int v = array[j];
        for(;i<=r;i++){
            if(array[i]<v){
                swap(array,j+1,i);
                j++;
            }

        }
        swap(array,l,j);
        return j;
    }

    private static void swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }
}