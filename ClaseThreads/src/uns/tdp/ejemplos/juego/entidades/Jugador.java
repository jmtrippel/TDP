package uns.tdp.ejemplos.juego.entidades;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Jugador extends Entidad{

	public Jugador(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		this.mImages[0] = new ImageIcon(this.getClass().getResource("/BattleCity/up.png"));
		this.mImages[1] = new ImageIcon(this.getClass().getResource("/BattleCity/down.png"));
		this.mImages[2] = new ImageIcon(this.getClass().getResource("/BattleCity/left.png"));
		this.mImages[3] = new ImageIcon(this.getClass().getResource("/BattleCity/right.png"));
		
		this.mDestroyedImage = new ImageIcon(this.getClass().getResource("/BattleCity/explotion.png"));
	}

	public void mover(int dir){
		switch (dir){
			case KeyEvent.VK_UP : 
				this.mPosicion.setLocation(this.mPosicion.x, this.mPosicion.y - this.mVelocidad);
				super.mover(MOVIMIENTO_ARRIBA);
				break;
			case KeyEvent.VK_DOWN :
				this.mPosicion.setLocation(this.mPosicion.x, this.mPosicion.y + this.mVelocidad);
				super.mover(MOVIMIENTO_ABAJO);
				break;
			case KeyEvent.VK_LEFT :
				this.mPosicion.setLocation(this.mPosicion.x - this.mVelocidad, this.mPosicion.y);
				super.mover(MOVIMIENTO_IZQUIERDA);
				break;
			case KeyEvent.VK_RIGHT :
				this.mPosicion.setLocation(this.mPosicion.x + this.mVelocidad, this.mPosicion.y);
				super.mover(MOVIMIENTO_DERECHA);
				break;
		}
	}
}
