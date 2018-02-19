package recursion;

public class test {
	public static void main(String[] args) {
		System.out.println(f(28));
	}

	public static int f(int x) {
		if (x > 100) {
			return (x - 10);
		} else {
			//System.out.println(x);
			return (f(f(x + 11)));
		}
	}
}
