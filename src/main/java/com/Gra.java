package com;

public class Gra
{
    private char [][] planszaObecna;
    private char [][] planszaNastepna;

    public Gra()
    {
        planszaObecna = new char[15][15];
        planszaNastepna = new char [15][15];
    }

    public Gra(int rozmiar) // zakladamy ze tablica nie jest mniejsza niż 15 x 15
    {
        if (rozmiar < 15)
        {
            rozmiar=15;
        }
         planszaObecna = new char [rozmiar][rozmiar];
         planszaNastepna = new char [rozmiar][rozmiar];

    }
    public void wypelnijPlanszeWariantDrugi()
    {
        planszaObecna[0][1] = '#';
        planszaObecna[1][2] = '#';
        planszaObecna[2][1] = '#';
        planszaObecna[2][0] = '#';
        planszaObecna[2][2] = '#';

    }

    public void wypelnijPlansze()
    {
        planszaObecna[5][5] = '#';
        planszaObecna[6][5] = '#';
        planszaObecna[7][5] = '#';
        planszaObecna[8][5] = '#';
        planszaObecna[9][5] = '#';
        planszaObecna[5][7] = '#';
        planszaObecna[5][9] = '#';
        planszaObecna[9][7] = '#';
        planszaObecna[9][9] = '#';
        planszaObecna[6][9] = '#';
        planszaObecna[7][9] = '#';
        planszaObecna[8][9] = '#';
    }

    public int sprawdzSasiada(int i, int j)
    {
        int licznikZywychKomorek = 0;

        if ( j-1 >= 0 && planszaObecna[i][j-1] == '#')
        {
            licznikZywychKomorek++;
        }
        ////////////////
        if (j + 1 <= 14 && planszaObecna[i][j+1] == '#')
        {
            licznikZywychKomorek++;
        }
        /////////////////
        if ( i - 1 >= 0 && planszaObecna[i-1][j] == '#')
        {
            licznikZywychKomorek++;
        }
        ////////////
        if ( i + 1 <= 14 && planszaObecna[i+1][j] == '#' )
        {
            licznikZywychKomorek++;
        }
        //////////////////////
        if ( i + 1 <=14 && j - 1 >= 0 && planszaObecna[i + 1][j - 1] == '#')
        {
            licznikZywychKomorek++;
        }
        ///////////////////////////
        if (i - 1 >= 0 && j -1 >= 0 && planszaObecna[i - 1][j - 1] == '#'  )
        {
            licznikZywychKomorek++;
        }
        ///////////////////////
        if (i - 1 >= 0 && j +1 <= 14 && planszaObecna[i - 1][j + 1] == '#' )
        {
            licznikZywychKomorek++;
        }
        ////////////////////////
        if ( i + 1 <= 14 && j + 1 <= 14 && planszaObecna[i + 1][j + 1] == '#')
        {
            licznikZywychKomorek++;
        }

        return licznikZywychKomorek;

    }
    public void copyOfArray()
    {
        for (int i = 0 ; i < planszaNastepna.length ; i++)
        {
            for (int j = 0 ; j < planszaNastepna.length ; j++)
            {
                planszaObecna[i][j] = planszaNastepna[i][j];
            }
        }

    }


    public void showTable(char [][] tab)
    {
        for (int i = 0 ; i < tab.length; i++)
        {
            for (int j = 0 ; j < tab.length; j++)
            {
                System.out.print(tab[i][j]);
            }
            System.out.println();

        }
        System.out.println();

    }

    public void generujPlansze()
    {
        for (int i = 0 ; i < planszaObecna.length; i++)
        {
            for (int j = 0 ; j < planszaObecna.length; j++)
            {
                planszaObecna[i][j] = '.';
                planszaNastepna[i][j] = '.';
            }
        }
    }


    public void startGry() throws InterruptedException
    {

      generujPlansze();
      wypelnijPlanszeWariantDrugi();// tutaj poczatkowe ustawienie zywych komórek, tak zwany poczatek gry
      Thread thread = new Thread();
      showTable(planszaObecna);


      while(true) {
          thread.sleep(2000);
          for (int i = 0; i < planszaNastepna.length; i++) {
              for (int j = 0; j < planszaNastepna.length; j++) {
                  if (planszaObecna[i][j] == '.') {
                      int ile = sprawdzSasiada(i, j);

                      if (ile == 3) {
                          planszaNastepna[i][j] = '#';
                      }
                  } else {
                      int ile = sprawdzSasiada(i, j);
                      if (ile < 2 || ile > 3) {
                          planszaNastepna[i][j] = '.';
                      } else {
                          planszaNastepna[i][j] = '#';
                      }
                  }
              }
          }
          copyOfArray();
          showTable(planszaNastepna);


      }

    }


}







