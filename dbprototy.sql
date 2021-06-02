-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Хост: localhost:8889
-- Время создания: Июн 02 2021 г., 06:03
-- Версия сервера: 5.7.24
-- Версия PHP: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `dbprototy`
--

-- --------------------------------------------------------

--
-- Структура таблицы `category`
--

CREATE TABLE `category` (
  `RowId` bigint(20) NOT NULL,
  `CategoryName` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `category`
--

INSERT INTO `category` (`RowId`, `CategoryName`) VALUES
(1, 'Электричество'),
(2, 'Газ'),
(3, 'Вода'),
(4, 'Тепло');

-- --------------------------------------------------------

--
-- Структура таблицы `mastertable`
--

CREATE TABLE `mastertable` (
  `RowId` bigint(20) NOT NULL,
  `MasterNAME` varchar(100) DEFAULT NULL,
  `MasterLastName` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `request`
--

CREATE TABLE `request` (
  `RowId` bigint(20) NOT NULL,
  `UserId` bigint(20) NOT NULL,
  `Masterid` bigint(20) DEFAULT NULL,
  `CategoryId` bigint(20) DEFAULT NULL,
  `SubCategoryId` bigint(20) DEFAULT NULL,
  `RequestDescription` varchar(100) DEFAULT NULL,
  `RequestSTATUS` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `request`
--

INSERT INTO `request` (`RowId`, `UserId`, `Masterid`, `CategoryId`, `SubCategoryId`, `RequestDescription`, `RequestSTATUS`) VALUES
(2, 1, NULL, 4, NULL, 'xzxzxz', 'НОВАЯ'),
(3, 3, NULL, 1, NULL, 'qeqeq', 'НОВАЯ');

-- --------------------------------------------------------

--
-- Структура таблицы `subcategory`
--

CREATE TABLE `subcategory` (
  `RowId` bigint(20) NOT NULL,
  `Category_id` bigint(20) DEFAULT NULL,
  `SubCategoryName` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `usertable`
--

CREATE TABLE `usertable` (
  `RowId` bigint(20) NOT NULL,
  `UserNAME` varchar(100) DEFAULT NULL,
  `UserLastName` varchar(100) DEFAULT NULL,
  `UserAddress` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `usertable`
--

INSERT INTO `usertable` (`RowId`, `UserNAME`, `UserLastName`, `UserAddress`) VALUES
(1, 'Егор', 'Долгих', 'Ленина 1, кв. 12'),
(2, 'Иван', 'Трубников', 'Ленина 2, кв. 22'),
(3, 'Никита', 'Щетинин', 'Ленина 4, кв. 25'),
(4, 'Надя', 'Строчкова', 'Ленина 56, кв. 53');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`RowId`);

--
-- Индексы таблицы `mastertable`
--
ALTER TABLE `mastertable`
  ADD PRIMARY KEY (`RowId`);

--
-- Индексы таблицы `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`RowId`),
  ADD KEY `UserId` (`UserId`),
  ADD KEY `MasterId` (`Masterid`),
  ADD KEY `CategoryId` (`CategoryId`),
  ADD KEY `SubCategoryId` (`SubCategoryId`);

--
-- Индексы таблицы `subcategory`
--
ALTER TABLE `subcategory`
  ADD PRIMARY KEY (`RowId`),
  ADD KEY `Category_id` (`Category_id`);

--
-- Индексы таблицы `usertable`
--
ALTER TABLE `usertable`
  ADD PRIMARY KEY (`RowId`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `category`
--
ALTER TABLE `category`
  MODIFY `RowId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `mastertable`
--
ALTER TABLE `mastertable`
  MODIFY `RowId` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `request`
--
ALTER TABLE `request`
  MODIFY `RowId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `subcategory`
--
ALTER TABLE `subcategory`
  MODIFY `RowId` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `usertable`
--
ALTER TABLE `usertable`
  MODIFY `RowId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `request`
--
ALTER TABLE `request`
  ADD CONSTRAINT `request_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `usertable` (`RowId`),
  ADD CONSTRAINT `request_ibfk_2` FOREIGN KEY (`Masterid`) REFERENCES `mastertable` (`RowId`),
  ADD CONSTRAINT `request_ibfk_3` FOREIGN KEY (`CategoryId`) REFERENCES `category` (`RowId`),
  ADD CONSTRAINT `request_ibfk_4` FOREIGN KEY (`SubCategoryId`) REFERENCES `subcategory` (`RowId`);

--
-- Ограничения внешнего ключа таблицы `subcategory`
--
ALTER TABLE `subcategory`
  ADD CONSTRAINT `subcategory_ibfk_1` FOREIGN KEY (`Category_id`) REFERENCES `category` (`RowId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
