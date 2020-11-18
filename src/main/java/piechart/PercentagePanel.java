package piechart;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The main frame of the application
 */
public class PercentagePanel extends JPanel {
	// The "Model" of a Percentage
	PercentageModel myModel = new PercentageModel(.33F);
	// A View of the myModel
	PercentageLabel myTextView = new PercentageLabel();
	// connect the view to the myModel
	// A View and Controller of the myModel
	PercentagePieChart myPieViewAndController = new PercentagePieChart(myModel);
	// Another view and Controller
	PercentageSlider mySliderViewAndController = new PercentageSlider(myModel);

	/**Construct the frame*/
	public PercentagePanel() {
		// Setup the window
		setLayout(new BorderLayout());
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());
		JLabel jLabel1 = new JLabel();
		jLabel1.setText("Percentage:");
		myTextView.setEnabled(false);
		myPieViewAndController.setPreferredSize(new Dimension(250, 100));
		northPanel.add(jLabel1, null);
		northPanel.add(myTextView, null);
		add(northPanel, BorderLayout.NORTH);
		add(myPieViewAndController, BorderLayout.CENTER);
		add(mySliderViewAndController, BorderLayout.SOUTH);

		// Connect the views to the model
		myModel.addView(myTextView);
		myModel.addView(myPieViewAndController);
		myModel.addView(mySliderViewAndController);
		//myModel.addView(new ConsoleView());

	}
}
