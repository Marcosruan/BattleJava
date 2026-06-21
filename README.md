# ⚔️ BattleJava
O **BattleJava** é um jogo de RPG de texto (CLI) baseado em turnos desenvolvido em Java puro. O objetivo do jogo é guiar um herói destemido por uma jornada perigosa repleta de batalhas contra as forças do mal, culminando no confronto final contra o temível Rei Demônio.

O projeto aplica fortemente os conceitos de **Programação Orientada a Objetos (POO)**, como Abstração, Herança, Polimorfismo e Encapsulamento, para criar um ecossistema dinâmico de heróis, inimigos, itens e atributos.

---

## 🕹️ Mecânicas do Jogo

O fluxo principal do jogo consiste em **8 fases progressivas**:
1. **Combate em Turnos:** A cada rodada, o jogador escolhe entre atacar, defender, usar poções ou desferir a habilidade especial de sua classe (consome mana). O inimigo responde com uma ação aleatória.
2. **Sistema de Progressão:** Ao vencer um combate, o herói ganha +100 de vida máxima permanentemente, recupera toda a sua vida atual e recebe moedas de ouro baseadas no valor de recompensa do inimigo.
3. **Acesso à Loja:** Entre as batalhas, o jogador pode visitar uma loja dinâmica que sorteia itens de 4 raridades diferentes (Comum, Raro, Épico e Lendário).
4. **Gerenciamento de Inventário:** É possível acessar o inventário fora de combate para consumir itens que aumentam atributos permanentemente.

---

## 🎭 Classes de Heróis Disponíveis

| Classe | Descrição | Atributo Destaque | Habilidade Especial (5) |
| :---: | :--- | :---: | :--- |
| **🏹 Arqueiro** | Herói preciso e equilibrado. | Equilíbrio e Crítico | **Super Flecha:** Causa 2x dano base e **atordoa** o inimigo, impedindo-o de agir no turno. |
| **🪓 Guerreiro** | Combatente blindado focado em resistência. | Vida e Armadura | **Ataque Avassalador:** Causa 3x dano base e ganha **+10 de armadura permanente**. |
| **🧙‍♂️ Mago** | Conjurador místico com alto poder destrutivo. | Dano e Mana | **Bola de Fogo:** Desfere uma explosão mágica massiva baseada em poder místico. |

---

## 🎲 Raridade de Itens da Loja

Os itens que surgem na loja possuem cores dinâmicas no console indicando seu nível de poder:
* ⚪ **Comum** (Cor Padrão) - Itens básicos e baratos.
* 🟢 **Raro** (Verde) - Melhorias moderadas de atributos.
* 🟣 **Épico** (Roxo) - Fortalecimento substancial para o herói.
* 🟡 **Lendário** (Amarelo) - Itens extremamente poderosos com baixa chance de sorteio.

---

## 🛠️ Arquitetura do Projeto

O código está modularizado nos seguintes pacotes:
```text
src/
│
├── itens/
│   └── Item.java
│
├── itens.pocao.mana/
│   ├── PocaoManaG.java
│   ├── PocaoManaM.java
│   └── PocaoManaP.java
│
├── itens.pocao.vida/
│   ├── PocaoVidaG.java
│   ├── PocaoVidaM.java
│   └── PocaoVidaP.java
│
├── itens.runa.armadura/
│   ├── RunaArmaduraG.java
│   ├── RunaArmaduraM.java
│   └── RunaArmaduraP.java
│
├── itens.runa.chanceCritico/
│   ├── RunaChanceCriticoG.java
│   ├── RunaChanceCriticoM.java
│   └── RunaChanceCriticoP.java
│
├── itens.runa.dano/
│   ├── RunaDanoG.java
│   ├── RunaDanoM.java
│   └── RunaDanoP.java
│
├── itens.runa.especial/
│   ├── ChanceCriticoMax.java
│   ├── Critico3x.java
│   ├── DobraDano.java
│   ├── DobraDanoEspecial.java
│   ├── DobraMoeda.java
│   └── DobraVida.java
│
├── itens.runa.mana/
│   ├── RunaManaG.java
│   ├── RunaManaM.java
│   └── RunaManaP.java
│
├── itens.runa.manaRegen/
│   ├── RunaManaRegenG.java
│   ├── RunaManaRegenM.java
│   └── RunaManaRegenP.java
│
├── itens.runa.vida/
│   ├── RunaVidaG.java
│   ├── RunaVidaM.java
│   └── RunaVidaP.java
│
├── jogo/
│   ├── Batalha.java
│   ├── Jogo.java
│   └── Loja.java
│
├── main/
│   └── Main.java
│
├── personagens/
│   ├── AtributoPersonagem.java
│   ├── Heroi.java
│   ├── Inimigo.java
│   └── Personagem.java
│
├── personagens.herois/
│   ├── Arqueiro.java
│   ├── AtributosHeroi.java
│   ├── Guerreiro.java
│   └── Mago.java
│
├── personagens.inimigos/
│   ├── DemonioAlado.java
│   ├── DemonioCaboSupremo.java
│   ├── DemonioCapitaoSupremo.java
│   ├── DemonioComMachado.java
│   ├── DemonioCoronelSupremo.java
│   ├── DemonioMago.java
│   ├── DemonioSargentoSupremo.java
│   └── ReiDemonio.java
│
└── utils/
    ├── Cores.java
    ├── ExibeJogo.java
    ├── InicializaItens.java
    └── TextoGradativo.java
```
## 🚀 Como Executar o Projeto
### Pré-requisitos:

 - Ter o Java JDK 11 ou superior instalado em sua máquina.
 - Ter o Git instalado para clonar o repositório.

### Clonar o Repositório
 - Abra o seu terminal e execute o comando abaixo para clonar o projeto:

   ```bash
   git clone https://github.com/Marcosruan/BattleJava.git
   ```
 - Em seguida, entre na pasta raiz do projeto:

   ```bash
   cd BattleJava
   ```
   
### Executando Sem IDE (Via Terminal)
   - Acesse a pasta fonte do projeto:
   ```bash
   cd src
   ```

   - Compile todos os arquivos .java de uma vez:
   ```bash
   javac main/Main.java jogo/*.java personagens/*.java personagens/herois/*.java personagens/inimigos/*.java utils/*.java itens/*.java itens/pocao/mana/*.java itens/pocao/vida/*.java itens/runa/armadura/*.java itens/runa/chanceCritico/*.java itens/runa/dano/*.java itens/runa/especial/*.java itens/runa/mana/*.java itens/runa/manaRegen/*.java itens/runa/vida/*.java
   ```

   - Execute o jogo através da classe Main:
   ```bash
   java main.Main
   ```
### Executando Com IDE (VS Code, Eclipse ou IntelliJ)
   - Abrir o projeto:
       - No VS Code: Abra o VS Code, vá em File > Open Folder e selecione a pasta raiz BattleJava. Certifique-se de ter a extensão Extension Pack for Java instalada.
        - No Eclipse / IntelliJ: Vá em Import > Existing Projects into Workspace (ou Open no IntelliJ) e selecione a pasta raiz do projeto.
   - Executar:
       - Navegue pelo gerenciador de arquivos até a classe Main.java (localizada dentro de src/main/).
       - Clique com o botão direito no arquivo Main.java e selecione Run Java ou clique no botão de Play (Run) no canto superior direito da tela.
       - O jogo iniciará diretamente pelo console integrado da sua IDE.

## Tecnologias usadas

![Java](https://img.shields.io/badge/Java-orange?style=for-the-badge&logo=java&logoColor=orange)

## 🗃️ **Versão**

    - 1.0.0

## 👨‍💻 Autor

- **Marcos Ruan V. de Figueiredo**  
  [@Marcosruan](https://github.com/Marcosruan)

## 🏛️ **Licença**

    - Distribuído sob a licença GPL2. Acesse `LICENSE.txt` para mais informações.
