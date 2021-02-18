package by.epam.task03.observer;

public interface Observable {
	void attach(CustomerObserver observer);

	void detach(CustomerObserver observer);

	void notifyObservers();
}
