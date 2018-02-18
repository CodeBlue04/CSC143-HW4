import java.awt.Color;
import java.awt.Graphics;
/**
 * Simple interface with method Draw
 * @author Colby Easton, Max Sutters
 *
 */
public interface Shape {

	public void draw(Graphics g);
	
	public boolean addLevel();
	
	public boolean removeLevel();

	public boolean createChildren();
	
	public Shape[] getChildren();
	
	public void resetLevel();

}
