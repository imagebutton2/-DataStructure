public class ArrayTest {
	
	public static void main(String[] args) {
		long[] arr;
		arr=new long [100];
		int nElems=0;
		int j;
		long searchkey;
		arr[0]=77;
		arr[1]=99;
		arr[2]=44;
		arr[3]=55;
		arr[4]=22;
		arr[5]=88;
		arr[6]=11;
		arr[7]=00;
		arr[8]=66;
		arr[9]=33;
		nElems=10;
		display(arr, nElems);
		
		searchkey=66;
		for(j=0;j<nElems;j++) {
			if(arr[j]==searchkey) {
				break;
			}
		}
		if(j==nElems)
			System.out.println("找不到"+searchkey);
		else
			System.out.println("找到了"+searchkey);
		
		searchkey=55;
		for(j=0;j<nElems;j++) {
			if(arr[j]==searchkey) {
				break;
			}
		}
		for(int k=j;k<nElems;k++) {
			arr[k]=arr[k+1];
		}
		nElems-=1;
		display(arr, nElems);
		
	}
public  static void display(long[]arr,int nElems) {
	for(int i=0;i<nElems;i++) {
		System.out.println(arr[i]+"");
	}
}
}
