
import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import Collision.CollisionContext;
import Collision.TriangleCollision;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import GameBoard.GameBoardUI;
import GameBoard.GameToolBar;
import GameBoard.Vector2D;
import GameObjectRepository.Debris;
import GameObjectRepository.GameObject;
import GameObjectRepository.Planet;
import GameObjectRepository.Triangle;

@ExtendWith(EasyMockExtension.class)
public class MockTest {
	@TestSubject
	private CollisionContext context;

	@Mock
	private Triangle triangleMock;

	@Test
	void testTriangleCollision() {
		Planet planet = new Planet(null);
		expect(triangleMock.detectCollision(planet)).andReturn(true);
		replay(triangleMock);

		context = new CollisionContext(triangleMock, planet);
		if (context.isTriangle()) {
			context.setCollisionType(new TriangleCollision(triangleMock, planet));
		}

		assertTrue(context.getCollisionType().isCrash());
	}
}
