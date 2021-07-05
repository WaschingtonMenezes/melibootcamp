import java.util.List;

public class SortUtil <T extends Comparable<? super T>> {
    public static <T> void sort(Precedente<T> arr[]) {
        int n = arr.length;
        while (n > 0)
        {
            int lastModifiedIndex = 0;
            for (int currentIndex = 1; currentIndex < n; currentIndex++)
            {
                // if the item at the previous index is greater than the item at the `currentIndex`, swap them
                if (arr[currentIndex - 1].precedeA((T)arr[currentIndex]) > 0)
                {
                    // swap
                    Precedente<T> temp = arr[currentIndex - 1];
                    arr[currentIndex - 1] = arr[currentIndex];
                    arr[currentIndex] = temp;
                    // save the index that was modified
                    lastModifiedIndex = currentIndex;
                }
            }
            // save the last modified index so we know not to iterate past it since all proceeding values are sorted
            n = lastModifiedIndex;
        }
    }

}