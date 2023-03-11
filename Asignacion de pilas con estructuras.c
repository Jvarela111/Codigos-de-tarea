#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

typedef struct armadefuego{
	char modelo [15]; 	//m16, scar-h,etc.
	char tipo [15];		//subfusil, escopeta, etc
	int cadencia;		//velocidad de disparo
	int calibre; 		//tipo de bala
	int Cantbalas; 		//cargador
	int distancia; 		//metros de distancia maxima
}Armadefuego;

typedef struct nodo{
	Armadefuego *dato;
	struct nodo *siguiente;
}Nodo;

typedef struct pila{
	Nodo *tope;
	int total;
}Pila;

//Prototipos de los metodos
Armadefuego *crearArma(char modelo [15], char tipo [15], int cadencia, int calibre, int Cantbalas, int distancia);
Nodo *crearNodo(Armadefuego * armadefuego);
Pila *crearPila();
int estaVacia(Pila *pila);
void insertar(Pila *pila, Nodo *nodo);
void imprimir(Pila *pila);
void eliminarUltimo(Pila *pila);
//Prototipos de los metodos

int main(){
	int opc;
	Pila *p;
	Armadefuego *a;
	p = crearPila();
	do{
		printf("\nOpciones del programa \n");
		printf("\n1. Insertar los nodos en la pila \n");
		printf("2. Imprimir la pila \n");
		printf("3. Eliminar el ultimo de la pila \n");
		printf("\nEleccion: ");
		scanf("%d",&opc);
		switch (opc){
			case 1:
				insertar (p, crearNodo(crearArma("Scar", "fusil de asalto", 400, 30, 40, 50)));
				insertar (p, crearNodo(crearArma("Locus", "francotirador", 20, 50, 8, 400)));
				insertar (p, crearNodo(crearArma("Striker", "escopeta", 100, 25, 10, 20)));
				insertar (p, crearNodo(crearArma("MW911", "pistola", 200, 15, 20, 40)));
				insertar (p, crearNodo(crearArma("P90", "subfusil", 500, 22, 30, 35)));
				printf("\n Nodos insertados con exito.\n");
				break;
				
			case 2:
				imprimir(p);
				break;
				
			case 3:
				eliminarUltimo(p);
				break;
			default:
				printf("\n Opcion invalida.\n");
				break;
		}
		printf("\nDesea seguir utilizando el programa? \n");
		printf("\n1. Si \n");
		printf("2. No \n");
		printf("\nEleccion: ");
		scanf("%d",&opc);
	}while(opc!=2);
	return 0;
}

Armadefuego *crearArma(char modelo [15], char tipo [15], int cadencia, int calibre, int Cantbalas, int distancia){
	Armadefuego *aux = (Armadefuego*) malloc(sizeof(Armadefuego));
	strcpy(aux->modelo, modelo);
	strcpy(aux->tipo, tipo);
	aux->cadencia = cadencia;
	aux->calibre = calibre;
	aux->Cantbalas = Cantbalas;
	aux->distancia = distancia;
	return aux;
}

Nodo *crearNodo(Armadefuego * armadefuego){
	Nodo *aux = (Nodo*) malloc(sizeof(Nodo));
	aux->dato = armadefuego;
	aux->siguiente = NULL;
}

Pila *crearPila(Armadefuego * armadefuego){
	Pila *aux = (Pila*) malloc(sizeof(Pila));
	aux->tope = NULL;
	aux->total = 0;
	return aux;
}
//1 si ella esta vacia. 0 si no esta vacia
int estaVacia(Pila * pila){
	if(pila->total==0){
		return 1;
	}else{
		return 0;
	}
}

void insertar(Pila * pila, Nodo * aux){
	if(estaVacia(pila)){
		pila->tope = aux;
	}else{
		aux->siguiente = pila->tope;
		pila->tope = aux;
	}
	
	pila->total++;
}

void imprimir(Pila *pila){
	
	Nodo *aux = pila->tope;
	Armadefuego *a;
	while(aux != NULL){
		a = aux->dato;
		printf("\n Modelo %s  \n", a->modelo);
		printf("\n El arma es de tipo %s ", a->tipo);
		printf("\n El arma tiene una cadencia de %d DPM", a->cadencia);
		printf("\n El arma utiliza balas de calibre .%d ", a->calibre);
		printf("\n El arma posee un cargador base de %d balas", a->Cantbalas);
		printf("\n El arma tiene un alcance maximo de %d metros\n", a->distancia);
		aux = aux->siguiente;
	}
}

void eliminarUltimo(Pila *pila){
	
	if (pila->tope != NULL) {
	    Nodo *aux = pila->tope;
	    pila->tope = aux->siguiente;
	    free(aux->dato);
	    printf("\n Ultimo nodo eliminado con exito.\n");
	}
}