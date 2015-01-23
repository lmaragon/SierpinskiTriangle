import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SierpinskiTriangle extends PApplet {

int sizeTri = 20;
int c1 = 249;
int c2 = 234;
int c3 = 26;
int flash = 1;


public void setup()
{
	size(400,400);
	frameRate(10);
}
public void draw()
{

	background(255);
	fill(100,100,0);
	stroke(0,0,0);
	sierpinski(0,400,400);
	fill(0,0,255);
	ellipse(mouseX, 20, 25, 25);
	stroke(0,0,255);
	line(-10,20,500,20);
	flashingLights();
}


public void flashingLights()
{
	flash = (int)(Math.random()*4);
	if (flash == 0)
	{
		c1 = 255;
		c2 = 0;
		c3 = 0;
	}
	if (flash == 1)
	{
		c1 = 249;
		c2 = 234;
		c3 = 26;
	}
	if (flash == 2)
	{
		c1 = 0;
		c2 = 162;
		c3 = 255;
	}
	if (flash == 3)
	{
		c1 = 0;
		c2 = 255;
		c3 = 43;
	}

}

public void mouseDragged()//optional
{
	sizeTri = mouseX/4;
	
	
}
public void sierpinski(int x, int y, int len) 
{
	
	if (len > sizeTri && len > 10)
	{
		fill(7,147,7);
		sierpinski(x, y, len/2);
		sierpinski(x+len/2, y, len/2);
		sierpinski(x+len/4, y-len/2, len/2);
		fill(c1,c2,c3);
		ellipse(x+len/2,y-len/2, len/8, len/8);
	}
	else
	{
		triangle(x, y, x+len, y, x+len/2, y-len);
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SierpinskiTriangle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
