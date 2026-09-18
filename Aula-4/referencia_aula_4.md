# Aula 4 — Internacionalização, Regionalização e Acessibilidade

**Disciplina:** UI & UX  
**Duração planejada:** 4 horas  
**Stack prática:** Android, Kotlin, Jetpack Compose e Material Design 3

## Objetivos da aula

Ao final da aula, o aluno deverá ser capaz de explicar a diferença entre internacionalização e localização/regionalização, retirar textos fixos do código Android, criar recursos para múltiplos idiomas, respeitar convenções regionais de números/datas/moedas e identificar/aplicar melhorias básicas de acessibilidade em interfaces Compose, incluindo semântica, `contentDescription`, contraste, tamanho de alvo e escalabilidade de texto.

## Roteiro sugerido para 4 horas

### Bloco 1 — Internacionalização — ~55 min

Comece com a pergunta: **“Se eu trocar o celular para inglês agora, o que acontece com o nosso aplicativo?”**. Mostre um `Text("Salvar")` e faça a passagem para `stringResource(R.string.save)`.

Conceitos:

- **i18n (internationalization):** preparar a arquitetura do software para múltiplos contextos linguísticos/culturais.
- **l10n (localization):** produzir a adaptação concreta para uma localidade.
- Regionalização não é só tradução: formatos, símbolos, convenções e direção de leitura também mudam.

### Resources e strings

Evitar:

```kotlin
Text("Configurações")
```

Preferir:

```kotlin
Text(
    text = stringResource(R.string.settings)
)
```

`res/values/strings.xml`:

```xml
<resources>
    <string name="app_name">Calculadora</string>
    <string name="settings">Configurações</string>
    <string name="save">Salvar</string>
</resources>
```

`res/values-en/strings.xml`:

```xml
<resources>
    <string name="app_name">Calculator</string>
    <string name="settings">Settings</string>
    <string name="save">Save</string>
</resources>
```

O código não precisa saber qual idioma está ativo. Ele solicita um recurso e o Android escolhe a melhor alternativa.

### Resources qualifiers

Exemplos:

```text
res/values/strings.xml
res/values-en/strings.xml
res/values-es/strings.xml
res/values-pt-rBR/strings.xml
```

Mantenha um conjunto padrão completo em `values/`. Ele é o fallback quando não existe uma alternativa mais específica.

### Strings parametrizadas

Não construa frases localizáveis concatenando pedaços:

```kotlin
Text("Olá, " + nome + "!")
```

Use parâmetros:

```xml
<string name="welcome">Olá, %1$s!</string>
```

```kotlin
Text(stringResource(R.string.welcome, nome))
```

Isso permite que outro idioma altere a ordem dos termos.

### Plurais

```xml
<plurals name="items">
    <item quantity="one">%d item</item>
    <item quantity="other">%d itens</item>
</plurals>
```

```kotlin
val texto = pluralStringResource(
    R.plurals.items,
    quantidade,
    quantidade
)
```

O ponto didático é: **pluralização é uma regra da língua, não um `if (n > 1) + "s"`.**

---

## Bloco 2 — Regionalização — ~45 min

### Locale

Uma `Locale` representa preferências linguísticas/regionais. Exemplos: `pt-BR`, `en-US`, `en-GB`. Dois usuários podem falar o mesmo idioma e ainda utilizar formatos diferentes.

### Números

O número `1234.56` pode aparecer como `1.234,56` ou `1,234.56`.

```kotlin
val formatter = NumberFormat.getNumberInstance()
val texto = formatter.format(1234.56)
```

### Moedas

Evite:

```kotlin
"R$ " + preco
```

Use:

```kotlin
val formatter = NumberFormat.getCurrencyInstance()
val texto = formatter.format(1234.50)
```

### Datas

Uma data numérica como `09/11/2026` é ambígua internacionalmente.

```kotlin
val formatter = DateFormat.getDateInstance(DateFormat.MEDIUM)
val texto = formatter.format(Date())
```

### RTL

Idiomas como árabe e hebraico utilizam direção de leitura da direita para a esquerda. Pense em **start/end**, não em esquerda/direita. O layout também faz parte da localização.

### Idioma por aplicativo

No Android 13+ o sistema possui suporte a preferência de idioma por aplicativo. Em projetos modernos também é possível configurar os idiomas suportados e integrá-los às configurações do sistema. Para a aula, o ponto principal é diferenciar isso de uma variável própria que simplesmente troca algumas strings.

### Demonstração sugerida

Abra o mesmo app em português e inglês e compare:

1. largura dos textos;
2. alinhamento;
3. datas;
4. números;
5. textos esquecidos no código.

---

## Intervalo / transição — ~10 min

Pergunta para a turma: **“Se eu remover a tela e deixar apenas a informação que um leitor de tela consegue obter, nosso aplicativo ainda é utilizável?”**

---

## Bloco 3 — Acessibilidade — ~70 min

### Acessibilidade não é um modo especial

Acessibilidade faz parte da qualidade da experiência. Considere deficiências permanentes, limitações temporárias e situações contextuais. Uma pessoa segurando uma criança no colo, usando o celular sob sol forte ou com uma mão ocupada também pode se beneficiar de decisões inclusivas.

### TalkBack e árvore semântica

O TalkBack não interpreta a interface como uma pessoa olhando a tela. Ele utiliza informações semânticas: conteúdo, função, estado e ações.

Compose e Material já fornecem muita semântica automaticamente. Componentes customizados exigem mais atenção.

### `contentDescription`

Para uma ação representada somente por ícone:

```kotlin
Icon(
    imageVector = Icons.Default.Delete,
    contentDescription = stringResource(R.string.cd_delete)
)
```

Uma descrição ruim descreve o desenho:

```text
"ícone vermelho de uma lixeira"
```

Uma descrição melhor comunica a função:

```text
"Excluir arquivo"
```

### Quando usar `contentDescription = null`

Elementos decorativos não devem poluir a navegação do leitor de tela.

```kotlin
Icon(
    imageVector = Icons.Default.Star,
    contentDescription = null
)
```

Também evite duplicação. Se um `Button` contém ícone + `Text("Salvar")`, normalmente o texto já comunica a ação e o ícone pode ser decorativo.

```kotlin
Button(onClick = onSave) {
    Icon(
        Icons.Default.Save,
        contentDescription = null
    )
    Text(stringResource(R.string.save))
}
```

### Acessibilidade também precisa de internacionalização

Não faça:

```kotlin
contentDescription = "Excluir"
```

Faça:

```kotlin
contentDescription = stringResource(R.string.cd_delete)
```

Esse é um ótimo ponto de ligação entre as duas metades da aula.

### Semântica customizada

```kotlin
Modifier.semantics {
    contentDescription = "Adicionar produto"
}
```

Para estado:

```kotlin
Modifier.semantics {
    stateDescription = if (ligado) "Ativado" else "Desativado"
}
```

Em um projeto internacionalizado, essas descrições também devem vir de resources.

### Agrupando elementos relacionados

```kotlin
Row(
    modifier = Modifier.semantics(
        mergeDescendants = true
    ) { }
) {
    Icon(...)
    Text("Wi-Fi")
    Text("Conectado")
}
```

O objetivo é transformar vários elementos visuais relacionados em uma unidade semântica coerente quando isso melhorar a navegação.

### Área de toque

A referência mínima para elementos interativos Android é **48 × 48 dp**. O desenho interno pode ser menor. Um ícone de 24 dp pode estar dentro de um `IconButton` com área interativa adequada.

```kotlin
IconButton(onClick = onDelete) {
    Icon(
        Icons.Default.Delete,
        contentDescription = stringResource(R.string.cd_delete)
    )
}
```

### Contraste

Como referência de qualidade Android:

- texto pequeno: 4,5:1;
- texto grande e gráficos essenciais: 3:1.

Conecte isso à aula de temas: um tema bonito pode ser um tema ruim se destruir contraste ou hierarquia.

### Não depender apenas da cor

Ruim: campo vermelho para indicar erro.

Melhor: cor + ícone + mensagem textual.

```kotlin
if (erro) {
    Row {
        Icon(
            Icons.Default.Warning,
            contentDescription = null
        )
        Text(stringResource(R.string.invalid_value))
    }
}
```

O ícone pode ser decorativo porque a mensagem já comunica o erro.

### Fonte ampliada

O usuário controla a escala de fonte. Teste a interface com texto maior. Evite alturas fixas quando elas podem cortar conteúdo e prefira os papéis de `MaterialTheme.typography`.

### Foco

Pergunte:

- a ordem de navegação é lógica?
- o foco está visível?
- consigo acessar ações importantes por teclado/tecnologia assistiva?
- componentes customizados mantêm comportamento esperado?

---

## Bloco 4 — Prática guiada — ~60 min

### Exercício A — Internacionalizar um app existente

Usar a calculadora ou o app do acelerômetro:

1. procurar strings fixas no Kotlin;
2. movê-las para `strings.xml`;
3. criar `values-en/strings.xml`;
4. executar em português;
5. executar em inglês;
6. observar quebras de layout.

Exemplo para o acelerômetro:

```xml
<string name="axis_value">%1$s: %2$.2f m/s²</string>
<string name="linear_acceleration">Aceleração linear</string>
<string name="gravity">Gravidade</string>
```

```kotlin
Text(
    text = stringResource(
        R.string.axis_value,
        "X",
        valorX
    )
)
```

### Exercício B — Auditoria de acessibilidade

No mesmo app:

1. localizar ícones de ação;
2. revisar `contentDescription`;
3. remover descrições redundantes de elementos decorativos;
4. procurar informação transmitida apenas por cor;
5. verificar alvos de toque;
6. aumentar o tamanho da fonte;
7. testar com TalkBack.

### Desafio de experiência

Peça para os alunos utilizarem o app com TalkBack por alguns minutos **sem olhar para a tela**. Depois pergunte:

- Qual era a primeira informação anunciada?
- A ordem fazia sentido?
- Havia “botão sem nome”?
- Alguma informação era repetida?
- Alguma ação era impossível de compreender?

Isso torna a discussão de semântica muito mais concreta.

---

## Checklist do professor

### Internacionalização

- [ ] textos saíram do Kotlin;
- [ ] `strings.xml` padrão está completo;
- [ ] existe pelo menos um idioma alternativo;
- [ ] strings parametrizadas não são concatenadas;
- [ ] plural usa resources adequados;
- [ ] números/datas/moedas usam formatação regional;
- [ ] layout suporta textos de comprimentos diferentes;
- [ ] foi discutido RTL.

### Acessibilidade

- [ ] TalkBack foi demonstrado;
- [ ] `contentDescription` foi explicado;
- [ ] foi mostrado quando usar `null`;
- [ ] descrições estão internacionalizadas;
- [ ] semântica do Compose foi apresentada;
- [ ] alvo de toque de 48 dp foi discutido;
- [ ] contraste foi relacionado aos temas;
- [ ] informação não depende só de cor;
- [ ] escala de fonte foi testada;
- [ ] foco/navegação foi discutido.

## Frases-chave

> Internacionalização prepara a aplicação; localização adapta a experiência.

> O componente visual é aquilo que enxergamos. A semântica é aquilo que a interface significa.

> Se uma informação existe apenas na cor, ela não existe para todos os usuários.

> `contentDescription` não deve descrever o desenho do botão; deve comunicar o que ele significa ou faz.

> Uma interface acessível não é uma versão especial da interface. É uma interface melhor especificada.

## Referências técnicas consultadas

- Android Developers — Localizar o aplicativo.
- Android Developers — Acessibilidade no Jetpack Compose.
- Android Developers — Semântica no Compose.
- Android Developers — Core App Quality.
- Android Developers — Android 13: idiomas por aplicativo.
