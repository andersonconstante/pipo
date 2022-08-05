# Cadastrar Plano de Saúde Pampulha Intermédica

### Quais são os dados de entrada necessários?

--Nome
--CPF
--Data Admissão dd/mm/aaaa
--Endereço

### O que devo fazer com esses dados?

--Validar se o campo Nome está preenchido
--Validar se o campo CPF está preenchido
--validar se o campo Data de Admissão está preenchida corretamente e no formato dd/mm/aaaa
--Validar se o campo endereço está preenchido

### Quais restrições deste problema?

--Campo Nome tem que estar preenchido
--Campo CPF tem que estar preenchido
--Campo Data de Admissão  tem que estar preenchida e em um formato válido
--Campo endereço precisa estar preenchido

### Qual resultado esperado?

--cadastrar um colaborador no Plano de Saúde Pampulha Intermédica

### Qual sequência de passos a ser feita para chegar ao resultado esperado?

--Digitar o Nome, CPF, Data de Admissão e Endereço
--Após digitar, o sistema verifica:
-- Se o nome está preenchido
-- Se o CPF está preenchido
-- Se a Data de Admissão está preenchida e é válida
-- Se o Endereço está preenchido
--Caso todos os campos estejam em conformidade, o colaborador é cadastrado no Plano
--Caso algum dado não seja compativel, será exibida a Mensagem "Não foi possível cadastrar o colaborador, dados inválidos"