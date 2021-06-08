package cl.jorcarca.designpatterns.behavioral.strategy;

public enum OrderBy {
    ASC(1), DESC(-1);

    private int value;

    OrderBy(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
