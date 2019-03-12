//Ï£¶ûÅÅĞò
public class Sort {
    
public  static void shellSort(int []array){
        int n=array.length;
        if(n<=1){
            return;

        }else {
            int step=n/2;
            while (step>=1){
                for(int i=step;i<n;i++){
                    int value=array[i];
                    int j=i-step;
                    for(;j>=0;j-=step){
                        if(value<array[j]){
                            array[j+step]=array[j];
                        }
                        else {
                            break;
                        }
                    }
                    array[j+step]=value;
                }
                step /= 2;
            }
        }
    }
 
}