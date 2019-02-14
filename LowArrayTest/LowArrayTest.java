
 public class LowArrayApp{
	 public static void main(String[] args) {
		 LowArray arr;
		 arr=new LowArray(100);
		 int nElems=0;
		 int j;
		 arr.setElem(0,77);
		 arr.setElem(1,99);
		 arr.setElem(2,44);
		 arr.setElem(3,55);
		 arr.setElem(4,22);
		 arr.setElem(5,88);
		 arr.setElem(6,11);
		 arr.setElem(7,00);
		 arr.setElem(8,66);
		 arr.setElem(9,33);
		 nElems=10;
		 for(j=0;j<nElems;j++)
			 System.out.println(arr.getElem(j)+"");
		 System.out.println("");
		 int searchkey=26;
			for(j=0;j<nElems;j++) {
				if(arr.getElem(j)==searchkey) {
					break;
				}
			}
			if(j==nElems)
				System.out.println("�Ҳ���"+searchkey);
			else
				System.out.println("�ҵ���"+searchkey);
			
			searchkey=55;
			for(j=0;j<nElems;j++) {
				if(arr.getElem(j)==searchkey) {
					break;
				}
			}
			for(int k=j;k<nElems;k++) {
				arr.setElem(k, arr.getElem(k+1));
			}
			nElems-=1;
			for(j=0;j<nElems;j++)
				 System.out.println(arr.getElem(j)+"");
			 System.out.println("");
		}
	 
 }
 class LowArray {
	private long []a;
	public LowArray (int size) {
		a=new long[size];
	}
	public  void setElem(int index ,long value) {
		a[index]=value;	
	}
	public long getElem(int index) {
		return a[index];
	}
	
}