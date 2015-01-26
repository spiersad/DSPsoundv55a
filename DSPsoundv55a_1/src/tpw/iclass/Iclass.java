/*
 * Iclass.java
 *
 * Created on August 15, 2006, 5:55 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package tpw.iclass;

import java.awt.*;  //needed for Graphics class inclusion
import javax.imageio.*;  //needed for ImageIO
import java.awt.image.*;  //needed for BufferedImage
import java.io.*;  //needed for File

/**
 *
 * @author Owner
 */
public class Iclass {
    
    	private int Ixdim;		//dimensions of image
	private int Iydim;
	private int[][] Iarray;	//pointer to first data (int)
 	private String Iname;		//name of image

    
    
    /** Creates a new instance of Iclass */
    public Iclass() {
        
       	Ixdim = 2;
	Iydim = 2;
 	Iarray = new int[Ixdim][Iydim];		//why not
 	
	Iname = new  String("unnamed");    
   

        
    }
  
    

    
   //    Function:  Iclass(int x, int y)  
//    		partial constructor, allocates memory, name="unnamed"
//    		Example: Iclass a(2,2);
 public Iclass(int x, int y)  //partial constructor
{

if( (x<1) || (y<1) ) // null array
	{
	System.out.println("null array assignment in  Iclass(int x, int y)  \n"
              + " x=" + x + " y=" + y + "\n");
	Runtime.getRuntime().exit(1);
	}
else	{
	
	Ixdim = x;
	Iydim = y;
	Iarray = new int[x][y];
	for (int xx = 0; xx < Ixdim; xx++)
		for (int yy = 0; yy < Iydim ; yy++)
		Iarray[xx][yy] = 0;
	Iname = new  String("unnamed");
	}
}


//    
//    Function:  Iclass(const Iclass& im) 
//    		copy constructor
//    		Example: Iclass a(b);
 public  Iclass(Iclass im)  //copy constructor
{

if( (im.Ixdim <=  0) || (im.Iydim <= 0) || 
		im.Iname == null ||
	 	im.Iarray ==  null ) // null array
	{
	System.out.println( "null  assignment in  Iclass(Iclass& im)  \n" 
            + " im.Ixdim=" + im.Ixdim+ " im.ydim=" 
            + im.Iydim + " im.Iarray="   + im.Iarray + "\n");
	Runtime.getRuntime().exit(1);
	}
else	{
	Ixdim = im.Ixdim;
	Iydim = im.Iydim;
	Iarray = new int[Ixdim][Iydim] ;
	for (int xx = 0; xx < Ixdim; xx++)
		for (int yy = 0; yy < Iydim ; yy++)
		 Iarray[xx][yy] = im.Iarray[xx][yy];
	Iname = new String(im.name());
	 
	}

}
 
 
 
//   
//    GET DATA FROM OBJECT *******************************************
//   


	public String name()			//return name
		{return Iname;}
        
	public int getxdim()
		{return Ixdim;}
        
	public int getydim()
		{return Iydim;}
        
	public int[][] getiarray()
		{return Iarray;}

	
 
//    
//    Function: int  getel(int x, int y)
//    		returns value of element x,y in Iclass
//    		Example: i.getel(1,1);
public int getel(int x, int y)
{
 if ( (x >= 0) && (x < Ixdim) && (y >= 0) && (y < Iydim))
 	return Iarray[x][y];
 else
	{System.out.println( "access element  getel(int x, int y)"  +  x  +  "," 
	 +  y  +  " out of range in Iarray "  +  Iname  +  "\n"); 
         Runtime.getRuntime().exit(1);return Iarray[x][y];}
}


//    
//    LOAD DATA INTO OBJECT ************************************************
//    

//    
//    Function:  void  setel(int x, int y, int c)
//    		sets value of element x,y in Iclass to c
//    
public void  setel(int x, int y, int c)
{
 if ( (x >= 0) && (x < Ixdim) && (y >= 0) && (y < Iydim))
 	Iarray[x][y]=c;
 else
	{System.out.println( "access element  setel(int x, int y, int c)"  +  x  +  "," 
	 +  y  +  " out of range in Iarray "  +  Iname  +  "\n"); 
         Runtime.getRuntime().exit(1);}
}

public void  dplus(int x, int y, int g)
{
 if ( (x >= 5) && (x < Ixdim -5) && (y >= 5) && (y < Iydim-5))
 	{
	for (int xx = x-3; xx < x+3; xx++)
		Iarray[xx][y] = g;
	for (int yy = y-3; yy < y+3 ; yy++)
		Iarray[x][yy] = g;

	}

 else
	{System.out.println( "access element  dplus(int x, int y, int g)"  +  x  +  "," 
	 +  y  +  " out of range in Iarray "  +  Iname  +  "\n"); 
         Runtime.getRuntime().exit(1);}
}


//    
//    IO ************************************************
//    


//     
//     Function: void  loadimage( char * name)
//     		loads a file into an image array
//     		Example: Iclass i5(2,2);
//     		i5.loadimage("file.img");
//     		
public void  loadimage( String name)	//load image file
{
    
    
//System.out.println("enter loadimage\n";
if( (Ixdim ==  0) || (Iydim == 0) ||
	 (Iarray == null) ||
	(name == null)  ) // null array
	{
	System.out.println( "null array assignment in  loadimage( int * name)  \n"
                + " Ixdim="  +  Ixdim +  " Iydim=" 
                + Iydim  +  " Iarray="  + Iarray  + "\n");
	Runtime.getRuntime().exit(1);
	}
else	
if( (name == null) || (name.length()<1) )
	{System.out.println( "bad filename in  loadimage(  char * name)\n"
                + "stringlength="  + name.length() + " name=" + name + "\n");
	}
else
	{

    
  /*  
    int size;
	int[][] p;
	char * cp;
	p= (*this).Iarray;
	size=(*this).Ixdim * (*this).Iydim;

	ifstream  infile;
	infile.open( name );
	if ( infile.fail() )
		{
		fputs("ERROR void  loadimage( char * name)", stderr);
		fprintf(stderr, "  file name=%s ", name);
		}
	infile.read( (char *) p,size);
	infile.close();
  */
    

    BufferedImage buffImg =null ;
    ImageIO imgIo = null;

        File   inFile = new File(name); 
        int ioflag = 0;
       
        try { buffImg = imgIo.read(inFile) ; }
          catch (IOException e) {
              System.out.println("Iclass::loadimage IOException="+e
                      + " file=" +name);
              ioflag=1;
                 
              }
      
        if(ioflag == 0)
        {
            int rgb=0, alpha=0, red=0, green=0, blue=0,gray=0;
            Ixdim=buffImg.getWidth();
            Iydim=buffImg.getHeight();
            Iarray=new int[buffImg.getWidth()][buffImg.getHeight()];
            Graphics gg = buffImg.createGraphics();
 
            
            
            for(int xx = 0; xx<buffImg.getWidth() ;xx++)
            for(int yy = 0; yy<buffImg.getHeight() ;yy++)
              {
            
                   rgb = buffImg.getRGB(xx, yy) ;  //read pixel
                   alpha = ((rgb >> 24) & 0xff);
                   red = ((rgb >> 16) & 0xff);
                   green = ((rgb >> 8) & 0xff);
                   blue = ((rgb ) & 0xff);
                   //System.out.println("yy="+ yy +" pix=" + buffImg.getRGB(xx, yy)
                    //    + " red=" + red + " green="  + green + " blue=" + blue
                    //    +" alpha=" +alpha );         
                   //rgb = (a << 24) | (r << 16) | (g << 8) | b;
                   //buffImg.setRGB(xx, yy, rgb);    //write pixel
                  Iarray[xx][yy]=(int)(Math.sqrt(red*red+green*green+blue*blue)/
                          Math.sqrt(3.0) ); 
              }
          }
             
    
        }
  
}



//     
//     Function: void  writeimage( char * name)
//     		writes image array to a file
//     		Example: Iclass i5(2,2);
//     		i5.writeimage("file.img");
//     		
/*public void  writeimage( String name)	//save image file
{
if( (Ixdim ==  0) || (Iydim == 0) || 
	(Iarray ==  null ||
	(name == null) ) // null array
	{
	System.out.println( "null array assignment in  writeimage( int * name)  \n";
	System.out.println( " Ixdim="  +  Ixdim +  " Iydim=" 
	 + Iydim  +  " Iarray="  + Iarray  + "\n";
	Runtime.getRuntime().exit(1);
	}
else	
if( (name == null) || (strlen(name)<1) )
	{System.out.println( "bad filename in  writeimage( int * name)\n";
	System.out.println( "stringlength="  + strlen(name) + " name=" + name + "\n";
	}
else
	{
	int size;
	int * p;
	p= (*this).Iarray;

	size=(*this).Ixdim * (*this).Iydim;

	ofstream outfile;
	outfile.open(name);
	outfile.write( (char *) p,size);
	if (outfile.fail())
		{System.out.println( "failure writing " + 
		Ixdim +  "x"  +  Iydim  +  " file "  +  name  +  
		" in  writeimage( char * name) \n";
		Runtime.getRuntime().exit(1);}
	outfile.close();
	}	
}

*/


//    
//    Functions ************************************************
//    



//    
//    Function: Iclass&   operator=(Iclass& im)
//    		overloaded equals operator:
//		not very sophisticated
//    
public  void equals(Iclass im)
{


if( (im.Ixdim ==  0) || (im.Iydim == 0) ||
	(im.name() ==  null) || 
	(im.Iarray ==  null)) // null array
	{
	System.out.println( "null array assignment in  operator= \n"
                + " im.Ixdim="  +  im.Ixdim +  " im.Iydim=" 
            + im.Iydim  +  " im.Iarray="  + im.Iarray  + "\n");
	Runtime.getRuntime().exit(1);
	}
else
	{
	Ixdim = im.Ixdim ;
	Iydim = im.Iydim  ;
	//if(Iarray != null delete  Iarray;
	Iarray = new int[Ixdim][Iydim];
	for (int xx = 0; xx < Ixdim; xx++)
		for (int yy = 0; yy < Iydim ; yy++)
		 Iarray[xx][yy]= im.Iarray[xx][yy];
	//if(Iname != null) delete Iname;
	Iname = new  String(im.name());
	//return this;
	}

}



//    
//    Function: Iclass   operator+(int x)
//    		add int value to all Iclass elements
//
public   void plus(int x)
{
if( (Ixdim ==  0) || (Iydim == 0) || 
		(Iarray== null ) )// null array

	{
	System.out.println( "null array assignment in  operator+(int x) \n");
	Runtime.getRuntime().exit(1);
        //return this;
	}

else	
	{
	int cx=(int ) x;
	Iclass im = new Iclass(this);
	for (int xx = 0; xx < Ixdim; xx++)
		for (int yy = 0; yy < Iydim ; yy++)
		 Iarray[xx][yy] =  im.Iarray[xx][yy]+cx;
	//return this;
	}

}


//    
//    Function: Iclass   operator+(Iclass& x)
//
public    void plus(Iclass x)
{
if( (Ixdim ==  0) || (Iydim == 0) || (Iarray== null) ||
		(x.Ixdim ==  0) || (x.Iydim == 0) ||
		 (x.Iarray== null ) )// null array
	{
	System.out.println( "null array assignment in  operator+(Iclass& x) \n");
	Runtime.getRuntime().exit(1);
        //return this;
	}
else
if( (Ixdim ==  x.Ixdim) && (Iydim == x.Iydim) )  //same size array
	{
	Iclass im = new Iclass(this);
	for (int xx = 0; xx < Ixdim; xx++)
		for (int yy = 0; yy < Iydim ; yy++)
		 Iarray[xx][yy] =  Iarray[xx][yy] + im.Iarray[xx][yy] ;
	//if (Iname != null) delete Iname;
	Iname = new String("unamed");
	//return this;
	}
else 
	{
	System.out.println( "error dropthrough all tests in  operator+(Iclass x) \n");
	Runtime.getRuntime().exit(1);
        //return this;
	}
}




 
 
 
	
     
    
    
    
    
    
    
    
    
}
