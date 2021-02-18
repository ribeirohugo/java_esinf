# ESINF 2020 Recurso

## Exercício 1

[Ver código Java](../src/e2020_recurso/ex1.java)

## Exercício 2

a) O método recebe um array de ``Integer`` ordenados ascendentemente e permite verificar quantos desses elementos são
menores que um dado Integer x.

Inicialmente o método verifica se o ``x`` é maior ou menor que todos os elementos do array e d seguida realiza um
ciclo ``while`` que vai percorrer o array até encontrar ou não um elemento menor que ``x``. Retorna 0 se forem todos
maiores.

O bom funcionamento pressupõe a introdução de um array ordenado e com pelo menos um elemento.
Com os valores introduzidos o método vai devolver um valor inteiro de 5.

b) No caso do valor de x for maior ou menor que todos os elementos do array, a complexidade do algoritmo será O(1) uma
vez que irá retornar de imediato um valor nas seguintes condições: ``if (a[n-1] < x)`` ``if (a[0] >= x)``.

Caso contrário o algoritmo irá iterar os restantes valores do array através do ciclo ``while (l<u)``, atingindo no pior
dos casos a complexidade de O(n-1).

## Exercício 3

[Ver código Java](../src/e2020_recurso/ex3.java)

## Exercício 5

[Ver código Java](../src/e2020_recurso/ex5.java)
