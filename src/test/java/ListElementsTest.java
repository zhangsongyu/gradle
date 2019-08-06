import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListElementsTest {
    @Test
    public void test() {
        List<String> strs = Arrays.asList("ab", "b","d", "c","a");
        ;
        strs.stream().filter(f->f.length()>1).collect(Collectors.toList());
        System.out.println(strs);
        String result = strs.stream().sorted().collect(Collectors.joining("-"));
        System.out.printf(result);
    }

    public void operation(List<String> strs) {
        for (int i = 0; i < strs.size(); i++) {
            strs.set(i, String.valueOf(i));
        }
    }
}
