INSERT INTO questiontypes (typename)
values
       ('History'),
       ('Science'),
       ('Sports'),
       ('Technology'),
       ('Math'),
       ('Physics'),
       ('Animals');
INSERT INTO questions (qtext,typeid)
VALUES
('When was the largest pyramid built?',1),
('What were the phoenicians known for?',1),
('When did the first world war happen?',1),
('What is the notation for the water molecule?',2),
('How many bones does a human have?',2),
('What country won the soccer world cup in 2018?',3),
('How many players does a soccer team have?',3),
('How many players does a basketball team have?',3),
('What is AI?',4),
('Is arduino used for building simple robots?',4),
('Do you recommend switching from apple to android?',4),
('What is (3*4)+8/4?',5),
('What is pythagorean theorem?',5),
('What is a binary number?',5),
('When was newton born?',6),
('What does newtons first law state?',6),
('How many breeds of dogs are there?',7),
('What is the biggest shark?',7);
INSERT INTO answers (answer,qid)
VALUES
    ('Yes definitely go for it!',11),
    ('No absolutely not! I have tried it and I regret it.',11),
    ('The Great Pyramid of Giza was built for the Fourth Dynasty Pharaoh Khufu (or Cheops), and was completed around 2560 BCE.',1),
    ('Purple dyes',2),
    ('Being great traders',2),
    ('The letters',2),
    ('They were the masters of the sea',2);