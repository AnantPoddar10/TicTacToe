import java.io.*;
class TicTacToe
{
    public static void twoPlayers()throws IOException
    {
        System.out.println("Instructions:- This is a two-player game. It is controlled entirely by the key-board. There is no requirement of the mouse.");
        System.out.println("               To make a move, enter the place where you want to put in your symbol i.e either a 'X' or an 'O'.");
        System.out.println("               The layout is shown below with corresponding place numbers.");
        System.out.println("                  |   |");
        System.out.println("                1 | 2 | 3");
        System.out.println("              ----|---|----");
        System.out.println("                4 | 5 | 6");
        System.out.println("              ----|---|----");
        System.out.println("                7 | 8 | 9");
        System.out.println("                  |   |");
        System.out.println("               Enjoy yourself...\n\n");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr[][] = new String[3][3];
        String p1 = "", p2 = "";
        int i, j, c=1, f=0;
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                arr[i][j] = ".";
            }
        }
        do
        {
            try
            {
                System.out.print("Enter player 1's name : ");
                p1 = br.readLine();
                f=0;
            }catch(Exception e)
            {
                f=1;
            }
        }while(f==1);
        do
        {
            try
            {
                System.out.print("Enter player 2's name : ");
                p2 = br.readLine();
                f=0;
            }catch(Exception e)
            {
                f=1;
            }
        }while(f==1);
        f=0;
        i=1;
        for(i=0;i<9;i++)
        {
            if(c%2!=0)
            {
                System.out.println("\n"+p1+"'s move.");
                enter(arr,c);
                c++;
            }
            display(arr);
            if(hasWon(arr))
            {
                f=1;
                break;
            }
            if(isFull(arr))
                break;
            if(c%2==0)
            {
                System.out.println("\n"+p2+"'s move.");
                enter(arr,c);
                c++;
            }
            display(arr);
            if(hasWon(arr))
            {
                f=2;
                break;
            }
            if(isFull(arr))
                break;
        }
        System.out.println("\n\nFinal state : ");
        display(arr);
        if(f==1)
            System.out.println("\n\nCongartulations "+p1+"!!! You win!!!");
        else if(f==2)
            System.out.println("\n\nCongratulations "+p2+"!!! You win!!!");
        else
            System.out.println("\n\nNo winner. Game even.");
        System.out.print(" Press any key to continue and enter : ");
        String x=br.readLine();
        System.out.println("\f");
        main();
    }

    static void display(String arr[][])
    {
        System.out.println("\f");
        System.out.println("                  |   |");
        System.out.println("                1 | 2 | 3");
        System.out.println("              ----|---|----");
        System.out.println("                4 | 5 | 6");
        System.out.println("              ----|---|----");
        System.out.println("                7 | 8 | 9");
        System.out.println("                  |   |");
        System.out.println();
        for(int i = 0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static String[][] enter(String arr[][],int j)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i=0, f=0, r=0, c=0;
        if(j%2!=0)
        {
            do
            {
                try
                {
                    System.out.print("Where do you want to enter your move? : ");
                    i = Integer.parseInt(br.readLine());
                    f=0;
                }catch(Exception e)
                {
                    f=1;
                }
            }while(f==1);
            switch(i)
            {
                case 1 : r=0; c=0;
                break;
                case 2 : r=0; c=1;
                break;
                case 3 : r=0; c=2;
                break;
                case 4 : r=1; c=0;
                break;
                case 5 : r=1; c=1;
                break;
                case 6 : r=1; c=2;
                break;
                case 7 : r=2; c=0;
                break;
                case 8 : r=2; c=1;
                break;
                case 9 : r=2; c=2;
                break;
                default :
                System.out.println("Wrong move. Please re-enter.\n");
                enter(arr, j);
                break;
            }
            if(arr[r][c].equals("."))
                arr[r][c]="X";
            else
            {
                System.out.println("Position already filled. Please enter a different position.\n");
                enter(arr, j);
            }
        }
        else if(j%2==0)
        {
            do
            {
                try
                {
                    System.out.print("Where do you want to enter your move? : ");
                    i = Integer.parseInt(br.readLine());
                    f=0;
                }catch(Exception e)
                {
                    f=1;
                }
            }while(f==1);
            switch(i)
            {
                case 1 : r=0; c=0;
                break;
                case 2 : r=0; c=1;
                break;
                case 3 : r=0; c=2;
                break;
                case 4 : r=1; c=0;
                break;
                case 5 : r=1; c=1;
                break;
                case 6 : r=1; c=2;
                break;
                case 7 : r=2; c=0;
                break;
                case 8 : r=2; c=1;
                break;
                case 9 : r=2; c=2;
                break;
                default :
                System.out.println("Wrong move. Please re-enter.\n");
                enter(arr, j);
                break;
            }
            if(arr[r][c].equals("."))
                arr[r][c]="O";
            else
            {
                System.out.println("Position already filled. Please enter a different position.\n");
                enter(arr, j);
            }
        }
        return arr;
    }

    static boolean hasWon(String arr[][])
    {
        int i, j, p1=0, p2=0;
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                if(arr[i][j].equals("X")==true)
                    p1++;
                else if(arr[i][j].equals("O"))
                    p2++;
            }
            if(p1==3 || p2==3)
                return true;
            p1=0;
            p2=0;
        }
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                if(arr[j][i].equals("X"))
                    p1++;
                else if(arr[j][i].equals("O"))
                    p2++;
            }

            if(p1==3 | p2==3)
                return true;
            p1=0;
            p2=0;
        }

        for(i=0;i<3;i++)
        {
            if(arr[i][i].equals("X"))
                p1++;
            else if(arr[i][i].equals("O"))
                p2++;
        }
        if(p1==3 | p2==3)
            return true;
        p1=0;
        p2=0;
        for(i=0,j=2;j>=0;i++,j--)
        {
            if(arr[i][j].equals("X"))
                p1++;
            else if(arr[i][j].equals("O"))
                p2++;
        }
        if(p1==3 | p2==3)
            return true;
        return false;
    }

    static String[][] computersMove(String arr[][])
    {
        int i, j, p=0, k, m, r, c, q=0;
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                if(arr[i][j].equals("X"))
                    p++;
                else if(arr[i][j].equals("O"))
                    q++;
            }
            if(q==2)
            {
                for(k=0;k<3;k++)
                {
                    if(arr[i][k].equals("."))
                    {
                        arr[i][k] = "O";
                        return arr;
                    }
                }
            }
            q=0;
            if(p==2)
            {
                for(k=0;k<3;k++)
                {
                    if(arr[i][k].equals("."))
                    {
                        arr[i][k] = "O";
                        return arr;
                    }
                }
            }
            p=0;
        }
        p=0;
        q=0;
        for(i=0;i<3;i++)/* column*/
        {
            for(j=0;j<3;j++)
            {
                if(arr[j][i].equals("X"))
                    p++;
                else if(arr[i][j].equals("O"))
                    q++;
            }
            if(q==2)
            {
                for(k=0;k<3;k++)
                {
                    if(arr[k][i].equals("."))
                    {
                        arr[k][i] = "O";
                        return arr;
                    }
                }
            }
            q=0;
            if(p==2)
            {
                for(k=0;k<3;k++)
                {
                    if(arr[k][i].equals("."))
                    {
                        arr[k][i] = "O";
                        return arr;
                    }
                }
            }
            p=0;
        }
        p=0;
        q=0;
        for(i=0;i<3;i++)/* right dia*/
        {
            if(arr[i][i].equals("X"))
                p++;
            else if(arr[i][i].equals("O"))
                q++;
        }
        if(q==2)
        {
            for(j=0;j<3;j++)
            {
                if(arr[j][j].equals("."))
                {
                    arr[j][j]="O";
                    return arr;
                }
            }
        }
        q=0;
        if(p==2)
        {
            for(j=0;j<3;j++)
            {
                if(arr[j][j].equals("."))
                {
                    arr[j][j]="O";
                    return arr;
                }
            }
        }
        p=0;
        q=0;
        for(i=0,j=2;j>=0;i++,j--)/* left dia*/
        {
            if(arr[i][j].equals("X"))
                p++;
            else if(arr[i][j].equals("O"))
                q++;
        }
        if(q==2)
        {
            for(k=0,m=2;m>=0;k++,m--)
            {
                if(arr[k][m].equals("."))
                {
                    arr[k][m]="O";
                    return arr;
                }
            }
        }
        if(p==2)
        {
            for(k=0,m=2;m>=0;k++,m--)
            {

                if(arr[k][m].equals("."))
                {
                    arr[k][m]="O";
                    return arr;
                }
            }
        }
        outer : for(i=0;i<3;i++)
        {
            inner : for(j=0;j<3;j++)
            {
                if(arr[i][j].equals("."))
                {
                    arr[i][j]="O";
                    break outer;             
                }
            }
        }
        return arr;
    }            

    static void main()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to TicTacToe.\n---------------------\n\nWhich type of game do you want to play?\nPress 1 for 1'Player game \nPress 2. for 2'Player game.\nPress 3. for Exit.\n");
        int f=0, ch=0;
        do
        {
            try
            {
                System.out.print("Your choice : ");
                ch = Integer.parseInt(br.readLine());
                f=0;
            }catch(Exception e)
            {
                f=1;
            }
        }while(f==1);
        switch(ch)
        {
            case 1 : System.out.println("\f");
            onePlayer();
            break;
            case 2 : System.out.println("\f");
            twoPlayers();
            break;
            case 3 : System.out.println("\f");
            System.out.println("Thank you.");
            System.out.println("Program Developed by Anant Poddar.");
            return;
            default : System.out.println("Wrong choice!!!\n\n\n\n");
            main();
            break;
        }
    }

    static void onePlayer()throws IOException
    {
        System.out.println("Instructions:- This is a one-player game. It is controlled entirely by the key-board. There is no requirement of the mouse.");
        System.out.println("               To make a move, enter the place where you want to put in your symbol i.e either a 'X'.");
        System.out.println("               The layout is shown below with corresponding place numbers.");
        System.out.println("                  |   |");
        System.out.println("                1 | 2 | 3");
        System.out.println("              ----|---|----");
        System.out.println("                4 | 5 | 6");
        System.out.println("              ----|---|----");
        System.out.println("                7 | 8 | 9");
        System.out.println("                  |   |");
        System.out.println("               Enjoy yourself...\n\n");
        String arr[][] = new String[3][3], player = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int f=0, i,j, c=1;
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                arr[i][j] = ".";
            }
        }
        do
        {
            try
            {
                System.out.print("Enter your name : ");
                player = br.readLine();
                f=0;
            }catch(Exception e)
            {
                f=1;
            }
        }while(f==1);
        f=0;
        for(i=1;i<=9;i++)
        {
            if(c%2!=0)
            {
                System.out.println(player+"'s move.");
                enter(arr,c);
                c++;
            }
            display(arr);
            if(hasWon(arr))
            {
                f=1;
                break;
            }
            if(isFull(arr))
            {
                f=0;
                break;
            }
            if(c%2==0)
            {
                computersMove(arr);
                display(arr);
                c++;
            }
            if(hasWon(arr))
            {
                f=2;
                break;
            }
            if(isFull(arr))
            {
                f=0;
                break;
            }
        }
        display(arr);
        if(f==0)
            System.out.println("No winner. Game even.");
        else if(f==1)
            System.out.println("Awesome!!! "+player+" you win!");
        else
            System.out.println("Computer wins.");
        System.out.println();
        main();
    }

    static boolean isFull(String arr[][])
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(arr[i][j].equals("."))
                    return false;
            }
        }
        return true;
    }
}