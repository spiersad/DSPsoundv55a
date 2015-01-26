/*
 * Myclass.java
 *
 * Created on December 31, 2006, 5:21 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tpw.Myclass; 

import java.io.*;

/**
 *
 * @author Owner
 */
public class Myclass {
    
	private byte  data[];		//byte-data (data) array
	private float  re[];		//real data array
	private float  im[];		//imaginary data array
	private int n;

    
    
    
    /** Creates a new instance of Myclass */
   // public Myclass() {
   // }

    
//Myclass.java
//
// example Java class
//
// copyright 1995-2007, by Thomas P. Weldon,
// all rights reserved
//
//
// Students in eegr4124 may make copies and modify them 
//for the purposes of their course projects.
//Any other use of this file is prohibited.
//
// Revisions:
//	1.   4/15/96  
//		fix Wn sign:
//			*( w0.re + nn) = cos ( (- 2.0 * pi * arg) / N); etc.
//
//




public Myclass()
{
	n = 10; 			//default length
	data = new byte[n];		//char data array creation
	re = new float[n];	
	im = new float[n];	
	for (int a=0; a<n; a++ )
		{
		data[a] = (byte)  0;
		re[a]    = (float) 0;
		im[a]    = (float) 0;
		}
}






public Myclass(int nn)
{
	if (nn <= 0)
		{
		System.out.println(   "error nn<=0 in " + 
		"public Myclass(int nn)\n" +
		"nn=" +(float) nn  + "\n");
		Runtime.getRuntime().exit(1);
		}
	n = nn; 			//default length
	data = new byte[n];		//data array creation
	re = new float[n];	
	im = new float[n];	

	for (int a=0; a<n; a++ )
		{
		data[a] = (byte)  0;
		re[a]    = (float) 0;
		im[a]    = (float) 0;
		}
}



public int getn()
{
	return n;

}

public byte[] getdata()
{
	return data;

}


public void magnitude()
{
    float maxx=0;
    float yy=0;
    for(int nn=0; nn<n; nn++)
    {
        yy=(this.re)[nn]*(this.re)[nn]+(this.im)[nn]*(this.im)[nn];
        yy=(float)Math.sqrt(yy);
        (this.re)[nn]=yy;
        (this.im)[nn]=0;
    }
  

}

public float getmaxmag()
{
    float maxx=0;
    float yy=0;
    for(int nn=0; nn<n; nn++)
    {
        yy=(this.re)[nn]*(this.re)[nn]+(this.im)[nn]*(this.im)[nn];
        yy=(float)Math.sqrt(yy);
        if (yy>maxx) maxx = yy;
    }
    return maxx;

}


public float maxre()
{
    float maxx=(this.re)[0];
    for(int nn=0; nn<n; nn++)
    {
         if ( (this.re)[nn] >maxx) maxx = (this.re)[nn];
    }
    return maxx;

}


public float minre()
{
    float minn=(this.re)[0];
    for(int nn=0; nn<n; nn++)
    {
         if ( (this.re)[nn] < minn) minn = (this.re)[nn];
    }
    return minn;

}

public void normalize()
{
    float maxx=0;
    maxx=this.getmaxmag();
    for(int nn=0; nn<n; nn++)
    {
        (this.re)[nn]=(this.re)[nn]/maxx;
       (this.im)[nn]=(this.im)[nn]/maxx;
       (this.data)[nn]=(byte)(126*(this.re)[nn]);
    }
}


public void lnmag()
{
    this.magnitude();
    float maxx=0;
    maxx=this.getmaxmag();
    for(int nn=0; nn<n; nn++)
    {
        if( ((this.re)[nn])<maxx/8100.0f)
            (this.re)[nn]=maxx/8100.0f;
       (this.im)[nn]=0;
       (this.re)[nn]=(float)(2.0*Math.log((this.re)[nn]));
    }
}





public void   equals(Myclass  x)	 //equal
{
	int a;


		(this).data =  new byte[x.n];	//new array creation
		(this).re   =  new float[x.n];	
		(this).im   =  new float[x.n];	
		(this).n = x.n;

		for (a=0; a<x.n ; a++ )
			{
			(this.data)[a]=(x.data)[a];
			(this.re)[a]=(x.re)[a];
			(this.im)[a]=(x.im)[a];
			}

		//return this ;


}



//    
//    Function: Myclass  public void   plus(int x)
//    		add float value to all Myclass re elements
//
public void   plus(int x)
{
if( (n ==  0) || (data == null )) // null array
	{
	System.out.println(   "null array assignment in public void   plus(int x) \n");
	Runtime.getRuntime().exit(1);
	}
else	
	{

	for (int xx = 0; xx < n; xx++)
		 (this.re)[xx] 
		=  (this.re)[xx] + x;
	//return z;
	}
}


//    
//    Function: Myclass  public void plus(Myclass x)
//
public void plus(Myclass x)
{
if( (n ==  0) ||(data== null ) ||
		(x.n ==  0)  ||
		 (x.data== null ) )// null array
	{
	System.out.println(   "null array assignment in public void plus(Myclass x) \n");
	Runtime.getRuntime().exit(1);
	}
else
if( (n ==  x.n)  )  //same size array
	{

	for (int xx = 0; xx < n; xx++)
		{
            	(this.data)[xx]  =  (byte)((this.data)[xx] + (x.data)[xx]);
            	(this.re)[xx]  =  (this.re)[xx] + (x.re)[xx];
            	(this.im)[xx]  =  (this.im)[xx] + (x.im)[xx];

		}
	//return z;
	}
else 
	{
	System.out.println(  "error dropthrough all tests in public void plus(Myclass x) \n");
	Runtime.getRuntime().exit(1);
	}
}








 public float getelre(int nn)
{
	if ( (nn >= n ) || (nn < 0) )
		{
		System.out.println(  "bad get index nn=" +nn+ " n=" +n +
		"in public getelre(int nn) \n");
		Runtime.getRuntime().exit(1);
		}
	return  (this.re)[nn] ;

}



 public float getelim(int nn)
{
	if ( (nn >= n ) || (nn < 0) )
		{
		System.out.println(   "bad get index nn=" +nn+ " n=" +n+
		"in public getelim(int nn) \n");
		Runtime.getRuntime().exit(1);
		}
	return  (this.im)[nn] ;

}


 public void setelre(int nn, float x)
{
	if ( (nn >= n ) || (nn < 0) )
		{
		System.out.println(  "bad set index nn=" +nn+ " n=" +n+
		"in public setelre(int nn) \n");
		Runtime.getRuntime().exit(1);
		}
	 (this.re)[nn]  = x;

}


 public void setelim(int nn, float x)
{
	if ( (nn >= n ) || (nn < 0) )
		{
		System.out.println(   "bad set index nn=" +nn+ " n=" +n +
		"in public setelim(int nn) \n");
		Runtime.getRuntime().exit(1);
		}
	 (this.im)[nn]  = x;

}



public Myclass fft2(int inv)		//inverse if inv !=0
{

				//copyright 1995-2007, Thomas Weldon,
				//allrights reserved


	if ( (this).n <= 0)
		{
		System.out.println(  "error n <= 0 in " + 
		"public fft2()\n" +
		"n=" +(float) n  + "\n");
		Runtime.getRuntime().exit(1);
		}

	int prime=2;			//prime factor of this routine
	int N;				//fft size
	int maxpow=20;			//max size=prime^maxpower
	int pown;			//actual power; N=prime^pown
	//double pi=3.141592654;
        double pi=Math.PI;
	int a,b,i1,i2,flag;		//dummy vars
	int nn,kk,arg;			//more dummies
	int mask1,mask2;		//bit reversal mask
	int fwd,rev;			//fwd and bit reverse
	int rr,offset;			//buterfly level
	Myclass w0 = new Myclass( this.n );	// array of all possible angles
//	Myclass wk( (this).n );	// array particular twiddle factors 
	float topsumre,topsumim,botsumre,botsumim;	// butter dummies
	float topre,topim,botre,botim;		    //butter dummies
	int groups,gcnt,gsize,butcnt,numbut,kn;		//butter dummies
	Myclass t1=new Myclass();

	N= (this).n;
	t1.equals(this);

	
	
	i1=1; flag=1; pown=0;		//first check for power of prime
	for ( a=0; a < maxpow; a++)
		{
		i1=i1*prime;
		if (i1==N) 
			{flag=0; pown=a+1;}
		}

	if ( flag != 0 )
		{
		System.out.println(  "error size not power of " +prime+
		" or bigger than  " + Math.pow((double)prime,(maxpow)) +
		"public fft2()\n" +
		"n=" +(float) n  + "\n");
		Runtime.getRuntime().exit(1);
		}

	System.out.println( "fft2: N= "+N+"  pown= "+pown);


						//reorder data
	for (a=0; a < N ; a++)
		{
		fwd=a;
		rev=0;
		mask1=1;
		mask2=N>>1;
		if ((mask1 & fwd ) != 0) rev=rev | mask2;
		for (b=2; b<=pown; b++)
			{
			mask2=  mask2 >> 1;
			mask1=  mask1 << 1;
			if ((mask1 & fwd ) != 0) rev=rev | mask2;
			}

		if ( (rev >= n) || (rev < 0) )
			{
			System.out.println(   "error bad index bit reverse in " +
			"public fft2()\n" +
			"rev=" +(float) rev  + "\n");
			Runtime.getRuntime().exit(1);
			}
		else
			{
			(t1.re)[a]  = (this.re)[rev];
			(t1.im)[a]  = (this.im)[rev];
			}
		}


//**** level 0 butterflies **********************

	rr=0; 	//first level is just additions
	groups=N/(2<<rr);	//number of butterfly groups
	numbut= 1 << rr;	//number of butterflies in group
	offset= numbut;		//offset between top and bot of one but
	gsize=2*offset;		//size of a group of butterflies
	


	for ( gcnt=0; gcnt < groups; gcnt++ ) 
		{
						//buterfly inputs
		i1=gcnt * gsize ;	//index of top of but
		i2=gcnt * gsize +offset;//index of bot of but
		topre=(t1.re)[i1];	
		topim=(t1.im)[i1];
		botre=(t1.re)[i2];
		botim=(t1.im)[i2];

		topsumre=topre + botre;		//butterfly outputs
		topsumim=topim + botim;
		botsumre=topre - botre;
		botsumim=topim - botim;

		(t1.re)[i1]=topsumre;		//save result in place
		(t1.im)[i1]=topsumim;
		(t1.re)[i2]=botsumre;
		(t1.im)[i2]=botsumim;

		}
	


	kk=1;				//create all possible angles (W0)

	if (inv != 1)	//forward transform
	   	{
	   	for ( nn=0; nn < N ; nn++ )
			{
			arg = (nn * kk) % N;
			(w0.re)[nn] = (float) Math.cos ( (-2.0 * pi * arg) / N);
			(w0.im)[nn] = (float) Math.sin ( (-2.0 * pi * arg) / N);
			}
	   	}

	else		//inverse transform
	   	{
	   	for ( nn=0; nn < N ; nn++ )
			{
			arg = (nn * kk) % N;
			(w0.re)[nn]  = (float) Math.cos ( (2.0 * pi * arg) / N);
			(w0.im)[nn]  = (float) Math.sin ( (2.0 * pi * arg) / N);
			}
	   	}



//**** upper level  butterflies **********************


	for (rr=1; rr<pown ; rr++)	//subsequent levels
		{
		groups=N/(2<<rr);	//number of butterfly groups
		numbut= 1 << rr;	//number of butterflies in group
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

			topre=(t1.re)[i1];	
			topim=(t1.im)[i1] ;
			botre=(t1.re)[i2] * ( (w0.re)[kn] )
				- (t1.im)[i2] * ( (w0.im)[kn] );
			botim=(t1.re)[i2] *  ( (w0.im)[kn] )+
				( (w0.re)[kn] ) * (t1.im)[i2];

			topsumre=topre + botre;		//butterfly outputs
			topsumim=topim + botim;
			botsumre=topre - botre;
			botsumim=topim - botim;

			(t1.re)[i1]=topsumre;		//save result in place
			(t1.im)[i1]=topsumim;
			(t1.re)[i2]=botsumre;
			(t1.im)[i2]=botsumim;
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
			(t1.re)[a] = (t1.re)[a]/N;
			(t1.im)[a] = (t1.im)[a]/N;
			}
		
		return t1;
		}
}





public Myclass fft()
{

	if ( (this).n <= 0)
		{
		System.out.println(   "error n <= 0 in " + 
		"public fft()\n" +
		"n=" +(float) n  + "\n");
		Runtime.getRuntime().exit(1);
		}

	Myclass t1 = new Myclass();

	t1.equals(this);
		t1.equals(t1.fft2(0));
		return t1;

}


public Myclass ifft()
{

	Myclass t1 = new Myclass();

	t1.equals(this);

		t1.equals(t1.fft2(1));
		return t1;

}





public void digitize8mulaw(float mu)
{
	if ( ((this).n <= 0 )   )
		{	System.out.println(  "error in " + 
		"public digitize8()\n" +"n=" +(float) n  + "\n");
		Runtime.getRuntime().exit(1);		}
	int a;
	Myclass z = new Myclass();
	z.equals(this);
	float max1,min1,extreme,scale;
	float magin,magout,rr,scale2,signrr;
	float linmax=125;
	byte dout;
	byte hexsign=(byte)0x80;	//sign bit for mu law


max1=z.getelre(0);
min1=z.getelre(0);

for (a=0; a< z.getn(); a++)
	{
	if ( max1 < z.getelre(a) ) max1=z.getelre(a);
	if ( min1 > z.getelre(a) ) min1=z.getelre(a);
	}

	if (Math.abs(max1)>Math.abs(min1)) extreme=Math.abs(max1);
		else extreme=Math.abs(min1);
	if ( extreme == 0 )  extreme=1;
	scale=1/extreme;
	scale2=linmax;


	for ( a=0; a< n ; a++ )
			{
			rr= (this.re)[a] * scale;
			if (rr >= 0) signrr=1;
				else signrr=-1;
			magin=Math.abs(rr);
			magout=(float)(Math.log(1 + mu * magin)/Math.log(1+mu));
			magout=magout * scale2;
			dout=(byte)( magout + .5 );
			dout=(byte)((~dout)&(~hexsign));     //deviates from t1?
			if (signrr==1) dout= (byte)((dout) | hexsign) ;
			(this.data)[a]= dout  ; 
			}

}



public void writeraw(String filename)
{

	System.out.println( "writeraw: filename %s \n" + filename);

        try {
            //FileWriter  outfile = new FileWriter(filename);
            DataOutputStream outfile =
                    new DataOutputStream( new FileOutputStream(filename));
        
 
	for ( int nn=0; nn< (this).n ;nn++ )
		{
//		c= *( (this).data + nn);
//		outfile.put(c);
            outfile.writeBytes((this.re)[nn]+" "+(this.im)[nn]+ "\r\n");
		//outfile<< (this.re)[nn] + " ";
		//outfile<< (this.im)[nn] + "\n";
		}
	outfile.close();	       
        }
        catch(IOException e){
            System.out.println( "ioexception file: "+filename);
		System.out.println( "public writeraw() ioexception="+e);

        }
	

	

}




public Myclass readraw(String filename)
{
	System.out.println( "readraw: filename %s \n" + filename);
	Myclass z = new Myclass();		

        try {
            //FileReader  infile = new FileReader(filename);
            DataInputStream infile =
                    new DataInputStream( new FileInputStream(filename));
    
	int size=0;
        float zz=0;
        while( (zz=infile.readFloat()) != -1){size=size+1;
        }
        
	System.out.println( "readraw: filename %s \n"+ filename+"size="+size);
		infile.close();

 	size=size-1;
     
	float ff;
        size=0;
        infile = new DataInputStream( new FileInputStream(filename));

	Myclass x = new Myclass(size);		//create proper size object

	z.equals(x);

	for ( int nn=0; nn< z.getn() ;nn++ )
		{

//		*(z.re +nn)= (float) (*(z.data + nn));
//		*(z.im +nn)= (float)0;
//		infile>> *( z.re + nn) ;
//		infile>> *( z.im + nn) ;
                (z.re)[nn]=infile.readFloat();
                (z.im)[nn]=infile.readFloat();
		}
	infile.close();

 	return z;
        }
        catch(IOException e){
            System.out.println( "ioexception file: "+filename);
		System.out.println( "public readraw() ioexception="+e);
 	return z;

        }
 
	
}



public void readau(String filename)
{
	Myclass z = new Myclass();		
	float mu=100;
	float magin,magout,rr,signrr;
	char c;
	byte din;
	byte hexsign=(byte)0x80;	//sign bit for mu law
	byte p;
	int size=0;

	//sun audio see /usr/demo/SOUND/include/multimedia/audio_filehdr.h
	byte[] audhdr =new byte[100];
	int so=40;		//au file header-throw away



	System.out.println( "readau: filename %s \n"+ filename);

       float zz=0;

       try {
           DataInputStream infile =
                    new DataInputStream( new FileInputStream(filename));
	//System.out.println( "readau: "+ infile.   +"  size="+size);

           
           while( (zz=infile.read() ) != -1){size=size+1;        }
		infile.close();
        }
        catch(IOException e){
            System.out.println( "ioexception file: "+filename);
		System.out.println( "public readau() sizing ioexception="+e);
        }
       
	System.out.println( "readau: filename "+ filename+"  size="+size);
		
       try {
           DataInputStream infile =
                    new DataInputStream( new FileInputStream(filename));
	size=size-40; //tpw was 41?
	if ( size < 1 )
		{System.out.println( "public readau() bad size:"+filename);}
	float ff;
        infile = new DataInputStream( new FileInputStream(filename));
	Myclass x = new Myclass(size);		//create proper size object
        z.equals(x);
        
       	
	infile.skipBytes(so);					//strip header
	//infile.read(audhdr,0,so);
		infile.read(z.data,0,z.getn());
		infile.close();	

	for (int a=0; a<z.n; a++ )	//decode au file format
			{
			din=(z.data)[a];
			if ( (din & hexsign) !=0 ) signrr=1;
				else signrr=-1;
			rr=(float)( (byte)( (~din) & (~hexsign) ) /127.0);
			//magout=fabs(rr);
			magout=rr;
			magin=(float)(magout*Math.log(1+mu));
			magin=(float)(Math.exp(magin));
			magin=(magin - 1)/mu;
			magin=signrr*magin;

			(z.re)[a]=magin;
			(z.im)[a]= (float)0;

			}


		this.equals(z);
   }
        catch(IOException e){
            System.out.println( "ioexception file: "+filename);
		System.out.println( "public readau() ioexception="+e);
		

        }
			

}


  
    
//end Myclass.java
}
