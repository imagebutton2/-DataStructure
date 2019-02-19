import git.classDataArrayTest.classDataArray.Person;

public class classDataArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxSize=100;
		classDataArray arr;
		arr=new classDataArray(maxSize);
		arr.insert("Eva","Pat", 24);
		arr.insert("Smi", "Lor", 37);
		arr.insert("Yee", "Tom", 43);
		arr.displayA();
		String searchKey="Smi";
		Person found;
		found=arr.find(searchKey);
		if(found!=null) {
			System.out.println("Found"+searchKey);
			found.displayPerson();
		}			
		else {
			System.out.println("Can't find"+searchKey);
		}
		System.out.println("deleting Smi");
		arr.delete(searchKey);
		arr.displayA();
		
	}

}
