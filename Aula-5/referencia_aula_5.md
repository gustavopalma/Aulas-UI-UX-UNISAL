# Aula 5 — Arquitetura e História da Web

## Objetivo
Introduzir a Web como plataforma antes de iniciar HTML, CSS, JavaScript e Vue.js. A aula conecta história, arquitetura e protocolos ao eixo de UI & UX.

## Linha narrativa
1. Internet não é Web.
2. A Internet surge de pesquisa em redes e comutação de pacotes.
3. ARPANET conecta quatro hosts em 1969.
4. E-mail torna-se uma aplicação importante no início dos anos 1970.
5. Kahn e Cerf desenvolvem a arquitetura que evolui para TCP/IP.
6. Em 1/1/1983, ARPANET migra para TCP/IP.
7. A Web é proposta por Tim Berners-Lee no CERN em 1989.
8. URL/URI, HTTP e HTML formam a base da Web.
9. O primeiro website aparece no CERN e a tecnologia é liberada publicamente em 1993.
10. A Web evolui de documentos para aplicações complexas.

## Pontos para enfatizar
- Internet = infraestrutura/rede de redes. Web = serviço/aplicação sobre essa infraestrutura.
- Cliente e servidor são papéis.
- DNS resolve nomes; HTTP define a conversa de aplicação; TCP/IP sustenta a comunicação em rede.
- HTTPS é HTTP protegido por TLS e hoje é o padrão esperado na Web pública.
- `file://` acessa um arquivo local; `http://localhost/...` faz uma requisição a um servidor local.
- No laboratório, o Apache do WampServer é suficiente. PHP e MySQL não são necessários para arquivos estáticos.
- Alternativa simples: `python -m http.server 8000`.
- Vite será introduzido mais adiante junto ao fluxo moderno de Vue.

## Atividade sugerida
Criar um `index.html`, servi-lo via Apache/WampServer ou Python, abrir DevTools e localizar a requisição na aba Network. A atividade serve para tornar concreta a diferença entre arquivo local e recurso servido via HTTP.

## Fontes para atualização histórica
- CERN — The birth of the Web: https://home.cern/science/computing/the-birth-of-the-web/
- Internet Society — A Brief History of the Internet: https://www.internetsociety.org/internet/history-internet/brief-history-internet/
- MDN — How the Web works: https://developer.mozilla.org/en-US/docs/Learn_web_development/Getting_started/Web_standards/How_the_web_works

## Observação sobre o material de 2017
A estrutura conceitual de cliente/servidor, protocolos e servidores foi reaproveitada. Foram modernizadas as explicações de HTTPS, a distinção entre Internet e Web e o papel dos ambientes locais. A tirinha do Vida de Programador e imagens históricas foram mantidas como conexão com o material original.
