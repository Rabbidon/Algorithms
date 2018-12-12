//A fast way to search an integer array for a pair summing to a fixed total

public class FindPair
	public static void findPair(List<int> integers, int total)
	{
		HashSet<int> compSet = new HashSet<int>();
		for (int i : integers)
		{
			int comp = total - i;
			if (compSet.contains(comp))
			{
				System.println.out("True\n"+i+","+comp);
				return;
			}
			compSet.add(comp);
		}
		System.println.out("False");
	}
}
