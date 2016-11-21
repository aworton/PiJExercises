import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class MergeSortTests{

    private MergeSort<Integer> sorter = new MergeSort<>();

    @Test
    public void correctSortReverseOrdered(){
        List<Integer> ordered = Arrays.asList(1,2,3,4,5);   
        List<Integer> reverseOrdered = Arrays.asList(5,4,3,2,1);        
        List<Integer> sorted = this.sorter.sort(reverseOrdered);

        assertEquals(ordered, sorted);
    }

    @Test
    public void correctSortAlreadyOrdered(){
        List<Integer> ordered = Arrays.asList(1,2,3,4,5);   
        List<Integer> reverseOrdered = Arrays.asList(1,2,3,4,5);        
        List<Integer> sorted = this.sorter.sort(reverseOrdered);

        assertEquals(ordered, sorted);
    }

    @Test
    public void correctSortJumbleOrdered(){
        List<Integer> ordered = Arrays.asList(1,2,3,4,5);   
        List<Integer> reverseOrdered = Arrays.asList(4,1,3,5,2);        
        List<Integer> sorted = this.sorter.sort(reverseOrdered);

        assertEquals(ordered, sorted);
    }

    @Test
    public void correctSortLarge(){
        List<Integer> ordered = new LinkedList<>();   

        for(int i = 1; i <= 20000; i++){
            ordered.add(i);
        }

        List<Integer> reverseOrdered = new LinkedList<>();  

        for(int i = 20000; i > 0; i--){
            reverseOrdered.add(i);
        }

        List<Integer> sorted = this.sorter.sort(reverseOrdered);

        assertEquals(ordered, sorted);
    }

}