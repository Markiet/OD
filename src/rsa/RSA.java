/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static java.lang.Math.random;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Markiet
 */
public class RSA {

   public static int NajwiekszyWspolnyDzielnik( int x, int y)
    {
        int z;
        while(y != 0)
        {
            z = y;
            y = z % y;
            x = z;
        }
        return x;
    }
    
   public static int OdwrotnoscModulo(int x, int n)
    {
        int x0, n0, p0, p1, q, r, t;
        p0 = 0;
        p1 = 1;
        x0 = x;
        n0 = n;
        
        q = n0 / x0;
        r = n0 % x0;
        
        while (r > 0)
        {
            t = p0 - q * p1;
            
            if(t >= 0)
            {
                t = t % n;
            }
            else
                t = n - ((-t) % n);
                p0 = p1;
                p1 = t;
                n0 = x0;
                x0 = r;
                q = n0 / x0;
                r = n0 % x0;
        }
        return p1;
    }
    
  
    public static void KluczRSA()
    {
        int[] tablica;
       // tablica = new int[] {11, 13, 17, 19, 23, 29, 31, 37, 41, 43};
        
        int p, q, phi, n ,e ,d;
        
       System.out.println("Generowania klucza RSA");
      // Random rand = new Random(); 
       do
       {
            p = 19;//tablica[rand.nextInt() % 10];
            q = 31;//tablica[rand.nextInt() % 10];   
        } while ( p == q);
        phi = (p - 1) * (q - 1);
        n   = p * q;
        
       // for(e =3; NajwiekszyWspolnyDzielnik(e, phi) != 1; e +=2 );
        e = 3;
        NajwiekszyWspolnyDzielnik(e, phi);
        d = OdwrotnoscModulo(e, phi);
        
        System.out.println(" Klucz Publiczny:");
        System.out.println(" Wykładnik e: " +e);
        System.out.println(" Wmodul n: " +n);
        System.out.println(" ");
        System.out.println(" Klucz Prywatny " );
        System.out.println(" Wykładnik d: " +d);
    }
    
   public static int PotegaModulo( int x, int w, int n)
    {
        int potega;
        int wyn;
        int q;
        
        potega = x;
        wyn = 1;
        
        for (q = w; q > 0; q /=2)
        {
            if(q==2) wyn = (wyn * potega) % n;
            potega = (potega * potega) % n;
        }
        return wyn;
    }
    
    public static void KodowanieRSA()
    { 
        Scanner input = new Scanner(System.in);
        
         System.out.println(" Kodowanie Danych RSA");
         System.out.println(" Podaj wykładnik =");
         int e = input.nextInt();
         System.out.println(" Podaj modul = ");
         int n = input.nextInt();
         System.out.println(" Podaj kod RSA =");
         int t = input.nextInt();
         System.out.println(" Wynik kodowania = " + PotegaModulo(t,e,n) );
    }
    public static void main(String[] args) {
     
      
          Scanner input = new Scanner(System.in);
          
           System.out.println(" System szyfrowania RSA");
           System.out.println(" 1 - Generowanie Klucza RSA");
           System.out.println(" 2 - Kodowanie RSA");
           System.out.println(" 0 - Koniec Pracy");
           int w = input.nextInt();
          
          switch (w)
          {
              case 1:
              {
                KluczRSA();
                break;
              }
              case 2:
              {
                  KodowanieRSA();
                  break;
              }  
          }  
    }

  
}
