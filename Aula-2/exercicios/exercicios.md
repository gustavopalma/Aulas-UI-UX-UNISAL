# Lista de Exercícios – Estrutura de Dados

## Aula 1 – Introdução à Linguagem C

### Exercício 1 – Tipos Primitivos (Conceitual)

Explique com suas próprias palavras:

a) O que são tipos primitivos?

b) Por que existem diferentes tipos de dados em uma linguagem de programação?

c) Cite um exemplo de situação em que utilizar um `char` seja mais adequado do que um `int`.

---

### Exercício 2 – Identificando Tipos

Indique qual seria o tipo mais adequado para armazenar as seguintes informações:

* Idade de uma pessoa
* Nota de um aluno
* Temperatura ambiente
* Quantidade de alunos de uma turma
* Letra do alfabeto
* Situação de um equipamento (ligado ou desligado)

Justifique cada escolha.

---

### Exercício 3 – `stdint.h`

Pesquise e responda:

a) Qual a diferença entre `int` e `int32_t`?

b) Em quais situações é recomendável utilizar os tipos definidos em `stdint.h`?

---

### Exercício 4 – Magic Numbers

Analise o código abaixo:

```c
if (velocidade > 80)
    printf("Multado!\n");
```

Reescreva o código utilizando uma macro para eliminar o *Magic Number*.

---

### Exercício 5 – Criando Macros

Crie macros para representar:

* Número máximo de alunos de uma sala (40)
* Quantidade máxima de produtos em estoque (500)
* Valor de PI (3.1415926535)
* Ano atual

Utilize essas macros em um pequeno programa.

---

### Exercício 6 – Utilizando `typedef`

Crie um programa utilizando `typedef` para definir os seguintes apelidos:

* `byte`
* `inteiro`
* `real`

Declare variáveis utilizando esses novos nomes e exiba seus valores.

---

### Exercício 7 – Descobrindo os Tipos

Escreva um programa que utilize o operador `sizeof()` para informar o tamanho, em bytes, dos seguintes tipos:

* char
* short
* int
* long
* long long
* float
* double
* long double

Compare os resultados obtidos com a tabela apresentada em aula.

---

### Exercício 8 – Investigando a Plataforma

Pesquise qual é o maior valor que pode ser armazenado pelos seguintes tipos utilizando as constantes da biblioteca `limits.h`:

* INT_MAX
* INT_MIN
* CHAR_MAX
* CHAR_MIN

Exiba esses valores em um programa.

---

### Exercício 9 – Organizando um Programa

Escreva um programa que utilize:

* pelo menos três macros;
* um `typedef`;
* tipos de tamanho fixo (`uint8_t` ou `int32_t`).

O programa pode representar qualquer situação do cotidiano (cadastro, estoque, alunos, biblioteca etc.).

---

### Exercício 10 – Pesquisa -- Deixar para a proxima aula

Pesquise e responda, em no máximo uma página:

* O que é um Tipo Abstrato de Dados (TAD)?
* Qual a diferença entre um TAD e uma estrutura de dados?
* Cite três exemplos de TADs utilizados na computação.
