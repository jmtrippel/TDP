package uns.tdp.ejemplos.juego.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uns.tdp.ejemplos.juego.Juego;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel mContentPane;
	
	private Juego mJuego;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				accion(arg0);
			}
		});
		
		this.mContentPane = new JPanel();
		this.mContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.mContentPane.setLayout(null);
		
		setContentPane(this.mContentPane);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		this.mJuego = new Juego(this);
	}
	
	protected void accion(KeyEvent key){
		
		switch (key.getKeyCode()) {
		case KeyEvent.VK_1:
			this.mJuego.destruir(0);
			break;
		case KeyEvent.VK_2:
			this.mJuego.destruir(1);
			break;
		case KeyEvent.VK_3:
			this.mJuego.destruir(2);
			break;
		default:
			this.mJuego.mover(key.getKeyCode());
			break;
		}
		
	}
}