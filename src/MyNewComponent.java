import java.awt.Component;
import java.awt.Graphics;

public class MyNewComponent extends Component {
	private static final long serialVersionUID = 1L;
	
	public int x,y;
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void paint(Graphics g) {
		g.drawString("Component", x, y);
	}
}
