//’€∞Î≤Â»Î≈≈–Ú
public class Sort {
    
public  static void binaryInsertSort(int []array){
            int n=array.length;
            if(n<=1){
                return;
            }else {
                for(int i=1;i<n;i++){
                    int j=i-1;
                    int h=0;
                    int t=i-1;
                    int value=array[i];
                   while (h<=t){
                       int mid=(h+t)/2;
                       if(array[mid]>value){
                           t=mid-1;
                       }else {
                           h=mid+1;
                       }

                   }
                   for (;j>=t;j--){
                       if(array[j]>value){
                           array[j+1]=array[j];
                       }else {
                           break;
                       }
                   }
                    array[j+1]=value;

                    }
                }
            }
            
 
}