package tasks;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

public class CountVariants {

	static int variants(int n)
	{
		if (n <= 1)
			return n;
		return variants(n - 1) + variants(n - 2);
	}

	static int countWays(int s)
	{
		return variants(s + 1);
	}

}
