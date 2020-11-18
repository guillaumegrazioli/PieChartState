package piechart;

public class Percentage {
	/**
	 * The Percentage value is internally stored as an integer
	 */
	protected int myValue;
	/**
	 * Create a Percentage with an initial value
	 * @param initialValue : the initial value
	 * @throws IllegalArgumentException if value is not correct
	 **/
	public Percentage(float initialValue) {
		setValue(initialValue);
	}

	public Percentage() {
		this(0.0F);
	}

	protected boolean valueIsOK(float value) {
		return ( (0.0F <= value) && (value <= 1.0F));
	}

	/**
	 * Change the value of this Percentage.
	 * Notify Listeners of this model.
	 * @param newValue : the value
	 * @throws IllegalArgumentException if value is not correct
	 **/
	public void setValue(float newValue) {
		if (valueIsOK(newValue)) {
			myValue = Math.round(newValue * 100);
		} else {
			throw (new IllegalArgumentException("Bad percentage value: " + newValue));
		}
	}

	/**
	 * @returns the current value
	 **/
	public float getValue() {
		return myValue / 100f;
	}
}
