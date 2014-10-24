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

public class OldMacDonald extends PApplet {

//your variable declarations here
public void setup() 
{    
    // Cow c = new Cow("cow", "moo");   
    // System.out.println(c.getType() + " goes " + c.getSound());  
    // Chick a = new Chick("chick", "cheep", "cluck");   
    // System.out.println(a.getType() + " goes " + a.getSound());  
    // Pig b = new Pig("pig", "oink");   
    // System.out.println(b.getType() + " goes " + b.getSound());  

    Farm f = new Farm();
    f.animalSounds();
}

interface Animal 
  {    
    public String getSound();        
    public String getType(); 
  }   

class Cow implements Animal 
{     
  protected String myType;     
  protected String mySound;      
  public Cow(String type, String sound)    
  {         
     myType = type;         
     mySound = sound;     
  }     
  public Cow()    
  {         
     myType = "unknown";         
     mySound = "unknown";     
  }      
  public String getSound(){
    return mySound;
  }     

  public String getType(){
    return myType;
  } 
}

class NamedCow extends Cow{
  private String myName;
  public NamedCow(String type, String name, String sound){
    myName = name;
    myType = type;
    mySound = sound;
  }

  public String getName(){
    return myName;
  }
}

class Pig implements Animal 
{     
  private String myType;     
  private String mySound;      
  public Pig(String type, String sound)    
  {         
     myType = type;         
     mySound = sound;     
  }     
  public Pig()    
  {         
     myType = "unknown";         
     mySound = "unknown";     
  }      
  public String getSound(){return mySound;}     
  public String getType(){return myType;} 
}

class Chick implements Animal 
{     
  private String myType;     
  private String mySound; 
  private String mySoundTwo;
  private int num;      
  public Chick(String type, String sound, String soundTwo)    
  {         
     myType = type;         
     mySound = sound;
     mySoundTwo = soundTwo;
     num = (int)(Math.random()*2)+1;
  }     
  public Chick()    
  {         
     myType = "unknown";         
     mySound = "unknown";     
  }    

  public String getSound(){
    if (num == 1){
      return mySound;
    }
    else{
      return mySoundTwo;
    }
  }    

  public String getType(){
    return myType;
  } 
}

class Farm 
{     
  private Animal[] aBunchOfAnimals = new Animal[3];    
  public Farm()    
  {       
   aBunchOfAnimals[0] = new NamedCow("cow","Elsie","moo");          
   aBunchOfAnimals[1] = new Chick("chick","cheep","cluck");
   aBunchOfAnimals[2] = new Pig("pig","oink");    
  }     
  public void animalSounds()    
  {
    for (int nI=0; nI < aBunchOfAnimals.length; nI++) 
    {             
       System.out.println( aBunchOfAnimals[nI].getType() + " goes " + aBunchOfAnimals[nI].getSound() );       
    }       
    System.out.println( "The cow is known as " + ((NamedCow)aBunchOfAnimals[0]).getName() );    
  } 
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OldMacDonald" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
