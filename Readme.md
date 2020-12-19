Java Developer contest
Условия на вход
Есть сущность Автомобиль, содержащая, для простоты, следующие атрибуты:
• Марка (строка);
• Модель (строка);
• Год выпуска (число в диапазоне 1980-2019);
• Месяц выпуска (число в диапазоне 01-12);
• Рабочий объём двигателя (число);
• Наличие турбонагнетателя (да/нет);
• Мощность (число);
• Трансмиссия (автомат, вариатор, механика);
• Привод (передний, задний, полный);
• Кузов (универсал, внедорожник, седан, купе);
• Цвет (строка);
Ожидается использование следующего технологического стека: Java(8 и новее), SpringCore(DIи
т.д.), SpringDataJpa, SpringTX, SpringMVC, Hibernate, Postgres.
Выполнение уровня Junior
• Необходимо обеспечить сохранение экземпляров сущности Автомобиль в БД.
• Реализовать стандартные СRUD-операции.
Выполнение уровня Middle/Senior
• Реализовать расширенные возможности по выборке: сортировка по любому полю,
возможность фильтрации по любому полю (выбрать только красные автомобили) и по
паре полей (пример 1: выбрать автомобили с рабочим объемом двигателя не более 2000
см3 и иналичием турбрнагнетателя; пример 2: выбрать все универсалы или
внедорожники).
• Приложение реализовать в виде сервиса с предоставлением доступа к нему с помощью
mvc-контроллера.Имеющиеся в БД данные необходимо вывести на страницу в
видетаблицы, в которой поддерживается сортировка. Рядом должна быть кнопка,при
нажатии на которую,произойдет выгрузка данных в excel формат и на клиентский
компьютер скачается файл с данными.
Выполнение домашнего задания
• Написать тесты для методов сервиса (можно не для всех).
• Написать тесты для методов контроллера (можно не для всех).