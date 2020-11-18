package piechart;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * A PercentagePieSlider acts boths as a MVC View and Controller of a Percentage
 * It maintains a reference to its model in order to update it.
 */
public class PercentageSlider extends JSlider implements PercentageView {

	private final PercentageModel myModel;

	public PercentageSlider(PercentageModel model) {
		myModel = model;
		setMinimum(0);
		setMaximum(100);
		this.setMinorTickSpacing(5);
		this.setMajorTickSpacing(10);
		this.setPaintTicks(true);
		this.setPaintLabels(true);
		this.setSnapToTicks(true);

		// "Controller" behaviour : when the value of the slider changes,
		// The model must be updated
		addChangeListener(
			new ChangeListener() {

				public void stateChanged(ChangeEvent e) {
					myModel.setValue(getValue() / 100F);
				}
			});

	}

	// "View" behaviour : when the percentage changes, the slider must be updated
	public void notify(PercentageModel model) {
		setValue(Math.round(model.getValue() * 100));
	}
}
