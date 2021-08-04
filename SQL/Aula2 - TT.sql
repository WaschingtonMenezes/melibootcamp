#1 - Explique o conceito de normalização e para que é usado.
#	R: São 3 níveis que consistem na validaçao e padronização de dados, evitando inconscistências e redundãncias
 
#2 - Adicione um filme à tabela de filmes.
INSERT INTO movies VALUES (22,current_time,current_time,'The Crow',10,3,'2010-10-04 00:00:00',220,2);
  
#3 - Adicione um gênero à tabela de gêneros.
INSERT INTO genres VALUES (15,current_time,current_time, 'Other', 19,1);

#4 - Associe o filme do Ex 2. ao gênero criado no Ex. 3.
UPDATE movies 
   SET genre_id = 13
 WHERE id = 22;
 
#5 - Modifique a tabela de atores para que pelo menos um ator adicione como favorito o filme adicionado no Ex. 2.
UPDATE actors 
   SET favorite_movie_id = 22 
 WHERE id = 1;
   
#6 - Crie uma cópia temporária da tabela de filmes.
CREATE TEMPORARY TABLE IF NOT EXISTS moviesTemp AS (SELECT * FROM movies);
SELECT * FROM moviesTemp;

#7 - Elimine desta tabela temporária todos os filmes que ganharam menos de 5 prêmios.
DELETE FROM moviesTemp
 WHERE awards <= 5;
 
#8 - Obtenha a lista de todos os gêneros que possuem pelo menos um filme.
SELECT name, count(*) AS CONTADOR
  FROM genres AS g
 INNER JOIN movies AS m
	ON g.id = m.genre_id
GROUP BY (name);

#9 - Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios.
select * from movies;

SELECT title, awards
  FROM actors AS a
 INNER JOIN movies AS m
	ON a.favorite_movie_id = m.id
 WHERE awards > 3;

#10 - Use o plano de explicação para analisar as consultas nos Ex. 6 e 7.
EXPLAIN DELETE FROM moviesTemp
  WHERE awards <= 5;
#11 - O que são os índices? Para que servem?
	#No contexto de banco de dados, um índice é uma estrutura associada a uma tabela para acelerar o tempo de busca. 
    
#12 - Crie um índice sobre o nome na tabela de filmes.
	CREATE INDEX idx_MOVIES_NAME ON movies(title);
    
#13 - Verifique se o índice foi criado corretamente.
SHOW INDEX FROM movies;