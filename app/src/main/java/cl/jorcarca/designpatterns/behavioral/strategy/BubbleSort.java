package cl.jorcarca.designpatterns.behavioral.strategy;

public class BubbleSort implements SortStrategy {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array, OrderBy order) {
        boolean swaped;
        do {
            swaped = false;
            for (var i = 0; i < array.length - 1; i++) {
                if (order.getValue() * array[i].compareTo(array[i + 1]) > 0) {
                    array = swap(array, i, i + 1);
                    swaped = true;
                }
            }
        } while (swaped);

        return array;
    }

}
