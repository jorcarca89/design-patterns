package cl.jorcarca.designpatterns.behavioral.observer;

public class Publisher extends BaseObservable {
    private String title;

    @SuppressWarnings("unused")
    private Publisher() {
    }

    public Publisher(String name) {
        super(name);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyChanges();
    }

}
