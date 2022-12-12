# AppsDiversos
- Desenvolvimento para Dispositivos Móveis
- Professor: Alessandro Brawerman

--
### Biscoito da Sorte

- A ideia é desenvolver um app que mostre aleatoriamente uma frase de
biscoito da sorte dentre 10 no total.
- Sua activity deve possuir uma forma do usuário pedir a sorte e uma
maneira do app mostrar a sorte do dia.
- Armazene as frases da sorte do dia em uma estrutura de dados.
- Mostre a sorte do dia de forma aleatória, toda vez que o usuário clicar
no botão.

---

### Conversor de moeda

- Faça um app que converta entre as moedas dólar, real e euro.

- Use radio groups e radio buttons para descobrir a moeda origem e a moeda destino.

- Mostre o resultado final da conversão baseado nas taxas:

- 1 Real = 5,50 Dólares 
- 1 Real = 6,20 Euros

---

### TipCalc V1

#### Faça um aplicativo que recebe o valor de uma conta de um restaurante e permita o usuário (a partir de um seekbar) informar a gorjeta a ser paga.

#### Input
* Valor da conta
* Seekbar – valor da gorjeta (em porcentagem)

#### Output
* Valor final da conta (conta + gorjeta)

---

### TipCalc V2

* O objetivo desta app é desenvolver uma calculadora de gorjetas.

* Para tal será projetada uma interface usando o TableLayout e os componentes TextView, EditText e SeekBar.

* O usuário pode dividir a conta em até 10 pessoas.

* Insira na view um seekbar e textview para informar o número de pessoas que irão dividir a conta.

* Insira ainda um textview que informe o preço da conta total (conta + gorjeta) por pessoa.


---

### Cálculadora IMC

* Faça um app que captura dados de um usuário em uma activity e mostra o resultado em uma segunda activity.
* Nome
* Peso
* Altura
* Use as máscaras apropriadas dos EditTexts.
* Não faça um botão para voltar para a tela 1, use o botão padrão do Android.
* IMC = peso / altura2


---

### Formulário

* Faça uma app que captura dados de um usuário em uma activity e
mostra estes em uma segunda activity.
* Nome
* Idade
* Telefone
* Login
* Senha
* Use as máscaras apropriadas dos EditTexts.
* Não faça um botão para voltar para a tela 1, use o botão padrão do Android.

---

### Simple DB

* Crie a classe Java SimpleDBWrapper: vamos usar esta classe para criar e atualizar o BD.
* Crie uma nova classe, StudentOperations, que irá realizar as operações de CRUD no BD.
* Classe de acesso ao BD.
* Nesta classe faremos as ações:
+ Abrir e fechar a base
+ Inserir estudante
+ Deletar o primeiro registro da lista
+ Listar todos os registro da base
+ Parser de registro para objeto estudante

---

### ToDoList

* O objetivo deste app é desenvolver uma lista de tarefas simples para fixação de conceitos e funcionamento de SQLite e Recycler View.
* Adicionar um menu Android para a tela principal.
* Adicionar na tela principal um Recycler View para podermos listar as tarefas gravadas.
* Adicione as opções de salvar em uma activity AddToDoActivity, que será chamada na edição também
* No clique normal no item da recycler view iremos editar a tarefa.
* No clique longo no item da recycler view iremos remover a tarefa, apresentando un dialogo de confirmação.
* Armazenar as tarefas em um banco de dados SQLite.