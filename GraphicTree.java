import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicTree extends JPanel
{
    private BinarySearchTree tree;
    private int xs = 10;
    private int ys = 45;
    private String x = "";

    public GraphicTree(BinarySearchTree tree, ArrayList<String> l) 
    {
        this.tree = tree;
        for(int i = 0;i<l.size();i++)
        {
        	if(i==l.size()-1)
        		x+=l.get(i);
        	else
        		x+=l.get(i)+" ";
        }
        
        JFrame frame = new JFrame("Graphic Binary Tree");
        frame.setBackground(Color.black);
        frame.add(this);
        setVisible(true);
        frame.getContentPane().setBackground(Color.orange);
        frame.setSize(1920,1080);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void paintComponent(Graphics g) 
    {
    	g.setColor(Color.white.brighter());
    	g.setFont(new Font("Comic Sans", 0, 15));
        g.drawString("File input: "+x.toString(), 15, 25);
        draw(tree.root, g);
    }
    public void draw(BinaryNode n, Graphics g) 
    {
    	 int dx, dy, dx2, dy2;
         int SCREEN_WIDTH=1750; 
         int SCREEN_HEIGHT=1000;
         int XSCALE, YSCALE;  
         XSCALE=SCREEN_WIDTH/tree.totalnodes; 
         YSCALE=(SCREEN_HEIGHT-ys)/(tree.getHeight()+1); 
         
        if(n.getValue()!=null)
        {
        	draw(n.getLeft(), g);
        	dx = n.xpos * XSCALE; 
            dy = n.ypos * YSCALE +ys;
            g.setColor(Color.LIGHT_GRAY.darker());
            g.drawOval(dx, dy, 50, 50);
            g.setFont(new Font("Roboto", Font.BOLD, 13));
            if(n == tree.root)
            	g.setColor(Color.red);
            else
            	g.setColor(Color.GREEN);
            g.drawString(n.getValue(), dx+10, dy+27);
        	
            if(n.getLeft()!=null)
            { 
            	dx2 = n.getLeft().xpos * XSCALE; 
            	dy2 = n.getLeft().ypos * YSCALE +ys;
            	g.setColor(Color.WHITE.darker());
            	g.drawLine(dx+15,dy+48,dx2+21,dy2);
            }
            if(n.getRight()!=null)
            { 
                dx2 = n.getRight().xpos * XSCALE;
                dy2 = n.getRight().ypos * YSCALE + ys;
                g.setColor(Color.WHITE.darker());
                g.drawLine(dx+35,dy+48,dx2+30,dy2);
            }
            draw(n.getRight(), g); 
        }
        else
        {
        	dx = n.xpos * XSCALE; 
            dy = n.ypos * YSCALE +ys;
            
            g.setColor(Color.GRAY.darker());
            g.fillRect(dx+18, dy, 17, 17);
            g.setColor(Color.black);
            return;
        }
    }
   
}
