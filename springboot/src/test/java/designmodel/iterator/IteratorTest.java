package designmodel.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

    @Test
    public void testDuplicateRemove() {
        List names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        Iterator iterator1 = names.iterator();
        Iterator iterator2 = names.iterator();
        iterator1.next();
        iterator1.remove();
        // 这里是会报错的，源码有checkForComodification。
        // if (modCount != expectedModCount)
        //                throw new ConcurrentModificationException();
        iterator2.next(); // 运行结果？
    }

    @Test
    public void testSnapShotIterator1() {
        ArrayList<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");

        SnapshotArrayIterator snapshotA = new SnapshotArrayIterator(names);

        names.remove("a");

        SnapshotArrayIterator snapshotB = new SnapshotArrayIterator(names);

        while (snapshotA.hasNext()) {
            System.out.println("A：" + snapshotA.next());
        }

        while (snapshotB.hasNext()) {
            System.out.println("B：" + snapshotB.next());
        }


    }


}
