package GameObjectRepository;

import GameBoard.Dimension2D;
import GameBoard.Vector2D;
import SpaceShip.SpaceShip;

public class Triangle extends GameObject {

	public Triangle(Vector2D position, Vector2D velocity, double speed, double direction, double mass) {
		super(position, velocity, speed, direction, mass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean crash(GameObject object) {
		if (object instanceof Projectile || object instanceof Obstacle) {
			destroyed = true;
		} else if (object instanceof SpaceShip) {

			velocity.add(object.getVelocity().clone());
		}
		return destroyed;
	}

	@Override
	public void fly(Dimension2D gameBoardSize) {
		// TODO Auto-generated method stub

	}

	public boolean detectCollision(GameObject object) {
		// TODO Auto-generated method stub
		return false;
	}

}