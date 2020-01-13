/* 
 * Drawing
 * 
 * Copyright 2020
 */

package STOCKOVERFLOWPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Creates 
 * author Menia Konstantinou
 */

import javax.imageio.ImageIO;

public class Drawing {

	public static void drawRoutes(String fileName) throws Exception {

		int VRP_Y = 800;
		int VRP_INFO = 200;
		int X_GAP = 600;

		int XXX = VRP_INFO + X_GAP;
		int YYY = VRP_Y;

		BufferedImage output = new BufferedImage(XXX, YYY, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = output.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, XXX, YYY);
		g.setColor(Color.BLACK);
		
		OptimumRoute a1 = new OptimumRoute();
		String cst = "VRP solution for " + Order.getOrders().size() + " customers";
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		g.drawString(cst, 30, 30);
		g.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 26));
		int a = 100;
		int b = 100;
		String res[] = new String[VolumeSet.returnFinal().length + 1];
		res = OptimumRoute.implementTheVRP();
		for (int i = 0; i < res.length; i++) {
			g.drawString(res[i], a, b);
			a+= 50;
			b+= 50;
		}
		fileName = fileName + ".png";
		File f = new File(fileName);
		try {
			ImageIO.write(output, "PNG", f);
		} catch (IOException ex) {
			// Logger.getLogger(s.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
