//Here we make the pic

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
public class makeThePic {
	
	static int width = 3840;
	static int height = 2160;
	static int[] pixels = new int[width*height];
	static int scale = 3;
	static Color deepPurple = new Color(22, 00, 50);
	static int deepPurpleRGB = deepPurple.getRGB();
	static Color purple2 = new Color(20, 20, 90);
	static int purple2RGB = purple2.getRGB();
	static Color myBlue = new Color(16, 16, 76);
	static int rgbBlue = myBlue.getRGB();
	static Color planetGreen = new Color(98, 225, 205);
	static int rgbPlanetGreen = planetGreen.getRGB();
	static Color planetPink = new Color(255, 128, 123);
	static int rgbPlanetPink = planetPink.getRGB();
	
	public static Image getImageFromArray(int[] pixels, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        WritableRaster raster = (WritableRaster) image.getData();
        raster.setPixels(0,0,width,height,pixels);
        return image;
    }
	
	public static <E> void p(E thing) {
		System.out.println(thing);
	}
	
	public static int getRGB (int num) {
		if (num <= 3000) {
			return deepPurpleRGB;
		}
		else if (num <= 6000) {
			return purple2RGB;
		}
		else if (num <= 9000) return rgbBlue;
		else if(num == 9001) return rgbPlanetGreen;
		else return rgbPlanetPink;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random random = new Random();
		int current = 0;
		int count =0;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


		
		for(int i = 0; i < pixels.length; i++) {
			current = random.nextInt(3);
			pixels[i] = current + 9000;
			//img.setRGB((i%width),(i%height), getRGB(current));
		}
		
//		for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//            	current = random.nextInt(9004);
//                img.setRGB(i, j, getRGB(current));
//        
//                }
//            }
		
		
		//make a background that puts little blue dots in...
//		
		for (int y = 0; y < height; y++) {
			if ( y < 0 || y>= height) break;
            for (int x = 0; x < width; x++) {
            	if(x < 0 || x >= width) break;
            	int rando = random.nextInt(400);
            	if(rando == 399){
	            	int pixelIndex = (x/64) + (y/64) * 64;
	                img.setRGB(x, y, 0x000033); 				// only a few colors				
            	}
                }
            }
		
		
		//adding planets
		
		for (int y = 0; y < height; y++) {
			if ( y < 0 || y>= height) break; 										// to avoid exceptions
            for (int x = 0; x < width; x++) {
            	if(x < 0 || x >= width) break;										// ''
            	int rando = random.nextInt(9000);
            	if(rando == 399){
	            	int pixelIndex = (x/128) + (y/128) * 64;
	                //img.setRGB(x, y, getRGB(pixels[pixelIndex])); 				// only a few colors
	                img.setRGB(x, y, random.nextInt(0xffffff));						// totally random colors...
            	}
              }
           }
		
		
	//adding bigger planets
		
		for (int y = 1; y < height -1; y++) {
			if ( y < 1 || y>= height -1) break; 										// to avoid exceptions
            for (int x = 1; x < width - 1; x++) {
            	if(x < 1 || x >= width - 1 ) break;										// ''
            	int rando = random.nextInt(15000);
            	if(rando == 399){
	            	int col = random.nextInt(0xffffff);									// for random Colors
	                img.setRGB(x, y, col);
	                img.setRGB(x, y-1, col);// totally random colors...
	                img.setRGB(x-1, y, col);// totally random colors...
	                img.setRGB(x+1,y, col);// totally random colors...
	                img.setRGB(x,y+1, col);// totally random colors...
            	}
              }
           }
		
	//adding even bigger planets
		
		for (int y = 2; y < height -2; y++) {
			if ( y < 2 || y>= height -2) break; 										// to avoid exceptions
            for (int x = 1; x < width - 1; x++) {
            	if(x < 1 || x >= width - 1 ) break;										// ''
            	int rando = random.nextInt(45000);
            	if(rando == 399){
	            	int col = random.nextInt(0xffffff);									// for random Colors
	                img.setRGB(x, y, col);
	                img.setRGB(x, y-1, col);// totally random colors...
	                img.setRGB(x-1, y-1, col);// totally random colors...
	                img.setRGB(x-1, y, col);// totally random colors...
	                img.setRGB(x+1, y-1, col);// totally random colors...
	                img.setRGB(x+1,y, col);// totally random colors...
	                img.setRGB(x-1, y+1, col);// totally random colors...
	                img.setRGB(x+1, y+1, col);// totally random colors...
	                img.setRGB(x,y+1, col);// totally random colors...
	                
	                img.setRGB(x, y-2, col);// totally random colors...
	                img.setRGB(x-2, y, col);// totally random colors...
	                img.setRGB(x, y+2, col);// totally random colors...
	                img.setRGB(x+2, y, col);// totally random colors...
            	}
              }
           }
		
	        // make two offsets so the sums of them can make unique arrangments...
		
		//make a scanner that goes through and edits it...
		// to make little pockets of planets
	
		
		
			// This writes it to the file...
		File f = new File("biggerPlanets.png");
			try {
				if (!ImageIO.write(img, "png", f)) {
					  throw new RuntimeException("Unexpected error writing image");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	}
	
}
