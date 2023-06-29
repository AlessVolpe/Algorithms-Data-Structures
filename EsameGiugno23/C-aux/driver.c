#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "graph.h"
#include "graph_services.h"

void print_help() {
	printf("Richiesto argomento: {distances}\n");
}

int main(int argc, char** argv) {
	if (argc != 2) {
		print_help();
		return EXIT_FAILURE;
	}
	else if (strcmp(argv[1], "distances") == 0) {
		graph *gra = graph_new();

		graph_node *a = graph_add_node(gra, "A");
		graph_node *b = graph_add_node(gra, "B");
		graph_node *c = graph_add_node(gra, "C");
		graph_node *d = graph_add_node(gra, "D");
		graph_node *e = graph_add_node(gra, "E");
		graph_node *f = graph_add_node(gra, "F");
		graph_node *g = graph_add_node(gra, "G");
		graph_node *h = graph_add_node(gra, "H");
		graph_node *i = graph_add_node(gra, "I");
		graph_node *l = graph_add_node(gra, "L");



		graph_add_edge(gra,a, e);
		graph_add_edge(gra,b, a);
		graph_add_edge(gra,b, d);
		graph_add_edge(gra,c, e);		
		graph_add_edge(gra,d, g);
		graph_add_edge(gra,d, i);
		graph_add_edge(gra,e, b);
		graph_add_edge(gra,e, d);
		graph_add_edge(gra,f, c);		
		graph_add_edge(gra,f, e);		
		graph_add_edge(gra,f, h);		
		graph_add_edge(gra,f, l);		
		graph_add_edge(gra,g, h);		
		graph_add_edge(gra,h, l);		
		graph_add_edge(gra,l, i);


		printf("Grafo:\n\n");
		graph_print(gra);
		printf("\n");

		printf("Il tuo programma dovrebbe stampare:\n");
				
		printf("Nodo A --> {A:0,E:1,B:2,D:2,G:3,I:3,H:4,L:5}\n");
		printf("Nodo B --> {B:0,A:1,D:1,E:2,G:2,I:2,H:3,L:4}\n");
		printf("Nodo C --> {C:0,E:1,B:2,D:2,A:3,G:3,I:3,H:4,L:5}\n");
		printf("Nodo D --> {D:0,G:1,I:1,H:2,L:3}\n");
		printf("Nodo E --> {E:0,B:1,D:1,A:2,G:2,I:2,H:3,L:4}\n");
		printf("Nodo F --> {F:0,C:1,E:1,H:1,L:1,B:2,D:2,I:2,A:3,G:3}\n");
		printf("Nodo G --> {G:0,H:1,L:2,I:3}\n");
		printf("Nodo H --> {H:0,L:1,I:2}\n");
		printf("Nodo I --> {I:0}\n");
		printf("Nodo L --> {L:0,I:1}\n");
		printf("\n\n");

		printf("Il tuo programma stampa:\n");
		distances(gra);

		graph_delete(gra);
	}
}

