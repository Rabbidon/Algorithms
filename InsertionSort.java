import java.util.Random;

public class InsertionSort
{
	public static void main(String[] args)
	{
		int cap = 10;
		Random r = new Random();
		float[] toSort = new float[cap];
		for (int n=0; n<cap; n++)
		{
			toSort[n]=r.nextFloat();
		}
		for (int i = 1; i<toSort.length; i++)
		{
			// We need to iterate over the first several elements of the array(up to index i-1) and
			// place the new element where it belongs (when we find an element greater than it).
			// We then need to shift all remaining elements up one until we reach the original vacated position.
			float buffer = 0;
			for (int j=0; j<i; j++)
			{
				if (toSort[j]>toSort[i])
				{
					buffer = toSort[j];
					toSort[j] = toSort[i];
					for (int k=j+1; k<i+1; k++)
					{
						toSort[i] = toSort[k];
						toSort[k] = buffer;
						buffer = toSort[i];
						for (float o : toSort)
						{
							System.out.println(o);
						}
						System.out.println("-");
					}
					break;
				}
			}
		}
		for (float o : toSort)
		{
			System.out.println(o);
		}
	}
}