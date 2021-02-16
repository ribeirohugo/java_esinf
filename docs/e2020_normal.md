# ESINF 2020 Normal

## Exercício 1

[Ver código Java](../src/e2020_normal/ex1.java)

## Exercício 2

a) O método recebe um _Set_ de strings que são percorridas ``i`` vezes.

Em cada iteração de ``i`` será percorrido o _iésimo_ caracter de cada _string_ e adicionado a uma _LinkedList_ pela ordem
de inserção.

O ciclo termina quando não existir nenhuma string com a extensão de ``i`` caracteres e o resultado final será uma
_LinkedList_ ordenada pelo primeiro caracter de cada _string_ do Set, até ao último caracter da _string_ mais extensa.

b) A complexidade temporal varia consoante o número de elementos do _Set_ e a extensão máxima da _string_ mais longa
pode ser de:
- O(1) - se o Set não tiver elementos e se a _string_ mais extensa tiver 1 caracter.
- O(n) - se o Set só tiver um elemento ou se todos os elementos tiverem apenas 1 caracter.
- O(n^2) - nos restantes casos.
