package com.ictforu.bill;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class UserAdd extends JPanel {
	private JTextField user_name_field;
	private JTextField user_email_id;
	private JTextField user_age_field;
	private JLabel user_age;
	private JLabel Header;

	/**
	 * Create the panel.
	 */
	public UserAdd() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBackground(SystemColor.window);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 81, 114, 80, 114, 0};
		gridBagLayout.rowHeights = new int[]{19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		Header = new JLabel("Enter User Details");
		Header.setLabelFor(Header);
		GridBagConstraints gbc_Header = new GridBagConstraints();
		gbc_Header.gridwidth = 4;
		gbc_Header.fill = GridBagConstraints.HORIZONTAL;
		gbc_Header.insets = new Insets(0, 0, 5, 5);
		gbc_Header.gridx = 0;
		gbc_Header.gridy = 0;
		add(Header, gbc_Header);
		
		JLabel user_name = new JLabel("User name:");
		GridBagConstraints gbc_user_name = new GridBagConstraints();
		gbc_user_name.anchor = GridBagConstraints.WEST;
		gbc_user_name.insets = new Insets(0, 0, 5, 5);
		gbc_user_name.gridx = 0;
		gbc_user_name.gridy = 1;
		add(user_name, gbc_user_name);
		
		user_name_field = new JTextField();
		user_name_field.setHorizontalAlignment(SwingConstants.CENTER);
		user_name_field.setColumns(10);
		GridBagConstraints gbc_user_name_field = new GridBagConstraints();
		gbc_user_name_field.fill = GridBagConstraints.HORIZONTAL;
		gbc_user_name_field.anchor = GridBagConstraints.NORTHWEST;
		gbc_user_name_field.gridx = 1;
		gbc_user_name_field.gridy = 1;
		add(user_name_field, gbc_user_name_field);
		
		JLabel user_email = new JLabel("User email:");
		GridBagConstraints gbc_user_email = new GridBagConstraints();
		gbc_user_email.gridx = 0;
		gbc_user_email.anchor = GridBagConstraints.NORTHWEST;
		gbc_user_email.gridy = 2;
		add(user_email, gbc_user_email);
		
		user_email_id = new JTextField();
		user_email_id.setColumns(10);
		GridBagConstraints gbc_user_email_id = new GridBagConstraints();
		gbc_user_email_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_user_email_id.insets = new Insets(0, 0, 5, 5);
		gbc_user_email_id.anchor = GridBagConstraints.NORTHWEST;
		gbc_user_email_id.gridx = 1;
		gbc_user_email_id.gridy = 2;
		add(user_email_id, gbc_user_email_id);
		
		user_age = new JLabel("User Age:");
		GridBagConstraints gbc_user_age = new GridBagConstraints();
		gbc_user_age.anchor = GridBagConstraints.EAST;
		gbc_user_age.insets = new Insets(0, 0, 5, 5);
		gbc_user_age.gridx = 0;
		gbc_user_age.gridy = 3;
		add(user_age, gbc_user_age);
		
		user_age_field = new JTextField();
		GridBagConstraints gbc_user_age_field = new GridBagConstraints();
		gbc_user_age_field.fill = GridBagConstraints.HORIZONTAL;
		gbc_user_age_field.anchor = GridBagConstraints.NORTHWEST;
		gbc_user_age_field.insets = new Insets(0, 0, 5, 5);
		gbc_user_age_field.gridx = 1;
		gbc_user_age_field.gridy = 3;
		add(user_age_field, gbc_user_age_field);
		user_age_field.setColumns(10);
		
		JButton button = new JButton("Save the User");
		
		GridBagConstraints gbc_button = new GridBagConstraints();
		
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.anchor = GridBagConstraints.NORTHWEST;
		gbc_button.gridx = 1;
		gbc_button.gridy = 4;
		add(button, gbc_button);
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Person person = new Person();
				person.setAge(Integer.parseInt(user_age_field.getText()));
				person.setName(user_name_field.getText());
				person.setEmail(user_email_id.getText());
				
				PersonList.getPersonList().addPerson(person);
				System.out.println("Added person to list");
			}
		});

	}

}
