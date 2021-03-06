package extra2;

import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FortuneTeller extends JPanel implements Runnable, MouseListener {

    JFrame jf = new JFrame();

    int jfw = 500;
    int jfh = 500;

    FortuneTeller() throws Exception {
   	 // 1. Choose an image for your fortune teller and put it in your default package
   	 fortuneTellerImage = ImageIO.read(getClass().getResource("fortune teller.png"));
   	 // 2. Adjust the frameWidth and frameHeight variables to fit your image nicely (doesn’t need a new line of code)
   	 
   	 //done
   	 
     // 3. Complete the begin() method in the FortuneTellerRunner class
   	 
   	 //done
 	 
   	 // 4. add a mouse listener to the frame
jf.addMouseListener(this);
    }



    @Override
    public void mousePressed(MouseEvent e) {
   	 int mouseX = e.getX();
   	 int mouseY = e.getY();
   	 // 5. Print the mouseX variable
System.out.println("x: "+mouseX+" y: "+mouseY);
   	 // 6. Add the mouseY variable to the previous line so that it prints out too (no new line)

//done

   	 // 7. Adjust your secret location co-ordinates here:
   	 int secretLocationX = 250;
   	 int secretLocationY = 250;
   	 /** If the mouse co-ordinates and secret location are close, we'll let them ask a question. */
   	 if (areClose(mouseX, secretLocationX) && areClose(mouseY, secretLocationY)) {
   		 // 8. Get the user to enter a question for the fortune teller
   		int r = new Random().nextInt(4);
   	// 3. Print out this variable
   	System.out.println(r);
   	// 4. Get the user to enter a question for the 8 ball
   	JOptionPane.showInputDialog("ask me a question");
   	// 5. If the random number is 0
   	if(r==0) {
   	// -- tell the user "Yes"
   	JOptionPane.showMessageDialog(null, "Yes");
   	}
   	// 6. If the random number is 1
   	if(r==1) {
   	// -- tell the user "No"
   	JOptionPane.showMessageDialog(null, "NO");
   	}


   	// 7. If the random number is 2
   	if(r==2) {
   	// -- tell the user "Maybe you should ask Google?"
   	JOptionPane.showMessageDialog(null, "Maybe you should ask Google?");
   	}


   	// 8. If the random number is 3
   	if(r==3) {
   	// -- write your own answer
   	JOptionPane.showMessageDialog(null, "unclear ask again later");
   	}

   		 // 9. Find a spooky sound and put it in your default package (freesound.org)

//done

   		 // AudioClip sound = JApplet.newAudioClip(getClass().getResource("creepy-noise.wav"));
AudioClip sound = JApplet.newAudioClip(getClass().getResource("creepy-noise2.wav"));
   		 // 10. Play the sound
sound.play();
   		 // 11. Use the pause() method below to wait until your music has finished
pause(3);
   		 // 12. Insert your completed Magic 8 ball code here



}

}


   	 

    

    private boolean areClose(int mouseX, int secretLocationX) {
   	 return mouseX < secretLocationX + 15 && mouseX > secretLocationX - 15;
    }

    private void pause(int seconds) {
   	 try {
   		 Thread.sleep(1000 * seconds);
   	 } catch (InterruptedException e) {
   		 e.printStackTrace();
   	 }
    }
    
    /**************** don't worry about the stuff under here *******************/
    
    BufferedImage fortuneTellerImage;



    @Override
    public void run() {
   	 jf.add(this);
		setPreferredSize(new Dimension(jfw, jfh));
   	 jf.pack();
   	 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	 jf.setResizable(false);
   	 jf.setVisible(true);
    }

private void showAnotherImage(String imageName) {
   	 try {
   		 fortuneTellerImage = ImageIO.read(getClass().getResource(imageName));
   	 } catch (Exception e) {
   		 System.err.println("Couldn't find this image: " + imageName);
   	 }
   	 repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
   	 g.drawImage(fortuneTellerImage, 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}