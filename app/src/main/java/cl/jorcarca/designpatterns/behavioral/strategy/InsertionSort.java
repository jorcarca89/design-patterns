package cl.jorcarca.designpatterns.behavioral.strategy;

public class InsertionSort implements SortStrategy {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array, OrderBy order) {
        for (var i = 1; i < array.length; i++) {
            for (var j = i; j > 0; j--) {
                if (order.getValue() * array[j-1].compareTo(array[j]) > 0) {
                    array = swap(array, j, j - 1);
                }
            }
        }
        return array;
    }

}
