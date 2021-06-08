package cl.jorcarca.designpatterns.behavioral.strategy;

public interface SortStrategy {
    <T extends Comparable<T>> T[] sort(T[] array, OrderBy order);

    default <T extends Comparable<T>> T[] sort(T[] array) {
        return sort(array, OrderBy.ASC);
    }

    default <T extends Comparable<T>> T[] swap(T[] array, int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
        return array;
    }

}
