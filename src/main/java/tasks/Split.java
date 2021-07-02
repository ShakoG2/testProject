package tasks;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Split {


	Integer minSplit(int amount) {
		int quantity = 0;
		Integer[] coins = {1, 2, 5, 10, 20, 50};
		Arrays.sort(coins, Collections.reverseOrder());
		for (int coin : coins) {
			while (amount > coin) {
				amount -= coin;
				quantity++;
			}
		}

		return quantity;
	}
}
