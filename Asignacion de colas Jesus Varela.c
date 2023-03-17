#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

typedef struct futbolista{
	char nombre [10];
	int Balondeoro;		//velocidad de disparo
	int Botadeoro; 		//tipo de bala
	int mundial; 		//cargador
	int champions; 		//metros de champions maxima
}Futbolista;

typedef struct nodo {
    struct futbolista * data;
    struct nodo* sig ;
}Nodo;

typedef struct cola {
    Nodo *primero, *ultimo;
}Cola;

Futbolista *crearJugador( char nombre [10], int Balondeoro, int Botadeoro, int mundial, int champions){
	Futbolista*nuevo = (Futbolista*) malloc(sizeof(Futbolista));
	strcpy(nuevo->nombre, nombre);
	nuevo->Balondeoro = Balondeoro;
	nuevo->Botadeoro = Botadeoro;
	nuevo->mundial = mundial;
	nuevo->champions = champions;
	return nuevo;
}

Nodo *crearNodo (Futbolista *futbolista){
    Nodo * nuevo =  (Nodo*) malloc( sizeof (Nodo));
    nuevo->data = futbolista;
    nuevo->sig  = NULL;
}

Cola * crearCola(){
    Cola * c = (Cola*)  malloc (sizeof (Cola));
    c->primero = c->ultimo = NULL;
    return c;
}

void  enQueue (Nodo* nuevo, Cola * c ){

    if(c->primero == NULL){
		c->primero = c->ultimo = nuevo;
    return;
    }

    //si la cola no esta vacia
    c->ultimo->sig = nuevo;
    c->ultimo = nuevo;
}

void deQueue(int i, Nodo*eliminado, Cola *c){
	
     if( c->primero==NULL  )  return 0;

     //que ocurrre si la cola no esta vacia
    eliminado = c->primero;
    printf("\nDatos eliminados numero %d\n", i+1);
    printf("\Jugador: %s",eliminado->data->nombre);
    printf("\nBalon de oro: %d",eliminado->data->Balondeoro);
    printf("\nBota de oro: %d",eliminado->data->Botadeoro);
    printf("\nMundiales: %d",eliminado->data->mundial);
    printf("\nChampions: %d\n",eliminado->data->champions);

      //eliminamos el nodo de la cola
      c->primero = c->primero->sig;

      if(c->primero==NULL){
        c->ultimo = NULL;
      }

      free(eliminado);
}

void mostrar ( Cola * c){
	Futbolista*data;
    if ( c ->primero==NULL) return printf("\nCola vacia\n");
    //si no esta vacia
    printf("\n \t\t Primero | Ultimo \n");
    printf("\nNombre:  \t  %s  | %s \n", c->primero->data->nombre, c->ultimo->data->nombre );
    printf("Balones de oro:     %d    |   %d \n", c->primero->data->Balondeoro, c->ultimo->data->Balondeoro );
	printf("Botas de oro:\t    %d    |   %d \n", c->primero->data->Botadeoro, c->ultimo->data->Botadeoro );
	printf("Mundiales:\t    %d    |   %d\n", c->primero->data->mundial, c->ultimo->data->mundial );
	printf("Champions:\t    %d    |   %d \n", c->primero->data->champions, c->ultimo->data->champions );
	printf("\nCola completa actual\n");
    Nodo *actual = c->primero;

    while(actual){
    	printf ("\n%s,  ", actual->data->nombre);
        printf ("\t%d,  ", actual->data->Balondeoro);
        printf ("%d,  ", actual->data->Botadeoro);
        printf ("%d,  ", actual->data->mundial);
        printf ("%d,  ", actual->data->champions);
        actual = actual->sig;
    }

    printf ("\n----------\n ");


}

int main (){
	int opc;
	struct futbolista *data;
	Cola *c;
	c = crearCola();
	do{
		printf("\nOpciones del programa \n");
		printf("\n1. Insertar los nodos en la cola \n");
		printf("2. Imprimir la cola \n");
		printf("3. Eliminar elementos de la oola \n");
		printf("\nEleccion: ");
		scanf("%d",&opc);
		switch (opc){
			case 1:
			    enQueue ( crearNodo (crearJugador( "Messi", 7, 6, 1, 4) ), c);
			    enQueue( crearNodo (crearJugador("Cristiano", 5, 4, 0, 5) ), c);
			    enQueue( crearNodo (crearJugador("Suarez", 0, 2, 0, 1) ), c);
			    enQueue( crearNodo (crearJugador("Zidane", 1, 0, 1, 1) ), c);
    		break;
			case 2:
		    	mostrar(c);
		    break;
			
			case 3:
				printf("\nCuantos jugadores quieres sacar de la cola?: \n");
				scanf("%d",&opc);
				for( int i = 0; i < opc ; i++){
		    	deQueue(i,data,c);
		    	}
				break;
			
			default:
				printf("\nDato invalido\n");
		}
		    printf("\nDesea seguir utilizando el programa? \n");
				printf("\n1. Si \n");
				printf("2. No \n");
				printf("\nEleccion: ");
				scanf("%d",&opc);

	}while(opc!=2);

    return 0;
}
