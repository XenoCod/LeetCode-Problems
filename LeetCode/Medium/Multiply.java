public class Multiply{
	static String multiply(String num1, String num2) {
		int n1= num1.length(), n2= num2.length();
		int products[]= new int [n1 + n2];
		for(int i= n1 -1; i>=0; i--) {
			for(int j= n2-1; j>=0; j--) {
				int a= num1.charAt(i) - '0';
				int b= num2.charAt(j) - '0';
				products[i + j + 1]+= a *b;
			}
		}
		int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : products) sb.append(num);
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
		
		
	}
	public static void main(String [] args) {
		String num1="123", num2="456";
		System.out.println(multiply(num1, num2));
	}
}