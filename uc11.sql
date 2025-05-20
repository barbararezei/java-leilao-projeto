
--
create database uc11;
use  uc11;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE produtos (
  id int(20) primary key  auto_increment,
  nome text DEFAULT NULL,
  valor int(11) DEFAULT NULL,
  status text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO produtos (id, nome, valor, status) VALUES
(2, 'PS4', 1500, 'Vendido'),
(3, 'Xbox 360', 800, 'Vendido'),
(4, 'Iphone 12', 4800, 'Vendido'),
(5, 'PS2', 400, 'A Venda');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `produtos`
--


--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `produtos`
--

COMMIT;

select * from produtos;

