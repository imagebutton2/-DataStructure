//—°‘Ò≈≈–Ú
public class Sort {
    
public  static void selectionSort(int []array){
         int n=array.length;
         if(n<=1){
             return;
         }else {
             for(int i=0;i<n-1;++i){
                 int minIndex=i;
                 for(int j=i+1;j<n;++j){
                     if(array[j]<array[minIndex]){
                         minIndex=j;
                     }
                 }
                 int temp=array[i];
                 array[i]=array[minIndex];
                 array[minIndex] = temp;

             }
         }
    }
 
}