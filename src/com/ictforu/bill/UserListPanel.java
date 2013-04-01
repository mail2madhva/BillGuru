package com.ictforu.bill;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class UserListPanel extends JPanel {

	DefaultListModel<String> model = new DefaultListModel();

	/**
	 * Create the panel.
	 */
	public UserListPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 191, 63, 1, 0 };
		gridBagLayout.rowHeights = new int[] { 15, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel headerLabel = new JLabel("User List");
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_headerLabel = new GridBagConstraints();
		gbc_headerLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_headerLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_headerLabel.insets = new Insets(0, 0, 0, 5);
		gbc_headerLabel.gridx = 0;
		gbc_headerLabel.gridy = 0;
		add(headerLabel, gbc_headerLabel);
		JList user_list = new JList(model);
		user_list.setVisibleRowCount(10);
		user_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GridBagConstraints gbc_user_list = new GridBagConstraints();
		gbc_user_list.fill = GridBagConstraints.HORIZONTAL;
		gbc_user_list.anchor = GridBagConstraints.WEST;
		gbc_user_list.gridx = 0;
		gbc_user_list.gridy = 1;
		add(user_list, gbc_user_list);
		System.out.println("Refresh from list called");
		refreshModel();

		addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				refreshModel();
				System.out.println("refresh called");
			}
		});

	}

	private void refreshModel() {
		Iterator<Person> personIterator = PersonList.getPersonList()
				.getPersonListArray().iterator();
		Person per = null;
		while (personIterator.hasNext()) {
			per = personIterator.next();
			String person = per.getName() + " " + per.getEmail();
			System.out.println("Items ssss - " + person);

			model.addElement(person);
		}
		model.addElement("1");
	}
}
