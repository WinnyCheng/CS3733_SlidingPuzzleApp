package slide.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import slide.model.*;
import slide.controller.*;

public class SlidingPuzzleApp extends JFrame {

	private JPanel contentPane;

	Model model = new Model();
	
	PuzzleView puzzleView;
	
	JButton upButton, leftButton, rightButton, downButton;
	JTextField label;

/*	
    //Launch App
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SlidingPuzzleApp frame = new SlidingPuzzleApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	public PuzzleView getPuzzleView() {
		return puzzleView;
	}
	
	public JTextField getLabel() {
		return label;
	}
	
	/**
	 * Create the frame.
	 */
	public SlidingPuzzleApp(Model m) {
		
		this.model = m;
		
		setTitle("SlidingPuzzleApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane); 
		
		puzzleView = new PuzzleView(model);
		puzzleView.setBackground(Color.BLACK);
		puzzleView.setSize(new Dimension(410, 510));
		
		SelectTileController selectTile = new SelectTileController(model, this);
		puzzleView.addMouseListener(selectTile);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResetPuzzleController(model, SlidingPuzzleApp.this).reset();
			}
		});
		
		upButton = new JButton("^");
		upButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MoveSelectedController(model, SlidingPuzzleApp.this).moveTile("up");
			}
		});
		
		leftButton = new JButton("<"); 
		leftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MoveSelectedController(model, SlidingPuzzleApp.this).moveTile("left");
			}
		});
		
		rightButton = new JButton(">");
		rightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MoveSelectedController(model, SlidingPuzzleApp.this).moveTile("right");
			}
		});
		
		downButton = new JButton("v");
		downButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MoveSelectedController(model, SlidingPuzzleApp.this).moveTile("down");
			}
		});
		
		JLabel lblMoves = new JLabel("Moves:");
		label = new JTextField(0);
		label.setEditable(false);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(puzzleView, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addComponent(leftButton)
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(upButton)
								.addComponent(downButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addComponent(rightButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(74)
							.addComponent(btnReset))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(65)
							.addComponent(lblMoves)
							.addGap(18)
							.addComponent(label))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(137)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(14)
									.addComponent(leftButton))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(upButton)
									.addGap(6)
									.addComponent(downButton))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(13)
									.addComponent(rightButton)))
							.addGap(68)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMoves)
								.addComponent(label))
							.addGap(89)
							.addComponent(btnReset))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(puzzleView, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
