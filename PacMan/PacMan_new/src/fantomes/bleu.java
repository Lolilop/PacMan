package fantomes;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



public class bleu {
    
    private int cmp = 0; //compteur des vul
    private int cmpy = 0; // compteur des yeux 
    private int cmpImage = 6; //Compteur d'images (déplacement)
    private int x = 140 ,y = 120; //Position (x,y) du fantome
    private int posX = 14 ,posY = 12; //Position (x,y) fantome
    
    /*
        Variables BOOLEAN (false,true)
    */
    
    private boolean isPower = false; //Super power (possibilité de manger les fantomes 
    private boolean eat = false; //Fantomes manger ?  
    
    /*
        Variables tableaux d'images
    */
  
    private Image[] fantome = new Image[8]; //Image du fantome
    private Image[] vul = new Image[2]; // Image de vul
    private Image[] yeux = new Image[4]; // Image des yeux apres le fantomes mangé 
    
    public bleu() throws IOException {
        
        Image();
    }
    
    /*##########################################################################
    #                                  GETEUR                                  #
    ##########################################################################*/
    

    public int getCmpImage() {
        return this.cmpImage;
    }

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getPosX() {
        return this.posX;
    }
    
    public int getPosY() {
        return this.posY;
    }
    
    public boolean getPower() {
        return this.isPower;
    }
    
    
    public boolean getEat() {
        return this.eat;
    }
    
    /*##########################################################################
    #                                  SETEUR                                  #
    ##########################################################################*/

    
    public void setCmpImage(int image) {
        this.cmpImage = image;
    }
    
    public void setcmpy(int image) {
        this.cmpy = image;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setPosX(int x) {
        this.posX = x;
    }
    
    public void setPosY(int y) {
        this.posY = y;
    }
    
    public void setPower(boolean power) {
        this.isPower = power;
    }
    
    public void setEat(boolean power) {
        this.eat = power;
    }
    
    /*##########################################################################
    #                                 METHODE                                  #
    ##########################################################################*/
    
    /*
        remplis le tableau d'image 2D du pacMan
    */
    
    public void Image() throws IOException {
        
        String path = "src/img/ghosts/blue ghost/";
        
           for(byte i = 0; i < fantome.length ; i++) {
                   fantome[i] = ImageIO.read(new File(path + i + ".png"));
  
           }
           
        path = "src/img/ghosts/vulnerable ghost/";
        
           for(byte i = 0; i < vul.length ; i++) {
                   vul[i] = ImageIO.read(new File(path + i + ".png"));
  
           }
           
        path = "src/img/ghosts/yeux/";
        
           for(byte i = 0; i < yeux.length ; i++) {
                   yeux[i] = ImageIO.read(new File(path + i + ".png"));
  
           }
           
   }
    
   public void drawImage(Graphics g) {
       
       if(isPower == false && eat == false) {
          g.drawImage(fantome[cmpImage], x, y, null); 
       } else if(isPower == true && eat == false)  {
           if(cmp == 0) {
             g.drawImage(vul[1], x, y, null); 
             cmp++;
           } else {
              g.drawImage(vul[0], x, y, null); 
             cmp--; 
           }
           
       } else if (isPower == true && eat == true) {
           g.drawImage(yeux[cmpy], x, y, null); 
       }
       
   }

    
}

