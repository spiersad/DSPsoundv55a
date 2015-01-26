/*
 * Fclass.java
 *
 * Created on August 15, 2006, 5:54 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package tpw.fclass;

import tpw.iclass.*;  //needed for Graphics class inclusion


/**
 *
 * @author Owner
 */
public class Fclass {
   
   	private int Fxdim;		//dimensions of image
	private int Fydim;
	private float Re[][];	//pointer to first real data (float)
	private float Im[][];	//pointer to first imaginary data (float)
 	private String Fname;		//name of image
	
 
    
   
    
    
    
   //default constructor//default constructor
    /** Creates a new instance of Fclass */
    public Fclass() {
        
  	Fxdim = 2;
	Fydim = 2;
 	Re = new float[Fxdim][Fydim];		//why not
 	Im = new float[Fxdim][Fydim];		//why not
	Fname = new  String("unnamed");    
       
    }
 

//    Function:  Fclass(int x, int y)  
//    		partial constructor, allocates memory, name="unnamed"
//    		Example: Fclass a(2,2);
 public  Fclass(int x, int y)  //partial constructor
{
	
if( (x<1) || (y<1) ) // null array
	{
	System.out.println( "null array assignment in  Fclass(int x, int y)  \n"
                + " x="  +  x +  " y="  + y  + "\n");
	Runtime.getRuntime().exit(1);
	}
else	{
	
	Fxdim = x;
	Fydim = y;
	Re = new float[x][y];
	Im = new float[x][y];
	for (int xx = 0; xx < Fxdim; xx++)
		for (int yy = 0; yy < Fydim ; yy++)
                {Re[xx][yy] = 0;
		Im[xx][yy] = 0;
		}
	Fname = new  String("unnamed");

	}

 }

//    
//    Function:  Fclass(const Fclass& im) 
//    		copy constructor
//    		Example: Fclass a(b);
 public  Fclass(Fclass im)  //copy constructor
{
	
if( (im.Fxdim <=  0) || (im.Fydim <= 0) || 
		(im.Fname == null) ||
	 	(im.Re ==  null)   ||
	 	(im.Im ==  null) ) // null array
	{
	System.out.println( "null  assignment in  Fclass(Fclass& im)  \n"
                + " im.Fxdim="  +  im.Fxdim +  " im.ydim=" 
            + im.Fydim  +  " im.Re="  + im.Re  + "\n");
	Runtime.getRuntime().exit(1);
	}
else	{

	Fxdim = im.Fxdim;
	Fydim = im.Fydim;
	Re = new float[Fxdim][Fydim];
	Im = new float[Fxdim][Fydim];
	for (int xx = 0; xx < Fxdim; xx++)
		for (int yy = 0; yy < Fydim ; yy++)
		{
		Re[xx][yy] = im.Re[xx][yy];
		Im[xx][yy] = im.Im[xx][yy];
		}
	Fname = new  String("unnamed");	
	}
     
}
	



//   
//    GET DATA FROM OBJECT *******************************************
//   


	public String name()			//return name
		{return Fname;}
 



//    
//    Function: float  getelre(int x, int y)
//    		returns real value of element x,y in Fclass
//    		Example: i.getelre(1,1);
float  getelre(int x, int y)
{
 if ( (x >= 0) && (x < Fxdim) && (y >= 0) && (y < Fydim))
 	return Re[x][y];
 else
	{System.out.println( "access element  getelre(int x, int y)"  +  x  +  "," 
	 +  y  +  " out of range in Re "  +  Fname  +  "\n"); 
         Runtime.getRuntime().exit(1); return (float)0.0;}
}

//    
//    Function: float  getelre(int x, int y)
//    		returns imaginary value of element x,y in Fclass
//    		Example: i.getelim(1,1);
float  getelim(int x, int y)
{
 if ( (x >= 0) && (x < Fxdim) && (y >= 0) && (y < Fydim))
 	return Im[x][y];
 else
	{System.out.println( "access element  getelim(int x, int y)"  +  x  +  "," 
	 +  y  +  " out of range in Im "  +  Fname  +  "\n"); 
         Runtime.getRuntime().exit(1); return (float)0.0; }
}


//    
//    LOAD DATA INTO OBJECT ************************************************
//    

//    
//    Function:  void  setelre(int x, int y, float c)
//    		sets real value of element x,y in Fclass to c
//    
void  setelre(int x, int y, float c)
{
 if ( (x >= 0) && (x < Fxdim) && (y >= 0) && (y < Fydim))
 	Re[x][y]=c;
 else
	{System.out.println( "access element  setelre(int x, int y, float c)"  
                 +  x  +  "," 
	 +  y  +  " out of range in Re "  +  Fname  +  "\n"); 
         Runtime.getRuntime().exit(1);}
}


//    
//    Function:  void  setelim(int x, int y, float c)
//    		sets imaginary value of element x,y in Fclass to c
//    
void  setelim(int x, int y, float c)
{
 if ( (x >= 0) && (x < Fxdim) && (y >= 0) && (y < Fydim))
 	Im[x][y]=c;
 else
	{System.out.println( "access element  setelim(int x, int y, float c)"  +  x  +  "," 
	 +  y  +  " out of range in Im "  +  Fname  +  "\n"); 
         Runtime.getRuntime().exit(1);}
}

//    
//    IO ************************************************
//    


//    
//    Functions ************************************************
//    



//    
//    Function: Fclass&   operator=(Fclass& im)
//    		overloaded equals operator:
//		not very sophisticated
//    
public void   equals(Fclass im)
{
	
if( (im.Fxdim ==  0) || (im.Fydim == 0) ||
	(im.name() ==  null) || 
	(im.Re ==  null)|| 
	(im.Im ==  null)  ) // null array
	{
	System.out.println( "null array assignment in  operator= \n"
                + " im.Fxdim="  +  im.Fxdim +  " im.Fydim=" 
                + im.Fydim  +  " im.Re="  + im.Re  +  " im.Im="  + im.Im  + "\n");
	Runtime.getRuntime().exit(1);
	}
else
	{
	Fxdim = im.Fxdim ;
	Fydim = im.Fydim  ;
	//if(Re != null) delete  Re;
	Re = new float[Fxdim][Fydim];
	//if(Im != null) delete  Im;
	Im = new float[Fxdim][Fydim];
	for (int xx = 0; xx < Fxdim; xx++)
		for (int yy = 0; yy < Fydim ; yy++)
		{
		 Re[xx][yy]= im.Re[xx][yy];
		 Im[xx][yy]= im.Im[xx][yy];
		}
	//return this;
	}

}




//    
//    Function: Fclass&   operator=(Fclass& im)
//    		overloaded equals operator:
//		not very sophisticated
//    
public void   equals(Iclass im)
{

if( (im.getxdim() ==  0) || (im.getydim() == 0) ||
	(im.name() ==  null) || 
	(im.getiarray() ==  null ) 
	  ) // null array
	{
	System.out.println( "null array assignment in  operator= \n"
                + " im.getxdim()="  +  im.getxdim() +  " im.getydim()=" 
            + im.getydim()  +  " im.getiarray()="  + im.getiarray()   + "\n");
	Runtime.getRuntime().exit(1);
	}
else
	{
	Fxdim = im.getxdim() ;
	Fydim = im.getydim()  ;
	//if(Re != null) delete  Re;
	Re = new float[Fxdim][Fydim];
	//if(Im != null) delete  Im;
	Im = new float[Fxdim][Fydim];
	for (int xx = 0; xx < Fxdim; xx++)
		for (int yy = 0; yy < Fydim ; yy++)
		{
		 Re[xx][yy]= im.getel(xx,yy);
		 Im[xx][yy]= 0;
		}
	//if(Fname != (char *) 0) delete Fname;
	Fname = new  String(im.name());
	//return *this;
	}

}

//    
public Iclass   logmag()
{

if( (this.Fxdim ==  0) || (this.Fydim == 0) ||
	(this.name() ==  null)  
	  ) // null array
	{
	System.out.println( "null array assignment in  logmag \n"
                + " im.getxdim()="  +  this.Fxdim +  " im.getydim()=" 
            + this.Fydim    + "\n");
	Runtime.getRuntime().exit(1);
	}
else
	{
        Fclass x = new Fclass(this);
        float max=0,min=0;
	for (int xx = 0; xx < Fxdim; xx++)
		for (int yy = 0; yy < Fydim ; yy++)
		{
		 x.Re[xx][yy]= (float)(  (Re[xx][yy]*Re[xx][yy]
                         +Im[xx][yy]*Im[xx][yy]) );
		 x.Im[xx][yy]= (float) 0.0;
		}
	for (int xx = 0; xx < Fxdim; xx++)
		for (int yy = 0; yy < Fydim ; yy++)
		{
		 if (x.Re[xx][yy] > max)  max = x.Re[xx][yy];
		 if (x.Re[xx][yy] < min)  min = x.Re[xx][yy] ;
		}
        System.out.println( "Fclass::logmag mag max="+max+" min="+min+"\n");
 
        if (max == min) max=min+1;
        float scale=1/max;
        Iclass im = new Iclass(x.Fxdim,x.Fydim);
	for (int xx = 0; xx < Fxdim; xx++)
		for (int yy = 0; yy < Fydim ; yy++)
		{
		 x.Re[xx][yy] = (float)Math.log10( 1e8*(x.Re[xx][yy] + max/1e9)*scale +1 )*30;
                 im.setel(xx, yy, (int)x.Re[xx][yy]);
		}
        
        
        max=0; min=0;
	for (int xx = 0; xx < Fxdim; xx++)
		for (int yy = 0; yy < Fydim ; yy++)
		{
		 if (im.getel(xx,yy) > max)  max = im.getel(xx,yy);
		 if (im.getel(xx,yy) < min)  min = im.getel(xx,yy) ;
		}
        System.out.println( "Fclass::logmag logmag max="+max+" min="+min+"\n");
        
	//if(Fname != (char *) 0) delete Fname;
	//Fname = new  String(im.name());
		return im;
    }
return new Iclass();
}



//    average of real part
public float   avgRe()
{

if( (this.Fxdim ==  0) || (this.Fydim == 0) ||
	(this.name() ==  null)  
	  ) // null array
	{
	System.out.println( "null array assignment in  avg \n"
                + " im.getxdim()="  +  this.Fxdim +  " im.getydim()=" 
            + this.Fydim    + "\n");
	Runtime.getRuntime().exit(1); return 0;
	}
else
	{
        
        float sum=0,avg=0;
	for (int xx = 0; xx < Fxdim; xx++)
		for (int yy = 0; yy < Fydim ; yy++)
		{
		 sum= (float)(  sum + (Re[xx][yy]) );
		}
        avg=sum/(Fxdim * Fydim);
        return avg;
    }

}







//    
//    Function: void  cvtimg(Iclass & im)
//    		writes real contents into image
//		not very sophisticated
//    
public void  cvtimg(Iclass im)
{


if( (im.getxdim() ==  0) || (im.getydim() == 0) ||
	(im.name() ==  null) || 
	(im.getiarray() ==  null) 
	 || (  im.getxdim() != Fxdim  )  
	 || (  im.getydim() != Fydim  )  
	) // null array
	{
	System.out.println( "null array assignment in  cvtimg \n"
                + " im.getxdim()="  +  im.getxdim() +  " im.getydim()=" 
	 + im.getydim()  +  " im.getiarray()="  +  im.getiarray()  + "\n"
	 +  "Fxdim=" + Fxdim + " Fydim=" + Fydim + " im.name()=" +  im.name()  
         + "\n");
	Runtime.getRuntime().exit(1);
	}
else
	{
	int xx,yy;
	float max,min,z;
	max=(this).getelre(0,0);
	min=(this).getelre(0,0);
	
	for ( xx = 0; xx < Fxdim; xx++)
		for ( yy = 0; yy < Fydim ; yy++)
		{
		if (max< Re[xx][yy]) 
			max=Re[xx][yy];
		if (min> Re[xx][yy]) 
			min=Re[xx][yy];
		}
	System.out.println("max=" + max + "min=" + min + "\n");

	if (max==min) min=max-1;
	for ( xx = 0; xx < Fxdim; xx++)
		for ( yy = 0; yy < Fydim ; yy++)
		{
		z=Re[xx][yy];
		z= 255 *(z-min)/(max-min);
		im.setel(xx,yy, (int)z);
		}

	}

}



//    
//    Function: Fclass   operator+(int x)
//    		add int value to all Fclass elements
//
public void   plus(int x)
{
if( (Fxdim ==  0) || (Fydim == 0) || 
		(Re== null) ) // null array

	{
	System.out.println( "null array assignment in  operator+(int x) \n");
	Runtime.getRuntime().exit(1);
	}

else	
	{
	float cx=(float ) x;
	Fclass im = new Fclass(this);
	for (int xx = 0; xx < Fxdim; xx++)
		for (int yy = 0; yy < Fydim ; yy++)
		 Re[xx][yy] =  im.Re[xx][yy]+cx;
	//return this;
	}
}

//    
//    Function: Fclass   operator+(int x)
//    		add int value to all Fclass elements
//
public void   plus(float x)
{
if( (Fxdim ==  0) || (Fydim == 0) || 
		(Re== null) ) // null array

	{
	System.out.println( "null array assignment in  operator+(int x) \n");
	Runtime.getRuntime().exit(1);
	}

else	
	{	
	Fclass im = new Fclass(this);
	for (int xx = 0; xx < Fxdim; xx++)
		for (int yy = 0; yy < Fydim ; yy++)
		 Re[xx][yy] =  im.Re[xx][yy]+x;
	//return this;
	}
}


//    
//    Function: Fclass   operator+(Fclass& x)
//
public void    plus(Fclass x)
{
if( (Fxdim ==  0) || (Fydim == 0) || (Re== null) ||
		(x.Fxdim ==  0) || (x.Fydim == 0) ||
		 (x.Re== null )) // null array
	{
	System.out.println( "null array assignment in  operator+(Fclass& x) \n");
	Runtime.getRuntime().exit(1);
	}
else
if( (Fxdim ==  x.Fxdim) && (Fydim == x.Fydim) )  //same size array
	{
	Fclass im = new Fclass(this);
	for (int xx = 0; xx < Fxdim; xx++)
		for (int yy = 0; yy < Fydim ; yy++)
		{
		 Re[xx][yy]= Re[xx][yy] + x.Re[xx][yy];
		Im[xx][yy]= Im[xx][yy] + x.Im[xx][yy];
		}
	//if (Fname != (char *) 0) delete Fname;
	Fname = new String("unamed");
	//return this;
	}
else 
	{
	System.out.println( "error dropthrough all tests in  operator+(Fclass x) \n");
	Runtime.getRuntime().exit(1);
	}
}





//    
//    Function: Fclass   operator*(Fclass& x)
//
public void   times(Fclass x)
{
if( (Fxdim ==  0) || (Fydim == 0) || (Re== null ) ||
		(x.Fxdim ==  0) || (x.Fydim == 0) ||
		 (x.Re== null ) ) // null array
	{
	System.out.println( "null array assignment in  operator+(Fclass& x) \n");
	Runtime.getRuntime().exit(1);
	}
else
if( (Fxdim ==  x.Fxdim) && (Fydim == x.Fydim) )  //same size array
	{
	Fclass im = new Fclass(this);
	for (int xx = 0; xx < Fxdim; xx++)
		for (int yy = 0; yy < Fydim ; yy++)
		{
		 Re[xx][yy]= Re[xx][yy] * x.Re[xx][yy]
                            -Im[xx][yy] * x.Im[xx][yy];
		Im[xx][yy]= Re[xx][yy] + x.Im[xx][yy]
                            + Im[xx][yy] * x.Re[xx][yy];
		}
	//if (Fname != (char *) 0) delete Fname;
	Fname = new String("unamed");
	//return this;
	}
else 
	{
	System.out.println( "error dropthrough all tests in  operator+(Fclass x) \n");
	Runtime.getRuntime().exit(1);
	}    
    
}

//
//
// Students in eegr6118 may make copies and modify them 
//for the purposes of their course  projects .
//Any other use of this file is prohibited.
//
// a VERY rough draft FFT for 2-D images
// 
//

public Fclass fft()
{


	if ( (this).Fxdim <= 0)
		{
		System.out.println( "error n <= 0 in "   +  
		"Fclass::fftoned()\n"   + 
		"n="  + (float)Fxdim  + "\n");
		Runtime.getRuntime().exit(1);
                return this;
		}

 	int xx,yy;

	Fclass im= new Fclass(this);

	Fclass row = new Fclass( im.Fxdim , 1);

	for ( xx = 0; xx < im.Fxdim; xx++)
	{
	for ( yy= 0; yy < im.Fydim; yy++)
		{ 
		row.setelre(yy,0, im.getelre(yy,xx) );
		row.setelim(yy,0, im.getelim(yy,xx) );
		}
	row.equals(row.fftoned());
	for ( yy= 0; yy < im.Fydim; yy++)
		{ 
		im.setelre(yy,xx, row.getelre(yy,0) );
		im.setelim(yy,xx, row.getelim(yy,0) );
		}
	}
 	im.equals(im.transpose());
 	for ( xx = 0; xx < im.Fxdim; xx++)
	{
	for ( yy= 0; yy < im.Fydim; yy++)
		{ 
		row.setelre(yy,0, im.getelre(yy,xx) );
		row.setelim(yy,0, im.getelim(yy,xx) );
		}
	row.equals(row.fftoned());
	for ( yy= 0; yy < im.Fydim; yy++)
		{ 
		im.setelre(yy,xx, row.getelre(yy,0) );
		im.setelim(yy,xx, row.getelim(yy,0) );
		}
	}
	im.equals(im.transpose());

	return im;

}


public Fclass ifft()
{

	if ( (this).Fxdim <= 0)
		{
		System.out.println( "error n <= 0 in "   +  
		"Fclass::fftoned()\n"   + 
		"n="  + (float)Fxdim  + "\n");
		Runtime.getRuntime().exit(1);
		}

 	int xx,yy;

	Fclass im= new Fclass(this);

	Fclass row= new Fclass( im.Fxdim , 1);

	for ( xx = 0; xx < im.Fxdim; xx++)
	{
	for ( yy= 0; yy < im.Fydim; yy++)
		{ 
		row.setelre(yy,0, im.getelre(yy,xx) );
		row.setelim(yy,0, im.getelim(yy,xx) );
		}
	row.equals(row.ifftoned());
	for ( yy= 0; yy < im.Fydim; yy++)
		{ 
		im.setelre(yy,xx, row.getelre(yy,0) );
		im.setelim(yy,xx, row.getelim(yy,0) );
		}
	}
 
	im.equals(im.transpose());
  
	for ( xx = 0; xx < im.Fxdim; xx++)
	{
	for ( yy= 0; yy < im.Fydim; yy++)
		{ 
		row.setelre(yy,0, im.getelre(yy,xx) );
		row.setelim(yy,0, im.getelim(yy,xx) );
		}
	row.equals(row.ifftoned());
	for ( yy= 0; yy < im.Fydim; yy++)
		{ 
		im.setelre(yy,xx, row.getelre(yy,0) );
		im.setelim(yy,xx, row.getelim(yy,0) );
		}
	}
	im.equals(im.transpose());

	return im;

}

public Fclass transpose()
{
	Fclass im = new Fclass(Fydim,Fxdim);
	for (int xx = 0; xx < Fxdim; xx++)
		for (int yy = 0; yy < Fydim ; yy++)
		{
		 im.Re[xx][yy]= Re[yy][xx];
		 im.Im[xx][yy]= Im[yy][xx];
            //*(im.Re + yy * im.Fydim + xx)= 
		//*(Re + xx * Fydim + yy) ;
		 //*(im.Im + yy * im.Fydim + xx)= 
		//*(Im + xx * Fydim + yy) ;
		}
 	return im;

}


public Fclass fftoned()
{

	if ( (this).Fxdim <= 0)
		{
		System.out.println( "error n <= 0 in "   +  
		"Fclass::fftoned()\n"   + 
		"n="  + (float) Fxdim   + "\n");
		Runtime.getRuntime().exit(1);
		}

	Fclass t1 = new Fclass(this);
		t1.equals(t1.fftoned2(0));
		return t1;

}


public Fclass  ifftoned()
{

	Fclass t1= new Fclass(this);

		t1.equals(t1.fftoned2(1));
		return t1;

}



//
// 	1-D FFT routine
// 	
// 	assumes xdimension is power of 2, ydimension=1
//

public Fclass fftoned2(int inv)		//inverse if inv !=0
{

				//copyright 1995, Thomas Weldon,
				//allrights reserved


	if ( ( (this).Fxdim <= 0 ) || ( (this).Fydim != 1 )  )
		{
		System.out.println( "error n <= 0 in "   +  
		"Fclass::fftoned2()\n"   + 
		"n="  + (float) Fxdim   + "\n");
		Runtime.getRuntime().exit(1);
                return this;
		}

	int prime=2;			//prime factor of this routine
	int N= (this).Fxdim;				//fftoned size
	int maxpow=20;			//max size=prime^maxpower
	int pown;			//actual power; N=prime^pown
	double pi=3.141592654;
	int a,b,i1,i2,flag;		//dummy vars
	int nn,kk,arg;			//more dummies
	int mask1,mask2;		//bit reversal mask
	int fwd,rev;			//fwd and bit reverse
	int rr,offset;			//buterfly level
	Fclass w0 = new Fclass(this);		// array of all possible angles
//	Fclass wk( *this );		// array particular twiddle factors 
	float topsumre,topsumim,botsumre,botsumim;	// butter dummies
	float topre,topim,botre,botim;		    //butter dummies
	int groups,gcnt,gsize,butcnt,numbut,kn;		//butter dummies

        Fclass t1 = new Fclass(this);
	N= (this).Fxdim;

		
	i1=1; flag=1; pown=0;		//first check for power of prime
	for ( a=0; a < maxpow; a++)
		{
		i1=i1*prime;
		if (i1==N) 
			{flag=0; pown=a+1;}
		}

	if ( flag != 0 )
		{
		System.out.println( "error size not power of "  + prime  + 
		" or bigger than  "   +  Math.pow(prime,(maxpow))   + 
		"Fclass::fftoned2()\n"   + 
		"n="  + (float) Fxdim   + "\n");
		Runtime.getRuntime().exit(1);
                return this;
		}

//	fprintf(stderr,"fftoned2: N= %d, pown= %d  \n",N,pown);


						//reorder data
	for (a=0; a < N ; a++)
		{
		fwd=a;
		rev=0;
		mask1=1;
		mask2=N>>1;
		if ( (mask1 & fwd ) != 0)  rev=rev | mask2;
		for (b=2; b<=pown; b++)
			{
			mask2=  mask2 >> 1;
			mask1=  mask1  << 1;
			if (  (mask1 & fwd)!= 0) rev=rev | mask2;
			}

		if ( (rev >= Fxdim) || (rev < 0) )
			{
			System.out.println( "error bad index bit reverse in "   + 
			"Fclass::fftoned2()\n"   + 
			"rev="  + (float) rev   + "\n");
			Runtime.getRuntime().exit(1); return this;
			}
		else
			{
                        t1.Re[a][0] =  this.Re[rev][0];
                        t1.Im[a][0] =  this.Im[rev][0];                        
			//*(t1.Re + a) = *( (*this).Re + rev);
			//*(t1.Im + a) = *( (*this).Im + rev);
			}
		}


//**** level 0 butterflies **********************

	rr=0; 	//first level is just additions
	groups=N/(2<<rr);             //number of butterfly groups
	numbut= 1 <<  rr;	//number of butterflies in group
	offset= numbut;		//offset between top and bot of one but
	gsize=2*offset;		//size of a group of butterflies
	



	for ( gcnt=0; gcnt < groups; gcnt++ ) 
		{
						//buterfly inputs
		i1=gcnt * gsize ;	//index of top of but
		i2=gcnt * gsize +offset;//index of bot of but
		//topre=*(t1.Re + i1 );	
		//topim=*(t1.Im + i1 ) ;
		//botre=*(t1.Re + i2 ) ;
		//botim=*(t1.Im + i2 );
                
 		topre=t1.Re[i1][0];	
		topim=t1.Im[i1][0];
		botre=t1.Re[i2][0] ;
		botim=t1.Im[i2][0];
               

		topsumre=topre + botre;		//butterfly outputs
		topsumim=topim + botim;
		botsumre=topre - botre;
		botsumim=topim - botim;

//		*(t1.Re + i1)=topsumre;		//save result in place
//		*(t1.Im + i1)=topsumim;
//		*(t1.Re + i2)=botsumre;
//		*(t1.Im + i2)=botsumim;

                t1.Re[i1][0]=topsumre;		//save result in place
		t1.Im[i1][0]=topsumim;
		t1.Re[i2][0]=botsumre;
		t1.Im[i2][0]=botsumim;

		}
	
	kk=1;				//create all possible angles (W0)

	if (inv != 1)	//forward transform
	   	{
	   	for ( nn=0; nn < N ; nn++ )
			{
			arg = (nn * kk) % N;
			//*( w0.Re + nn) = Math.cos( (-2.0 * pi * arg) / N);
			//*( w0.Im + nn) = Math.sin( (-2.0 * pi * arg) / N);
			w0.Re[nn][0] = (float) Math.cos( (-2.0 * pi * arg) / N);
			w0.Im[nn][0] = (float) Math.sin( (-2.0 * pi * arg) / N);
			}
	   	}

	else		//inverse transform
	   	{
	   	for ( nn=0; nn < N ; nn++ )
			{
			arg = (nn * kk) % N;
			//*( w0.Re + nn) = cos ( (2.0 * pi * arg) / N);
			//*( w0.Im + nn) = sin ( (2.0 * pi * arg) / N);
			w0.Re[nn][0] = (float)Math.cos( (2.0 * pi * arg) / N);
			w0.Im[nn][0] = (float)Math.sin( (2.0 * pi * arg) / N);
			}
	   	}



//**** upper level  butterflies **********************


	for (rr=1; rr<pown ; rr++)	//subsequent levels
		{
		groups=N/(2<<rr);	//number of butterfly groups
		numbut= 1   <<  rr;	//number of butterflies in group
		offset= numbut;		//offset between top and bot of one but
		gsize=2*offset;		//size of a group of butterflies
	
					//gcnt counts which group
					//butsiz counts butterflies in group

		for ( gcnt=0; gcnt < groups; gcnt++ ) 
		for ( butcnt=0; butcnt<numbut; butcnt++)
			{
			kn=(groups * butcnt) ;
							//buterfly inputs
			i1=gcnt * gsize +butcnt;	//index of top of but
			i2=gcnt * gsize +butcnt +offset;//index of bot of but

			//topre=*(t1.Re + i1 );	
			//topim=*(t1.Im + i1 ) ;
			//botre=*(t1.Re + i2 ) * ( *( w0.Re + kn) )
			//	- *(t1.Im + i2 ) * ( *( w0.Im + kn) );
			//botim=*(t1.Re + i2 ) *  ( *( w0.Im + kn) )+
			//	( *( w0.Re + kn) ) * *(t1.Im + i2 );
                        
                 /*      if (i1==512)
                       {
 		System.out.println( "Fclass::fftoned2()\n"    
                        +" N="+N+" pown="+pown
                        +" rr="+rr+" offset="+offset+" gsize="+gsize
                        + " i1="+i1+" i2="+i2 
                        +" gcnt="+gcnt+" groups="+groups
                        +" butcnt="+butcnt+" numbut="+numbut
		   + "\n");
		Runtime.getRuntime().exit(1);       
                       }
                  */
                        
                        topre=t1.Re[i1][0];	
                        topim=t1.Im[i1][0];
                        botre=t1.Re[i2][0] * w0.Re[kn][0] 
                                - t1.Im[i2][0] * w0.Im[kn][0];
                        botim=t1.Re[i2][0] * w0.Im[kn][0] 
                                + t1.Im[i2][0] * w0.Re[kn][0];;

			topsumre=topre + botre;		//butterfly outputs
			topsumim=topim + botim;
			botsumre=topre - botre;
			botsumim=topim - botim;

			//*(t1.Re + i1)=topsumre;		//save result in place
			//*(t1.Im + i1)=topsumim;
			//*(t1.Re + i2)=botsumre;
			//*(t1.Im + i2)=botsumim;
                        
			t1.Re[i1][0]=topsumre;		//save result in place
			t1.Im[i1][0]=topsumim;
			t1.Re[i2][0]=botsumre;
			t1.Im[i2][0]=botsumim;
			}


		}	
	


	if (inv != 1)	//forward transform
	   	{
		return t1;
		}
	else
		{

		for (a=0; a < N ; a++)
			{

			//*(t1.Re + a) = *(t1.Re + a)/N;
			//*(t1.Im + a) = *(t1.Im + a)/N;
                        
			t1.Re[a][0] = t1.Re[a][0]/N;
			t1.Im[a][0] = t1.Im[a][0]/N;
                }
		
		return t1;
		}
}

    
    
    
 
    
}

