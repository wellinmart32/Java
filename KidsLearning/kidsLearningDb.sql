create table Game
(
	id int primary key,
	name varchar(50) not null,
	state int not null
);

create table QuestionAnswersGame
(
	id int primary key,
	gameId int not null,
	question varchar(200) not null,
	answer1 varchar(200),
	result1 int,
	answer2 varchar(200),
	result2 int,
	answer3 varchar(200),
	result3 int,
	answer4 varchar(200),
	result4 int,
	answer5 varchar(200),
	result5 int,
	dificult int not null,
	state int not null,
	CONSTRAINT fk_Game FOREIGN KEY (gameId) REFERENCES Game (id)
);

insert into Game(
	id, name, state
) values (
	1, 'Juego de pregunta y respuestas', 1
);

insert into QuestionAnswersGame(
	id, gameId, question, answer1, result1, answer2, result2, answer3, result3, answer4, result4, answer5, result5, state, 1
) values (
	1, 1, '¿Cuál es la capital de España?', 'Madrid', 1, 'Quito', 0, 'Roma', 0, '', 0, '', 0, 1
);
insert into QuestionAnswersGame(
	id, gameId, question, answer1, result1, answer2, result2, answer3, result3, answer4, result4, answer5, result5, state, 1
) values (
	2, 1, '¿Cuál es la capital de Ecuador?', 'Madrid', 0, 'Quito', 1, 'Roma', 0, '', 0, '', 0, 1
);
