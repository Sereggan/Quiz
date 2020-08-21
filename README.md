# Quiz
Quiz app  
backend - Spring boot REST APi(с возможностью выбора между Spring data/Hibernate), так же сделал frontend на React(но там нет авторизации)  
Есть 2 пользователя user:user admin:admin, юзер может только получать квиз и решать его, а админ так же может удалить и добавить   
Целью было написать бекенд-часть на Java с использованием Java(Spring boot,Spring MVC, Spring data, PostgreSQL)  
Сам по себе сервис представляет набор задач(Квизов) и возможность их решения, удаления и добавления  
Пример использования API приведен на скринах ниже:  
  
Получение всех квизов:  
![alt text](API_screenshots/get_All_quizzes.png)  
Получение одного квиза по ид:  
![alt text](API_screenshots/get_quiz_by_id.png)  
Получение всех квизов:  
![alt text](API_screenshots/get_All_quizzes.png)  
Добаваление квиза:  
![alt text](API_screenshots/add_quiz.png)  
Удаление квиза:  
![alt text](API_screenshots/delete_quiz.png)  
Решение квиза:  
![alt text](API_screenshots/solve_quiz.png)  
  
  
Для backend есть тесты(Junit5 + Mockito)  
Осустствует проверка на "дурочка"  
Todo: Paging, Docker, Задеплоить
