#include <stdio.h>
main()
{
int n;
long int factorial (int n);

printf("Introducir la cantidad entera a la que le queremos hallar el factorial: ");
scanf("%d", &n);

printf("%d! = %d\n", n, factorial(n));
}

long int factorial (int n)   /* Calcular el factorial */
{

if (n <= 1)
return(1);
else
return(n * factorial (n-1));
}