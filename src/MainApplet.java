import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.List;
import model.LineBean;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
/*
 <applet code="MainApplet" width=200, height=400></applet> 
*/

public  class MainApplet extends Applet implements MouseListener,MouseMotionListener,MouseWheelListener,Runnable {
	String message = "";
	int x1,y1,x2,y2;
	Thread t;
	List<LineBean> lineList = new ArrayList<LineBean>();
	LineBean myLineBean;
	int counter=0;
	Boolean dragFlag=false;
	MyNewComponent myNewcomponent = new MyNewComponent();
	
	@Override
	public void init() {
		t=new Thread(this);
		addMouseListener(this);
		addMouseMotionListener(this);

		setSize(getWidth()+200, getHeight()+200);

	}
	@Override
	public void paint(Graphics g) {
			g.drawRect(10, 10, 20, 20);
			g.fillRect(10, 10, 20, 20);
			g.drawRect(x1, y1, x2, y2);
			g.drawRect(x2, y2, x2, y2);
			g.drawLine(x1, y1, x2, y2);
			g.drawLine(x1+x2, y1, x2+x2, y2);
			g.drawLine(x1, y1+y2, x2, y2+y2);
			g.drawLine(x1+x2, y1+y2, x2+x2, y2+y2);
			if(lineList.size()>0){
				for(int i=0;i<lineList.size();i++){
						g.drawRect(lineList.get(i).getX1(), lineList.get(i).getY1(), lineList.get(i).getX2(), lineList.get(i).getY2());
						g.drawRect(lineList.get(i).getX2(), lineList.get(i).getY2(), lineList.get(i).getX2(), lineList.get(i).getY2());
						g.drawLine(lineList.get(i).getX1(), lineList.get(i).getY1(), lineList.get(i).getX2(), lineList.get(i).getY2());
						g.drawLine(lineList.get(i).getX1()+lineList.get(i).getX2(), lineList.get(i).getY1(), 
								lineList.get(i).getX2()+lineList.get(i).getX2(), lineList.get(i).getY2());
						g.drawLine(lineList.get(i).getX1(), lineList.get(i).getY1()+lineList.get(i).getY2(),
								lineList.get(i).getX2(), lineList.get(i).getY2()+lineList.get(i).getY2());
						g.drawLine(lineList.get(i).getX1()+lineList.get(i).getX2(), lineList.get(i).getY1()+lineList.get(i).getY2(),
								lineList.get(i).getX2()+lineList.get(i).getX2(), lineList.get(i).getY2()+lineList.get(i).getY2());
					
					}
				}
			
		
	/*	g.drawRect(x1, y1, x2, y2);
		g.drawRect(x2, y2, x2, y2);
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x1+x2, y1, x2+x2, y2);
		g.drawLine(x1, y1+y2, x2, y2+y2);
		g.drawLine(x1+x2, y1+y2, x2+x2, y2+y2);*/
	
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		x2=e.getX();
		y2=e.getY();
		
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1=e.getX();
		y1=e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x2=e.getX();
		y2=e.getY();
		myLineBean = new LineBean();
		// TODO Auto-generated method stub
		myLineBean.setX1(x1);
		myLineBean.setX2(x2);
		myLineBean.setY1(y1);
		myLineBean.setY2(y2);
		lineList.add(myLineBean);
		dragFlag = false;
		repaint();
		System.out.println(lineList.size());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
		
}
