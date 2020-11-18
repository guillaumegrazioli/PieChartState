package piechart;

import java.util.Set;

/**
 * This class is a MVC "Model" of a percentage (a value such as 0 <= x <= 1)
 **/
public class PercentageModel extends Percentage {
	private Set<PercentageView> myViews = new java.util.HashSet<PercentageView> ();

	/**
	 * Create a Percentage with an initial value
	 * @param initialValue : the initial value
	 * @throws IllegalArgumentException if value is not correct
	 **/
	public PercentageModel(float initialValue) {
		super(initialValue);
	}

	/**
	 * Create a Percentage with an initial value of 0
	 **/
	public PercentageModel() {
		this(0.0F);
	}

	/**
	 * Change the value of this Percentage.
	 * Notify Listeners of this model.
	 * @param newValue : the value
	 * @throws IllegalArgumentException if value is not correct
	 **/
	@Override
	public void setValue(float newValue) {
		float oldValue = getValue();
		super.setValue(newValue);
		if (getValue() != oldValue) 
			// Percentage has changed, notify the Views.
			notifyViews();
	}

	/**
	 * Add a new Listener to this model
	 * @param l     the new listener
	 **/
	public void addView(PercentageView l) {
		myViews.add(l);
		// Bring the Listener up to date
		l.notify(this);
	}

	/**
	 * Remove a Listener from this model
	 * @param l     the  listener to remove
	 **/
	public void removeView(PercentageView l) {
		myViews.remove(l);
	}

	/**
	 * Iterates on all listeners and
	 * send the StateChanged method to each
	 * @param e the event to dispatch
	 */
	protected void notifyViews() {
		if (null != myViews) 
			for (PercentageView view : myViews) 
				view.notify(this);
	}
}
