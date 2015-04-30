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
	private double  re[];		//real data array
	private double  im[];		//imaginary data array
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
	re = new double[n];	
	im = new double[n];	
	for (int a=0; a<n; a++ )
		{
		data[a] = (byte)  0;
		re[a]    = (double) 0;
		im[a]    = (double) 0;
		}
}






public Myclass(int nn)
{
	if (nn <= 0)
		{
		System.out.println(   "error nn<=0 in " + 
		"public Myclass(int nn)\n" +
		"nn=" +(double) nn  + "\n");
		Runtime.getRuntime().exit(1);
		}
	n = nn; 			//default length
	data = new byte[n];		//data array creation
	re = new double[n];	
	im = new double[n];	

	for (int a=0; a<n; a++ )
		{
		data[a] = (byte)  0;
		re[a]    = (double) 0;
		im[a]    = (double) 0;
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
    double maxx=0;
    double yy=0;
    for(int nn=0; nn<n; nn++)
    {
        yy=(this.re)[nn]*(this.re)[nn]+(this.im)[nn]*(this.im)[nn];
        yy=(double)Math.sqrt(yy);
        (this.re)[nn]=yy;
        (this.im)[nn]=0;
    }
  

}

public double getmaxmag()
{
    double maxx=0;
    double yy=0;
    for(int nn=0; nn<n; nn++)
    {
        yy=(this.re)[nn]*(this.re)[nn]+(this.im)[nn]*(this.im)[nn];
        yy=(double)Math.sqrt(yy);
        if (yy>maxx) maxx = yy;
    }
    return maxx;

}


public double maxre()
{
    double maxx=(this.re)[0];
    for(int nn=0; nn<n; nn++)
    {
         if ( (this.re)[nn] >maxx) maxx = (this.re)[nn];
    }
    return maxx;

}


public double minre()
{
    double minn=(this.re)[0];
    for(int nn=0; nn<n; nn++)
    {
         if ( (this.re)[nn] < minn) minn = (this.re)[nn];
    }
    return minn;

}

public void normalize()
{
    double maxx=0;
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
    double maxx=0;
    maxx=this.getmaxmag();
    for(int nn=0; nn<n; nn++)
    {
        if( ((this.re)[nn])<maxx/8100.0f)
            (this.re)[nn]=maxx/8100.0f;
       (this.im)[nn]=0;
       (this.re)[nn]=(double)(2.0*Math.log((this.re)[nn]));
    }
}



public void movingAverageFilter(int filterLength){
    Myclass temp = new Myclass(this.n);
    for (int nn = 0; nn < this.n; nn++){
        for (int kk = 0; kk <= filterLength; kk++){
            if (nn-kk < 0)
                break;
            temp.re[nn] = temp.re[nn] + this.re[nn-kk];
            temp.im[nn] = temp.im[nn] + this.im[nn-kk];
        }
        temp.re[nn] = temp.re[nn] / (filterLength+1);
        temp.im[nn] = temp.im[nn] / (filterLength+1);
    }
    this.equals(temp);
}


public void twentyLogTenMag(double differance) {
    this.magnitude();
    double maxx = 0;
    for(int nn=0; nn<this.n; nn++) {
        if (this.re[nn] == 0) { 
            this.re[nn] = 0;
        }
        else {
            this.re[nn] = (double)((20*Math.log(this.re[nn])/Math.log(10)));
        }
        
        if (this.re[nn] > maxx) {
            maxx = this.re[nn];
        }
    }
    double min = maxx - differance;
    for(int nn=0; nn<this.n; nn++) {
        if (this.re[nn] < min) {
            this.re[nn] = min;
        }
    }
}


public void   equals(Myclass  x)	 //equal
{
	int a;
		(this).data =  new byte[x.n];	//new array creation
		(this).re   =  new double[x.n];	
		(this).im   =  new double[x.n];	
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
//    		add double value to all Myclass re elements
//
public void   plus(int x) {
    if( (n ==  0) || (data == null )) {
	System.out.println(   "null array assignment in public void   plus(int x) \n");
	Runtime.getRuntime().exit(1);
    }
    else {
	for (int xx = 0; xx < n; xx++)
            (this.re)[xx] =  (this.re)[xx] + x;
    }
}



public void   divide(double x) {
    if( (n ==  0) || (data == null )) {
	System.out.println(   "null array assignment in public void   divide(double x) \n");
	Runtime.getRuntime().exit(1);
    }
    else if (x == 0) {
        System.out.println(   "divide by 0 not possible \n");
	Runtime.getRuntime().exit(1);
    }
    else {
        for (int xx = 0; xx < n; xx++) 
            (this.re)[xx] =  (this.re)[xx] / x;
        
        for (int xx = 0; xx < n; xx++)
            (this.im)[xx] =  (this.im)[xx] / x;
    }
}


public void multiply(double real, double imag) {
    if( (n ==  0) || (data == null )) {
	System.out.println(   "null array assignment in public void divide(multiply x) \n");
	Runtime.getRuntime().exit(1);
    }
    else {
        for (int xx = 0; xx < n; xx++) {
            (this.re)[xx] =  (this.re)[xx] * real - this.im[xx] * imag;
            (this.im)[xx] =  (this.im)[xx] * real + this.re[xx] * imag;
        }
    }
}

public void differenceEqnFilter(double n0, double n1, double n2, double n3, double n4, double n5, double n6, 
                               double d0, double d1, double d2, double d3, double d4, double d5, double d6){
    double[] num = {n0, n1, n2, n3, n4, n5, n6};
    double[] den = {d0, d1, d2, d3, d4, d5, d6};
    Myclass y = new Myclass(this.n);
    for (int nn = 0; nn < this.n; nn++){
        for (int kk = 0; kk <= 6; kk++){
            if ((nn - kk) >= 0)
                y.re[nn] = y.re[nn] - y.re[nn - kk] * den[kk] + this.re[nn - kk] * num[kk];
        }
    }
    this.equals(y);
}


public static Myclass freqresp(int samp, double a6, double a5, double a4, double a3, double a2, double a1, double a0, 
                               double b6, double b5, double b4, double b3, double b2, double b1, double b0){
    Myclass N = new Myclass(samp);
    Myclass D = new Myclass(samp);
    Myclass H = new Myclass(samp);
    
    for (int kk  = 0; kk < samp; kk++){
        double ww = (double)Math.PI * 2 * kk / samp;
        N.re[kk] = (double)(a6 * Math.cos(6*ww) + a5 * Math.cos(5*ww) + a4 * Math.cos(4*ww) + a3 * Math.cos(3*ww) + a2 * Math.cos(2*ww) + a1 * Math.cos(ww) + a0);
        N.im[kk] = (double)(a6 * Math.sin(6*ww) + a5 * Math.sin(5*ww) + a4 * Math.sin(4*ww) + a3 * Math.sin(3*ww) + a2 * Math.sin(2*ww) + a1 * Math.sin(ww)); 
        D.re[kk] = (double)(b6 * Math.cos(6*ww) + b5 * Math.cos(5*ww) + b4 * Math.cos(4*ww) + b3 * Math.cos(3*ww) + b2 * Math.cos(2*ww) + b1 * Math.cos(ww) + b0);
        if (D.re[kk] == 0)
            D.re[kk] = (double).00000001;
        D.im[kk] = (double)(b6 * Math.sin(6*ww) + b5 * Math.sin(5*ww) + b4 * Math.sin(4*ww) + b3 * Math.sin(3*ww) + b2 * Math.sin(2*ww) + b1 * Math.sin(ww));
        if (D.im[kk] == 0)
            D.im[kk] = (double).00000001;
        (H.re)[kk] = ((N.re)[kk]*(D.re)[kk]+(N.im)[kk]*(D.im)[kk])/((D.re)[kk]*(D.re)[kk]+(D.im)[kk]*(D.im)[kk]);
        (H.im)[kk] = ((N.im)[kk]*(D.re)[kk]-(N.re)[kk]*(D.im)[kk])/((D.re)[kk]*(D.re)[kk]+(D.im)[kk]*(D.im)[kk]);
    }

    H.magnitude();
    return H;
}


public void freqShift(int distance) {
    Myclass Y = new Myclass(this.n);
    if( (this.n ==  0) || (this.data == null )) {
	System.out.println(   "null array assignment in public void divide(multiply x) \n");
	Runtime.getRuntime().exit(1);
    }
    else {
        for (int nn = 0; nn < this.n; nn++) {
            double ww = -2 * Math.PI * distance * nn / this.n;
            Y.re[nn] = (double)(this.re[nn] * Math.cos(ww) - this.im[nn] * Math.sin(ww));
            Y.im[nn] = (double)(this.im[nn] * Math.cos(ww) + this.re[nn] * Math.sin(ww));
        }
    }
    this.equals(Y);
}




public void plus(Myclass x) {
    if( (n ==  0) || (data== null ) || (x.n ==  0)  || (x.data== null ) ) {
	System.out.println(   "null array assignment in public void plus(Myclass x) \n");
	Runtime.getRuntime().exit(1);
    }
    else if( (n ==  x.n)  ) {
        for (int xx = 0; xx < n; xx++) {
            (this.data)[xx]  =  (byte)((this.data)[xx] + (x.data)[xx]);
            (this.re)[xx]  =  (this.re)[xx] + (x.re)[xx];
            (this.im)[xx]  =  (this.im)[xx] + (x.im)[xx];
        }
    }
    else {
	System.out.println(  "error dropthrough all tests in public void plus(Myclass x) \n");
	Runtime.getRuntime().exit(1);
    }
}


public void divide(Myclass x) {
    if( (n ==  0) || (data == null ) || (x.n ==  0)  || (x.data == null ) ) {
	System.out.println(   "null array assignment in public void plus(Myclass x) \n");
	Runtime.getRuntime().exit(1);
    }
    else if( (n ==  x.n)  ) { 
        for (int xx = 0; xx < n; xx++) {
            if (x.re[xx] == 0 || ((x.re)[xx]*(x.re)[xx]+(x.im)[xx]*(x.im)[xx]) == 0) {
               this.re[xx] = 0;
            }
            else {
                (this.re)[xx]  =  ((this.re)[xx]*(x.re)[xx]+(this.im)[xx]*(x.im)[xx])
                                  /((x.re)[xx]*(x.re)[xx]+(x.im)[xx]*(x.im)[xx]);
            }
            if (x.im[xx] == 0 || ((x.re)[xx]*(x.re)[xx]+(x.im)[xx]*(x.im)[xx]) == 0) {
               this.im[xx] = 0;
            }
            else {
                (this.im)[xx]  =  (-(this.re)[xx]*(x.im)[xx]+(x.re)[xx]*(this.im)[xx])
                                  /((x.re)[xx]*(x.re)[xx]+(x.im)[xx]*(x.im)[xx]);
            }
            (this.data)[xx]  =  (byte)((this.data)[xx] + (x.data)[xx]);
        }
    }
	//return z;
	
    else {
	System.out.println(  "error dropthrough all tests in public void plus(Myclass x) \n");
	Runtime.getRuntime().exit(1);
    }
}



public void multiply(Myclass x) {
    if( (n ==  0) ||(data == null ) || (x.n ==  0)  || (x.data == null ) ) {
	System.out.println(   "null array assignment in public void plus(Myclass x) \n");
	Runtime.getRuntime().exit(1);
    }
    else if( (n ==  x.n)  ) { 
        for (int xx = 0; xx < n; xx++) {
            (this.re)[xx]  =  (this.re)[xx]*(x.re)[xx]-(this.im)[xx]*(x.im)[xx];
            (this.im)[xx]  =  (this.re)[xx]*(x.im)[xx]+(x.re)[xx]*(this.im)[xx];
            (this.data)[xx]  =  (byte)((this.data)[xx] * (x.data)[xx]);
        }
    }	
    else {
	System.out.println(  "error dropthrough all tests in public void multiply(Myclass x) \n");
	Runtime.getRuntime().exit(1);
    }
}



 public double getelre(int nn)
{
	if ( (nn >= n ) || (nn < 0) )
		{
		System.out.println(  "bad get index nn=" +nn+ " n=" +n +
		"in public getelre(int nn) \n");
		Runtime.getRuntime().exit(1);
		}
	return  (this.re)[nn] ;

}



 public double getelim(int nn)
{
	if ( (nn >= n ) || (nn < 0) )
		{
		System.out.println(   "bad get index nn=" +nn+ " n=" +n+
		"in public getelim(int nn) \n");
		Runtime.getRuntime().exit(1);
		}
	return  (this.im)[nn] ;

}


 public void setelre(int nn, double x)
{
	if ( (nn >= n ) || (nn < 0) )
		{
		System.out.println(  "bad set index nn=" +nn+ " n=" +n+
		"in public setelre(int nn) \n");
		Runtime.getRuntime().exit(1);
		}
	 (this.re)[nn]  = x;

}


 public void setelim(int nn, double x)
{
	if ( (nn >= n ) || (nn < 0) )
		{
		System.out.println(   "bad set index nn=" +nn+ " n=" +n +
		"in public setelim(int nn) \n");
		Runtime.getRuntime().exit(1);
		}
	 (this.im)[nn]  = x;

}

 
 
public static Myclass linconvolve(Myclass x, Myclass h, int samp) {
    Myclass y = new Myclass(samp);    
    int errors = 0;
    
    for (int nn = 0; nn < y.n; nn++) {
        for (int kk = 0; kk < h.n; kk++) {
            try {
                if ((nn - kk >= x.n) || (nn - kk < 0)) {}
                else {
                    (y.re)[nn] = (y.re)[nn] + (h.re)[kk]*(x.re)[nn - kk] - (h.im)[kk]*(x.im)[nn - kk];
                    (y.im)[nn] = (y.im)[nn] - (h.im)[kk]*(x.re)[nn - kk] + (h.re)[kk]*(x.im)[nn - kk];
                }
            }
            catch (java.lang.IndexOutOfBoundsException e) {
                errors++;
            }
        }
    }
    System.out.println("Index out of bounds errors: " + errors);
    return y;   
}


public void ft() {
    Myclass h = new Myclass(this.n);
    double ww = 0;
    int errors = 0;
    
    for (int nn = 0; nn < this.n; nn++) {
        for (int kk = 0; kk < this.n; kk++) {
            try {
                ww = -2 * Math.PI * nn * kk / this.n;
                h.re[nn] +=  this.re[kk] * Math.cos(ww) - this.im[kk] * Math.sin(ww);
                h.im[nn] +=  this.re[kk] * Math.sin(ww) + this.im[kk] * Math.cos(ww);
                }
            catch (java.lang.IndexOutOfBoundsException e) {
                errors++;
            }
        }
    }
    this.equals(h);
    System.out.println("Index out of bounds errors: " + errors); 
}


public void ift() {
    Myclass h = new Myclass(this.n);
    double ww = 0;
    int errors = 0;
    
    for (int nn = 0; nn < this.n; nn++) {
        for (int kk = 0; kk < this.n; kk++) {
            try {
                ww = 2 * Math.PI * nn * kk / this.n;
                h.re[nn] +=  (this.re[kk] * Math.cos(ww) - this.im[kk] * Math.sin(ww))/this.n;
                h.im[nn] +=  (this.re[kk] * Math.sin(ww) + this.im[kk] * Math.cos(ww))/this.n;
                }
            catch (java.lang.IndexOutOfBoundsException e) {
                errors++;
            }
        }
    }
    this.equals(h);
    System.out.println("Index out of bounds errors: " + errors); 
}


public Myclass fft2(int inv)		//inverse if inv !=0
{

				//copyright 1995-2007, Thomas Weldon,
				//allrights reserved


	if ( (this).n <= 0)
		{
		System.out.println(  "error n <= 0 in " + 
		"public fft2()\n" +
		"n=" +(double) n  + "\n");
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
	double topsumre,topsumim,botsumre,botsumim;	// butter dummies
	double topre,topim,botre,botim;		    //butter dummies
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
		"n=" +(double) n  + "\n");
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
			"rev=" +(double) rev  + "\n");
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
			(w0.re)[nn] = (double) Math.cos ( (-2.0 * pi * arg) / N);
			(w0.im)[nn] = (double) Math.sin ( (-2.0 * pi * arg) / N);
			}
	   	}

	else		//inverse transform
	   	{
	   	for ( nn=0; nn < N ; nn++ )
			{
			arg = (nn * kk) % N;
			(w0.re)[nn]  = (double) Math.cos ( (2.0 * pi * arg) / N);
			(w0.im)[nn]  = (double) Math.sin ( (2.0 * pi * arg) / N);
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
		"n=" +(double) n  + "\n");
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





public void digitize8mulaw(double mu)
{
	if ( ((this).n <= 0 )   )
		{	System.out.println(  "error in " + 
		"public digitize8()\n" +"n=" +(double) n  + "\n");
		Runtime.getRuntime().exit(1);		}
	int a;
	Myclass z = new Myclass();
	z.equals(this);
	double max1,min1,extreme,scale;
	double magin,magout,rr,scale2,signrr;
	double linmax=125;
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
			magout=(double)(Math.log(1 + mu * magin)/Math.log(1+mu));
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
        double zz=0;
        while( (zz=infile.readFloat()) != -1){size=size+1;
        }
        
	System.out.println( "readraw: filename %s \n"+ filename+"size="+size);
		infile.close();

 	size=size-1;
     
	double ff;
        size=0;
        infile = new DataInputStream( new FileInputStream(filename));

	Myclass x = new Myclass(size);		//create proper size object

	z.equals(x);

	for ( int nn=0; nn< z.getn() ;nn++ )
		{

//		*(z.re +nn)= (double) (*(z.data + nn));
//		*(z.im +nn)= (double)0;
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
	double mu=100;
	double magin,magout,rr,signrr;
	char c;
	byte din;
	byte hexsign=(byte)0x80;	//sign bit for mu law
	byte p;
	int size=0;

	//sun audio see /usr/demo/SOUND/include/multimedia/audio_filehdr.h
	byte[] audhdr =new byte[100];
	int so=40;		//au file header-throw away



	System.out.println( "readau: filename %s \n"+ filename);

       double zz=0;

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
	double ff;
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
			rr=(double)( (byte)( (~din) & (~hexsign) ) /127.0);
			//magout=fabs(rr);
			magout=rr;
			magin=(double)(magout*Math.log(1+mu));
			magin=(double)(Math.exp(magin));
			magin=(magin - 1)/mu;
			magin=signrr*magin;

			(z.re)[a]=magin;
			(z.im)[a]= (double)0;

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
