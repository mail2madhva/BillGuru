package com.ictforu.bill;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;


public class MainFrame extends JFrame {

	private JPanel contentPane;
	
	private static void refreshModel() {
		String filename = "data.bin";
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream(filename));
			PersonList listRead = (PersonList) is.readObject();
			PersonList.getPersonList().setPersonList(listRead.getPersonListArray());
			Iterator<Person> per = PersonList.getPersonList().getPersonListArray().iterator();
			while(per.hasNext()){
				System.out.println(per.next().getEmail());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		refreshModel();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					
					frame.addWindowListener(new WindowListener() {
						
						public void windowOpened(WindowEvent arg0) {
							
						}
						
						@Override
						public void windowIconified(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowDeiconified(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowDeactivated(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}
						
						public void windowClosing(WindowEvent arg0) {
							String filename = "data.bin";
							try {
								ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
								os.writeObject(PersonList.getPersonList());
								os.close();
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}	
							System.out.println("Done writing ");
							System.exit(0);			
						}
						
						public void windowClosed(WindowEvent arg0) {

						}
						
						public void windowActivated(WindowEvent arg0) {
							
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		System.out.println("Test123");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{440, 0};
		gbl_contentPane.rowHeights = new int[]{169, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.SCROLL_TAB_LAYOUT);
//		JScrollPane pane = new JScrollPane();
//		pane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
//		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
//		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		tabbedPane.add("Add Users", pane);
		
		JPanel userAddPanel = new UserAddPane();
		tabbedPane.add("Add Users",userAddPanel);
		
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		contentPane.add(tabbedPane, gbc_tabbedPane);
		
		
		JPanel userListPanel = new UserListPanel();
		tabbedPane.add("List Users",userListPanel);
		
	}

}
