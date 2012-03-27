# language: pt
Funcionalidade: Pack 02
  Contexto:
	Dado que o nível possui 2 movimentos possíveis
	
  Cenário: Resolver o pack 2, nível 1
    Dado que a cabeça superior esquerda está com a face virada para "CIMA" e a as orelhas viradas para "TRÁS"
    E a cabeça superior direita está com a face virada para "CIMA" e a as orelhas viradas para "TRAS"
    E a cabeça inferior esquerda está com a face virada para "CIMA" e a as orelhas viradas para "TRÁS"
    E a cabeça inferior direita está com a face virada para "CIMA" e a as orelhas viradas para "TRÁS"
    Quando eu pergunto a solução para o nível
    Então deve ser repondindo com uma lista de movimentos com a mesma quantidade de movimentos possíveis

  Cenário: Resolver o pack 2, nível 2
    Dado que a cabeça superior esquerda está com a face virada para "ESQUERDA" e a as orelhas viradas para "TRÁS"
    E a cabeça superior direita está com a face virada para "ESQUERDA" e a as orelhas viradas para "CIMA"
    E a cabeça inferior esquerda está com a face virada para "CIMA" e a as orelhas viradas para "TRÁS"
    E a cabeça inferior direita está com a face virada para "FRENTE" e a as orelhas viradas para "CIMA"
    Quando eu pergunto a solução para o nível
    Então deve ser repondindo com uma lista de movimentos com a mesma quantidade de movimentos possíveis