
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Player {

	private Image normal, stress, hunger, hurt, sick; 
	private AffineTransform tx, tx2;
	
	public int dir=0;
	public int maxDir=4;
	int width, height;
	int x, y;				
	double scaleWidth = 0.75;		
	double scaleHeight = 0.75;
	double scaleWidth2 = 0.6;		
	double scaleHeight2 = 0.6;
	
	int hungerScore, mentalScore, healthScore, illScore;
	
	public Player() {
		
		normal 	= getImage("/imgs/"+"yipee.jpg"); 
		stress 	= getImage("/imgs/"+"stress.PNG"); 
		hunger 	= getImage("/imgs/"+"stewie.png"); 
		hurt 	= getImage("/imgs/"+"houseattic.PNG"); 
		sick 	= getImage("/imgs/"+"ashbaby.jpg"); 
		width = 200;
		height = 200;
		x = 0;
		y = 0;
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		tx2 = AffineTransform.getTranslateInstance(0, 0);
		
		hungerScore=100;
		mentalScore=100;
		healthScore=100;
		illScore=100;
		//init(x, y); 
		
	}

	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;

		g.drawRect(x, y, width, height);

		switch(dir) {
			case 0:
				init2(x,y);
				g2.drawImage(normal, tx2, null);
				g.drawRect(x, y, width, height);
				break;
				
			case 1:
				init2(x,y);
				g2.drawImage(stress, tx2, null);
				g.drawRect(x, y, width, height);
				break;
				
			case 2:
				init(x, y); 
				g2.drawImage(hunger, tx2, null);
				g.drawRect(x, y, width, height);
				break;
				
			case 3:
				init(x, y);  
				g2.drawImage(sick, tx2, null);
				g.drawRect(x, y, width, height);
				break;
				
			case 4:
				init(x, y); 
				g2.drawImage(hurt, tx2, null);
				g.drawRect(x, y, width, height);
				break;
			case 5: //closing
				init(x,y);

				break;
				
		}
		


	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scaleWidth, scaleHeight);
	}
	
	
	private void init2(double a, double b) {
		tx2.setToTranslation(a, b);
		tx2.scale(scaleWidth2, scaleHeight2);
	}

	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Player.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	


	public int getHungerScore() {
		return hungerScore;
	}

	public void setHungerScore(int hungerScore) {
		this.hungerScore = hungerScore;
	}

	public int getMentalScore() {
		return mentalScore;
	}

	public void setMentalScore(int mentalScore) {
		this.mentalScore = mentalScore;
	}

	public int getHealthScore() {
		return healthScore;
	}

	public void setHealthScore(int healthScore) {
		this.healthScore = healthScore;
	}

	public int getIllScore() {
		return illScore;
	}

	public void setIllScore(int illScore) {
		this.illScore = illScore;
	}
	
	
	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Player f = new Player();
	}
	
	
	

}
