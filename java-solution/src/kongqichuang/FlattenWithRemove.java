package kongqichuang;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-11-01
 **/
public class FlattenWithRemove {
    public class NestedIterator implements Iterator<Integer> {
        Iterator<List<Integer>> rowIte;
        Iterator<Integer> colIte;

        public NestedIterator(List<List<Integer>> vec2d) {
            rowIte = vec2d.iterator();
            colIte = Collections.emptyIterator();
        }

        @Override
        public boolean hasNext() {
            while (rowIte.hasNext() && (colIte == null || !colIte.hasNext())) {
                colIte = rowIte.next().iterator();
            }
            return colIte != null && colIte.hasNext();
        }

        @Override
        public Integer next() {
            return colIte.next();
        }

        @Override
        public void remove() {
            while (rowIte.hasNext() && (colIte == null || !colIte.hasNext())) {
                colIte = rowIte.next().iterator();
            }
            if (colIte != null) {
                colIte.remove();
            }
        }
    }
}
