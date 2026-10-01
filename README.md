# 🎵 MundoMusical

Aplicativo Android desenvolvido com **Jetpack Compose** e **Firebase Authentication**, criado com o objetivo de apresentar diferentes instrumentos musicais do mundo de forma organizada, visual e interativa.

O projeto foi desenvolvido como atividade acadêmica, utilizando **Kotlin**, **Jetpack Compose** para construção da interface e **Firebase Authentication** para gerenciamento de autenticação dos usuários.

---

## 📱 Sobre o projeto

O **MundoMusical** é um aplicativo voltado para a apresentação e exploração de instrumentos musicais de diferentes partes do mundo.

A proposta do aplicativo é permitir que o usuário tenha uma experiência simples e intuitiva, podendo realizar seu cadastro, entrar no aplicativo por meio de login e acessar uma tela principal relacionada ao universo dos instrumentos musicais.

O projeto também possui uma **identidade visual própria**, baseada no tema musical e na ideia de diversidade cultural presente nos instrumentos de diferentes regiões do mundo.

---

# 🎨 Identidade Visual

A identidade visual foi desenvolvida especificamente para o tema **Instrumentos Musicais do Mundo**, evitando uma aparência genérica de aplicativo padrão.

### 🎵 Conceito visual

A interface utiliza elementos relacionados diretamente à música, buscando transmitir a ideia de:

* Música;
* Diversidade cultural;
* Instrumentos musicais;
* Exploração de diferentes culturas;
* Organização e facilidade de navegação.

A escolha dos elementos visuais foi pensada para que o usuário consiga identificar rapidamente a finalidade do aplicativo.

### 🎨 Cores

A paleta de cores foi escolhida para criar uma aparência relacionada ao universo musical e proporcionar contraste adequado entre os elementos da interface.

As cores são utilizadas de maneira consistente entre as telas, principalmente em:

* Botões;
* Campos de entrada;
* Títulos;
* Fundos;
* Elementos de destaque;
* Componentes de navegação.

Dessa forma, a mesma identidade visual é mantida durante a utilização do aplicativo.

### 🎼 Elementos gráficos

Os elementos gráficos utilizados no aplicativo possuem relação com o tema musical.

A composição visual procura associar a interface aos instrumentos musicais e à diversidade cultural, fazendo com que o tema do aplicativo esteja presente não apenas no conteúdo, mas também na aparência das telas.

---

# 🖼️ Wireframe do aplicativo

Antes da implementação da interface, foi planejada a estrutura das telas e o fluxo de navegação do aplicativo por meio de um **wireframe**.

O wireframe serviu como referência para definir a organização dos elementos, a disposição dos componentes e a navegação entre as telas.

A estrutura principal planejada é composta pelas seguintes telas:

1. Tela de Login;
2. Tela de Cadastro;
3. Tela Principal;
4. Fluxo de acesso entre autenticação e conteúdo do aplicativo.

---

# 📐 Estrutura do Wireframe

## 1. Tela de Login

A tela de login é o primeiro ponto de acesso do usuário ao aplicativo.

### Elementos planejados

A tela contém:

* Identificação visual do MundoMusical;
* Título do aplicativo;
* Campo para inserção do e-mail;
* Campo para inserção da senha;
* Botão para realizar o login;
* Opção para acessar a tela de cadastro.

### Objetivo da tela

Permitir que usuários já cadastrados realizem autenticação para acessar o conteúdo do aplicativo.

### Fluxo

```text
TELA DE LOGIN
     │
     ├── Usuário informa e-mail
     │
     ├── Usuário informa senha
     │
     └── Clica em "Entrar"
             │
             ▼
       Firebase Authentication
             │
             ▼
       Tela Principal
```

---

# 2. Tela de Cadastro

A tela de cadastro foi planejada para permitir que um novo usuário crie uma conta.

### Elementos planejados

A tela apresenta:

* Identidade visual do aplicativo;
* Título relacionado ao cadastro;
* Campo de e-mail;
* Campo de senha;
* Campo para confirmação ou informações necessárias ao cadastro;
* Botão para criar a conta;
* Opção para retornar à tela de login.

### Objetivo

Permitir que novos usuários sejam registrados no sistema utilizando o Firebase Authentication.

### Fluxo

```text
TELA DE LOGIN
     │
     └── "Criar conta"
             │
             ▼
      TELA DE CADASTRO
             │
             ├── E-mail
             ├── Senha
             │
             └── "Cadastrar"
                    │
                    ▼
          Firebase Authentication
                    │
                    ▼
             Acesso ao aplicativo
```

---

# 3. Tela Principal

Depois da autenticação, o usuário é direcionado para a tela principal do MundoMusical.

Essa tela representa o conteúdo central do aplicativo.

### Elementos planejados

A tela principal apresenta:

* Identidade visual do MundoMusical;
* Título relacionado aos instrumentos musicais;
* Conteúdo sobre instrumentos;
* Elementos visuais relacionados à música;
* Organização das informações de maneira simples;
* Opções de navegação disponíveis no aplicativo.

### Objetivo

Apresentar ao usuário o conteúdo principal relacionado aos instrumentos musicais do mundo.

A organização da tela foi pensada para evitar excesso de informações e facilitar a compreensão do conteúdo.

---

# 🧭 Fluxo de Navegação

O fluxo geral planejado para o aplicativo é:

```text
                 ┌─────────────────┐
                 │  Tela de Login  │
                 └────────┬────────┘
                          │
             ┌────────────┴────────────┐
             │                         │
             ▼                         ▼
     ┌───────────────┐         ┌────────────────┐
     │    Login      │         │    Cadastro    │
     │    válido     │         │   de usuário   │
     └───────┬───────┘         └───────┬────────┘
             │                         │
             │                         ▼
             │                 Firebase Authentication
             │                         │
             └────────────┬────────────┘
                          ▼
                 ┌─────────────────┐
                 │  Tela Principal │
                 │  MundoMusical   │
                 └─────────────────┘
```

Esse fluxo foi utilizado como base para a implementação da navegação no aplicativo.

---

# 🔥 Firebase Authentication

O aplicativo utiliza o **Firebase Authentication** para realizar o gerenciamento da autenticação dos usuários.

A autenticação é feita utilizando **e-mail e senha**.

## Funcionalidades de autenticação

O sistema permite:

* Criar uma nova conta;
* Realizar login;
* Validar as credenciais do usuário;
* Identificar usuários autenticados;
* Controlar o acesso às áreas do aplicativo.

### Funcionamento

Quando o usuário realiza um cadastro, os dados de autenticação são enviados ao Firebase.

No login, o aplicativo utiliza as credenciais informadas pelo usuário para realizar a autenticação.

De forma simplificada:

```text
Usuário
   │
   ▼
Aplicativo MundoMusical
   │
   ▼
Firebase Authentication
   │
   ├── Credenciais válidas
   │        │
   │        ▼
   │   Usuário autenticado
   │        │
   │        ▼
   │   Tela Principal
   │
   └── Credenciais inválidas
            │
            ▼
      Mensagem de erro
```

---

# 🛠️ Tecnologias utilizadas

O projeto foi desenvolvido utilizando:

* **Kotlin**
* **Android Studio**
* **Jetpack Compose**
* **Material 3**
* **Firebase Authentication**
* **Gradle**
* **Git**
* **GitHub**

---

# 🏗️ Arquitetura e organização

O projeto foi organizado de maneira a separar as responsabilidades da aplicação.

Entre os principais componentes utilizados estão:

* `MainActivity`
* `AuthViewModel`
* `LoginScreen`
* `SignupScreen`
* `HomeScreen`
* `Theme.kt`

### MainActivity

Responsável pelo ponto de entrada da aplicação e pela inicialização da interface.

### AuthViewModel

Responsável pela lógica relacionada à autenticação dos usuários.

### LoginScreen

Responsável pela interface de login.

### SignupScreen

Responsável pela interface de cadastro.

### HomeScreen

Responsável pela apresentação do conteúdo principal do MundoMusical.

### Theme.kt

Responsável pelas configurações relacionadas ao tema e à identidade visual da aplicação.

---

# 📱 Telas do aplicativo

## Tela de Login

A tela de login apresenta a identidade visual do MundoMusical e permite que usuários cadastrados informem suas credenciais.

**Principais elementos:**

* Logo/identificação do aplicativo;
* Campo de e-mail;
* Campo de senha;
* Botão de login;
* Acesso ao cadastro.

---

## Tela de Cadastro

Permite que novos usuários criem uma conta.

**Principais elementos:**

* Identificação visual do MundoMusical;
* Campos de cadastro;
* Botão de criação da conta;
* Navegação para retornar ao login.

---

## Tela Principal

Após o login, o usuário acessa o conteúdo principal do aplicativo.

**Principais elementos:**

* Identidade visual;
* Título;
* Conteúdo relacionado aos instrumentos musicais;
* Elementos gráficos relacionados ao tema.

---

# ⚙️ Funcionalidades

O aplicativo possui como principais funcionalidades:

### 🔐 Autenticação

* Cadastro de usuário;
* Login com e-mail e senha;
* Validação das credenciais;
* Integração com Firebase Authentication.

### 🎵 Conteúdo musical

* Apresentação do tema de instrumentos musicais;
* Organização do conteúdo relacionado à música;
* Interface desenvolvida especificamente para o tema.

### 🎨 Interface

* Identidade visual própria;
* Interface desenvolvida com Jetpack Compose;
* Organização baseada no wireframe;
* Componentes reutilizáveis;
* Navegação entre as telas.

---

# 📋 Requisitos do projeto

Para executar o projeto, é necessário possuir:

* Android Studio;
* JDK compatível com o projeto;
* Android SDK;
* Gradle;
* Uma conta/projeto configurado no Firebase;
* Dispositivo Android ou emulador.

---

# 🔥 Configuração do Firebase

Para utilizar a autenticação do Firebase, é necessário configurar um projeto no Firebase Console.

O aplicativo utiliza o arquivo:

```text
google-services.json
```

Esse arquivo deve ser colocado no diretório:

```text
app/google-services.json
```

No Firebase Authentication, deve ser habilitado o método de autenticação:

```text
E-mail e senha
```

Após a configuração, o aplicativo poderá utilizar os serviços de autenticação.

> **Observação:** o arquivo `google-services.json` contém configurações específicas do projeto Firebase e não deve ser substituído por um arquivo de outro projeto.

---

# ▶️ Como executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/Herley777/MundoMusicalApp.git
```

### 2. Abrir no Android Studio

Abra a pasta clonada no Android Studio.

### 3. Configurar o Firebase

Adicione o arquivo:

```text
app/google-services.json
```

e configure o Firebase Authentication.

### 4. Sincronizar o Gradle

Aguarde o Android Studio concluir a sincronização das dependências.

### 5. Executar

Selecione um dispositivo físico ou emulador Android e execute o aplicativo.

---

# 🎯 Objetivo acadêmico

O desenvolvimento do MundoMusical teve como objetivo aplicar na prática conceitos de:

* Desenvolvimento Android;
* Kotlin;
* Jetpack Compose;
* Construção de interfaces;
* Identidade visual;
* Wireframe;
* Navegação entre telas;
* Autenticação de usuários;
* Firebase;
* Organização de projetos Android.

Além da implementação das funcionalidades, o projeto buscou transformar o planejamento visual realizado no wireframe em uma aplicação funcional.

---

# 📊 Relação entre Wireframe e Aplicativo

O wireframe foi utilizado como referência durante o desenvolvimento da aplicação.

| Wireframe             | Implementação                             |
| --------------------- | ----------------------------------------- |
| Tela de Login         | `LoginScreen`                             |
| Tela de Cadastro      | `SignupScreen`                            |
| Tela Principal        | `HomeScreen`                              |
| Fluxo de autenticação | `AuthViewModel` + Firebase Authentication |
| Identidade visual     | `Theme.kt` e componentes Compose          |
| Navegação             | Fluxo entre as telas                      |

Essa relação demonstra como o planejamento inicial da interface foi transformado em componentes funcionais dentro do aplicativo.

---

# 📂 Estrutura simplificada

```text
MundoMusicalApp/
│
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/example/mundomusical/
│   │       │
│   │       ├── res/
│   │       │
│   │       └── AndroidManifest.xml
│   │
│   ├── google-services.json
│   └── build.gradle.kts
│
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

---

# 👨‍💻 Autor

**Daniel Bispo**

Projeto acadêmico desenvolvido utilizando Android Studio, Kotlin, Jetpack Compose e Firebase Authentication.

---

# 🔗 Repositório

GitHub:

https://github.com/Herley777/MundoMusicalApp

---

# 🎥 Demonstração

Vídeo demonstrativo do aplicativo:

****[Vídeo demonstrativo do MundoMusical](https://youtube.com/shorts/32akq4s1Uuk?feature=share)****

O vídeo demonstra o funcionamento do aplicativo, incluindo:

1. Abertura do MundoMusical;
2. Identidade visual;
3. Tela de login;
4. Cadastro de usuário;
5. Autenticação pelo Firebase;
6. Acesso à tela principal;
7. Apresentação do conteúdo do aplicativo.

---

# 📌 Conclusão

O **MundoMusical** foi desenvolvido como uma aplicação Android utilizando **Kotlin, Jetpack Compose e Firebase Authentication**.

O projeto contempla tanto a parte funcional, com cadastro e autenticação de usuários, quanto a parte visual, com uma identidade desenvolvida de acordo com o tema **Instrumentos Musicais do Mundo**.

O wireframe foi utilizado como base para organizar as telas e definir o fluxo de navegação, permitindo que o planejamento inicial fosse convertido em uma aplicação funcional.

Dessa forma, o projeto reúne **planejamento, identidade visual, desenvolvimento da interface, navegação e autenticação**, demonstrando a aplicação prática dos conceitos estudados durante a atividade.
