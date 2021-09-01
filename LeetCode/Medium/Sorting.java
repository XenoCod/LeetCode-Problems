import java.util.ArrayList;

public class Sorting {
	
	
	//Swap function
	private void swap(int nums[], int a, int b) {
		int temp=nums[a];
		nums[a]=nums[b];
		nums[b]=temp;
	}
	
	//Bubble Sort
	void bubbleSort (int arr[])
	{
	int n=arr.length;
	   for (int i = 0; i < n - 1; ++i)
	   { 
	      boolean swapped = false;
	      for (int j = 0; j < n - i - 1; ++j)
	      {
	         if (arr[j] > arr[j+1]) //check if adjacent element is
	                      //not in order
	         {
	            swap(arr,j, j + 1);
	            swapped = true;
	         }
	      }
	      // Value at n-i-1 will be maximum of all the values below this index.

	      if(!swapped)
	         break;
	   } 
	   
	   for(int i:arr) System.out.print(i+" ");
	} 
	
	
	
	//SelectionSort
	void selectionSort(int nums[]) {
		int n=nums.length;
		for(int i=0; i<n - 1;i++) {
			int min_index=i;
			for(int j=i+1;j<n;j++) {
				if(nums[j] < nums[min_index]) {
					swap(nums, min_index, j);
				}
			}
		}
		for(int i:nums) System.out.print(i+" ");
	}
	
	//Insertion Sort
	void insertionSort(int nums[]) {
		int n=nums.length;
		for(int i=1;i<n;i++) {
			int key=nums[i];
			int j=i-1;
			while(j>=0 && nums[j]>key) {
				nums[j+1]=nums[j];
				j--;
			}
			nums[j+1]=key;
		}
		
		for(int i:nums) System.out.print(i+" ");
	}
	
	//Merge Sort
	void mergesort(int nums[] ) {
		int l=0, r=nums.length-1;
		mergeSort(nums, l, r);
		for(int i:nums) System.out.print(i+" ");
	}
	
	void mergeSort(int nums[], int l, int r) {
		if(r > l) {
			int mid= l + (r - l)/2;
			mergeSort(nums, l, mid);//First half
			mergeSort(nums, mid+1, r);//Second half
			merge(nums, l, mid, r);
		}
	}
	
	void merge(int nums[], int low, int mid, int high) {
		int n1=mid - low +1;
		int n2=high- mid;
		int left[]= new int [n1];
		int right[]= new int [n2];
		for(int i=0; i<n1;i++) left[i]=nums[low + i];//Filling the left array
		for(int i=0; i<n2;i++) right[i]=nums[mid + 1+ i];//Filling the right array
		int i=0, j=0, k=low;
		while(i< n1 && j < n2) {
			if(left[i] <= right[j]) {
				nums[k]=left[i];
				k++;
				i++;
			}
			else {
				nums[k]= right[j];
				k++;
				j++;
			}
		}
		
		while(i<n1) {
			nums[k]=left[i];
			i++;
			k++;
		}
		while(j<n2) {
			nums[k]=right[j];
			j++;
			k++;
		}
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		Sorting obj= new Sorting();
	
		int nums[]= {5,1,9,7,2,6,0,3,8,4,10};
		obj.bubbleSort(nums);
		System.out.println();
		obj.selectionSort(nums);
		System.out.println();
		obj.insertionSort(nums);
		System.out.println();
		obj.mergesort(nums);
		
		
	}

}
