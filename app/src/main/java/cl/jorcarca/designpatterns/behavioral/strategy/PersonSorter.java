package cl.jorcarca.designpatterns.behavioral.strategy;

public class PersonSorter {
    private SortStrategy sortStrategy;

    public PersonSorter(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public Person[] sortPeople(Person[] people, OrderBy order) {

        return sortStrategy.sort(people, order);
    }

    public SortStrategy getSortStrategy() {
        return this.sortStrategy;
    }

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }
}
