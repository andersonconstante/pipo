# Cadastrar Plano de Saúde NorteEuropa

### Quais são os dados de entrada necessários?

--Nome
--CPF
--Data Admissão dd/mm/aaaa
--Email

### O que devo fazer com esses dados?

--Validar se o campo Nome está preenchido
--Validar se o campo CPF está preenchido
--Validar se a Data de Admissão está preenchida corretamente e no formato dd/mm/aaaa
--Validar se o campo email está preenchido e se está no padrão com @ e .com

### Quais restrições deste problema?

--Campo Nome tem que ser preenchido
--Campo CPF tem que ser preenchido
--Campo Data de Admissão  tem que ser preenchida e em um formato válido
--Campo Email precisa ser válido

### Qual resultado esperado?

--cadastrar um colaborador no Plano de Saúde NorteEuropa

### Qual sequência de passos a ser feita para chegar ao resultado esperado?

--Digitar o Nome, CPF, Data de Admissão e Email
--Após digitar, o sistema verifica:
-- Se o nome está preenchido
-- Se o CPF está preenchido
-- Se a Data de Admissão está preenchida e é válida
-- Se o Email está preenchido e é válido
--Caso todos os campos estejam em conformidade, o colaborador é cadastrado no Plano
--Caso algum dado não seja compatível, será exibida a Mensagem "Não foi possível cadastrar o colaborador, dados inválidos"