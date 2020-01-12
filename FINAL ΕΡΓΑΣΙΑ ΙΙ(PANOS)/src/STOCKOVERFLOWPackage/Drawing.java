package STOCKOVERFLOWPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Drawing {

	public static void drawRoutes(String fileName) throws Exception {

		int VRP_Y = 800;
		int VRP_INFO = 200;
		int X_GAP = 600;
		int margin = 30;
		int marginNode = 1;

		int XXX = VRP_INFO + X_GAP;
		int YYY = VRP_Y;

		BufferedImage output = new BufferedImage(XXX, YYY, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = output.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, XXX, YYY);
		g.setColor(Color.BLACK);
		
		OptimumRoute a1 = new OptimumRoute();
		String cst = "VRP solution for " + Customer.getCustomers().size() + " customers";
		g.drawString(cst, 10, 10);
		g.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));
		int a = 30;
		int b = 30;
		String res[] = new String[VolumeSet.returnFinal().length + 1];
		res = OptimumRoute.implementTheVRP(VolumeSet.returnFinal(), a1.nodesVisited);
		for (int i = 1; i < res.length; i++) {
			g.drawString("The solution is: " + res[i], a, b);
			a+= 10;
			b+=10;
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
