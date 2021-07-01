package Collision;

import GameObjectRepository.GameObject;
import GameObjectRepository.Triangle;

public class TriangleCollision implements CollisionType {
	private boolean isCollision;
	private GameObject object1;
	private GameObject object2;

	public TriangleCollision(GameObject object1, GameObject object2) {
		this.object1 = object1;
		this.object2 = object2;
		isCollision = detectCollision();
	}

	@Override
	public boolean isCrash() {
		return isCollision;
	}

	@Override
	public boolean detectCollision() {
		boolean collision;
		if (object1 instanceof Triangle) {
			collision = ((Triangle) object1).detectCollision(object2);
		} else {
			collision = ((Triangle) object2).detectCollision(object1);
		}
		return collision;
	}

}