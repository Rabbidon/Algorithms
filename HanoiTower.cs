//A quick implementation of a tower of Hanoi solver - made with the intention of gaining familiarity with C#
using System;
using System.Collections.Generic;

namespace Algorithms
{
    public class HanoiTower{
        public static void Main(string[] args)
        {
            solve(2,"LEFT","RIGHT","MIDDLE");
        }
        public static void solve(int n, string origin, string destination, string other)
        {
            if (n==1)
            {
                Console.WriteLine(origin+"-->"+destination);
            }
            else
            {
                solve(n-1,origin,other,destination);
                Console.WriteLine(origin+"-->"+destination);
                solve(n-1,other,destination,origin);
            }

        }
    }
}
