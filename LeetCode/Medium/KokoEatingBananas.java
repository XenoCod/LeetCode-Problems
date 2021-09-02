
public class KokoEatingBananas {
	int minHours(int nums[], int h) {
		int max=-1;
		for(int i:nums) { max= Math.max(max, i);};
		int res=0;
		int low=1, high=max;
		while(low <= high) {
			int mid= low + ((high - low) >> 1);
			if(isValid(nums, h, mid)) {
				res= mid;
				high= mid-1;
//				System.out.print(res+" ");
			}
			else low= mid+1;
		}
		return res;
	}
	
	
	private boolean isValid(int nums[], int h, int speed) {
		int res=0;
		for(int i=0; i<nums.length;i++) {
			res+= (int)Math.ceil(nums[i]*1.0/speed);
		}
		return res<= h;
	}
	public static void main(String[] args) {
		int nums[]= {3,6,7,11};
		int h=5;
		KokoEatingBananas obj= new KokoEatingBananas();
		System.out.println(obj.minHours(nums, h));
	}
}
